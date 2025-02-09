import React from "react";
import Img1 from "../images/altair.png";
import Img2 from "../images/atos.png";
import Img3 from "../images/tata.png";
import Img4 from "../images/onmobile.png";
import Img5 from "../images/nse.png";
import CardStacker from "./CardStacker";
import "./Res.css"; // Import the CSS file
import { useNavigate } from "react-router-dom";

const Recruiters = () => {
  const navigate = useNavigate();
  const data = [
    {
      title: "Altair",
      subtitle: "Bangalore Base",
      rating: "4.7",
      backgroundColors: { top: "#51D1F7", bottom: "#5B8FEF" },
      image: Img1,
    },
    {
      title: "Atos",
      subtitle: "Chennai Base",
      rating: "4.8",
      backgroundColors: { top: "#F85B6B", bottom: "#E83842" },
      image: Img2,
    },
    {
      title: "Tata",
      subtitle: "Mumbai Base",
      rating: "4.9",
      backgroundColors: { top: "#28DFAB", bottom: "#26CBCF" },
      image: Img3,
    },
    {
      title: "OnMobile",
      subtitle: "Pune Base",
      rating: "4.9",
      backgroundColors: { top: "#6F3FF1", bottom: "#6E3CCA" },
      image: Img4,
    },
    {
      title: "NSE",
      subtitle: "Mumbai Base",
      rating: "5.0",
      backgroundColors: { top: "#FBDA35", bottom: "#E3A237" },
      image: Img5,
    },
  ];

  return (
    <div className="app-container">
      {/* Title */}
      <h1 className="title">OUR MAJOR RECRUITERS</h1>

      {/* CardStacker */}
      <CardStacker data={data} />

      {/* Read More Button */}
      <button className="read-more-btn" onClick={()=> navigate("/AllRecruiters")}>Read More</button>
    </div>
  );
};

export default Recruiters;
