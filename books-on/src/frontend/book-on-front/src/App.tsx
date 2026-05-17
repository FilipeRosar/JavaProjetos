import './App.css'
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom'
import Login from './pages/Login'
import Home from './pages/home'
import ProtectedRoute from './components/ProtectedRoute'

function App() {

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route 
          path="/home" 
          element={
            <ProtectedRoute>
              <Home />
            </ProtectedRoute>
          } 
        />
        <Route path="*" element={<Navigate to="/" replace />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App
