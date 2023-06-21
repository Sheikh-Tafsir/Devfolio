import React from 'react'
import Heromain from './Heromain'
import About from './About'
import Service from './Service'
import Projects from './Projects'
import Contacts from './Contacts'
import Footer from './Footer'

const Homepage = () => {
  return (
    <>
      {/* <Navbar/> */}
      <Heromain/>
      <About/>
      <Service/>
      <Projects/>
      <Contacts/>
      <Footer/>
    </>
  )
}

export default Homepage