package com.example.theatre.api;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.theatre.model.AddNewTheater;
import com.example.theatre.model.TheaterDTO;
import com.example.theatre.service.TheaterService;

@RestController
@CrossOrigin
public class TheaterAPI {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	TheaterService theaterService;

	// Fetches details of a specific theater
	@RequestMapping(value = "/theaterdetails/{theaterName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TheaterDTO> getTheaterDetails(@PathVariable String theaterName) {

		logger.info("Theaterdetails request for user {}", theaterName);

		return theaterService.getTheaterDetails(theaterName);
	}
	
	// adds new theater
	@PostMapping(value = "/addTheatre")
	public String addTheater(@RequestBody AddNewTheater addNewTheater) {
		String message;
		message = theaterService.addTheater(addNewTheater);
		System.out.println("Theater added successfully");
		return message;
	} 
	
	// updates a theater
		@PutMapping(value = "/theatre/{theaterId}",produces = MediaType.APPLICATION_JSON_VALUE)
		public String updateTheater(@PathVariable Integer theaterId, @RequestBody TheaterDTO theater) {
			String message;
			message = theaterService.updateTheater(theaterId, theater);
			return message;
		} 
		
		// deletes theater
					@RequestMapping(value = "/theatre/{theaterId}", method = RequestMethod.DELETE )
					public String delete(@PathVariable Integer theaterId) {
						String message;
						message = theaterService.delete(theaterId);
						return message;
					} 
}

