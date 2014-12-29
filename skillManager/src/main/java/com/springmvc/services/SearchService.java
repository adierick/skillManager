package com.springmvc.services;

import java.util.Collection;

import com.springmvc.model.SearchType;


public interface SearchService {

	public Collection<SearchType> getAllTypes();

	public SearchType getSearchType(Long id);
}
