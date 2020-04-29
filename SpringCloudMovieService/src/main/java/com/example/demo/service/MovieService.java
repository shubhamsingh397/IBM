package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Movie;

public interface MovieService {

	public List<Movie> getAllMovies();
	public List<Movie> getMovie(int userId);
	public Movie addMovie(int userid,Movie movie);
	public boolean deleteMovie(int userid,int movieId);
	
}
