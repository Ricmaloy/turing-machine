import styled from "styled-components";

export const Container = styled.div`
  width: 100%;
  max-width: 112rem;
  margin: 0px auto;
`;

export const Content = styled.div`
  height: 100%;

  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
`;

export const TapeDisplay = styled.div`
  display: flex;
  justify-content: center;

  position: relative;
`;

export const TapeItem = styled.div`
  width: 8rem;
  height: 8.5rem;
  font-size: 2rem;

  display: flex;
  justify-content: center;
  align-items: center;

  border: 1px solid #c6c6c6;
  background-color: #dddddd;
`;

type TapePointerProps = {
  tapePosition: number;
};

export const TapePointer = styled.div<TapePointerProps>`
  width: 6rem;
  height: 5.5rem;
  transition: all 0.5s;

  background-color: green;
  clip-path: polygon(0 0, 50% 100%, 100% 0);
  position: absolute;
  top: -4rem;
  left: calc(1rem + ${(props) => props.tapePosition} * 8rem);
`;

export const InfosSection = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;

  margin-top: 3rem;

  p {
    font-size: 1.8rem;
  }
`;

export const ParralelSection = styled.div`
  display: flex;
  gap: 12rem;
`;

export const FeedbackSection = styled.div`
  width: 50rem;
  display: flex;

  margin-top: 3rem;
  text-align: center;

  span {
    font-size: 2rem;
  }
`;

export const RestartBtn = styled.button`
  font-family: Poppins;
  font-size: 1.6rem;
  cursor: pointer;

  padding: 1rem 2rem;
  margin-top: 2rem;
`;
