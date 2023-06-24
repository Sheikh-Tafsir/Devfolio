import React,{useEffect, useContext} from 'react'
import {Routes, Route, BrowserRouter, useParams} from "react-router-dom";
import './App.css';
import Homepage from './components/Homepage';
import AOS from 'aos';
import Axios from 'axios';
import 'aos/dist/aos.css';
import Login from './components/Login';
import Portfolio from './components/Portfolio';
import Signup from './components/Signup';
import Profile from './components/Profile';
import ProjectsAdd from './components/ProjectsAdd';
import { NameProvider } from './contexts/NameContext';
import  PortfolioContext, {PortfolioProvider } from './contexts/PortfolioContext';
import { UserProvider } from './contexts/UserContext';
import ServiceAdd from './components/ServiceAdd';


const App = () =>{

  useEffect(() => {
    AOS.init();
  }, []);

  return (
    <>
      <BrowserRouter>
       <NameProvider>
          <PortfolioProvider>
            <UserProvider>
              <Routes>
                <Route path="/" element={<Homepage />} />
                <Route path="/login" element={<Login />} />
                <Route path="/signup" element={<Signup />} />
                <Route path="/profile" element={<Profile />} />
                <Route path="/profile/projectsadd" element={<ProjectsAdd />} />
                \<Route path="/profile/serviceadd" element={<ServiceAdd />} />
                <Route path="/portfolio/:name" element={<DynamicPage />} />
              </Routes>
            </UserProvider>
          </PortfolioProvider>
        </NameProvider>
      </BrowserRouter>
    </>
  )
}

const DynamicPage = () => {
  const { name } = useParams();
  const {setPortfolio} = useContext(PortfolioContext);

  const savePortfolio = async (name) => {
    
    try {
      await Axios.post('http://localhost:8080/user/portfolio',{
        name:name,
      }).then((response) =>{
        //console.log(response.data.data.userEntity);
        if(response.data.message === "user found")setPortfolio(response.data.data.userEntity);
      });
    } 
    catch (error) {
      console.error('Error while saving object:', error);
    }
  };

  useEffect(() => {
    savePortfolio(name);
  }, [name]);

  return (
      <>
          <Portfolio/>
      </>
  );
};



export default App;
