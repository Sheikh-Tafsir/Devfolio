import React, {useState, useEffect, useContext}from 'react'
import "../styles/Heromain.css"
import Axios from 'axios';
import Navbar from './Navbar'
// import NameContext from '../contexts/NameContext';
import PortfolioContext from '../contexts/PortfolioContext';

const Heromain = () => {
  // const {setName} = useContext(NameContext);
  const {portfolio, setPortfolio} = useContext(PortfolioContext);
  const [backgroundImageLink,setBaackgroundImageLink]=useState("");

  useEffect(() => {
    // handleSetName();
    savePortfolio(1);
    if (Array.isArray(portfolio.about) && portfolio.about.length > 0) {
      setBaackgroundImageLink(portfolio.about[0].backgroundImageLink);
      //console.log(portfolio.about[0].backgroundImageLink);
    }
  }, [portfolio]);

  // const handleSetName = () => {
  //   setName('Mohsina');
  // };

  const savePortfolio = async (userId) => {
    try {
      await Axios.post('http://localhost:8080/user/portfolio',{
        id:userId,
      }).then((response) =>{
        //console.log(response.data.data.userEntity);
        if(response.data.message === "user found")setPortfolio(response.data.data.userEntity);
      });
    } 
    catch (error) {
      console.error('Error while saving object:', error);
    }
  };

  return (
    <div className="heromain" id="home" style={{ backgroundImage: `url(${backgroundImageLink})` }}>
        <Navbar/>
        <div className="text-white w-2/3 lg:w-1/3 lg:ml-40 hero-writings" data-aos="fade-up">
            <div className="flex text-lg lg:text-sm 2xl:text-lg mb-3"><p className="bg-orange-600 mr-1 p-hello rounded-sm">Hello</p><p>I'm</p></div>
            <h1 className="text-5xl lg:text-6xl 2xl:text-7xl font-bold  mb-2">{portfolio.name}</h1>
            <div className="flex text-2xl lg:text-3xl 2xl:text-4xl font-bold  mb-3"><p className="mr-2">Software</p><p className="text-orange-600">Engineer.</p></div>
            <p className="text-lg lg:text-sm 2xl:text-lg mb-6">Web developer with 1+ years experiencethat keep customers coming back for about sevices makes effort.</p>
            <button className="bg-orange-600 w-40 h-8 lg:w-24 lg:h-8 xl:w-32 xl:h-11 lg:text-sm 2xl:text-lg font-semibold pb-0.5 rounded-sm">Say Hello</button>
        </div>
    </div>
  )
}

export default Heromain