import React from "react";
import styled from "styled-components";
import { Link } from "react-router-dom";

const NavBar = () => {
    const [scrollY, setScrollY] = React.useState(window.pageYOffset);

    const getScrollY = () => {
        setScrollY(window.pageYOffset);
    };
    window.addEventListener("scroll", getScrollY);

    return (
        <div
            style={{
                position: "fixed",
                top: "0px",
                zIndex: "1",
            }}
        >
            {scrollY > 50 ? (
                <NavBarHeaderOpacity>
                    <MyLink to={"/"}>Home</MyLink>
                    <MyLink to={"/"}>Idk yet</MyLink>
                </NavBarHeaderOpacity>
            ) : (
                <NavBarHeader>
                    <MyLink to={"/"}>Home</MyLink>
                    <MyLink to={"/"}>Idk yet</MyLink>
                </NavBarHeader>
            )}
        </div>
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

const NavBarHeaderOpacity = styled.header`
  padding: 1rem;
  background-color: #2b2b2b;
  display: flex;
  width: 99.9vw;
  flex-direction: row;
  /* justify-content: flex-begin; */
  margin: 0;
  opacity: 0.8;
  transition: opacity 4s linear;
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