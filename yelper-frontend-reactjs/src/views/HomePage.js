// src/components/HomePage.js
import React, {useState, useEffect} from "react";
import db from "../util/MockDB";
import axios from "axios";
import Thread from "../components/Thread";
// Styling
import '../styles/HomePage.css';

function HomePage() {
    const [data, setData] = useState(null);

    useEffect(() => {
        axios
            .get("http://localhost:8080/api/users/1")
            .then((response) => setData(response.data))
            .catch((error) => {
                // console.log(error)
                setData(db)
            });
    }, []);

    return (
        <>
            <h1>Homepage</h1>
            <Thread/>
        </>
    );
}

export default HomePage;
