import styled from "styled-components";

export const Container = styled.div`
  display: flex;
  align-items: stretch;
  height: 100vh;
`;

export const Content = styled.div`
  width: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
`;

export const GenerateMachineBtn = styled.button`
  height: fit-content;
  font-family: Poppins;
  font-size: 1.6rem;
  cursor: pointer;

  padding: 1rem 2rem;
  margin-top: 2rem;
`;
