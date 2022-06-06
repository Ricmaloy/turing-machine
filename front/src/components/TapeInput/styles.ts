import styled from "styled-components";

export const Container = styled.div`
  width: 45rem;
  background-color: #f8fbf8;

  display: flex;
  flex-direction: column;
  justify-content: center;

  box-shadow: 0px 0px 4px #c6c6c6;
  margin: auto auto;
  border-radius: 0.5rem;
`;

export const Title = styled.h1`
  margin: 2.5rem auto;
`;

export const Input = styled.input`
  text-align: center;
  font-family: Poppins;
  font-size: 1.6rem;

  margin: 0 5rem 2.5rem;
  border: none;
  border-bottom: 1px solid #c6c6c6;
  background-color: transparent;

  &:focus-visible {
    outline: none;
  }
`;

export const Button = styled.button`
  width: 15rem;
  height: 4.5rem;
  color: white;

  border: none;
  border-radius: 5px;
  margin: 0 auto 2rem;

  font-family: Poppins;
  font-weight: bold;

  background-color: green;

  cursor: pointer;
  transition: all 0.3s;

  &:hover {
    filter: brightness(0.9);
  }

  &:disabled {
    opacity: 0.4;
    pointer-events: none;
  }
`;
