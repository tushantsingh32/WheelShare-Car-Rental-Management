# WheelShare – Car Rental Management

WheelShare is a web-based car rental management system built using Java Spring Boot, MySQL, HTML, CSS, JavaScript, and Bootstrap. The application allows users to view available cars, book rentals, return vehicles, and check their complete rental history.

---

## Features

- View list of available cars
- Book a car with name, email, and rental dates
- Automatic calculation of total rental amount
- Mark a booking as returned
- View rental history using customer email
- Responsive UI using Bootstrap
- MySQL database with JPA/Hibernate

---

## Technologies Used

- Java  
- Spring Boot  
- Spring MVC  
- Spring Data JPA  
- MySQL  
- Thymeleaf  
- HTML, CSS, JavaScript  
- Bootstrap 5  
- Maven  

---

## Project Structure

WheelShare - Car Rental Management/
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
    │   │               │
    │   │               ├── controller/
    │   │               │   ├── HomeController.java
    │   │               │   ├── CarController.java
    │   │               │   ├── BookingController.java
    │   │               │   └── HistoryController.java
    │   │               │
    │   │               ├── model/
    │   │               │   ├── Car.java
    │   │               │   └── Booking.java
    │   │               │
    │   │               ├── repository/
    │   │               │   ├── CarRepository.java
    │   │               │   └── BookingRepository.java
    │   │               │
    │   │               └── service/
    │   │                   ├── CarService.java
    │   │                   └── BookingService.java
    │   │
    │   └── resources/
    │       ├── application.properties
    │       │
    │       ├── templates/
    │       │   ├── index.html
    │       │   ├── booking-form.html
    │       │   ├── booking-success.html
    │       │   ├── history.html
    │       │   └── history-form.html
    │       │
    │       └── static/
    │           ├── css/
    │           │   └── style.css
    │           │
    │           └── js/
    │               └── main.js
    │
    └── test/
        └── (auto-generated test files)

        
## 👤 Author

Vyas Mittal

vyasmittal1206@gmail.com
"# WheelShare-Car-Rental-Management" 
