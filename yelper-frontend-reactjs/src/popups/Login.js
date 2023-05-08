import React, { useState } from 'react';

function Login() {
    let User = { username: '', password: '' };
    const [user, setUser] = useState<User>({ username: '', password: '' });

    const handleLogin = async () => {
        try {
            const response = await fetch('/api/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(user)
            });

            const data = await response.json();
            console.log(data); // user data
        } catch (error) {
            console.error(error);
        }
    };

    return (
        <div>
            <input type="text" value={user.username} onChange={(e) => setUser({ ...user, username: e.target.value })} />
            <input type="password" value={user.password} onChange={(e) => setUser({ ...user, password: e.target.value })} />
            <button onClick={handleLogin}>Login</button>
        </div>
    );
}

export default Login;