import React, {useEffect, useContext} from 'react';

import Axios from 'axios';
import Heromain from './Heromain'
import AboutProfile from './AboutProfile'
import ServiceProfile from './ServiceProfile'
import ProjectsProfile from './ProjectsProfile'
import ContactsProfile from './ContactsProfile'
import Footer from './Footer'
//import NameContext from '../contexts/NameContext';
import  PortfolioContext from '../contexts/PortfolioContext';

const Profile = () => {
  //const {name,setName} = useContext(NameContext);
  let name=localStorage.getItem("localStorageUsername");
  const {setPortfolio} = useContext(PortfolioContext);

  // const handleSetName = (name) => {
  //     setName(name);
  // };

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
      <Heromain/>
      <AboutProfile/>
      <ServiceProfile/>
      <ProjectsProfile/>
      <ContactsProfile/>
      <Footer/>
    </>
  )
}

export default Profile