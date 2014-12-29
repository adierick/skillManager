/*
 * File: ExportExcel.java
 *
 * Goal: .
 *
 * History:
 * //  Creation of the file (ADI)
 */
package com.springmvc.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import com.springmvc.model.SearchCriteria;
import com.springmvc.model.SearchResult;

/**
 * The Class ExportExcel.
 *
 * @author adi
 * @version 5.1, //2014
 */
public class ExportExcel {

	/**
	 * Export excel.
	 *
	 * @param list the list
	 * @param searchCriteria the search criteria
	 */
	public static void exportExcel(List<SearchResult> list, SearchCriteria searchCriteria) {
		try {
			
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			FileOutputStream fileOut = new FileOutputStream("C:\\SII_Skills_"+dateFormat.format(new Date())+".xls");
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet worksheet = workbook.createSheet("Worksheet");

			int rowNum = 0;
			// title
			HSSFRow row = worksheet.createRow((short) rowNum++);
			row.createCell((short) 0).setCellValue(Translation.getInstance().getTranslation(ITranslations.SEARCH_DOSEARCH));
			
			// search type
			row = worksheet.createRow((short) rowNum++);
			row.createCell((short) 0).setCellValue(Translation.getInstance().getTranslation(ITranslations.SEARCH_TYPE));
			row.createCell((short) 1).setCellValue(searchCriteria.getType().getLabel());
			
			// search criteria
			row = worksheet.createRow((short) rowNum++);
			row.createCell((short) 0).setCellValue(Translation.getInstance().getTranslation(ITranslations.SEARCH_CRITERIA));
			row.createCell((short) 1).setCellValue(searchCriteria.getCriteria());
			
			// table header
			row = worksheet.createRow((short) rowNum++);
			createHeader((short) 0, "search.result.bu.label", row, workbook);
			createHeader((short) 1, "search.result.person.lastname", row, workbook);
			createHeader((short) 2, "search.result.person.firstname", row, workbook);
			createHeader((short) 3, "search.result.item.code", row, workbook);
			createHeader((short) 4, "search.result.item.label", row, workbook);
			createHeader((short) 5, "search.result.skill.level", row, workbook);

			// table body
			for(int i=0; i<list.size(); i++) {
				SearchResult result = list.get(i);
				row = worksheet.createRow((short) rowNum++);
				
				createCell((short) 0, result.getBuLabel(), row, workbook, (i%2==0));
				createCell((short) 1, result.getLastName(), row, workbook, (i%2==0));
				createCell((short) 2, result.getFirstName(), row, workbook, (i%2==0));
				createCell((short) 3, result.getItemCode(), row, workbook, (i%2==0));
				createCell((short) 4, result.getItemLabel(), row, workbook, (i%2==0));
				createCell((short) 5, result.getLevel(), row, workbook, (i%2==0));
			}

			// write in workbook and file
			workbook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Creates the header.
	 *
	 * @param col the col
	 * @param labelKey the label key
	 * @param row the row
	 * @param workbook the workbook
	 * @return the HSSF cell
	 */
	private static HSSFCell createHeader(short col, String labelKey, HSSFRow row, HSSFWorkbook workbook) {
		// define header colors
		HSSFPalette palette = workbook.getCustomPalette();
		HSSFColor headerColor = null;
		try {
			headerColor = palette.findColor((byte)57, (byte)115, (byte)152); 
			if (headerColor == null ){
				palette.setColorAtIndex(HSSFColor.BLUE.index, (byte)57, (byte)115, (byte)152);
				headerColor = palette.getColor(HSSFColor.BLUE.index);
			}
		} catch (Exception e) {
		}
		
		// create cell
		HSSFCell cellA1 = row.createCell(col);
		cellA1.setCellValue(Translation.getInstance().getTranslation(labelKey));
		HSSFCellStyle styleOfCell = workbook.createCellStyle();
		styleOfCell.setFillForegroundColor(headerColor.getIndex());

		// set font
		HSSFFont hSSFFont = workbook.createFont();
        hSSFFont.setFontName(HSSFFont.FONT_ARIAL);
        hSSFFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        hSSFFont.setColor(HSSFColor.WHITE.index);
        styleOfCell.setFont(hSSFFont);
		
		styleOfCell.setFillPattern(HSSFCellStyle.BORDER_THIN);
		cellA1.setCellStyle(styleOfCell);
		
		return cellA1;
	}
	
	/**
	 * Creates the cell.
	 *
	 * @param col the col
	 * @param value the value
	 * @param row the row
	 * @param workbook the workbook
	 * @param active true for colored line, false for white line
	 * @return the HSSF cell
	 */
	private static HSSFCell createCell(short col, Object value, HSSFRow row, HSSFWorkbook workbook, boolean active) {
		// define body color
		HSSFPalette palette = workbook.getCustomPalette();
		HSSFColor headerColor = null;
		try {
			
			if(active) {
				headerColor = palette.findColor((byte)221, (byte)244, (byte)252); 
				if (headerColor == null ){
					palette.setColorAtIndex(HSSFColor.LAVENDER.index, (byte)221, (byte)244, (byte)252);
					headerColor = palette.getColor(HSSFColor.LAVENDER.index);
				}
			} else {
				headerColor = palette.findColor((byte)255, (byte)255, (byte)255); 
				if (headerColor == null ){
					palette.setColorAtIndex(HSSFColor.LAVENDER.index, (byte)255, (byte)255, (byte)255);
					headerColor = palette.getColor(HSSFColor.LAVENDER.index);
				}
			}
		} catch (Exception e) {
		}
		
		HSSFCell cellA1 = row.createCell(col);
		if(value instanceof String) {
			cellA1.setCellValue((String)value);
		} 
		if(value instanceof Integer) {
			cellA1.setCellValue((Integer)value);
		}
		HSSFCellStyle styleOfCell = workbook.createCellStyle();
		styleOfCell.setFillForegroundColor(headerColor.getIndex());

		HSSFFont hSSFFont = workbook.createFont();
        hSSFFont.setFontName(HSSFFont.FONT_ARIAL);
        hSSFFont.setColor(HSSFColor.GREY_50_PERCENT.index);
        styleOfCell.setFont(hSSFFont);
		
		styleOfCell.setFillPattern(HSSFCellStyle.BORDER_THIN);
		cellA1.setCellStyle(styleOfCell);
		
		return cellA1;
	}
}
