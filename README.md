# 🛒 Digikala Online Shop Simulator

**Course:** Advanced Programming - Spring 2023  
**Project Type:** Solo Project
**Score:** 460 out of 400 [60 extra points]



## 🚀 Introduction
A **command-line-based online shop simulator** inspired by **Digikala & Amazon**.  
Implemented in **Java**, showcasing **OOP principles**: inheritance, polymorphism, abstraction, and encapsulation.

---

## 📝 Features

### 🏬 Shop
- Name, web address & support phone  
- Manages **accounts, products, orders, and profit**

### 👥 Account Types
- **Admin**: manage funds, authorize sellers, add new admins  
- **User**: register, browse products, manage cart, place orders  
- **Seller**: manage products, receive payments after order confirmation  

### 📦 Products & Cart
- Products: name, price, quantity, comments, category  
- **10+ categories** using inheritance  
- Users can search, view, add to cart, update cart, and checkout  

### 💳 Wallet & Orders
- Admins add funds to users  
- Sellers earn after order confirmation  
- Shop earns **10% commission** per product  
- Orders: date, total price, buyer & seller info  

---

## ✨ Bonus Features
- Persistent data storage (files/DB)  
- GUI with **JavaFX**  
- Product rating & recommendations  
- Multiple sellers per product  
- Shipping fees, notifications, subscription & refund system  

---

## 🛠 Tools & Libraries
- **Java**, **UUID**, **Maven/Gradle**  
- Optional: **JavaFX**, **PostgreSQL**  

---

## ⚡ Setup & Run
```bash
git clone https://github.com/<your-username>/digikala-simulator.git
cd digikala-simulator
mvn clean install   # or gradle build
java -jar target/digikala-simulator.jar

