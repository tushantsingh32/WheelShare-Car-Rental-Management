-- MySQL schema for WheelShare Spring Boot project

CREATE DATABASE IF NOT EXISTS wheelshare_db;
USE wheelshare_db;

CREATE TABLE IF NOT EXISTS cars (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  brand VARCHAR(100) NOT NULL,
  model VARCHAR(100) NOT NULL,
  registration_number VARCHAR(50) NOT NULL UNIQUE,
  daily_rate DOUBLE NOT NULL,
  available TINYINT(1) NOT NULL DEFAULT 1
);

CREATE TABLE IF NOT EXISTS bookings (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  customer_name VARCHAR(150) NOT NULL,
  customer_email VARCHAR(150) NOT NULL,
  car_id BIGINT NOT NULL,
  start_date DATE NOT NULL,
  end_date DATE NOT NULL,
  total_amount DOUBLE NOT NULL,
  status VARCHAR(20) NOT NULL,
  CONSTRAINT fk_booking_car FOREIGN KEY (car_id) REFERENCES cars(id)
);

INSERT INTO cars(brand, model, registration_number, daily_rate, available) VALUES
('Honda', 'City ZX', 'DL01AB1234', 2200, 1),
('Hyundai', 'Creta SX', 'DL02CD5678', 2800, 1),
('Maruti', 'Baleno', 'DL03EF9012', 1800, 1)
ON DUPLICATE KEY UPDATE brand = VALUES(brand);
