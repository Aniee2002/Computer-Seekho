import { useState } from 'react'
import './index.css';
import LandPage from './components/Assemble/LandPage';
import { createBrowserRouter, RouterProvider,} from "react-router-dom";;

import Gallery from './components/Gallery/Gallery';
import AssembleAbout from './components/AboutUs/AssembleAbout';
import AboutUs from './components/AboutUs/AboutUs'
import AssembledCourse from './components/MainCourse/AssembledCourse';
import Batch from './components/Batch/Batch';
import Placedstudent from './components/Batch/BatchWiseStudent';

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
  },
  {
    path: "/Placement",
    element : <Batch/>
  },
  {
    path: "/BatchWiseStudent/:batchId",
    element: <Placedstudent/>
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
