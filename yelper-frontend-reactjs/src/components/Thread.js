import React from "react";
import db from "../util/MockDB";
import Card from "react-bootstrap/Card";
// I want to import the Thread css file here
import "../styles/Thread.css";
import { HandThumbsUpFill, ShareFill } from 'react-bootstrap-icons';
// to add a prop to the component, do this:
// function Messages(userId)
// then to call it from the parent component, do this:
// <Messages userId={1} />
function Thread() {
    // set the userId to 1 for now
    const userId = 2;
    return (
        <div>
            {db.users[userId].threads.map((threadId, threadIndex) => {
                // Grab the individual thread from the db of this user
                const thread = db.threads.find((thread) => thread.id === threadId);
                // REMOVE: temporary debugging
                console.log("ThreadID: ", threadId, "ThreadIndex: ", threadIndex);
                console.log("Thread: ", thread);
                // I want to map the messageList of thread to the messages in db.messages
                return (<div className={"thread-container"} key={threadIndex}>
                    {thread.messageList.map((messageId, index) => {
                        // Grab the individual message from the db that matches the messageId
                        // and the user from the db that matches the user of the message
                        // then return the message and user
                        // split the initial message and the replies into two separate cards
                        const post = db.messages.find((message) => message.id === messageId);
                        const user = db.users.find((user) => user.id === post.user);
                        // REMOVE: temporary debugging
                        console.log("Post: ", user, post);
                        return (
                            <Card
                                key={`message-${post.id}`}
                                className={`message ${index === 0 ? "first-message" : "comment"}`}
                            >
                                <Card.Body>
                                    <Card.Title>{user.firstName} {user.lastName}</Card.Title>
                                    <Card.Text>{post.message}</Card.Text>
                                    <Card.Subtitle><HandThumbsUpFill/> {post.likes}  - <ShareFill/> Shared: {post.shares}</Card.Subtitle>
                                </Card.Body>
                            </Card>
                        );
                    })}
                </div>);
            })}
        </div>
    );
}

export default Thread;