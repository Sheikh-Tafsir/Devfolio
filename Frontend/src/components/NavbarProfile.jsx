import React,{useState} from 'react'
import {Link, useNavigate} from "react-router-dom";
import Logo from "../images/FLogo.png";
import {RxHamburgerMenu} from "react-icons/rx";
import { Button } from 'react-bootstrap';
import '../App.css';
import '../styles/Navbar.css'

const Navbar = () => {
  
  const[navHamburgerClicked,setNavHamburgerClicked] = useState(true);

  const navigate = useNavigate();
 
  window.addEventListener("scroll",function(){
    document.querySelector(".headnavbar").classList.toggle("sticky-headnavbar",window.scrollY > 80);
  });
  
  const navbarChange = () =>{
    setNavHamburgerClicked(!navHamburgerClicked);
    if(navHamburgerClicked){
      document.querySelector(".navbar").classList.add("navbar-down");
      document.querySelector(".headnavbar").classList.add("headnavbar-down");
    }
    else{
      document.querySelector(".navbar").classList.remove("navbar-down");
      document.querySelector(".headnavbar").classList.remove("headnavbar-down");
    }
  };

  const logout = () => {
    localStorage.setItem("localStorageUsername",null);
    localStorage.setItem("token",null);
    localStorage.setItem("localStorageUserId",null);
    //navigate("/");
    window.open("/", "_top");
  }

  return (
    
    <div className="flex text-sm lg:text-xs 2xl:text-lg z-10 headnavbar">
      <div className="w-1/2">
        <Link to="/"><img src={Logo} alt="logo" className="w-50 lg:w-1/2 h-2/3 lg:ml-40 mt-3"></img></Link>
        <RxHamburgerMenu className="sm:invisible hamburger" onClick={navbarChange}/>
      </div>
      <div className="w-1/2 text-white font-semibold">
        <div className="flex flex-col sm:flex-row sm:justify-between w-4/5 lg:mt-5 2xl:mt-6 navbar" >
          <a href="#home">Home</a>
          <a href="#about">About Me</a>
          <a href="#service">Service</a>
          <a href="#portfolio">Portfolio</a>
          <a href="#contacts">Contact Me</a>
          <Button className="bg-red-600 lg:h-8 lg:w-16 2xl:h-12 2xl:w-20 rounded-lg transform -translate-y-2" onClick={logout}>Logout</Button>
        </div>
        
      </div>
    </div>
  )
}

export default Navbar