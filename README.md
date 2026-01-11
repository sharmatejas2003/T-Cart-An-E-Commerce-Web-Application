#  T-Cart — E-Commerce Web Application (Java)

T-Cart is a full-stack e-commerce web application developed using **Java, JSP, Servlets, JDBC, and MySQL**, following the **MVC (Model–View–Controller)** architecture.  
The project demonstrates real-world backend concepts such as session management, request routing, database integration, and deployment using **Apache Tomcat**.

The application is designed for learning and demonstration purposes and can be accessed locally or exposed publicly using **ngrok**.

---

##  Features

- User Registration & Login (Session-based authentication)
- Category-wise Product Browsing
- Product Search (by keyword)
- Discount Handling
- Add to Cart & Cart Management
- Order Placement
- Admin Dashboard (basic)
- MVC Architecture
- JDBC + MySQL Integration

---

##  Tech Stack

### Backend
- Java (JDK 17+)
- JSP & Servlets
- JDBC
- Apache Tomcat 11

### Frontend
- JSP (View layer)
- HTML5
- CSS3

### Database
- MySQL

### Tools
- Eclipse IDE
- Git & GitHub
- ngrok (for public demo)

----------

###  Project Structure
ECommerceProject/
│
├── src/
│ └── main/
│ └── java/
│ └── com/
│ └── ecommerce/
│ ├── controller/
│ │ ├── LoginServlet.java
│ │ ├── RegisterServlet.java
│ │ ├── ProductServlet.java
│ │ ├── CartServlet.java
│ │ ├── OrderServlet.java
│ │ └── ViewCartServlet.java
│ │
│ ├── dao/
│ │ ├── DBUtil.java
│ │ ├── ProductDAO.java
│ │ ├── UserDAO.java
│ │ └── CategoryDAO.java
│ │
│ ├── model/
│ │ ├── Product.java
│ │ ├── User.java
│ │ └── CartItem.java
│ │
│ └── service/
│ ├── ProductService.java
│ └── UserService.java
│
├── webapp/
│ ├── WEB-INF/
│ │ ├── views/
│ │ │ ├── login.jsp
│ │ │ ├── register.jsp
│ │ │ ├── products.jsp
│ │ │ ├── cart.jsp
│ │ │ └── admin.jsp
│ │ │
│ │ └── web.xml
│ │
│ └── META-INF/
│ └── MANIFEST.MF
│
├── .gitignore
├── README.md
└── LICENSE



**Public Access Using ngrok (Temporary Hosting)**
When the application is not deployed on a cloud server, ngrok can be used to temporarily expose the locally running application to the public internet.

**Steps:**
ngrok http 8080

_Example public URL:_   https://xxxxxx.ngrok-free.dev/ECommerceProject/products

**Notes:**
URL changes after restart (free version)
Application runs from local machine
Database remains local

**Purpose of the Project**
This project was developed to:
1> Learn Java web development fundamentals
2> Understand MVC architecture
3> Practice JDBC and relational database design.
4> Gain experience with deployment and exposure tools.
5> Serve as a portfolio and interview demonstration project.


**License**
This project is licensed under the MIT License.

**Creator**
Tejas Sharma

Contact -> tejassharma939@gmail.com


**License
Copyright © 2026 Tejas Sharma
This project is developed for educational, learning, and demonstration purposes.You are free to use, modify, and distribute this project under the terms of the MIT License.**
