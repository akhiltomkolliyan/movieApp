package com.example.Movie.service;

import java.util.List;
import com.example.Movie.entity.MovieEntity;
import com.example.Movie.model.AddNewMovie;
import com.example.Movie.model.MovieDTO;

public interface MovieService {
	 List<MovieDTO> getMovieDetails (String movieName);
	 String addMovie(AddNewMovie addNewMovie);
	 String delete(String movieName);
	String updateMovie(Integer movieId, AddNewMovie addNewMovie);
}
