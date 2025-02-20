import React from 'react';
import './CourseVideo.css';
import videoBanner from '../../../public/PG-DAC.mp4';
import logo from '../../../public/Smlogo.png';
const CourseVideo = () => {
  return (
    <div>
      <header className='header5'>
        {/* <a href="#" className="logo5">Heart Out</a> */}
        <div className="toggle5">
          <img src={logo} alt="Toggle Menu" />
        </div>
      </header>
      <div className="banner5">
        <video src={videoBanner} autoPlay loop type="mp4"></video>
        <div className="textbox5">
          <h2>PG-DAC</h2>
          <p>
            PGDAC stands for Post Graduate Diploma in Advanced Computing. It is a course that helps students develop skills in advanced computing and prepare them for careers in the IT industry
          </p>
          <ul className="">
            <li>
              <p>Starting date  : 13-02-2025</p>
            </li>
            <li>
              <p>Duration : 6 month </p>
            </li>
            <li>
              <p>Syllabus: JavaSE ,JavaEE , DBMS ,MS.NET, React JS </p>
            </li>
            <li>
              <p>Fees: 12000</p>
            </li>
          </ul>
          {/* <a href="#">Read more</a> */}
        </div>

        <div className="videobx5">
          <video src="PG-DAC.mp4" muted autoPlay loop type="mp4"></video>
        </div>
        {/* <ul className="sci">
          <li>
            <a href="#">
              <img src="facebook.png" alt="Facebook" />
            </a>
          </li>
          <li>
            <a href="#">
              <img src="twitter.png" alt="Twitter" />
            </a>
          </li>
          <li>
            <a href="#">
              <img src="instagram.png" alt="Instagram" />
            </a>
          </li>
        </ul> */}
      </div>
    </div>
  );
};

export default CourseVideo;
