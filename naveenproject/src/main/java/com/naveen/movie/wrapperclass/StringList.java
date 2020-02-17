package com.naveen.movie.wrapperclass;

import java.util.ArrayList;
import java.util.List;

public class StringList {

	private List<String> ls;
	public StringList() {
		this.ls=new ArrayList<String>();
	}
	public List<String> getLs() {
		return ls;
	}
	public void setLs(List<String> ls) {
		this.ls = ls;
	}
}
