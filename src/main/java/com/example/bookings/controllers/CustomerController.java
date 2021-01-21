package com.example.bookings.controllers;

import com.example.bookings.models.Course;
import com.example.bookings.models.Customer;
import com.example.bookings.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@RestController
public class CustomerController {

    @Configuration
    public class WebConfig implements WebMvcConfigurer {
        @Override
        public void configurePathMatch(PathMatchConfigurer configurer) {
            AntPathMatcher matcher = new AntPathMatcher();
            matcher.setCaseSensitive(false);
            configurer.setPathMatcher(matcher);
        }
    }


    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(
            @RequestParam(required = false, name = "course") String course,
            @RequestParam(required = false, name = "town") String town,
            @RequestParam(required = false, name = "age") Integer age
    ) {
        if (course != null) {
            return new ResponseEntity<>(customerRepository.findByBookingsCourseNameIgnoreCase(course), HttpStatus.OK);
        }
        if(course != null && town != null){
            return new ResponseEntity<>(customerRepository.findByTownAndBookingsCourseNameIgnoreCase(town, course), HttpStatus.OK);
        }
        if(course != null && town != null && age != null){
            return new ResponseEntity<>(customerRepository.findByAgeGreaterThanAndTownAndBookingsCourseNameIgnoreCase(age, town, course), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }
}


