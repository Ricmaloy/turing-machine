import { Step } from "../../types/step";

import {
  Container,
  Content,
  TapeDisplay,
  TapeItem,
  TapePointer,
  InfosSection,
  FeedbackSection,
  ParralelSection,
  RestartBtn,
} from "./styles";

export function MachineDisplay({
  tapeValue,
  tapePosition,
  actualState,
  isAccepted,
  transition,
  onResetMachine,
}: Step & { onResetMachine: () => void }) {
  return (
    <Container>
      <Content>
        <TapeDisplay>
          <TapePointer tapePosition={Number(tapePosition)} />
          {tapeValue?.map((tapeChar, index) => {
            return <TapeItem key={`${tapeChar}-${index}`}>{tapeChar}</TapeItem>;
          })}
        </TapeDisplay>

        {transition && isAccepted === null && (
          <>
            <InfosSection>
              <p>transição passada:</p>
              <h1>{transition}</h1>
            </InfosSection>
            <ParralelSection>
              <InfosSection>
                <p>Estado atual:</p>
                <h1>{actualState}</h1>
              </InfosSection>
              <InfosSection>
                <p>Posição na fita:</p>
                <h1>{tapePosition}</h1>
              </InfosSection>
            </ParralelSection>
          </>
        )}

        {transition && isAccepted !== null && (
          <>
            <FeedbackSection>
              {isAccepted ? (
                <>
                  <span>🎉</span>
                  <h1>Oba, a máquina escolhida reconheceu a linguagem</h1>
                  <span>🎉</span>
                </>
              ) : (
                <>
                  <span>⛔</span>
                  <h1>Opa, algo deu errado, a linguagem não foi reconhecida</h1>
                  <span>⛔</span>
                </>
              )}
            </FeedbackSection>
            <RestartBtn onClick={() => onResetMachine()}>Recomeçar</RestartBtn>
          </>
        )}
      </Content>
    </Container>
  );
}
