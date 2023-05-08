const db = {
    users: [
        { id: 0, firstName: "John", lastName: "Doe", username: "jdoe", password: "password", email: "jdoe@example.com", threads: [0] },
        { id: 1, firstName: "Jane", lastName: "Doe", username: "jane", password: "password", email: "jane@example.com", threads: [0] },
        { id: 2, firstName: "Bob", lastName: "Smith", username: "bsmith", password: "password", email: "bsmith@example.com", threads: [1, 2] },
        { id: 3, firstName: "Alice", lastName: "Johnson", username: "ajohnson", password: "password", email: "ajohnson@example.com", threads: [2] },
        { id: 4, firstName: "Mike", lastName: "Brown", username: "mbrown", password: "password", email: "mbrown@example.com", threads: [3] },
    ],
    messages: [
        { id: 0, user: 0, message: "This is the first message", likes: 69, shares: 420 },
        { id: 1, user: 1, message: "This is a reply to the first message", likes: 69, shares: 420 },
        { id: 2, user: 0, message: "This is another message", likes: 69, shares: 420 },
        { id: 3, user: 2, message: "Thread 2: This is the first message", likes: 69, shares: 420 },
        { id: 4, user: 0, message: "Thread 2: This is a reply to the first message", likes: 69, shares: 420 },
        { id: 5, user: 2, message: "Thread 2: This is another reply to the first message", likes: 69, shares: 420 },
        { id: 6, user: 1, message: "Thread 3: This is the first message", likes: 69, shares: 420 },
        { id: 7, user: 2, message: "Thread 3: This is a reply to the first message", likes: 69, shares: 420 },
        { id: 8, user: 3, message: "Thread 3: This is another reply to the first message", likes: 69, shares: 420 },
        { id: 9, user: 2, message: "Thread 4: This is the first message", likes: 69, shares: 420 },
        { id: 10, user: 4, message: "Thread 4: This is a reply to the first message", likes: 69, shares: 420 },
    ],
    threads: [
        { id: 0, messageList: [0, 1] },
        { id: 1, messageList: [3, 4, 5] },
        { id: 2, messageList: [6, 7, 8] },
        { id: 3, messageList: [9, 10] },
    ],
};

export default db;
