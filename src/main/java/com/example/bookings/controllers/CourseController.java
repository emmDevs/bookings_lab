package com.example.bookings.controllers;

import com.example.bookings.models.Course;
import com.example.bookings.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RestController
public class CourseController {

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
    CourseRepository courseRepository;

    @GetMapping(value="/courses")
    public ResponseEntity<List<Course>> findAllCourses(
            @RequestParam(name="starRating", required = false)Integer starRating,
            @RequestParam(name="customerName", required = false) String customerName
    ){
        if(starRating != null){
            return new ResponseEntity<>(courseRepository.findByStarRating(starRating), HttpStatus.OK);
        }
        if(customerName != null){
            return new ResponseEntity<>(courseRepository.findByBookingsCustomerNameIgnoreCase(customerName), HttpStatus.OK);
        }
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }
}
