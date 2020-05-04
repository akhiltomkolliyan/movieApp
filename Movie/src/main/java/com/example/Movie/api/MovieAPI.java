package com.example.Movie.api;

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
import com.example.Movie.model.AddNewMovie;
import com.example.Movie.model.MovieDTO;
import com.example.Movie.service.MovieService;

@RestController
@CrossOrigin
public class MovieAPI {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	MovieService movieService;

	// Fetches details of a specific movie
	@RequestMapping(value = "/moviedetails/{movieName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MovieDTO> getMovieDetails(@PathVariable String movieName) {

		logger.info("Moviedetails request for user {}", movieName);

		return movieService.getMovieDetails(movieName);
	}
	
	// adds new movie
		@PostMapping(value = "/addmovie")
		public String addMovie(@RequestBody AddNewMovie addNewMovie) {
			String message;
			message = movieService.addMovie(addNewMovie);
			return message;
		} 
		
	// updates a movie
				@PutMapping(value = "/movie/{movieId}",produces = MediaType.APPLICATION_JSON_VALUE)
				public String updateMovie(@PathVariable Integer movieId, @RequestBody AddNewMovie addNewMovie) {
					String message;
					message = movieService.updateMovie(movieId, addNewMovie);
					return message;
				} 
		
	// deletes movie
		@RequestMapping(value = "movie/{movieName}", method = RequestMethod.DELETE )
		public String delete(@PathVariable String movieName) {
			String message;
			movieService.delete(movieName);
			message = movieName+" has been deleted successfully";
			return message;
		} 

}
