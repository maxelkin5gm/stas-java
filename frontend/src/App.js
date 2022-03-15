import React from "react";
import {Routes, Route, Link} from "react-router-dom";
import HomePage from "./HomePage";
import AboutPage from "./AboutPage";

function App() {
  return (
    <div className="App">
        <header>
            <Link to="/">HOME </Link>
            <Link to="/about">ABOUT</Link>
        </header>

        <hr/>

        <Routes>
            <Route path="/" element={<HomePage />} />
            <Route path="/about" element={<AboutPage />} />
            <Route path="*" element={<div>error404</div>} />
        </Routes>
    </div>
  );
}

export default App;
