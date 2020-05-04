package com.example.booking.service;


import java.util.List;

import com.example.booking.entity.BookingEntity;
import com.example.booking.model.BookTicketDTO;
import com.example.booking.model.ShowsDTO;

public interface BookingService {

	String getBookingDetails(BookTicketDTO bookTicket);
	List<ShowsDTO> getShowDetails(Integer showId);
	String addShow(ShowsDTO show);
	String updateShow(Integer showId, ShowsDTO shows);
	String deleteShow(Integer showId);
	String delete(Integer bookingId);
	//String book(BookTicketDTO bookTicket);
	

}
