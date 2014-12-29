/*

 * File: SearchServiceImpl.java
 *
 * Goal: .
 *
 * History:
 * //  Creation of the file (ADI)
 */
package com.springmvc.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springmvc.model.SearchType;
import com.springmvc.services.ISearchTypeConstant;
import com.springmvc.services.SearchService;
import com.springmvc.utils.Translation;

@Component
public class SearchServiceImpl implements SearchService {

	private List<SearchType> types;
	
	public SearchServiceImpl() {}
	

	public Collection<SearchType> getAllTypes() {
		if(types==null) {
			types = new ArrayList<SearchType>();
			
			String byItem = Translation.getInstance().getTranslation(ISearchTypeConstant.LABEL_ITEM);
			String byCollab = Translation.getInstance().getTranslation(ISearchTypeConstant.LABEL_COLLAB);
			String byBU = Translation.getInstance().getTranslation(ISearchTypeConstant.LABEL_BU);
			String byAll = Translation.getInstance().getTranslation(ISearchTypeConstant.LABEL_ALL);
			
			types.add(new SearchType(ISearchTypeConstant.TYPE_ALL, byAll));
			types.add(new SearchType(ISearchTypeConstant.TYPE_COLLAB, byCollab));
			types.add(new SearchType(ISearchTypeConstant.TYPE_ITEM, byItem));
			types.add(new SearchType(ISearchTypeConstant.TYPE_BU, byBU));
		}
		
		return types;
	}


	public SearchType getSearchType(Long id) {
		if(types==null) {
			getAllTypes();
		}
		
		for (SearchType type : types) {
			if(type.getId().equals(id)) {
				return type;
			}
		}
		return null;
	}
}
