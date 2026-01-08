package com.wheelshare.carrental.service;

import com.wheelshare.carrental.model.Booking;
import com.wheelshare.carrental.model.Car;
import com.wheelshare.carrental.repository.BookingRepository;
import com.wheelshare.carrental.repository.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final CarRepository carRepository;

    public BookingService(BookingRepository bookingRepository, CarRepository carRepository) {
        this.bookingRepository = bookingRepository;
        this.carRepository = carRepository;
    }

    @Transactional
    public Booking createBooking(Booking booking) {
        Car car = booking.getCar();
        if (car == null || car.getId() == null) {
            throw new IllegalArgumentException("Car must be set on booking");
        }

        Car managedCar = carRepository.findById(car.getId())
                .orElseThrow(() -> new IllegalArgumentException("Car not found"));

        if (!managedCar.isAvailable()) {
            throw new IllegalStateException("Car is not available");
        }

        long days = ChronoUnit.DAYS.between(booking.getStartDate(), booking.getEndDate());
        if (days <= 0) {
            days = 1;
        }
        double total = days * managedCar.getDailyRate();

        booking.setCar(managedCar);
        booking.setTotalAmount(total);
        booking.setStatus("BOOKED");

        managedCar.setAvailable(false);
        carRepository.save(managedCar);

        return bookingRepository.save(booking);
    }

    @Transactional
    public void markReturned(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new IllegalArgumentException("Booking not found"));
        booking.setStatus("RETURNED");
        bookingRepository.save(booking);

        Car car = booking.getCar();
        car.setAvailable(true);
        carRepository.save(car);
    }

    public List<Booking> getBookingsForCustomer(String email) {
        return bookingRepository.findByCustomerEmailOrderByStartDateDesc(email);
    }

    public Booking getBooking(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }
}
