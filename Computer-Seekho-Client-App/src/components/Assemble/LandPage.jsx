import React from 'react';
import Name from '../Text/Name';
import Navbar from '../Navbar/Navbar';
import Carousel from '../Carousel/Carousel';
import Recruiters from '../Recruiters/Recruiters'
import Footer from '../Footer/Footer';
import News from '../News/News'
import Course from '../CourseCard/Course';




const LandPage = () => {
  return (
    <>
      <Name/>
      <Navbar />
      <Carousel />
      <Course/>
      <News/>
      <Recruiters />  
      <Footer/>
    </>
  );
}

export default LandPage;
