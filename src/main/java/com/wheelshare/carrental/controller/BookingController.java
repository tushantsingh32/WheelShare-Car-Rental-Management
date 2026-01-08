package com.wheelshare.carrental.controller;

import com.wheelshare.carrental.model.Booking;
import com.wheelshare.carrental.model.Car;
import com.wheelshare.carrental.service.BookingService;
import com.wheelshare.carrental.service.CarService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;
    private final CarService carService;

    public BookingController(BookingService bookingService, CarService carService) {
        this.bookingService = bookingService;
        this.carService = carService;
    }

    @GetMapping("/new")
    public String showBookingForm(@RequestParam("carId") Long carId, Model model) {
        Car car = carService.getCarById(carId);
        if (car == null || !car.isAvailable()) {
            return "redirect:/cars";
        }
        Booking booking = new Booking();
        booking.setCar(car);
        model.addAttribute("car", car);
        model.addAttribute("booking", booking);
        return "booking-form";
    }

    @PostMapping
    public String createBooking(@RequestParam("carId") Long carId,
                                @RequestParam("customerName") String customerName,
                                @RequestParam("customerEmail") String customerEmail,
                                @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
                                Model model) {
        Car car = carService.getCarById(carId);
        if (car == null) {
            return "redirect:/cars";
        }

        Booking booking = new Booking();
        booking.setCar(car);
        booking.setCustomerName(customerName);
        booking.setCustomerEmail(customerEmail);
        booking.setStartDate(startDate);
        booking.setEndDate(endDate);

        Booking saved;
        try {
            saved = bookingService.createBooking(booking);
        } catch (IllegalStateException | IllegalArgumentException ex) {
            model.addAttribute("car", car);
            model.addAttribute("booking", booking);
            model.addAttribute("error", ex.getMessage());
            return "booking-form";
        }

        model.addAttribute("booking", saved);
        model.addAttribute("car", saved.getCar());
        return "booking-success";
    }

    @PostMapping("/{id}/return")
    public String returnCar(@PathVariable("id") Long id,
                            @RequestParam("customerEmail") String email) {
        bookingService.markReturned(id);
        return "redirect:/history?email=" + email;
    }
}
