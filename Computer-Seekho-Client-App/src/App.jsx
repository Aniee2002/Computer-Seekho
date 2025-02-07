import { useState } from 'react'
import './index.css';
import LandPage from './components/Assemble/LandPage';
import { createBrowserRouter, RouterProvider,} from "react-router-dom";;

import Gallery from './components/Gallery/Gallery';
import AssembleAbout from './components/AboutUs/AssembleAbout';
import AboutUs from './components/AboutUs/AboutUs'
import AssembledCourse from './components/MainCourse/AssembledCourse';

const router = createBrowserRouter([
  {
    path: "/",
    element: <LandPage/>
  },
  {
    path: "/About",
    // element: <AssembleAbout/>
    element:<AboutUs/>
  },
  {
    path:"/Gallery",
    element : <Gallery/>
   
  },
  {
    path:"/CourseDetails",
    element : <AssembledCourse/>
   
  }
]);

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <RouterProvider router={router} />
    </>
  )
}

export default App
