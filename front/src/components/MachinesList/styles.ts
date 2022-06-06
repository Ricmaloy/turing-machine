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

export const ListContainer = styled.ul`
  list-style: none;
  margin: 2rem 5rem;
`;

export const ListItem = styled.li`
  text-align: center;
  padding: 2rem 0;
  font-size: 1.5rem;
  cursor: pointer;
  transition: all 0.3s;
  border: 1px solid transparent;

  &:hover {
    border: 1px solid #c6c6c6;
    background-color: #f8f8ff;
  }
`;
