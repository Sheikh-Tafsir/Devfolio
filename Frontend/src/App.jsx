import React,{useState, useEffect, useParams} from 'react'
import {Routes, Route, BrowserRouter} from "react-router-dom";
import './App.css';
import Homepage from './components/Homepage';
import AOS from 'aos';
import 'aos/dist/aos.css';
import { NameProvider } from './contexts/NameContext';
import  {PortfolioProvider } from './contexts/PortfolioContext';
import Login from './components/Login';


const App = () =>{
  //let localStorageUsername=localStorage.getItem("localStorageUsername");
  //let localStorageLoggedState=localStorage.getItem("localStorageLoggedState");

  useEffect(() => {
    AOS.init();
  }, []);

  return (
    <>
      <BrowserRouter>
        <PortfolioProvider>
          <NameProvider>
            <Routes>
              <Route path="/" element={<Homepage />} />
              <Route path="/login" element={<Login />} />
              <Route path="/:name" element={<DynamicPage />} />
            </Routes>
          </NameProvider>
        </PortfolioProvider>
      </BrowserRouter>
    </>
  )
}

const DynamicPage = () => {
  const { name } = useParams();

  useEffect(() => {
    // Save the name in local storage
    localStorage.setItem('name', name);
  }, [name]);

  return (
    <div>
      <h1>Welcome, {name}!</h1>
    </div>
  );
};

export default App;
