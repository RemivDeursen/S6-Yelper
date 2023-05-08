// src/components/RegisterModal.js
import React, { useState } from "react";

function RegisterModal() {
    const [isOpen, setIsOpen] = useState(false);

    const handleToggle = () => {
        setIsOpen(!isOpen);
    };

    return (
        <div>
            <button onClick={handleToggle}>Register</button>
            {isOpen && (
                <div>
                    <h2>Register</h2>
                    {/* Register form */}
                </div>
            )}
        </div>
    );
}

export default RegisterModal;
