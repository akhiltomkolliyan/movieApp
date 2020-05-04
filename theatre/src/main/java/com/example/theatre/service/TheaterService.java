package com.example.theatre.service;

import java.util.List;
import com.example.theatre.model.AddNewTheater;
import com.example.theatre.model.TheaterDTO;

public interface TheaterService {
	 List<TheaterDTO> getTheaterDetails (String theaterName);
	 String addTheater(AddNewTheater addNewTheater);
	 String updateTheater(Integer theaterId, TheaterDTO theater);
	 String delete(Integer theaterId);
} 
