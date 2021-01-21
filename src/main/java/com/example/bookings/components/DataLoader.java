package com.example.bookings.components;

import com.example.bookings.models.Course;
import com.example.bookings.repositories.BookingRepository;
import com.example.bookings.repositories.CourseRepository;
import com.example.bookings.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader{}

    public void run(ApplicationArguments args){
        Course python = new Course()
    }
}
