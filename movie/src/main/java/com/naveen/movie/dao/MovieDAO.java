package com.naveen.movie.dao;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.naveen.movie.model.Movie;

@Component(value="dao")
public class MovieDAO {
	public Movie getMovie(String movieTitle) throws Exception{
		Movie movie=new Movie();
		//System.out.println(movieTitle);
		String url="https://en.wikipedia.org/w/api.php?action=parse&section=0&format=json&page="+movieTitle.replace(" ", "%20");
		
		try {
			URL urlmovie=new URL(url);
			try(
			BufferedReader br = new BufferedReader(new InputStreamReader(urlmovie.openConnection().getInputStream()))){
			String line=null;
			movie.setMovieTitle(movieTitle);
			movie.setMovieId(movieTitle.replaceAll("[^a-zA-Z]", "").substring(0,7)+"10000000");
			while((line=br.readLine())!=null) {
				char ss[]=line.trim().toCharArray();
				//line=line.trim().replaceAll("[^a-zA-Z0-9 ]", "");
				boolean f=true;
				//String s="";
				String directedBy="Directed by";
				String produceBy="Produced by";
				String writtenBy="Written by";
				String starring="Starring";
				String musicBy="Music by";
				String cinematography="Cinematography";
				String editedBy="Edited by";
				String productionCompanies="Production";
				String distributedBy="Distributed by";
				String releaseDate="Release Date";
				String runningTime="Running time";
				String country="Country";
				String language="Language";
				String budget="Budget";
				String boxOffice="Box office";
				if(line.contains(directedBy)) {
					
					int ind=line.indexOf(directedBy)+directedBy.length();
					String s=this.findString(ss, ind);
					movie.setDirectedBy(s);
					System.out.println(s);
					System.out.println("-----------------------------------------------------------------------");
				}if(line.contains(produceBy)) {
					int ind=line.indexOf(produceBy)+produceBy.length();
					String s=this.findString(ss, ind);
					movie.setProducedBy(s);
					System.out.println(s);
					System.out.println("-----------------------------------------------------------------------");
				}if(line.contains(writtenBy)) {
					int ind=line.indexOf(writtenBy)+writtenBy.length();
					String s=this.findString(ss, ind);
					movie.setWrittenBy(s);
					System.out.println(s);
					System.out.println("-----------------------------------------------------------------------");
				}
				if(line.contains(starring)) {
					int ind=line.indexOf(starring)+starring.length();
					List<String> s=this.findStringList(ss, ind);
					movie.setStarring(s);
					for(int i=0;i<s.size();i++) {
						System.out.println(s.get(i));
					}
					System.out.println("-----------------------------------------------------------------------");
				}
				if(line.contains(musicBy)) {
					int ind=line.indexOf(musicBy)+musicBy.length();
					String s=this.findString(ss, ind);
					movie.setMusicBy(s);
					System.out.println(s);
					System.out.println("-----------------------------------------------------------------------");
				}if(line.contains(cinematography)) {
					int ind=line.indexOf(cinematography)+cinematography.length();
					String s=this.findString(ss, ind);
					movie.setCinematography(s);
					System.out.println(s);
					System.out.println("-----------------------------------------------------------------------");
				}
				if(line.contains(productionCompanies)) {
					int ind=line.indexOf(productionCompanies)+productionCompanies.length();
					List<String> s=this.findStringList(ss, ind);
					movie.setProductionCompanies(s);
					for(int i=0;i<s.size();i++) {
						System.out.println(s.get(i));
					}
					System.out.println("-----------------------------------------------------------------------");
				}if(line.contains(editedBy)) {
					int ind=line.indexOf(editedBy)+editedBy.length();
					String s=this.findString(ss, ind);
					movie.setEditedBy(s);
					System.out.println(s);
					System.out.println("-----------------------------------------------------------------------");
				}
				if(line.contains(distributedBy)) {
					int ind=line.indexOf(distributedBy)+distributedBy.length();
					List<String> s=this.findStringList(ss, ind);
					movie.setDistributedBy(s);
					for(int i=0;i<s.size();i++) {
						System.out.println(s.get(i));
					}
					System.out.println("-----------------------------------------------------------------------");
				}
					if(line.contains(releaseDate)) {
					int ind=line.indexOf(releaseDate)+releaseDate.length();
					String s=this.findString(ss, ind);
					movie.setReleaseDate(releaseDate);
					System.out.println(s);
					System.out.println("-----------------------------------------------------------------------");
				}
				if(line.contains(runningTime)) {
					int ind=line.indexOf(runningTime)+runningTime.length();
					String s=this.findString(ss, ind);
					movie.setRunningTime(s);
					System.out.println(s);
					System.out.println("-----------------------------------------------------------------------");
				}
				if(line.contains(country)) {
					int ind=line.indexOf(country)+country.length();
					List<String> s=this.findStringList(ss, ind);
					
					for(int i=0;i<s.size();i++) {
						s.set(i, s.get(i).replaceAll("[^a-zA-Z]", ""));
						System.out.println(s.get(i));
					}
					movie.setCountry(s);
					System.out.println("-----------------------------------------------------------------------");
				}
				if(line.contains(language)) {
					int ind=line.indexOf(language)+language.length();
					String s=this.findString(ss, ind);
					movie.setLanguage(s);
					System.out.println(s);
					System.out.println("-----------------------------------------------------------------------");
				}
				if(line.contains(budget)) {
					int ind=line.indexOf(budget)+budget.length();
					String s=this.findString(ss, ind);
					movie.setBudgets(s);
					System.out.println(s);
					System.out.println("-----------------------------------------------------------------------");
				}if(line.contains(boxOffice)) {
					int ind=line.indexOf(boxOffice)+boxOffice.length();
					String s=this.findString(ss, ind);
					movie.setBoxOffice(s);
					System.out.println(s);
				}
			}
			}
			return movie;
					
		}catch(Exception e) {
				throw new Exception();
		}
		
		
	}
	public void getMovieList(List<Movie> movies){
		
		
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
