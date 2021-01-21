package com.example.bookings;

import com.example.bookings.models.Booking;
import com.example.bookings.models.Course;
import com.example.bookings.models.Customer;
import com.example.bookings.repositories.BookingRepository;
import com.example.bookings.repositories.CourseRepository;
import com.example.bookings.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookingsApplicationTests {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CourseRepository courseRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canFindAllCustomers(){
//		Customer bob = new Customer("Bob Smith", "Edinburgh", 32);
//		customerRepository.save(bob);
//
//		Customer john = new Customer("John Hunter", "Kilmarnock", 25);
//		customerRepository.save(john);
//
//		Customer emma = new Customer("Emma Hack", "Glasgow", 38);
//		customerRepository.save(emma);

		List<Customer> found = customerRepository.findAll();
		assertEquals(3, found.size());
	}

	@Test
	public void canFindBookingByDate(){
		List<Booking> found = bookingRepository.findByDate("05-04-2021");
		assertEquals(2, found.size());
	}

	@Test
	public void canFindCourseByRating(){
		List<Course> found = courseRepository.findByStarRating(5);
		assertEquals(1, found.size());
	}

	@Test
	public void canFindAllCoursesForGivenCustomer(){
		List<Course> found = courseRepository.findByBookingsCustomerNameIgnoreCase("Bob Smith");
		assertEquals(3, found.size());
	}

	@Test
	public void canFindAllCustomersForGivenCourse(){
		List<Customer> found = customerRepository.findByBookingsCourseNameIgnoreCase("Python Basics");
		assertEquals(2, found.size());
	}

	@Test
	public void canFindAllCustomersFromAGivenTownForAGivenCourse(){
		List<Customer> found = customerRepository.findByTownAndBookingsCourseNameIgnoreCase("Edinburgh", "Python Basics");
		assertEquals(1, found.size());
	}

	@Test
	public void canFindAllCustomersOverCertainAgeFromAGivenTownForAGivenCourse(){
		List<Customer> found = customerRepository.findByAgeGreaterThanAndTownAndBookingsCourseNameIgnoreCase(30, "Edinburgh", "Python Basics");
		assertEquals(1, found.size());
	}

	@Test
	public void canFindAllCustomersOverCertainAgeFromAGivenTownForAGivenCourse__NoCustomers(){
		List<Customer> found = customerRepository.findByAgeGreaterThanAndTownAndBookingsCourseNameIgnoreCase(40, "Edinburgh", "Python Basics");
		assertEquals(0, found.size());
	}

}
