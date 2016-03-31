package com.springmvc.services;

import java.util.Collection;
import java.util.List;


public interface ISearchService<T> {

	public List<T> find(String criteria, int rowStart, int numberResults);

	public Collection<T> find(String criteria);
}
