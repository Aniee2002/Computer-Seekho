import React from "react";
import Bg from "../images/bg.png";
import "./Card.css"; // Import the CSS file

const Card = ({ title, subtitle, rating, backgroundColors, className = "", image }) => {
  const { top, bottom } = backgroundColors;

  return (
    <div
      className={`card ${className}`}
      style={{
        background: `linear-gradient(to bottom, ${top}, ${bottom})`,
      }}
    >
      {/* Background Image */}
      <div className="card-bg">
        <img src={Bg} alt="background" />
      </div>

      {/* Card Content */}
      <div className="card-content">
        <div>
          <h2 className="card-title">{title}</h2>
          <p className="card-subtitle">{subtitle}</p>
        </div>

        {/* Rating Section */}
        <div className="card-rating">
          <div className="icon">
            <svg xmlns="http://www.w3.org/2000/svg" width="15" height="15" fill={top} viewBox="0 0 256 256">
              <path d="M232,64H208V48a8,8,0,0,0-8-8H56a8,8,0,0,0-8,8V64H24A16,16,0,0,0,8,80V96a40,40,0,0,0,40,40h3.65A80.13,80.13,0,0,0,120,191.61V216H96a8,8,0,0,0,0,16h64a8,8,0,0,0,0-16H136V191.58c31.94-3.23,58.44-25.64,68.08-55.58H208a40,40,0,0,0,40-40V80A16,16,0,0,0,232,64ZM48,120A24,24,0,0,1,24,96V80H48v32q0,4,.39,8ZM232,96a24,24,0,0,1-24,24h-.5a81.81,81.81,0,0,0,.5-8.9V80h24Z"></path>
            </svg>
          </div>
          <p className="rating-text">{rating}</p>
        </div>
      </div>

      {/* Image */}
      <img src={image} alt={title} className="card-image" />
    </div>
  );
};

export default Card;
