import React from 'react';
import MainPage from "./Components/MainPage";
import NavBar from "./Components/NavBar";
import {BrowserRouter as Router} from "react-router-dom";

function App() {
  return (
    <div className="App">
        <Router>
          <NavBar/>
          <MainPage/>
        </Router>
    </div>
  );
}

export default App;
