# movieApp
Skip to content
Search or jump to…

Pull requests
Issues
Marketplace
Explore
 
@akhiltomkolliyan 
akhiltomkolliyan
/
movieApp
1
00
 Code
 Issues 0
 Pull requests 0 Actions
 Projects 0
 Wiki
 Security 0
 Insights
 Settings
movieApp/readme.txt
@akhiltomkolliyan akhiltomkolliyan Add files via upload
d35116f 2 days ago
60 lines (49 sloc)  1.99 KB
  
#BookMyMovie
Online Movie Ticket Booking application which helps users to book desired movies and theaters with ease.

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Sample Code](#sample code)
* [Setup](#setup)
* [Features](#features)
* [Status](#status)
* [Contact](#contact)

## General info
This project is an online movie ticket booking system in which users can book or cancel tickets. They can view movie and theatre details. The admin is able to add, delete and update movies and theatres.


## Technologies
* Technology: Java 1.8 
* Database: PostgreSQL
* Discovery Server: Eureka 
* Framework: Spring Boot Application 
* API gateway: Zuul server 
* Registry: Eureka Server 


## Sample Code
* To add a new Movie into the application: 
  The API example is shown:
               @PostMapping(value = "/addmovie")
		public String addMovie(@RequestBody AddNewMovie addNewMovie) {
			String message;
			message = movieService.addMovie(addNewMovie);
			return message;
		} 

*  The Service Implementation will be as follows:
               public String addMovie(AddNewMovie addNewMovie) {
		String message = null;
		MovieEntity movie1 = new MovieEntity();
			message = addNewMovie.getMovieName() + " has been added successfully";
			movie1.setMovieName(addNewMovie.getMovieName());
			movie1.setGenre(addNewMovie.getGenre());
			movie1.setReleaseDate(addNewMovie.getReleaseDate());
			movie1.setRating(addNewMovie.getRating());
			movieDAO.save(movie1);
		return message;
	}
## Features
List of features ready aare as follows:
* User can register with the application and can login with their registered emailid and password.
* Users can view various movies and theaters.Also they can book their tickets with desired number of seats and can cancel their booking.
* Admin can add/delete/update new movies, shows and theaters.


## Status
Project is in progress. The backend is completed.


## Contact
Created by Akhil Tom(@akhil.tom).
© 2020 GitHub, Inc.
Terms
Privacy
Security
Status
Help
Contact GitHub
Pricing
API
Training
Blog
About
