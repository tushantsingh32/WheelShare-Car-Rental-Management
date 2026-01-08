package com.wheelshare.carrental.repository;

import com.wheelshare.carrental.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByCustomerEmailOrderByStartDateDesc(String customerEmail);
}
