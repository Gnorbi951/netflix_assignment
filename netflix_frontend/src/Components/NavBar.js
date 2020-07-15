import React from "react";
import styled from "styled-components";
import { Link } from "react-router-dom";

const NavBar = () => {

    return (
        <React.Fragment>
            <NavBarHeader>
                <MyLink to={"/"}>Home</MyLink>
            </NavBarHeader>
        </React.Fragment>
    );
};

const NavBarHeader = styled.header`
  padding: 1rem;
  background-color: #2b2b2b;
  display: flex;
  width: 99.9vw;
  flex-direction: row;
  /* justify-content: flex-begin; */
  margin: 0;
`;
const MyLink = styled(Link)`
  margin: 0.2rem 1rem;
  color: #ffffff;
  text-decoration: none;
  text-transform: uppercase;
  font-weight: bold;
  &:hover {
    transition: 350ms;
    color: #a9a9a9;
    text-decoration: none;
  }
  font-size: 1.5rem;
`;

export default NavBar;