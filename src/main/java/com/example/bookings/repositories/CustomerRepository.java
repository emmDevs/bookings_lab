package com.example.bookings.repositories;

import com.example.bookings.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByBookingsCourseNameIgnoreCase(String course); //derived query

    List<Customer> findByTownAndBookingsCourseNameIgnoreCase(String town, String courseName);

    List<Customer> findByAgeGreaterThanAndTownAndBookingsCourseNameIgnoreCase(int age, String town, String courseName);
}
