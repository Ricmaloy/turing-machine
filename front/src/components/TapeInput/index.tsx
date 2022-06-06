import { useState } from "react";
import { Container, Title, Input, Button } from "./styles";

type TapeInputProps = {
  onChangeTapeInput: (input: string) => void;
};

export function TapeInput({ onChangeTapeInput }: TapeInputProps) {
  const [inputData, setInputData] = useState("");

  return (
    <Container>
      <Title>Insira a fita</Title>
      <Input
        type="text"
        value={inputData}
        onChange={(ev) => setInputData(ev.target.value)}
      />
      <Button disabled={!inputData} onClick={() => onChangeTapeInput(inputData)}>
        Enviar
      </Button>
    </Container>
  );
}
