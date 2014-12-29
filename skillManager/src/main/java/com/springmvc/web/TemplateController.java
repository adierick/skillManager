package com.springmvc.web;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.springmvc.Context;
import com.springmvc.IConstants;
import com.springmvc.bo.FileSetting;
import com.springmvc.bo.Person;
import com.springmvc.formdata.ExpProFormData;
import com.springmvc.formdata.TemplateFormData;
import com.springmvc.services.FileSettingService;
import com.springmvc.utils.HandlerWordFile;
import com.springmvc.utils.KeyWordEnum;
import com.springmvc.utils.Security;

/**
 * @author glhomme
 *
 */

@Controller
@SessionAttributes("templateData")
@RequestMapping("/template")
public class TemplateController{
	
	private static final String PATTERN_DATE = "yyyyMMddHHmmss";
	private static final String EXP_SUFFIXE = " :";
	private static final String EMPTY_SUFFIXE = "";
	private static final String ERROR_FORWARD = "redirect:/main/login/login.do";
	private static final String SUCCESS_POPULATE = "template/templateFields";
	private static final String SUCCESS_STEP1 = "template/tabsCv";
	private static final String SUCCESS_STEP2 = "template/expPro";
	private static final String SUCCESS_DOWNLOAD= "template/download";
	private static final String DOC_CV = "cvdocsession";
	private static final String CV_PREFIX = "CV_";
	private static final String DOC_EXTENSION = ".docx";

	/** The service. */
	private final FileSettingService service = Context.getInstance().getApplicationContext().getBean(FileSettingService.class);
	
	
	@ModelAttribute("templateData")
    public TemplateFormData getTemplateData() {
        return new TemplateFormData();
    }
	
	@RequestMapping(value="/populate.do")
	public String templateDetail(Model model ,HttpSession session, HttpServletRequest request,@ModelAttribute("templateData") TemplateFormData templateFormData) throws IOException {

		Security secure = Security.getInstance();
		if (secure.verifyLogin(request)){
				Person connected = (Person) session.getAttribute(IConstants.USER_SESSION);
				templateFormData.setFirstname(connected.getFirstname());
				templateFormData.setLastname(connected.getLastname());
			
			return SUCCESS_POPULATE;
		} else {
			return ERROR_FORWARD;
		}
		
		
	}
	
	
	@RequestMapping( value="/step1.do")
	public String stepOneCv(@ModelAttribute("templateData") TemplateFormData templateFormData, BindingResult binding, Model model, HttpSession session, HttpServletRequest request) throws Exception{
		Security secure = Security.getInstance();
		if (secure.verifyLogin(request)) {
			FileSetting fileCv = service.getFile(1);
			XWPFDocument doci = new XWPFDocument(new ByteArrayInputStream(fileCv.getContent()));
			/** general fields*/
			
			
			
			Map<String,String> map = new HashMap<String,String>();
			/** >> field prefilled*/
			map.put(KeyWordEnum.FIRSTNAME.getValue(), templateFormData.getFirstname());
			map.put(KeyWordEnum.LASTNAME.getValue(), templateFormData.getLastname().substring(0, 1).toUpperCase()+".");
			/** << */
			
			if(templateFormData.getAge() != null){
				map.put(KeyWordEnum.AGECLB.getValue(),templateFormData.getAge().toString());
			}
			if(StringUtils.isNotBlank(templateFormData.getFctclb())){
				map.put(KeyWordEnum.FONCTIONCLB.getValue(),templateFormData.getFctclb());
			}
			if(StringUtils.isNotBlank(templateFormData.getExpclb())){
				map.put(KeyWordEnum.EXPCLB.getValue(),templateFormData.getExpclb());
			}
			if(StringUtils.isNotBlank(templateFormData.getDispoclb())){
				map.put(KeyWordEnum.DISPOCLB.getValue(),templateFormData.getDispoclb());
			}
			if(StringUtils.isNotBlank(templateFormData.getLastSchool())){
				map.put(KeyWordEnum.LASTSCHOOL.getValue(),templateFormData.getLastSchool());
			}
			
			if(StringUtils.isNotBlank(templateFormData.getFirstname()) && StringUtils.isNotBlank(templateFormData.getLastname())){
				String truncatename = templateFormData.getFirstname()+" "+templateFormData.getLastname().substring(0, 1).toUpperCase()+".";
				map.put(KeyWordEnum.INITIALES.getValue(),truncatename);
			}
			
			HandlerWordFile.writeDocument(doci, map);
			session.setAttribute(DOC_CV,doci);
			return SUCCESS_STEP1;
		}
		return ERROR_FORWARD;
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/step2.do")
	public String stepTwoCv(@ModelAttribute("templateData") TemplateFormData templateFormData, BindingResult binding, Model model, HttpSession session, HttpServletRequest request) throws Exception{
		Security secure = Security.getInstance();
		if (secure.verifyLogin(request)) {
			XWPFDocument doci = (XWPFDocument) session.getAttribute(DOC_CV);
			FileSetting fileFormation = service.getFile(2);
			XWPFDocument docFmt = new XWPFDocument(new ByteArrayInputStream(fileFormation.getContent()));

			/** 3 dynamic tables for doc*/
			
			/** Experiences significatives */
			if(templateFormData.getExpSignLbl()!= null && !templateFormData.getExpSignLbl().isEmpty() && templateFormData.getExpSign()!= null && !templateFormData.getExpSign().isEmpty()){
				Map<String,String> mapExp = HandlerWordFile.transformListsToMap(templateFormData.getExpSignLbl(), templateFormData.getExpSign());
				HandlerWordFile.replaceSpecific2DimTableWithKeyValue(mapExp, doci, 0, EXP_SUFFIXE);
			}
			
			/** Competences techniques*/
			if(templateFormData.getCptTechLbl()!= null && !templateFormData.getCptTechLbl().isEmpty() && templateFormData.getCptTech()!= null && !templateFormData.getCptTech().isEmpty()){
				Map<String,String> mapCpt = HandlerWordFile.transformListsToMap(templateFormData.getCptTechLbl(), templateFormData.getCptTech());
				HandlerWordFile.replaceSpecific2DimTableWithKeyValue(mapCpt, doci, 1,EMPTY_SUFFIXE);
			}
			/** Competences métiers*/
			if(templateFormData.getCptMtrLbl()!= null && !templateFormData.getCptMtrLbl().isEmpty() && templateFormData.getCptMtr()!= null && !templateFormData.getCptMtr().isEmpty()){
				Map<String,String> mapMtr = HandlerWordFile.transformListsToMap(templateFormData.getCptMtrLbl(), templateFormData.getCptMtr());
				HandlerWordFile.replaceSpecific2DimTableWithKeyValue(mapMtr, doci, 2,EMPTY_SUFFIXE);
			}
			
			/** Formations */
			if(templateFormData.getFmtLbl()!= null && !templateFormData.getFmtLbl().isEmpty() && templateFormData.getFmt()!= null && !templateFormData.getFmt().isEmpty()){
				Map<String,String> mapFmt = HandlerWordFile.transformListsToMap(templateFormData.getFmtLbl(), templateFormData.getFmt());
				HandlerWordFile.replaceSpecific2DimTableWithKeyValue(mapFmt, docFmt, docFmt.getTables().size()-1,EMPTY_SUFFIXE);
			}
			
			XWPFTable table = docFmt.getTables().get(0);
			doci.createTable();
			doci.setTable(doci.getTables().size()-1, table);

			
			session.setAttribute(DOC_CV,doci);
			return SUCCESS_STEP2;
		}
		return ERROR_FORWARD;
	}
	
	
	/**
	 * @param person
	 * @param binding
	 * @param model
	 * @param session
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(method=RequestMethod.POST, value="/generatePdf.do")
	public String generatePdf(@ModelAttribute("templateData") TemplateFormData templateFormData, BindingResult binding, Model model, HttpSession session, HttpServletRequest request,SessionStatus status) throws Exception{
		Security secure = Security.getInstance();
		if (secure.verifyLogin(request)) {
			
			
			FileSetting fileExp = service.getFile(3);
			
			XWPFDocument doci = (XWPFDocument) session.getAttribute(DOC_CV);
			
			 
			/** Exp pro fields*/
			XWPFParagraph refPara = doci.getParagraph(doci.getParagraphs().get(doci.getParagraphs().size()-1).getCTP());
			for(ExpProFormData experience : templateFormData.getExpPros()){
				XWPFDocument docExp = new XWPFDocument(new ByteArrayInputStream(fileExp.getContent()));
				Map<String,String> map = new HashMap<String,String>();
				map.put(KeyWordEnum.CLIENT.getValue(), experience.getClient());
				map.put(KeyWordEnum.LIEU.getValue(),experience.getLieu());
				map.put(KeyWordEnum.FONCTIONCLB.getValue(),experience.getFonction());
				map.put(KeyWordEnum.RESUME.getValue(),experience.getResume());
				map.put(KeyWordEnum.DEBUT.getValue(),experience.getDebut());
				map.put(KeyWordEnum.FIN.getValue(),experience.getFin());
				map.put(KeyWordEnum.TECHNO.getValue(),experience.getTechno());
				
				HandlerWordFile.replaceParagraphTextKeyByValue(map,docExp.getParagraphs());
			
				/** liste details experience*/ 
				HandlerWordFile.replaceSimpleTableValueWithListValue(experience.getDetails(), docExp, docExp.getTables().size()-1);
				
				/** add exp*/
				HandlerWordFile.addLayerWithOneTable(doci, docExp,refPara);

				
				
			}
			
			session.setAttribute(DOC_CV,doci);
	   		status.setComplete();	
			return SUCCESS_DOWNLOAD;
		}else{
			return ERROR_FORWARD;
		}
		
	}
	
	@RequestMapping(value="/dropItem/{list}/{id}")
    @ResponseBody
    public void dropItem(@ModelAttribute("templateData") TemplateFormData templateFormData,@PathVariable("list") String list, @PathVariable("id") String id,HttpServletRequest request) throws NumberFormatException, IOException {
		Security secure = Security.getInstance();
		if (secure.verifyLogin(request)) {
			try{
				int index = Integer.parseInt(id);
				
				if(list.equals("exp")) {
					templateFormData.getExpSign().remove(index);
					templateFormData.getExpSignLbl().remove(index);
				} else if(list.equals("fmt")) {
					templateFormData.getFmt().remove(index);
					templateFormData.getFmtLbl().remove(index);
				} else if(list.equals("mtr")) {
					templateFormData.getCptMtr().remove(index);
					templateFormData.getCptMtrLbl().remove(index);
				} else if(list.equals("tec")) {
					templateFormData.getCptTech().remove(index);
					templateFormData.getCptTechLbl().remove(index);
				}
				
//				switch(list){
//						case "exp" :{
//							templateFormData.getExpSign().remove(index);
//							templateFormData.getExpSignLbl().remove(index);
//							break;
//						}
//						case "fmt" :{
//							templateFormData.getFmt().remove(index);
//							templateFormData.getFmtLbl().remove(index);
//							break;
//						}
//						case "mtr" :{
//							templateFormData.getCptMtr().remove(index);
//							templateFormData.getCptMtrLbl().remove(index);
//							break;
//						}
//						case "tec" :{
//							templateFormData.getCptTech().remove(index);
//							templateFormData.getCptTechLbl().remove(index);
//							break;
//						}
//					};
			}catch(NumberFormatException nfe){
				System.out.println(nfe.getMessage());
			}
		}
		
    }
	
	@RequestMapping(method=RequestMethod.GET, value="/download.do")
	public void downloadFile(HttpServletRequest request,
            HttpServletResponse response,HttpSession session) throws IOException{
		Security secure = Security.getInstance();
		if (secure.verifyLogin(request)) {
			/** create specified file name */
			Person connected = (Person) session.getAttribute(IConstants.USER_SESSION);
			String initiales =  StringUtils.upperCase(connected.getFirstname()).substring(0, 1)+StringUtils.upperCase(connected.getLastname()).substring(0, 1);
			SimpleDateFormat spf = new SimpleDateFormat(PATTERN_DATE);
			String namefile = CV_PREFIX+initiales+"_"+spf.format(GregorianCalendar.getInstance().getTime())+DOC_EXTENSION ;	
			XWPFDocument doci = (XWPFDocument) session.getAttribute(DOC_CV);

	        // set headers for the response
	        String headerKey = "Content-Disposition";
	        String headerValue = String.format("attachment; filename=\"%s\"",
	        		namefile);
	        response.setHeader(headerKey, headerValue);
	        
	        // get output stream of the response
	        ServletOutputStream outStream = response.getOutputStream();
	        doci.write(outStream);

	        outStream.flush();
	        outStream.close();
	        response.flushBuffer();
			
		}
	}

}
