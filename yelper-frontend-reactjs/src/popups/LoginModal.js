// src/components/LoginModal.js
import React, { useState } from "react";

function LoginModal() {
    const [isOpen, setIsOpen] = useState(false);

    const handleToggle = () => {
        setIsOpen(!isOpen);
    };

    return (
        <div>
            <button onClick={handleToggle}>Log in</button>
            {isOpen && (
                <div>
                    <h2>Log in</h2>
                    {/* Login form */}
                </div>
            )}
        </div>
    );
}

export default LoginModal;
