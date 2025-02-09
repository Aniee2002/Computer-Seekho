import React from "react";
import "./style.css";

import landscape1 from "../images/PG-DAC-logo.jpeg";
import landscape2 from "../images/PG-DBDA-logo.jpeg";
import landscape3 from "../images/PRE-CAT-logo.jpeg";

const placements = [
  {
    name: "Anurag Patil",
    description: "Just got placement in Tata Power as Senior Software Dev",
    image: landscape1,
  },
  {
    name: "Anurag Patil",
    description: "Just got placement in Tata Power as Senior Software Dev",
    image: landscape2,
  },
  {
    name: "Anurag Patil",
    description: "Just got placement in Tata Power as Senior Software Dev",
    image: landscape3,
  },
  {
    name: "Anurag Patil",
    description: "Just got placement in Tata Power as Senior Software Dev",
    image: landscape3,
  },
  {
    name: "Anurag Patil",
    description: "Just got placement in Tata Power as Senior Software Dev",
    image: landscape3,
  },
  {
    name: "Anurag Patil",
    description: "Just got placement in Tata Power as Senior Software Dev",
    image: landscape3,
  },
];

const Card = ({ name, description, image }) => {
  return (
    <div className="box">
      <img src={image} alt="news" />
      <div className="overlay">
        <h3>{name}</h3>
        <p>{description}</p>
        <a href="#">Read More</a>
      </div>
    </div>
  );
};

const PlacementCards = () => {
  return (
    <div id="card-area">
      <div className="wrapper">
        {/* Bold heading at the top */}
        <h1 className="gossip-heading">Gossip at Vita</h1>

        <div className="box-area">
          {placements.map((placement, index) => (
            <Card key={index} {...placement} />
          ))}
        </div>
      </div>
    </div>
  );
};

export default PlacementCards;
