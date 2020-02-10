package com.naveen.movie.api;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.naveen.movie.model.Movie;
import com.naveen.movie.service.MovieService;

@CrossOrigin
@RestController
@RequestMapping(value="movie")
public class MovieApi {
	@Autowired
	MovieService service;
	@RequestMapping(value="/{movieTitle}",method=RequestMethod.GET)
	private ResponseEntity<Movie> getMovie(@PathVariable String movieTitle){
		Movie movie=null;
		//System.out.println(movieTitle);
		String url="https://en.wikipedia.org/w/api.php?action=parse&section=0&format=json&page="+movieTitle.replace(" ", "%20");
		
		try {
		//RestTemplate rt=new RestTemplate();
			URL urlmovie=new URL(url);
			try(
			BufferedReader br = new BufferedReader(new InputStreamReader(urlmovie.openConnection().getInputStream()))){
			String line=null;
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
				String production="Production";
				String companies="companies";
				String distributedBy="Distributed by";
				String releaseDate="Release Date";
				String runningTime="Running time";
				String country="Country";
				String language="Language";
				String budget="Budget";
				String boxOffice="Box office";
				if(line.contains(directedBy)) {
					
					int ind=line.indexOf(directedBy)+directedBy.length();
					String s=service.findString(ss, ind);
					System.out.println(s);
					System.out.println("-----------------------------------------------------------------------");
				}if(line.contains(produceBy)) {
					int ind=line.indexOf(produceBy)+produceBy.length();
					String s=service.findString(ss, ind);
					System.out.println(s);
					System.out.println("-----------------------------------------------------------------------");
				}if(line.contains(writtenBy)) {
					int ind=line.indexOf(writtenBy)+writtenBy.length();
					String s=service.findString(ss, ind);
					System.out.println(s);
					System.out.println("-----------------------------------------------------------------------");
				}
				if(line.contains(starring)) {
					int ind=line.indexOf(starring)+starring.length();
					List<String> s=service.findStringList(ss, ind);
					for(int i=0;i<s.size();i++) {
						System.out.println(s.get(i));
					}
					System.out.println("-----------------------------------------------------------------------");
				}
				if(line.contains(musicBy)) {
					int ind=line.indexOf(musicBy)+musicBy.length();
					String s=service.findString(ss, ind);
					System.out.println(s);
					System.out.println("-----------------------------------------------------------------------");
				}if(line.contains(cinematography)) {
					int ind=line.indexOf(cinematography)+cinematography.length();
					String s=service.findString(ss, ind);
					System.out.println(s);
					System.out.println("-----------------------------------------------------------------------");
				}
				if(line.contains(production)) {
					int ind=line.indexOf(production)+production.length();
					List<String> s=service.findStringList(ss, ind);
					for(int i=0;i<s.size();i++) {
						System.out.println(s.get(i));
					}
					System.out.println("-----------------------------------------------------------------------");
				}if(line.contains(editedBy)) {
					int ind=line.indexOf(editedBy)+editedBy.length();
					String s=service.findString(ss, ind);
					System.out.println(s);
					System.out.println("-----------------------------------------------------------------------");
				}
				if(line.contains(distributedBy)) {
					int ind=line.indexOf(distributedBy)+distributedBy.length();
					List<String> s=service.findStringList(ss, ind);
					for(int i=0;i<s.size();i++) {
						System.out.println(s.get(i));
					}
					System.out.println("-----------------------------------------------------------------------");
				}
					if(line.contains(companies)) {
					int ind=line.indexOf(companies)+companies.length();
					List<String> s=service.findStringList(ss, ind);
					for(int i=0;i<s.size();i++) {
						System.out.println(s.get(i));
					}
					System.out.println("-----------------------------------------------------------------------");
				}if(line.contains(releaseDate)) {
					int ind=line.indexOf(releaseDate)+releaseDate.length();
					String s=service.findString(ss, ind);
					System.out.println(s);
					System.out.println("-----------------------------------------------------------------------");
				}
				if(line.contains(runningTime)) {
					int ind=line.indexOf(runningTime)+runningTime.length();
					String s=service.findString(ss, ind);
					System.out.println(s);
					System.out.println("-----------------------------------------------------------------------");
				}
				if(line.contains(country)) {
					int ind=line.indexOf(country)+country.length();
					List<String> s=service.findStringList(ss, ind);
					for(int i=0;i<s.size();i++) {
						System.out.println(s.get(i).replaceAll("[^a-zA-Z]", ""));
					}
					System.out.println("-----------------------------------------------------------------------");
				}
				if(line.contains(language)) {
					int ind=line.indexOf(language)+language.length();
					String s=service.findString(ss, ind);
					System.out.println(s);
					System.out.println("-----------------------------------------------------------------------");
				}
				if(line.contains(budget)) {
					int ind=line.indexOf(budget)+budget.length();
					String s=service.findString(ss, ind);
					System.out.println(s);
					System.out.println("-----------------------------------------------------------------------");
				}if(line.contains(boxOffice)) {
					int ind=line.indexOf(boxOffice)+boxOffice.length();
					String s=service.findString(ss, ind);
					System.out.println(s);
				}
//				for(int i=0;i<ss.length;i++) {
//					if(ss[i]=='<') {
//						f=false;
//						continue;
//					}else if(ss[i]=='>') {
//						f=true;
//					}else if(f) {
//						s+=ss[i];
//					}
//				}
				
				//System.out.println(line);
				//System.out.println(s);
			}
			}
			
			
//			try(BufferedReader br = new BufferedReader(new InputStreamReader(urlmovie.openConnection().getInputStream()))){
//				String line=null;
//				//System.out.println(line=br.readLine());
//				while((line=br.readLine())!=null) {
//					//System.out.println("I am here");
//					if(line.contains("Directed by")) {
//						if(line.contains("title")) {
//							String n=null;
//							int i=line.indexOf("title")+7;
//							while(true) {
//								char c=line.charAt(i);
//								if(c=='>') {break;}
//								n+=c+"";
//							}
//							
//							movie.setDirectedBy(n);
//							System.out.println(movie.getDirectedBy());
//						}
//					}else if(line.contains("Produced by")) {
//						if(line.contains("title")) {
//							String n=null;
//							int i=line.indexOf("title")+7;
//							while(true) {
//								char c=line.charAt(i);
//								if(c=='>') {break;}
//								n+=c+"";
//							}
//							
//							movie.setProducedBy(n);}
//		
//					}else if(line.contains("Written by")) {
//						if(line.contains("title")) {
//							String n=null;
//							int i=line.indexOf("title")+7;
//							while(true) {
//								char c=line.charAt(i);
//								if(c=='>') {break;}
//								n+=c+"";
//							}
//							
//							movie.setWrittenBy(n);}
//		
//					}else if(line.contains("Starring")) {
//						if(line.contains("title")) {
//							String n=null;
//							int i=line.indexOf("title")+7;
//							while(true) {
//								char c=line.charAt(i);
//								if(c=='>') {break;}
//								n+=c+"";
//							}
//							
//							movie.setStarring(n);}
//		
//					}
//						else if(line.contains("Music by")) {
//							if(line.contains("title")) {
//								String n=null;
//								int i=line.indexOf("title")+7;
//								while(true) {
//									char c=line.charAt(i);
//									if(c=='>') {break;}
//									n+=c+"";
//								}
//								
//								movie.setMusicBy(n);}
//			
//						}else if(line.contains("Cinematography")) {
//							if(line.contains("title")) {
//								String n=null;
//								int i=line.indexOf("title")+7;
//								while(true) {
//									char c=line.charAt(i);
//									if(c=='>') {break;}
//									n+=c+"";
//								}
//								
//								movie.setCinematography(n);}
//			
//						}else if(line.contains("Edited by")) {
//							if(line.contains("title")) {
//								String n=null;
//								int i=line.indexOf("title")+7;
//								while(true) {
//									char c=line.charAt(i);
//									if(c=='>') {break;}
//									n+=c+"";
//								}
//								
//								movie.setEditedBy(n);}
//			
//						}else if(line.contains("Production")) {
//							if(line.contains("title")) {
//								String n=null;
//								int i=line.indexOf("title")+7;
//								while(true) {
//									char c=line.charAt(i);
//									if(c=='>') {break;}
//									n+=c+"";
//								}
//								
//								movie.setProduction(n);}
//			
//						}else if(line.contains("companies")) {
//							if(line.contains("title")) {
//								String n=null;
//								int i=line.indexOf("title")+7;
//								while(true) {
//									char c=line.charAt(i);
//									if(c=='>') {break;}
//									n+=c+"";
//								}
//								
//								movie.setCompanies(n);}
//			
//						}else if(line.contains("Distributed by")) {
//							if(line.contains("title")) {
//								String n=null;
//								int i=line.indexOf("title")+7;
//								while(true) {
//									char c=line.charAt(i);
//									if(c=='>') {break;}
//									n+=c+"";
//								}
//								
//								movie.setDistributedBy(n);}
//			
//						}else if(line.contains("Release date")) {
//							if(line.contains("title")) {
//								String n=null;
//								int i=line.indexOf("title")+7;
//								while(true) {
//									char c=line.charAt(i);
//									if(c=='>') {break;}
//									n+=c+"";
//								}
//								
//								movie.setReleaseDate(n);}
//			
//						}else if(line.contains("Running time")) {
//							if(line.contains("title")) {
//								String n=null;
//								int i=line.indexOf("title")+7;
//								while(true) {
//									char c=line.charAt(i);
//									if(c=='>') {break;}
//									n+=c+"";
//								}
//								
//								movie.setRunningTime(n);}
//			
//						}else if(line.contains("Country")) {
//							if(line.contains("title")) {
//								String n=null;
//								int i=line.indexOf("title")+7;
//								while(true) {
//									char c=line.charAt(i);
//									if(c=='>') {break;}
//									n+=c+"";
//								}
//								
//								movie.setCountry(n);}
//			
//						}else if(line.contains("Language")) {
//							if(line.contains("title")) {
//								String n=null;
//								int i=line.indexOf("title")+7;
//								while(true) {
//									char c=line.charAt(i);
//									if(c=='>') {break;}
//									n+=c+"";
//								}
//								
//								movie.setLanguage(n);}
//			
//						}else if(line.contains("Budget")) {
//							if(line.contains("title")) {
//								String n=null;
//								int i=line.indexOf("title")+7;
//								while(true) {
//									char c=line.charAt(i);
//									if(c=='>') {break;}
//									n+=c+"";
//								}
//								
//								movie.setBudgets(n);}
//			
//						}else if(line.contains("Box office")) {
//							if(line.contains("title")) {
//								String n=null;
//								int i=line.indexOf("title")+7;
//								while(true) {
//									char c=line.charAt(i);
//									if(c=='>') {break;}
//									n+=c+"";
//								}
//								
//								movie.setBoxOffice(n);}
//			
//						}
//			}
//						}
			
		
		//movie=rt.getForObject(url, Movie.class);
		}catch(Exception e) {
//			if(e.getMessage()!=null) {
//				return new ResponseEntity<Movie>(HttpStatus.INTERNAL_SERVER_ERROR);
//			}
		}
//		if(movie==null) {
//			return new ResponseEntity<Movie>(HttpStatus.BAD_REQUEST);
//		}else{
//			return new ResponseEntity<Movie>(movie,HttpStatus.OK);
//		}
		service.getMovie(movie);
		return new ResponseEntity<Movie>(movie,HttpStatus.OK);
		
	}
	@RequestMapping(value="/getMovieList",method=RequestMethod.GET)
	private ResponseEntity<List<Movie>> getMovieList(){
		RestTemplate rt=new RestTemplate();
		String moviess[]=rt.getForObject("locahost:8080/movie/getList", String[].class);
		List<Movie> movies=new ArrayList<Movie>();
		for(int i=0;i<=100;i++) {
			Movie movie=rt.getForObject("locahost:8080/movie/"+moviess[i], Movie.class);
			movies.add(movie);
		}
		if(movies.isEmpty()) {
			return new ResponseEntity<List<Movie>>(movies,HttpStatus.BAD_REQUEST);
		}else {
			service.getMovieList(movies);
		return new ResponseEntity<List<Movie>>(movies,HttpStatus.OK);
		}
	}
	@RequestMapping(value="/getSortedMovieList",method=RequestMethod.GET)
	private ResponseEntity<List<Movie>> getSortedMovieList(@RequestParam String type){
		RestTemplate rt=new RestTemplate();
		
		List<Movie> movies=new ArrayList<Movie>();
		for(int i=0;i<=100;i++) {
			Movie movie=rt.getForObject("locahost:8080/movie/", Movie.class);
			movies.add(movie);
		}if(type!=null && type=="Ascending") {
		movies.stream().sorted((o1,o2)-> o1.getMovieTitle().compareTo(o2.getMovieTitle())
			)
		.collect(Collectors.toList());
		movies.stream().sorted((o1,o2)-> o1.getReleaseDate().compareTo(o2.getReleaseDate())
				)
			.collect(Collectors.toList());
		movies.stream().sorted((o1,o2)-> o1.getMovieTitle().compareTo(o2.getMovieTitle())
				)
			.collect(Collectors.toList());}else {
				movies.stream().sorted((o1,o2)-> o2.getMovieTitle().compareTo(o1.getMovieTitle())
						)
					.collect(Collectors.toList());
					movies.stream().sorted((o1,o2)-> o2.getReleaseDate().compareTo(o1.getReleaseDate())
							)
						.collect(Collectors.toList());
					movies.stream().sorted((o1,o2)-> o2.getMovieTitle().compareTo(o1.getMovieTitle())
							)
						.collect(Collectors.toList());
				
			}
		if(movies.isEmpty()) {
			return new ResponseEntity<List<Movie>>(movies,HttpStatus.BAD_REQUEST);
		}else {
			service.getSortedMovieList(movies);
		return new ResponseEntity<List<Movie>>(movies,HttpStatus.OK);
		}
	}
	@RequestMapping(value="/getList",method=RequestMethod.GET)
	private ResponseEntity<List<String>> getList(){
		List<String> movies=new ArrayList<String>();
		movies.add("Transformer 1");
		movies.add("Transformer 2");
		movies.add("Transformer 3");
		movies.add("Transformer 4");
		movies.add("Transformer 5");
		movies.add("Death Race 1");
		movies.add("Death Race 2");
		movies.add("Death Race 3");
		movies.add("Harry Porter 1");
		movies.add("Harry Porter 2");
		movies.add("Harry Porter 3");
		movies.add("Harry Porter 4");
		movies.add("Harry Porter 5");
		movies.add("Harry Porter 6");
		movies.add("Harry Porter 7");
		movies.add("Harry Porter 8");
		movies.add("Aachi & Ssipak");
		movies.add("Aada Paduchu");
		movies.add("Aadaalla Majaka");
		movies.add("Aadab Arz");movies.add("Aadamkhor");movies.add("Aadukalam");movies.add("Aadum Koothu");
		movies.add("Aadyakiranangal");movies.add("Aadyarathrikku Munbu");movies.add("Aadyathe Anuraagam");movies.add("Aadyathe Kanmani");
		movies.add("Aafat");movies.add("Aag");movies.add("Aag Aandhi Aur Toofan");movies.add("Aag Aur Chingari");
		movies.add("Aai Bahar");movies.add("Aai Shappath..!");movies.add("Aaina");movies.add("Aaj Ka Arjun");
		movies.add("Alien");movies.add("Aliens");movies.add("Alien 3");movies.add("Alien 4");
		movies.add("Alien 5");movies.add("Alien 6");movies.add("Salt of the Earth");movies.add("Salvador Dalí");
		movies.add("All Is Well");movies.add("Same Kind of Different as Me");movies.add("Santa with Muscles");movies.add("Santa Sangre");
		movies.add("Le Samouraï");movies.add("Santo Contra los Zombis");movies.add("The Lame Devil");movies.add("Lancelot du Lac");
		movies.add("Last Exit to Brooklyn");movies.add("Readdy");movies.add("3 Idiots");movies.add("Aadab Arz");
		movies.add("The Last Exorcism");movies.add("Dabangg 2");movies.add("Dabangg 3");movies.add("Dabangg 4");
		movies.add("The Last Exorcism Part II");movies.add("Dabangg");movies.add("I Hate Love Story 2");movies.add("I Hate Love Story");
		movies.add("The Last Five Years");movies.add("Love Story");movies.add("Purani Geans");movies.add("Prirate Of The Carabian 10");
		movies.add("Last Holiday");movies.add("Prirate Of The Carabian 9");movies.add("Prirate Of The Carabian 8");movies.add("Prirate Of The Carabian 7");
		movies.add("The Last Horror Movie");movies.add("Prirate Of The Carabian 6");movies.add("Prirate Of The Carabian 5");movies.add("Prirate Of The Carabian 4");
		movies.add("Land of Plenty");movies.add("Prirate Of The Carabian 3");movies.add("Prirate Of The Carabian 2");movies.add("Prirate Of The Carabian");
		movies.add("Lammbock");movies.add("The Hobbit 4");movies.add("The Hobbit 3");movies.add("The Hobbit 2");
		movies.add("Legacy");movies.add("The Hobbit");movies.add("Avengers 3");movies.add("Avengers 2");
		movies.add("The Legend of Bagger Vance");movies.add("Andaaz Apna Apna");movies.add("Tarzan");movies.add("Avengers");
		movies.add("Legend of the Guardians: The Owls of Ga'Hoole");
		movies.add("Legion of the Night");
		movies.add("ABCD");
		movies.add("ABCD 2");
		movies.add("DHOOM");
		movies.add("DHOOM 2");
		movies.add("DHOOM 3");
		movies.add("DHOOM 4");
		if(movies.isEmpty()) {
			return new ResponseEntity<List<String>>(movies,HttpStatus.BAD_REQUEST);
		}else {
			service.getList(movies);
		return new ResponseEntity<List<String>>(movies,HttpStatus.OK);
		}
	}

}
