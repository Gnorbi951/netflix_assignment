import React from 'react';
import MainPage from "./Components/MainPage";
import NavBar from "./Components/NavBar";
import { BrowserRouter as Router, Route } from "react-router-dom";
import VideoDetail from "./Components/VideoDetail";

function App() {
  return (
    <div className="App">
        <Router>
          <NavBar/>
          <Route exact path="/" component={MainPage}/>
          <Route path="/video/:id" component={VideoDetail}/>
        </Router>
    </div>
  );
}

export default App;
