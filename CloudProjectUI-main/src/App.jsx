import { useState } from 'react'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import Login from './pages/login'
import Signup from './pages/Signup'
import Admin from './pages/admin'
import MapPage from './pages/MapPage'
// import reactLogo from './assets/react.svg'
// import viteLogo from './assets/vite.svg'
// import heroImg from './assets/hero.png'
import './App.css'

function App() {

  const [user, setUser] = useState(null)
  const admin = user?.type === 1

  return (
    <BrowserRouter>
    <Routes>
      {/* add the path to the actual map for regular users
      use this >> https://www.w3schools.com/react/react_router.asp*/}
      <Route path="/" element={<Login user={user} userHook={setUser} />} />
      <Route path="/signup" element={<Signup user={user} admin={admin} />} />
      <Route path="/admin" element={<Admin user={user} userHook={setUser} />} />
      <Route path="/map" element={<MapPage userHook={setUser} />} />
    </Routes>
    </BrowserRouter>
  )
}

export default App
