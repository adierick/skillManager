package com.springmvc.utils;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.xmlbeans.XmlCursor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;


public class HandlerWordFile {
	
	
	public static final String EXPRESSION_SERCH_SECTPR =
	        "declare namespace w='http://schemas.openxmlformats.org/wordprocessingml/2006/main'$this/w:sectPr";
	    
	    public static void writeDocument(XWPFDocument doc,Map<String,String> mapGen){

	    	/** search & replace for Body */
	    	replaceParagraphTextKeyByValue(mapGen,doc.getParagraphs());


	    	/** search & replace for Header */
	    	for(XWPFHeader header : doc.getHeaderList()){ 
	    		replaceParagraphTextKeyByValue(mapGen,header.getListParagraph());
	    	}
	    }
	    
	    
	    /**
	     * @param map
	     * @param doc
	     * @param position
	     */
	    public static void replaceSpecific2DimTableWithKeyValue(Map<String,String> map,XWPFDocument doc,int position,String suffixe){
	    	
	    	XWPFTable table = doc.getTables().get(position);
	    	Iterator<Entry<String, String>>  itMap = map.entrySet().iterator();
	    	int cpt = 0;
	    	if(table != null && map != null){
	    		XWPFTableRow firstRow = table.getRows().get(0);
	    		if(table.getNumberOfRows()>map.size()){

		    		while(table.getNumberOfRows()>map.size()){
		    			table.removeRow(table.getNumberOfRows()-1);
		    		}
		    		
		    	}else if(table.getNumberOfRows() < map.size()){
		    		while(table.getNumberOfRows()<map.size()){
		    			XWPFTableRow row = table.createRow();
		    			cloneParagraph(row.getTableCells().get(0).getParagraphs().get(0), firstRow.getTableCells().get(0).getParagraphs().get(0));
		    			cloneParagraph(row.getTableCells().get(1).getParagraphs().get(0), firstRow.getTableCells().get(1).getParagraphs().get(0));
		    		}
		    	}
		
		    	while(itMap.hasNext()){
		    		Entry<String,String> entry = itMap.next();
		    		if(StringUtils.isNotBlank(entry.getKey()) && StringUtils.isNotBlank(entry.getValue())){
		    			XWPFTableRow row = table.getRow(cpt);
		    			prepareCell(row.getCell(0),firstRow.getTableCells().get(0));
		    			prepareCell(row.getCell(1),firstRow.getTableCells().get(1));
		    			replaceCellText(row.getCell(0),entry.getKey(),suffixe);
		    			replaceCellText(row.getCell(1),entry.getValue(),"");		
			    		cpt++;
		    		}
		    	}
	    	}
	    }
	    
	    /**
	     * @param list
	     * @param doc
	     * @param position
	     */
	    public static void replaceSimpleTableValueWithListValue(List<String> list,XWPFDocument doc,int position){
	    	
	    	XWPFTable table = doc.getTables().get(position);
	    	
	    	int cpt = 0;
	    	if(table != null && list != null){
	    		XWPFTableRow firstRow = table.getRows().get(0);
	    		if(table.getNumberOfRows()>list.size()){

		    		while(table.getNumberOfRows()>list.size()){
		    			table.removeRow(table.getNumberOfRows()-1);
		    		}
		    		
		    	}else if(table.getNumberOfRows() < list.size()){
		    		while(table.getNumberOfRows()<list.size()){
		    			XWPFTableRow row = table.createRow();
		    			cloneParagraph(row.getTableCells().get(0).getParagraphs().get(0), firstRow.getTableCells().get(0).getParagraphs().get(0));
		    			
		    		}
		    	}
		
		    	for(String cellValue : list){
		    		if(StringUtils.isNotBlank(cellValue)){
		    			XWPFTableRow row = table.getRow(cpt);
		    			prepareCell(row.getCell(0),firstRow.getTableCells().get(0));
		    			replaceCellText(row.getCell(0),cellValue,"");
			    		cpt++;
		    		}
		    	}
		    	doc.insertTable(doc.getPosOfTable(table), table);
	    	}
	    }
	    
	    
	    
	    /**
	     * @param list1
	     * @param list2
	     * @return
	     */
	    public static <T, E> Map<T,E> transformListsToMap(List<T> list1,List<E> list2){
	    	Map<T,E> map = new LinkedHashMap<T,E>();
	    	Iterator<T> it = list1.iterator();
	    	Iterator<E> it2 = list2.iterator();
	    	while(it.hasNext() && it2.hasNext()) {
	    		  map.put(it.next(), it2.next());
	    	}
	    	return map;
	    }
	    
	    /**
	     * @param cell
	     * @param text
	     * @param suffixe
	     */
	    private static void replaceCellText(XWPFTableCell cell,String text,String suffixe){
	    	XWPFParagraph paragraph;
	    	
	    	//check & get paragraph
	    	if(cell.getParagraphs() != null && !cell.getParagraphs().isEmpty()){
	    		paragraph = cell.getParagraphs().get(0);	
	    	}else{
	    		paragraph = cell.addParagraph();
	    	}
	    	
	    	
	    	//replace text run or create run
	    	if(paragraph.getRuns() != null && !paragraph.getRuns().isEmpty()){
	    		paragraph.getRuns().get(0).setText(text+suffixe, 0);
			}else{
				XWPFRun run = paragraph.createRun();
				run.setText(text+suffixe);				
			}
	    }
	    
	    /**
	     * @param clone
	     * @param source
	     */
	    public static void cloneParagraph(XWPFParagraph clone, XWPFParagraph source) {
	        CTPPr pPr = clone.getCTP().isSetPPr() ? clone.getCTP().getPPr() : clone.getCTP().addNewPPr();
	        pPr.set(source.getCTP().getPPr());
	        for (XWPFRun r : source.getRuns()) {
	            XWPFRun nr = clone.createRun();
	            cloneRun(nr, r);
	        }
	    }

	    /**
	     * @param clone
	     * @param source
	     */
	    public static void cloneRun(XWPFRun clone, XWPFRun source) {
	        CTRPr rPr = clone.getCTR().isSetRPr() ? clone.getCTR().getRPr() : clone.getCTR().addNewRPr();
	        rPr.set(source.getCTR().getRPr());
	        clone.setText(source.getText(0));
	    }
	    
	    /**
	     * @param clone
	     * @param source
	     */
	    public static void cloneTable(XWPFTable clone, XWPFTable source){
	    	for(XWPFTableRow row : source.getRows()){
	    		clone.addRow(row);
	    	}
	    	clone.setStyleID(source.getStyleID());
	    	clone.getCTTbl().setTblGrid(source.getCTTbl().getTblGrid());
	    	clone.getCTTbl().setTblPr(source.getCTTbl().getTblPr());
	    }
	    
	    
	    /**
	     * @param cell
	     * @param firstcell
	     */
	    public static void prepareCell(XWPFTableCell cell,XWPFTableCell firstCell){
	    	//keep only one paragraph
	    	while(cell.getParagraphs().size()>1){
	    		cell.removeParagraph(cell.getParagraphs().size()-1);
	    	}
	    	if(!cell.getTableRow().equals(firstCell.getTableRow())){
	    		//clone style of 1st cell to the current cell
		    	for(XWPFParagraph parag : cell.getParagraphs()){
		    		cloneParagraph(parag, firstCell.getParagraphs().get(0));	
				}
	    	}
	    	
	    	// keep only one run
	    	for(XWPFParagraph parag : cell.getParagraphs()){
		    	while(parag.getRuns().size()> 1){	
		    		parag.removeRun(0);
				}
	    	}
	    }
	    
	    /**
	     * @param map
	     * @param list
	     */
	    public static void replaceParagraphTextKeyByValue(Map<String,String> map, List<XWPFParagraph> list){
	    	for(XWPFParagraph paragraph : list){
	    		if(StringUtils.isNotBlank(paragraph.getText())){
		    		for(int i=0;i < paragraph.getRuns().size(); i++){
		    			
		    				XWPFRun run = paragraph.getRuns().get(i);
					    		if(run.getText(run.getTextPosition()) != null){

					    			for(Entry<String, String> entry : map.entrySet()){
					    					if(run.getText(run.getTextPosition()).toLowerCase().contains(entry.getKey())){
								    			String replace = run.getText(run.getTextPosition()).toLowerCase().replace(entry.getKey(), entry.getValue());
								    			run.setText(replace, 0);
								    		}
					    	
					    			}
		    		 
					    		}  		
		    		}
	    		}
	    	}
	    }
	    
	    /**
	     * @param doc
	     * @param docExp
	     */
	    public static void addLayerWithOneTable(XWPFDocument doc,XWPFDocument docLittle,XWPFParagraph refPara){
	    	XWPFTable table = docLittle.getTables().get(0);
	    	boolean placed = false;
	    	for(XWPFParagraph parag : docLittle.getParagraphs()){
	    		/** Si un paragraphe de reference existe on va inserer par rapport à celui-ci sinon 
	    		 * à la suite des tableaux existants*/
	    		if((docLittle.getPosOfParagraph(parag) > docLittle.getPosOfTable(table)) && !placed){
	    			if(refPara != null){
	    				XWPFTable newTable = doc.insertNewTbl(refPara.getCTP().newCursor());
	    				cloneTable(newTable, table);
	    				
	    			}else{
	    				doc.createTable();
			    		doc.setTable(doc.getTables().size()-1, table);
	
	    			}
	    			placed = true;
	    		}
	    		
	    		/** Si un paragraphe de reference existe on va inserer par rapport à celui-ci sinon 
	    		 * à la suite des paragraphes existants*/
	    		XWPFParagraph newPara;
	    		if(refPara != null){
	    			XmlCursor cursor = refPara.getCTP().newCursor();
		    		newPara = doc.insertNewParagraph(cursor);
		    		
	    		}else{
	    			newPara = doc.createParagraph();
	    		}
	    		cloneParagraph(newPara, parag);
	    		
	    	}
	    	
	    	/** Si dans aucun cas le tableau n'a été placé, on le place à la fin*/
	    	if(!placed){
	    		doc.createTable();
	    		doc.setTable(doc.getTables().size()-1, table);
	    	}

	    	
	    }
	    
}
