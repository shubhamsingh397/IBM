package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MovieDao;
import com.example.demo.model.Movie;
import com.example.demo.model.User;
import com.example.demo.proxy.UserProxy;



@Service
public class MovieServiceImpl implements MovieService{

	private MovieDao dao;
	private UserProxy proxy;
	//private RestTemplate template;
	
	
	@Autowired
	public MovieServiceImpl(MovieDao dao, UserProxy proxy) {
		super();
		this.dao = dao;
		this.proxy = proxy;
		//this.template = template;
	}

	@Override
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		return (List<Movie>) dao.findAll();
	}

	@Override
	public List<Movie> getMovie(int userId) {
		List<Movie> list = null;
		User user = proxy.getUser(userId);
		
		
		if(user == null)
		{
			return list;
		}
		else
		{
			list = (List<Movie>) dao.findAll();
			for(Movie obj: list)
			{
				obj.setUser(user);
			}
			return list;
		}
	}

	@Override
	public Movie addMovie(int userid, Movie movie) {
		// TODO Auto-generated method stub
	   User user = proxy.getUser(userid);
	   if(user == null)
	   {
		   return null;
	   }
	   else
	   {
		   return dao.save(movie);
	   }
	}

	@Override
	public boolean deleteMovie(int userid, int movieId) {
		// TODO Auto-generated method stub
		User user = proxy.getUser(userid);
		if(user == null)
			return false;
		else
		{
			dao.deleteById(movieId);
			return true;
		}
		
	}
	
}
