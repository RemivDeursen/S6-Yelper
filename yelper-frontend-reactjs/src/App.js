import React from 'react';
// noinspection ES6CheckImport
import {BrowserRouter as Router, Route, Routes, Navigate} from "react-router-dom";
import HomePage from "./views/HomePage";
import Profile from "./views/Profile";
import Pages from "./views/Pages";
import Sidebar from "./components/Sidebar";
import {Container, Row, Col, Card, Form, Button} from "react-bootstrap";
import LoginModal from "./popups/LoginModal";
import RegisterModal from "./popups/RegisterModal";

// Styling
import './styles/App.css';

function App() {
    return (
        <Router>
            <div>
                <Container fluid>
                    <Row>
                        <Col xs={2} id="sidebar-wrapper">
                            <Sidebar/>
                        </Col>
                        <Col xs={10} id="page-content-wrapper">
                            <Routes>
                                <Route path="/" element={<Navigate to="/homepage" />} />
                                <Route path="/homepage" element={<HomePage/>}/>
                                <Route path="/profile" element={<Profile/>}/>
                                <Route path="/pages" element={<Pages/>}/>
                                <Route path="/login" element={<LoginModal />} />
                                <Route path="/register" element={<RegisterModal />} />
                            </Routes>
                        </Col>
                    </Row>
                </Container>
            </div>
        </Router>
    );
}

export default App;
