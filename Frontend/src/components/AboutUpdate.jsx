import React,{useState, useEffect} from 'react'
import { Button } from 'react-bootstrap';
import {useNavigate} from "react-router-dom";
import Axios from 'axios';
import '../styles/FeaturesAdd.css'

const AboutUpdate = () => {

    const [occupation, setOccupation] = useState("");
    const [description, setDescription] = useState("");
    const [backgroundImageLink, setBackgroundImageLink] = useState("");
    const [aboutImageLink, setAboutImageLink] = useState("");
    const [aboutUpdateStatus, setAboutUpdateStatus] = useState("");
    let localStorageUserId = localStorage.getItem("localStorageUserId");
  
    const navigate = useNavigate();
    
    const checkIfAboutExists = async () => {
      try {
        const response = await Axios.post('http://localhost:8080/about/viewpersonal', {
          userId: localStorageUserId,
        });
    
        if (response.data) {
          if (response.data.occupation) setOccupation(response.data.occupation);
          if (response.data.description) setDescription(response.data.description);
          if (response.data.backgroundImageLink) setBackgroundImageLink(response.data.backgroundImageLink);
          if (response.data.aboutImageLink) setAboutImageLink(response.data.aboutImageLink);
        }
      } catch (error) {
        setAboutUpdateStatus("Error occurred while fetching old about data");
      }
    };
    
  
    const updateAbout = async () => {
      if(occupation === "" || occupation == null || occupation === undefined ){
        setAboutUpdateStatus("Your occupation empty");
      }
      else if(description === "" || description == null || description === undefined ){
        setAboutUpdateStatus("Your description is empty");
      }
      else if(backgroundImageLink === "" || backgroundImageLink == null || backgroundImageLink === undefined ){
        setAboutUpdateStatus("Your background image link is empty");
      }
      else if(aboutImageLink === "" || aboutImageLink == null || aboutImageLink === undefined ){
        setAboutUpdateStatus("Your about image link is empty");
      }
      else{
        try{
            const response = await Axios.post('http://localhost:8080/about/create',{
                userId:localStorageUserId,
                occupation: occupation,
                description: description,
                aboutImageLink: aboutImageLink,
                backgroundImageLink: backgroundImageLink,
            });
            //console.log(response.data);
            setAboutUpdateStatus(response.data.responseMessage);
            
            setTimeout(() => {
                navigate("/profile");
            }, 800);

        }
        catch(error) {
            setAboutUpdateStatus("Error occured while saving new about data"); 
        }; 
      }
      
    }
  
    
    
    useEffect(() => {
      checkIfAboutExists();
    }, []);

  return (
    <div className="flex flex-col justify-center items-center featuresAdd">
        <form className="w-6/7 lg:w-2/5 2xl:w-2/6 text-black flex flex-col featuresAddForm">
            <h1 className="lg:text-2xl 2xl:text-4xl mx-auto pt-8 pb-6">Update Contacts</h1>
            <input type="text" className="lg:text-xs 2xl:text-base" placeholder="Insert your occupaation" value={occupation} onChange={(event) => {setOccupation(event.target.value);} }/>
            <textarea type="text" className="lg:text-xs 2xl:text-base lg:h-40 2xl:h-52 pt-2" placeholder="Insert your description" value={description} onChange={(event) => {setDescription(event.target.value);} }/>
            <input type="text" className="lg:text-xs 2xl:text-base" placeholder="Insert your background image link" value={backgroundImageLink} onChange={(event) => {setBackgroundImageLink(event.target.value);} }/>
            <input type="text" className="lg:text-xs 2xl:text-base" placeholder="Insert your about image link" value={aboutImageLink} onChange={(event) => {setAboutImageLink(event.target.value);} }/>
            <p className="mx-auto mb-4 text-red-600">{aboutUpdateStatus}</p>
            <Button className="mx-auto mb-10 text-white w-3/4 h-10 feature-save-button" onClick={updateAbout}>Save</Button>
        </form>
    </div>
  )
}

export default AboutUpdate