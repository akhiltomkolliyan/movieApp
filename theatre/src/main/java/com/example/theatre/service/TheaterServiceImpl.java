package com.example.theatre.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.theatre.dao.TheaterDAO;
import com.example.theatre.entity.TheaterEntity;
import com.example.theatre.model.AddNewTheater;
import com.example.theatre.model.TheaterDTO;
@Service
public class TheaterServiceImpl implements TheaterService{
	@Autowired
	TheaterDAO theaterDAO;

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public List<TheaterDTO> getTheaterDetails(String theaterName) {
		// TODO Auto-generated method stub
		logger.info("Theaterdetails request for customer {}", theaterName);

		List<TheaterEntity> theaterEntities=theaterDAO.findByTheaterName(theaterName);
	
		List<TheaterDTO> theaterDTO = new ArrayList<TheaterDTO>();

		for (TheaterEntity theater : theaterEntities) {
			theaterDTO.add(TheaterDTO.valueOf(theater));
		}
		return theaterDTO;
	}
	
	public String addTheater(AddNewTheater addNewTheater) {
		String message = null;
		TheaterEntity theater1 = new TheaterEntity();
			message = addNewTheater.getTheaterName() + "has been added successfully";
			theater1.setTheaterName(addNewTheater.getTheaterName());
			theater1.setAddress(addNewTheater.getAddress());
			theater1.setSeatingCapacity(addNewTheater.getSeatingCapacity());
			theater1.setCity(addNewTheater.getCity());
			theaterDAO.save(theater1);
		return message;
	}
	
	public String updateTheater(Integer theaterId, TheaterDTO theater) {
		String message = null;
		TheaterEntity theater1 = new TheaterEntity();
		theater1 = theaterDAO.findByTheaterId(theaterId);
		message = theater.getTheaterName() + " has been updated successfully";
		theater1.setTheaterName(theater.getTheaterName());
		theater1.setAddress(theater.getAddress());
		theater1.setSeatingCapacity(theater.getSeatingCapacity());
		theater1.setCity(theater.getCity());
		theaterDAO.save(theater1);
		return message;
	}
	

	@Override
	public String delete(Integer theaterId) {
		String message = null;
		TheaterEntity theater1 = new TheaterEntity();
		theater1 = theaterDAO.findByTheaterId(theaterId);
		if ( theater1.getTheaterId().equals(theaterId)){
			message = theater1.getTheaterName() + " has been deleted successfully";
			theaterDAO.delete(theater1);
		}
		return message;
	}
}
