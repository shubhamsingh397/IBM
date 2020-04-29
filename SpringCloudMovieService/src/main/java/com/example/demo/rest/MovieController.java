package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;

@RestController
public class MovieController {

	private MovieService service;
	@Value("${server.port}")
private String port;
	@Autowired
	public MovieController(MovieService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/movies")
	public List<Movie> getAllMovies()
	{
		return service.getAllMovies();
	}
	
	@GetMapping("/movie/{userId}")
	public List<Movie> getMovies(@PathVariable("userId")int userId) throws UserNotFoundException
	{
		
		List<Movie> list = service.getMovie(userId);
		if(list == null)
			throw new UserNotFoundException("Not Authorised with userId: "+userId);
		else
			return list;
	}
	
	@PostMapping("/movies/{id}")
	public Movie addMovie(@PathVariable("id")int id,@RequestBody Movie movie) throws UserNotFoundException
	{
		movie.setPort(port);
		Movie  obj = service.addMovie(id, movie);
		if(obj == null)
			throw new UserNotFoundException("Not Authorised with userId: "+id);
		else
			return movie;
	}
	
	@PutMapping("/updateMovie/{id}")
	public Movie updateMovie(@PathVariable("id")int id,@RequestBody Movie movie) throws UserNotFoundException
	{
		movie.setPort(port);
		Movie  obj = service.addMovie(id, movie);
		if(obj == null)
			throw new UserNotFoundException("Not Authorised with userId: "+id);
		else
			return movie;
	}
	@DeleteMapping("/movie/{id}/{movieId}")
	public ResponseEntity<String> deleteMovie(@PathVariable("id")int id,@PathVariable("movieId")int movieId) throws UserNotFoundException
	{
		
		boolean check = service.deleteMovie(id, movieId);
		if(check==true)
			return new ResponseEntity<String>("Successfully Deleted", HttpStatus.OK);
			
		else
			throw new UserNotFoundException("Not Authorised with userId: "+id);
	
		
	}
	
}
