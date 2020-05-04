package com.example.booking.api;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.booking.model.BookTicketDTO;
import com.example.booking.model.ShowsDTO;
import com.example.booking.service.BookingService;

@RestController
@CrossOrigin
public class BookingAPI {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BookingService bookingService;

	@PatchMapping(value = "/ticketdetails")
	public String getBookingDetails(@RequestBody BookTicketDTO bookTicket) {
		String message;
		message = bookingService.getBookingDetails(bookTicket);
		return message;
	}

	// Fetches details of a specific show
	@RequestMapping(value = "/showdetails/{showId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ShowsDTO> getMovieDetails(@PathVariable Integer showId) {

		logger.info("Showdetails request for user {}", showId);

		return bookingService.getShowDetails(showId);
	}

	// adds new show
	@PostMapping(value = "/addShow")
	public String addShow(@RequestBody ShowsDTO show) {
		String message;
		message = bookingService.addShow(show);
		return message;
	}

	// updates show
	@PutMapping(value = "/show/{showId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String updateShow(@PathVariable Integer showId, @RequestBody ShowsDTO shows) {
		String message;
		message = bookingService.updateShow(showId, shows);
		return message;
	}

	// deletes show
	@RequestMapping(value = "/show/{showId}", method = RequestMethod.DELETE)
	public String deleteShow(@PathVariable Integer showId) {
		String message;
		message = bookingService.deleteShow(showId);
		return message;
	}

	// cancels Booking
	@RequestMapping(value = "/booking/{bookingId}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Integer bookingId) {
		String message;
		message = bookingService.delete(bookingId);
		return message;
	}

}
