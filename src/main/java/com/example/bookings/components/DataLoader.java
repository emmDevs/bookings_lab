package com.example.bookings.components;

import com.example.bookings.models.Booking;
import com.example.bookings.models.Course;
import com.example.bookings.models.Customer;
import com.example.bookings.repositories.BookingRepository;
import com.example.bookings.repositories.CourseRepository;
import com.example.bookings.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader(){}

    public void run(ApplicationArguments args){
        Course python = new Course("Python Basics", "Kilmarnock", 4);
        courseRepository.save(python);

        Course java = new Course("Java", "Edinburgh", 5);
        courseRepository.save(java);

        Course javaScript = new Course("JavaScript for tumshies", "Glasgow", 2);
        courseRepository.save(javaScript);

        Customer bob = new Customer("Bob Smith", "Edinburgh", 32);
        customerRepository.save(bob);

        Customer john = new Customer("John Hunter", "Kilmarnock", 25);
        customerRepository.save(john);

        Customer emma = new Customer("Emma Hack", "Glasgow", 38);
        customerRepository.save(emma);

        Booking booking1 = new Booking("01-03-2021", python, john);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("05-04-2021", java, bob);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("10-10-2020", javaScript, emma);
        bookingRepository.save(booking3);

        Booking booking4 = new Booking("20-03-2019", javaScript, bob);
        bookingRepository.save(booking4);

        Booking booking5 = new Booking("16-04-2018", python, bob);
        bookingRepository.save(booking5);

        Booking booking6 = new Booking("05-04-2021", java, emma);
        bookingRepository.save(booking6);
    }
}
