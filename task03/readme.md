# Java Client-Server Chat Application

## Project Overview

This project is a **Client-Server Chat Application** developed using **Java Socket Programming** and **Multithreading**.  
The application allows multiple clients to connect to a single server and communicate with each other in real-time.

The server handles multiple users simultaneously using separate threads for each client connection.

---

#  Objectives

- Implement client-server communication using Java sockets.
- Enable real-time chat between multiple users.
- Use multithreading to handle multiple clients simultaneously.
- Understand networking concepts in Java.

---

#  Technologies Used

- Java
- Socket Programming
- Multithreading
- DataInputStream & DataOutputStream
- TCP/IP Protocol

---

# 📁 Project Structure

```text
ChatApplication/
│
├── Server.java
├── ClientHandler.java
└── Client.java

```
# ⚙️ Working of the Application

## 🔹 Server Side

The server:

- Starts on a specific port number.
- Waits for client connections.
- Accepts multiple clients.
- Creates a separate thread for every client.
- Broadcasts messages to all connected users.

---

## 🔹 Client Side

The client:

- Connects to the server using IP address and port.
- Sends username to the server.
- Sends and receives messages simultaneously.
- Uses multithreading for continuous communication.

---

# 📄 Source Code Explanation

## 1️⃣ Server.java

### Responsibilities

- Starts the server socket.
- Accepts incoming client connections.
- Stores connected clients.
- Broadcasts messages.

### Important Concepts

- `ServerSocket`
- Infinite connection loop
- Client list using `Vector`
- Broadcasting messages

---

## 2️⃣ ClientHandler.java

### Responsibilities

- Handles communication for one client.
- Runs as a separate thread.
- Receives and forwards messages.

### Important Concepts

- `Runnable Interface`
- Multithreading
- Message handling
- Client disconnection handling

---

## 3️⃣ Client.java

### Responsibilities

- Connects to server.
- Sends messages.
- Receives messages.

### Important Concepts

- `Socket`
- Input/Output streams
- Receiver thread
- Real-time communication

---

# ▶️ How to Run the Project

## Step 1: Compile Java Files

Open terminal inside the project folder.

```bash
javac *.java
```

---

## Step 2: Run Server

```bash
java Server
```

### Output

```text
Server started...
Waiting for clients...
```

---

## Step 3: Run Clients

Open multiple terminals and run:

```bash
java Client
```

---

# 💬 Example Output

## Client 1

```text
Enter your name:
Jay

Hello everyone!
```

---

## Client 2

```text
Enter your name:
Rahul

Jay: Hello everyone!
```

---

# 🔥 Features

- Multiple client support
- Real-time messaging
- Multithreading
- Client join/leave notifications
- Simple console interface

---

# ✅ Advantages

- Easy to understand
- Efficient communication
- Demonstrates networking concepts
- Scalable for future improvements

---

# 🚀 Future Enhancements

The project can be improved by adding:

- GUI using Java Swing or JavaFX
- Private messaging
- File sharing
- Chat history storage
- Encryption & security
- User authentication
- Online users list

---

# 📚 Concepts Learned

- Socket Programming
- TCP Communication
- Multithreading
- Concurrent Programming
- Java Networking APIs

---

# 🧠 Conclusion

This project demonstrates the implementation of a real-time multi-user chat application using Java sockets and multithreading.  
It provides practical knowledge of networking and concurrent programming concepts in Java.

The application successfully allows multiple clients to communicate through a centralized server efficiently.

---

# 👨‍💻 Developed Using

- Java
- Socket Programming
- Multithreading
