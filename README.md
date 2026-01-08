#WheelShare – Car Rental Management System

WheelShare is a web-based car rental management application developed using Java Spring Boot and MySQL with a responsive frontend built using HTML, CSS, JavaScript, and Bootstrap.
The system enables users to browse available vehicles, rent cars, return them, and view their rental history efficiently.

#Key Features

-Display all available cars for rent
-Rent a car by providing customer details and rental duration
-Automatic calculation of rental charges based on selected dates
-Option to mark a rented vehicle as returned
-View complete rental history using customer email
-Mobile-friendly and responsive UI with Bootstrap
-Persistent data storage using MySQL and JPA/Hibernate

#Tech Stack

-Java
-Spring Boot
-Spring MVC
-Spring Data JPA
-MySQL
-Thymeleaf
-HTML, CSS, JavaScript
-Bootstrap 5
-Maven

## Project Structure

WheelShare-Car-Rental-Management/
│
├── pom.xml
├── README.md
├── database/
│   └── wheelshare.sql
│
└── src/
    ├── main/
    │   ├── java/
    │   │   └── com/
    │   │       └── wheelshare/
    │   │           └── carrental/
    │   │               ├── CarRentalApplication.java
    │   │               ├── controller/
    │   │               │   ├── HomeController.java
    │   │               │   ├── CarController.java
    │   │               │   ├── BookingController.java
    │   │               │   └── HistoryController.java
    │   │               ├── model/
    │   │               │   ├── Car.java
    │   │               │   └── Booking.java
    │   │               ├── repository/
    │   │               │   ├── CarRepository.java
    │   │               │   └── BookingRepository.java
    │   │               └── service/
    │   │                   ├── CarService.java
    │   │                   └── BookingService.java
    │   │
    │   └── resources/
    │       ├── application.properties
    │       ├── templates/
    │       │   ├── index.html
    │       │   ├── booking-form.html
    │       │   ├── booking-success.html
    │       │   ├── history.html
    │       │   └── history-form.html
    │       └── static/
    │           ├── css/
    │           │   └── style.css
    │           └── js/
    │               └── main.js
    │
    └── test/
        └── (auto-generated test files)


        
## 👤 Author

Tushant Singh

 tushant12356@gmail.com
"# WheelShare-Car-Rental-Management" 
