package com.naveen.movie.model;

import java.util.List;
public class Movie {
private String movieTitle;
private String movieId;
private String directedBy;
private String producedBy;
private String writtenBy;
private List<String> starring;
private String musicBy;
private String cinematography;
private String editedBy;
private List<String> productionCompanies;
private List<String> distributedBy;
private String releaseDate;
private String runningTime;
private List<String> country;
private String language;
private String budgets;
private String boxOffice;
public List<String> getProductionCompanies() {
	return productionCompanies;
}
public void setProductionCompanies(List<String> productionCompanies) {
	this.productionCompanies = productionCompanies;
}
public String getMovieTitle() {
	return movieTitle;
}
public void setMovieTitle(String movieTitle) {
	this.movieTitle = movieTitle;
}
public String getMovieId() {
	return movieId;
}
public void setMovieId(String movieId) {
	this.movieId = movieId;
}
public String getDirectedBy() {
	return directedBy;
}
public void setDirectedBy(String directedBy) {
	this.directedBy = directedBy;
}
public String getProducedBy() {
	return producedBy;
}
public void setProducedBy(String producedBy) {
	this.producedBy = producedBy;
}
public String getWrittenBy() {
	return writtenBy;
}
public void setWrittenBy(String writtenBy) {
	this.writtenBy = writtenBy;
}
public String getMusicBy() {
	return musicBy;
}
public void setMusicBy(String musicBy) {
	this.musicBy = musicBy;
}
public String getCinematography() {
	return cinematography;
}
public void setCinematography(String cinematography) {
	this.cinematography = cinematography;
}
public String getEditedBy() {
	return editedBy;
}
public void setEditedBy(String editedBy) {
	this.editedBy = editedBy;
}

public String getReleaseDate() {
	return releaseDate;
}
public void setReleaseDate(String releaseDate) {
	this.releaseDate = releaseDate;
}
public String getRunningTime() {
	return runningTime;
}
public void setRunningTime(String runningTime) {
	this.runningTime = runningTime;
}
public List<String> getStarring() {
	return starring;
}
public void setStarring(List<String> starring) {
	this.starring = starring;
}

public List<String> getDistributedBy() {
	return distributedBy;
}
public void setDistributedBy(List<String> distributedBy) {
	this.distributedBy = distributedBy;
}
public List<String> getCountry() {
	return country;
}
public void setCountry(List<String> country) {
	this.country = country;
}
public String getLanguage() {
	return language;
}
public void setLanguage(String language) {
	this.language = language;
}
public String getBudgets() {
	return budgets;
}
public void setBudgets(String budgets) {
	this.budgets = budgets;
}
public String getBoxOffice() {
	return boxOffice;
}
public void setBoxOffice(String boxOffice) {
	this.boxOffice = boxOffice;
}
	
}
