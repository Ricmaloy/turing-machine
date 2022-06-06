import { useEffect, useState } from "react";
import { MachinesList } from "../../components/MachinesList";
import { MachineDisplay } from "../../components/TapeDisplay";
import { TapeInput } from "../../components/TapeInput";
import { api } from "../../services/axios/api";
import { Step } from "../../types/step";

import { Container, Content, GenerateMachineBtn } from "./styles";

var id: number;

export function Home() {
  const [machinesList, setMachinesList] = useState([]);
  const [selectedMachine, setSelectedMachine] = useState("");
  const [tape, setTape] = useState("");
  const [step, setStep] = useState<Step>({});

  async function getMachines() {
    await api.get("list").then((response) => {
      setMachinesList(response.data);
    });
  }

  function handleSelectMachine(machine: string) {
    setSelectedMachine(machine);
  }

  function handleGenerateMachineTape() {
    handleStartMT();
  }

  async function handleStartMT() {
    const { data } = await api.get(
      `startMT?filename=${selectedMachine}&word=${tape}`
    );

    setStep(() => ({
      tapeValue: data.tapeValue,
      tapePosition: data.tapePosition,
      actualState: data.actualState,
      isAccepted: data.isAccepted,
      transition: data.transition,
    }));

    id = setInterval(() => {
      handleNextStep();
    }, 3000);
  }

  async function handleNextStep() {
    const { data } = await api.get(`nextStepMT`);

    setStep(() => ({
      tapeValue: data.tapeValue,
      tapePosition: data.tapePosition,
      actualState: data.actualState,
      isAccepted: data.isAccepted,
      transition: data.transition,
    }));
  }

  function handleStopInterval() {
    clearInterval(id);
  }

  function handleRestartMachine() {
    setSelectedMachine("");
    setTape("");
    setStep({});
    handleStopInterval();
  }

  useEffect(() => {
    getMachines();
  }, []);

  return (
    <Container>
      {!selectedMachine && !tape ? (
        <MachinesList
          machines={machinesList}
          onSelectMachine={handleSelectMachine}
        />
      ) : selectedMachine && !tape ? (
        <TapeInput onChangeTapeInput={setTape} />
      ) : (
        <>
          {!step.tapeValue && (
            <Content>
              <h1>Clique para gerar a fita</h1>
              <GenerateMachineBtn onClick={() => handleStartMT()}>
                Gerar fita
              </GenerateMachineBtn>
            </Content>
          )}

          {step.tapeValue && (
            <MachineDisplay
              tapeValue={step.tapeValue}
              actualState={step.actualState}
              tapePosition={step.tapePosition}
              isAccepted={step.isAccepted}
              transition={step.transition}
              onResetMachine={handleRestartMachine}
            />
          )}
        </>
      )}
    </Container>
  );
}
