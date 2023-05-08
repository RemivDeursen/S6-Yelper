import React from 'react';
import Button from 'react-bootstrap/Button';
import { Link } from "react-router-dom";
import { MegaphoneFill } from 'react-bootstrap-icons';

// Styling
import '../styles/Sidebar.css';

function Sidebar() {
    return (
        <div id='sidebar-container'>
            <h1><MegaphoneFill /> Yelper</h1>
            <Link to="/homepage">
                <Button variant="dark">HomePage</Button>
            </Link>
            <Link to="/profile">
                <Button variant="dark">Profile</Button>
            </Link>
            <Link to="/pages">
                <Button variant="dark">Pages</Button>
            </Link>
            <Link to="/login">
                <Button variant="dark">Login/Register</Button>
            </Link>
        </div>
    );
}

export default Sidebar;