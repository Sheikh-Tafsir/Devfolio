import React,{useState, useEffect} from 'react'
import { Button } from 'react-bootstrap';
import {useNavigate} from "react-router-dom";
import Axios from 'axios';
import '../styles/FeaturesAdd.css'

const ContactsUpdate = () => {
  const [phoneNo, setPhoneNo] = useState("");
  const [email, setEmail] = useState("");
  const [facebookLink, setFacebookLink] = useState("");
  const [instagramLink, setInstagramLink] = useState("");
  const [githubLink, setGithubLink] = useState("");
  const [linkedinLink, setLinkedinLink] = useState("");
  const [contactsUpdateStatus, setContactsUpdateStatus] = useState("");
  let localStorageUserId = localStorage.getItem("localStorageUserId");

  const navigate = useNavigate();
  
  const checkIfContactsExists = async () => {
    try {
      const response = await Axios.post('http://localhost:8080/contacts/viewpersonal', {
        userId: localStorageUserId,
      });
  
      if (response.data) {
        if (response.data.phoneNo) setPhoneNo(response.data.phoneNo);
        if (response.data.email) setEmail(response.data.email);
        if (response.data.facebookLink) setFacebookLink(response.data.facebookLink);
        if (response.data.instagramLink) setInstagramLink(response.data.instagramLink);
        if (response.data.githubLink) setGithubLink(response.data.githubLink);
        if (response.data.linkedinLink) setLinkedinLink(response.data.linkedinLink);
      }
    } catch (error) {
      setContactsUpdateStatus("Error occurred while fetching old contact data");
    }
  };
  

  const updateContacts = async () => {
    if(phoneNo === "" || phoneNo == null || phoneNo === undefined ){
      setContactsUpdateStatus("Phone no is empty");
    }
    else if(email === "" || email == null || email === undefined ){
      setContactsUpdateStatus("Email is empty");
    }
    else{
      await Axios.post('http://localhost:8080/contacts/create',{
        userId:localStorageUserId,
        phoneNo:phoneNo,
        email: email,
        facebookLink: facebookLink,
        instagramLink: instagramLink,
        githubLink: githubLink,
        linkedinLink: linkedinLink
      }).then((response) =>{
        //console.log(response.data);
        setContactsUpdateStatus(response.data.responseMessage);
        
        setTimeout(() => {
          navigate("/profile");
      }, 800);
        
      }).catch(error => {
        setContactsUpdateStatus("Error occured while saving new contact data"); 
      }); 
    }
    
  }

  
  
  useEffect(() => {
    checkIfContactsExists();
  }, []);

  return (
    <div className="flex flex-col justify-center items-center featuresAdd">
        <form className="w-6/7 lg:w-2/5 2xl:w-2/6 text-black flex flex-col featuresAddForm">
            <h1 className="lg:text-2xl 2xl:text-4xl mx-auto pt-8 pb-6">Update Contacts</h1>
            <input type="text" className="lg:text-xs 2xl:text-base" placeholder="Insert your phone no" value={phoneNo} onChange={(event) => {setPhoneNo(event.target.value);} }/>
            <input type="text" className="lg:text-xs 2xl:text-base" placeholder="Insert your email" value={email} onChange={(event) => {setEmail(event.target.value);} }/>
            <input type="text" className="lg:text-xs 2xl:text-base" placeholder="Insert your facebook link" value={facebookLink} onChange={(event) => {setFacebookLink(event.target.value);} }/>
            <input type="text" className="lg:text-xs 2xl:text-base" placeholder="Insert your instagram link" value={instagramLink} onChange={(event) => {setInstagramLink(event.target.value);} }/>
            <input type="text" className="lg:text-xs 2xl:text-base" placeholder="Insert your github link" value={githubLink} onChange={(event) => {setGithubLink(event.target.value);} }/>
            <input type="text" className="lg:text-xs 2xl:text-base" placeholder="Insert your linkedin link" value={linkedinLink} onChange={(event) => {setLinkedinLink(event.target.value);} }/>
            <p className="mx-auto mb-4 text-red-600">{contactsUpdateStatus}</p>
            <Button className="mx-auto mb-10 text-white w-3/4 h-10 feature-save-button" onClick={updateContacts}>Save</Button>
        </form>
    </div>
  )
}

export default ContactsUpdate