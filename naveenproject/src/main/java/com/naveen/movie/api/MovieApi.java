package com.naveen.movie.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.naveen.movie.model.Movie;
import com.naveen.movie.service.MovieService;

@CrossOrigin
@RestController
@RequestMapping(value="movie")
public class MovieApi {
	@Autowired
	MovieService service;
	@RequestMapping(value="/{movieTitle}",produces= {"application/JSON"},method=RequestMethod.GET)
	private ResponseEntity<Movie> getMovie(@PathVariable String movieTitle){
		Movie movie=null;
		try {
			movie = service.getMovie(movieTitle);
			if(movie==null) {
				return new ResponseEntity<Movie>(movie,HttpStatus.OK);
			}else{
				return new ResponseEntity<Movie>(movie,HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<Movie>(movie,HttpStatus.OK);		
		}	
	}
	
	

}
