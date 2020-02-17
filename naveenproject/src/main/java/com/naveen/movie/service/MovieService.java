package com.naveen.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.naveen.movie.dao.MovieDAO;
import com.naveen.movie.model.Movie;
@Component(value="service")
public class MovieService {
	@Autowired
	MovieDAO dao;
	public List<String> getList(List<String> movies){
		if(movies==null) {
			return null;
		}else {
			return movies;
		}
		
		
	}
	public void getMovieList(List<Movie> movies){
		if(movies!=null) {
			dao.getMovieList(movies);
		}	
	}
	public Movie getMovie(String movieTitle) throws Exception{
		Movie movie=null;
		try {
			movie = dao.getMovie(movieTitle);
			if(movie==null) {
				return null;
			}else {
				return movie;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception();
		}
		
		
	}
	public List<Movie> getSortedMovieList(List<Movie> movies){
		if(movies==null) {
			return null;
		}else {
			return movies;
		}
		
		
	}
}
