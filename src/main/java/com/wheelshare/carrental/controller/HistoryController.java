package com.wheelshare.carrental.controller;

import com.wheelshare.carrental.service.BookingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HistoryController {

    private final BookingService bookingService;

    public HistoryController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/history")
    public String showHistory(@RequestParam(value = "email", required = false) String email,
                              Model model) {
        if (email == null || email.isBlank()) {
            return "history-form";
        }
        model.addAttribute("email", email);
        model.addAttribute("bookings", bookingService.getBookingsForCustomer(email));
        return "history";
    }
}
