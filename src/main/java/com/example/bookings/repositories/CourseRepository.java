package com.example.bookings.repositories;

import com.example.bookings.models.Course;
import com.example.bookings.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByStarRating(int starRating);

    List<Course> findByBookingsCustomerName(String customerName);

}
