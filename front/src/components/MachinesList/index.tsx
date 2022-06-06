type MachineListProps = {
  machines: string[];
  onSelectMachine: (machine: string) => void;
};

import { Container, Title, ListContainer, ListItem } from "./styles";

export function MachinesList({ machines, onSelectMachine }: MachineListProps) {
  return (
    <Container>
      <Title>Selecione uma máquina</Title>
      <ListContainer>
        {machines.map((machine) => {
          return (
            <ListItem onClick={() => onSelectMachine(machine)} key={machine}>
              {machine}
            </ListItem>
          );
        })}
      </ListContainer>
    </Container>
  );
}
