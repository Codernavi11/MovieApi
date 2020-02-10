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
	public List<String> findStringList(char ss[],int startInd){
		List<String> lst=new ArrayList<String>();
		String s="";
		boolean f=true;
		boolean f1=true;
		//boolean f2=true;
		for(int i=startInd;i<ss.length;i++) {
			if(ss[i]=='<' && f1) {
//				if(i!=ss.length-2 && ss[i+1]=='l' && ss[i+2]=='i') {
//					f2=true;
//				}
				if(i!=ss.length-3 && ss[i+1]=='/' && ss[i+2]=='u' && ss[i+3]=='l') {
					break;
				}
				f=false;
				continue;
			}else if(ss[i]=='>') {
				f=true;
			}else if(f) {
				f1=false;
				if(ss[i]=='\\' && ss[i+1]=='n') {
					s="";
					f1=true;
					i+=1;
				}
				else if(ss[i]=='<') {
					lst.add(s);
					f1=true;
					f=false;
				}else {
				s+=ss[i];
				}
				
			}
		}
		return lst;
	}

}
