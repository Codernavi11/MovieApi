package com.naveen.movie.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.naveen.movie.model.Movie;
@Component(value="service")
public class MovieService {
	
	public List<String> getList(List<String> movies){
		if(movies==null) {
			return null;
		}else {
			return movies;
		}
		
		
	}
	public List<Movie> getMovieList(List<Movie> movies){
		if(movies==null) {
			return null;
		}else {
			return movies;
		}
		
		
	}
	public Movie getMovie(Movie movies){
		if(movies==null) {
			return null;
		}else {
			return movies;
		}
		
		
	}
	public List<Movie> getSortedMovieList(List<Movie> movies){
		if(movies==null) {
			return null;
		}else {
			return movies;
		}
		
		
	}
	public String findString(char ss[],int startInd) {
		String retn="";
		boolean f=true;
		boolean f1=true;
		for(int i=startInd;i<ss.length;i++) {
			if(ss[i]=='<' && f1) {
				f=false;
				continue;
			}else if(ss[i]=='>') {
				f=true;
			}else if(f) {
				f1=false;
				if(ss[i]=='\\' && ss[i+1]=='n') {
					retn="";
					f1=true;
					i+=1;
				}
				else if(ss[i]=='<') {
					break;
				}else {
				retn+=ss[i];
				}
				
			}
		}
		return retn;
	}

}
