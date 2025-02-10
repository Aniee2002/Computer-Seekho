import React from 'react'
import MainCourse from './MainCourse'

import StaffDetails from '../Staff/StaffDetails.jsx'
import Footer from '../Footer/Footer.jsx'

const AssembledCourse = () => {
  return (
    <div>
      <MainCourse/>
      <StaffDetails/>
      <Footer/>
    </div>
  )
}

export default AssembledCourse
