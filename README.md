# 🌐 SocialSphere – A Facebook-like Social Media Web App

### 🧠 Overview
**SocialSphere** is a simple, text-based social networking platform built using **Java EE (Servlets, JSP, JDBC)** and an **H2 Database**.  
It allows users to **register, log in, create posts, view posts, and comment** on other users’ posts — mimicking a minimal version of Facebook.

This project demonstrates **core Java EE concepts**, **MVC architecture**, and **object-oriented design principles** (Encapsulation, Abstraction, Inheritance, Polymorphism).

## 🚀 Features

✅ **User Registration** – Sign up with a username, email, and password.  
✅ **User Login** – Authenticate securely against the H2 database.  
✅ **Create Post** – Add new text-based posts with timestamps.  
✅ **View All Posts** – Display all user posts in reverse chronological order.  
✅ **Add Comments** – Comment under any post.  
✅ **Session Management** – Only logged-in users can create or comment.  
✅ **Lightweight UI** – Simple HTML and JSP-based interface (no CSS/JS).  

## 🏗️ Project Architecture (MVC Pattern)

#📦 SocialSphere
- ┣ 📂 src
- ┃ ┣ 📂 main
- ┃ ┃ ┣ 📂 java
- ┃ ┃ ┃ ┣ 📂 dao              DAO interfaces
- ┃ ┃ ┃ ┣ 📂 daoImpl          DAO implementation classes
- ┃ ┃ ┃ ┣ 📂 model            Encapsulated data models (User, Post, Comment)
- ┃ ┃ ┃ ┣ 📂 servlets         Controller layer handling requests
- ┃ ┃ ┃ ┗ 📂 util             Database connection utility
- ┃ ┃ ┣ 📂 webapp
- ┃ ┃ ┃ ┣ 📜 index.jsp        Entry point
- ┃ ┃ ┃ ┣ 📜 login.jsp        Login page
- ┃ ┃ ┃ ┣ 📜 register.jsp     Registration page
- ┃ ┃ ┃ ┣ 📜 home.jsp         Main homepage displaying posts/comments
- ┃ ┃ ┃ ┣ 📜 createPost.jsp   Create new post page
- ┃ ┃ ┃ ┗ 📜 WEB-INF/web.xml  Deployment descriptor (if applicable)
- ┃ ┗ 📜 pom.xml              Maven dependencies and project configuration
- ┗ 📂 target                 Compiled WAR file output

## 🧰 Tech Stack

| Layer | Technology Used |
|--------|-----------------|
| **Frontend** | JSP (JavaServer Pages), HTML |
| **Backend** | Java Servlets (Jakarta EE) |
| **Database** | H2 Database (Embedded mode) |
| **ORM/DAO** | JDBC (Java Database Connectivity) |
| **Server** | Apache Tomcat |
| **Build Tool** | Maven |
| **Language** | Java 8+ |

## ⚙️ Installation and Setup

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/your-username/SocialSphere.git
cd SocialSphere
````

### 2️⃣ Configure the Database (H2)

The app uses an **H2 file-based database** 
To access it:

1. Run the H2 Console

2. Username: `sa`
   Password: *(leave blank)*

3. Then create the required tables:

   ```sql
   CREATE TABLE USERS (
       userId INT AUTO_INCREMENT PRIMARY KEY,
       username VARCHAR(100) NOT NULL,
       email VARCHAR(100) NOT NULL,
       password VARCHAR(100) NOT NULL
   );

   CREATE TABLE POSTS (
       postId INT AUTO_INCREMENT PRIMARY KEY,
       userId INT,
       title VARCHAR(200),
       content VARCHAR(1000),
       createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
       FOREIGN KEY (userId) REFERENCES USERS(userId)
   );

   CREATE TABLE COMMENTS (
       commentId INT AUTO_INCREMENT PRIMARY KEY,
       postId INT,
       userId INT,
       commentContent VARCHAR(500),
       createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
       FOREIGN KEY (postId) REFERENCES POSTS(postId),
       FOREIGN KEY (userId) REFERENCES USERS(userId)
   );
   ```

---

### 3️⃣ Build the Project

Use Maven to build and package the application:

```bash
mvn clean package
```

It will generate a WAR file:

```
target/SocialSphere.war
```

---

### 4️⃣ Deploy on Apache Tomcat

1. Copy the generated `SocialSphere.war` file into:

   ```
   <Tomcat Installation Directory>/webapps/
   ```
2. Start Tomcat.
3. Access the app in your browser:

   ```
   http://localhost:8080/SocialSphere/
   ```

---

## 🧩 Application Flow

| Step | Page                  | Functionality                                                 |
| ---- | --------------------- | ------------------------------------------------------------- |
| 1️⃣  | **index.jsp**         | Entry page with “Login” and “Register” buttons                |
| 2️⃣  | **register.jsp**      | New users register; validation checks empty fields            |
| 3️⃣  | **login.jsp**         | Existing users log in; invalid credentials show error         |
| 4️⃣  | **home.jsp**          | Displays all posts and comments; create post button available |
| 5️⃣  | **createPost.jsp**    | Allows user to create a new text post                         |
| 6️⃣  | **addCommentServlet** | Handles comment form submissions                              |
| 7️⃣  | **logout**            | Redirects to index.jsp and clears the session                     |

---

## 🧱 Object-Oriented Design Usage

| OOP Concept       | Implementation in Project                                                                       |
| ----------------- | ----------------------------------------------------------------------------------------------- |
| **Encapsulation** | All model classes (`User`, `Post`, `Comment`) have private fields with getters/setters.         |
| **Abstraction**   | DAO interfaces (`UserDAO`, `PostDAO`, `CommentDAO`) hide database implementation details.       |
| **Inheritance**   | All servlets extend `HttpServlet` and override `doGet()` / `doPost()`.                          |
| **Polymorphism**  | DAO interface references call implementations dynamically (`UserDAO dao = new UserDAOImpl();`). |

---

## 💾 Database Connection

```java
private static final String URL = "jdbc:h2 - your url";
private static final String USER = "sa";
private static final String PASS = "";
```

This connects to the H2 database in **file mode**, so your data persists across sessions.

---

## 📚 Key Learnings and Concepts

* Java EE web development fundamentals (Servlets, JSP, JDBC)
* MVC (Model–View–Controller) pattern
* DAO (Data Access Object) design
* Session handling using `HttpSession`
* Relational schema design (Users–Posts–Comments)
* Dynamic HTML rendering via JSP

---

## 🧑‍💻 Future Enhancements

* Add user profile pictures and bio section
* Implement likes/dislikes feature
* Integrate CSS for better styling
* Enable real-time updates using AJAX
* Add password encryption
* Deploy on cloud (Heroku / AWS / Render)

---

## 🧑‍🎓 Developed By

**Keerthikrishna Jog**
🎓 Computer Science Engineering | MIT ADT University, Pune
💡 Interests: Data Science | AI | Web Development | Analytics
📧 Contact: `keerthikrishnajog120304@gmail.com`

---

> *“SocialSphere is a minimalist yet powerful demonstration of how modern social platforms are built from the ground up using clean Java EE architecture.”*

```
