import React from "react";
import image from './images/nitin_hd.jpg';
import image2 from './images/ketki_hd.jpg';
import image3 from './images/nitin_hd.jpg';
import './staff.css';
import Navbar from "../Navbar/Navbar";
import Footer from "../Footer/Footer";

const Staff = () => {
  return (
    <>
    
    <h1 className="tag">Our Elites</h1>
    <div className="wrapper">
      <div className="cardOfAbout">
        <img src={image} alt="Staff1" />
        <div className="info">
          <h1>Nitin vijaykar</h1>
          <p>A profound teacher at sm-vita with over 25 years of experience</p>
          <a href="#" className="btn">Read ...</a>
        </div>
      </div>

      <div className="cardOfAbout">
        <img src={image2} alt="Staff2" />
        <div className="info">
          <h1>Ketki Acharya</h1>
          <p>A profound teacher at sm-vita with over 25 years of experience</p>
          <a href="#" className="btn">Read ...</a>
        </div>
      </div>

      <div className="cardOfAbout">
        <img src={image3} alt="Staff3" />
        <div className="info">
          <h1>Amar Panchal</h1>
          <p>A profound teacher at sm-vita with over 25 years of experience</p>
          <a href="#" className="btn">Read ...</a>
        </div>
      </div>
    </div>
    <Footer/>
    </>
  );
}

export default Staff;