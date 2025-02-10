import React, { lazy, Suspense } from 'react';
import Navbar from '../Navbar/Navbar';
import './Spinner.css'

// Lazy loading components
const Origin = lazy(() => import('./Origin'));
const Staff = lazy(() => import('./AboutUs'));
const CardsForMoreValue = lazy(() => import('./CardsForMoreValue'));

// Spinner Component
const Spinner = () => (
  <div className="spinner-container">
    <div className="spinner"></div>
  </div>
);

const AssembleAbout = () => {
  return (
    <>
      <Navbar />
      <Suspense fallback={<Spinner />}>
        <Origin />
        <CardsForMoreValue />
        <Staff />
      </Suspense>
    </>
  );
};

export default AssembleAbout;
