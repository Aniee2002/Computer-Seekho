import React from "react";
import "./Cource.css"; 

import landscape1 from "../images/PG-DAC-logo.jpeg";
import landscape2 from "../images/PG-DBDA-logo.jpeg";
import landscape3 from "../images/PRE-CAT-logo.jpeg";

const cardsData = [
  {
    img: landscape1,
    description: "Post Graduate Diploma in Advanced Computing (PG DAC) grooms engineers and IT professionals for a career in Software Development.",
    title: "PG-DAC",
  },
  {
    img: landscape2,
    description: "Post Graduate Diploma in Big Data Analytics (PG DBDA) enables students to explore the fundamental concepts of big data analytics.",
    title: "PG-DBDA",
  },
  {
    img: landscape3,
    description: "BThe admission to all PG Courses by-DAC ACTS is through an All-India C-DAC Common Admission TestC-CAT",
    title: "PRE-CAT",
  },
];

const Course = () => {
  return (
    <div className="container">
     <h1>Course Details</h1>
      <div className="card__container">
        {cardsData.map((card, index) => (
          <article className="card__article" key={index}>
            <img src={card.img} alt={card.title} className="card__img" />
            <div className="card__data">
              <span className="card__description">{card.description}</span>
              <h2 className="card__title">{card.title}</h2>
              <a href="#" className="card__button">
                Read More
              </a>
            </div>
          </article>
        ))}
      </div>
    </div>
  );
};

export default Course;
