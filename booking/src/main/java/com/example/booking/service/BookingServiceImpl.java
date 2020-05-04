package com.example.booking.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.booking.dao.BookingDAO;
import com.example.booking.dao.MovieDAO;
import com.example.booking.dao.ShowsDAO;
import com.example.booking.dao.TheaterDAO;
import com.example.booking.dao.UserDAO;
import com.example.booking.entity.BookingEntity;
import com.example.booking.entity.MovieEntity;
import com.example.booking.entity.TheaterEntity;
import com.example.booking.entity.ShowsEntity;
import com.example.booking.model.BookTicketDTO;
import com.example.booking.model.BookingDTO;
import com.example.booking.model.ShowsDTO;
import com.example.booking.entity.UserEntity;
@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingDAO bookingDAO;
	
	@Autowired
	ShowsDAO showsDAO;
	
	@Autowired
	TheaterDAO theaterDAO;
	
	@Autowired
	MovieDAO movieDAO;
	
	@Autowired
	UserDAO userDAO;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	

	@Override
	public String getBookingDetails(BookTicketDTO bookTicket) {
		// TODO Auto-generated method stub

		logger.info("Bookingdetails request for customer {}", bookTicket.getMovieName());
		String message = null;
		String theaterName = bookTicket.getTheaterName();
		System.out.println(theaterName + "    Theater name");
		String username = bookTicket.getUserName();
		String city = bookTicket.getCity();
		System.out.println(city + " City Name");
		String movieName=bookTicket.getMovieName();
		TheaterEntity theaterEntity = theaterDAO.findByTheaterNameAndCity(theaterName,city);
		System.out.println(theaterEntity.getCity());
	
		UserEntity userEntity = userDAO.findByUserName(username);
		MovieEntity movieEntity= movieDAO.findByMovieName(movieName);
		Integer theaterId=theaterEntity.getTheaterId();
		Integer movieId= movieEntity.getMovieId();
		Integer userId= userEntity.getUserId();
		
		ShowsEntity showsEntity= showsDAO.findByMovieIdAndTheaterId(movieId,theaterId);
		float totalCost = 0;
		//if (movieEntity!=null && theaterEntity!=null)
		if (movieName!=null && theaterName!=null)
		{
		BookingEntity bookingEntity = new BookingEntity();
		bookingEntity.setUserId(userId);
		bookingEntity.setShowId(showsEntity.getShowId());
		bookingEntity.setSeatsBooked(bookTicket.getSeatsforBooking());
		totalCost = ( bookTicket.getSeatsforBooking() * showsEntity.getUnitPrice() );
		bookingEntity.setTotalCost(totalCost);
		bookingDAO.save(bookingEntity);
			message ="Booking Successful'";
		}
		return message;
	} 
	

		
		

	@Override
	public List<ShowsDTO> getShowDetails(Integer showId) {
		// TODO Auto-generated method stub

		logger.info("Showdetails request for customer {}", showId);

		ShowsEntity showsEntities=showsDAO.findByShowId(showId);
		List<ShowsDTO> showsDTO = new ArrayList<ShowsDTO>();
		showsDTO.add(ShowsDTO.valueOf(showsEntities));
		
		return showsDTO;
	}

	public String addShow(ShowsDTO showsDTO) {
		String message = null;
		ShowsEntity show1 = new ShowsEntity();
			message = "Show has been added successfully";
			show1.setShowDate(showsDTO.getShowDate());
			show1.setShowTime(showsDTO.getShowTime());
			show1.setAvailableSeats(showsDTO.getAvailableSeats());
			show1.setUnitPrice(showsDTO.getUnitPrice());
			showsDAO.save(show1);
		return message;
	}


	public String updateShow(Integer showId, ShowsDTO shows) {
		String message = null;
		ShowsEntity show1 = new ShowsEntity();
		show1 = showsDAO.findByShowId(showId);
		message = "Show has been updated successfully";
		show1.setShowDate(shows.getShowDate());
		show1.setShowTime(shows.getShowTime());
		show1.setAvailableSeats(shows.getAvailableSeats());
		show1.setUnitPrice(shows.getUnitPrice());
		showsDAO.save(show1);
		return message;
	}


	public String deleteShow(Integer showId) {
		String message = null;
		ShowsEntity show1 = new ShowsEntity();
		show1 = showsDAO.findByShowId(showId);
		if ( show1.getTheaterId().equals(showId)){
			message = "Show has been deleted successfully";
			showsDAO.delete(show1);
		}
		return message;
	}

	public String delete(Integer bookingId) {
		String message = null;
		BookingEntity booking1 = new BookingEntity();
		booking1 = bookingDAO.findByBookingId(bookingId);
		if ( booking1.getBookingId().equals(bookingId)){
			message = "Booking has been cancelled successfully";
			bookingDAO.delete(booking1);
		}
		return message;
	}



	

}