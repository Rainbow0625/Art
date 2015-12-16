package com.art.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.art.backstageService.InfoService;
import com.art.entity.DateAndPos;
import com.art.entity.Editor;
import com.art.entity.InfoColumn;
import com.art.entity.Information;

@Controller
public class InfoController 
{
	@Resource
	private InfoService infoService;
	
	@Autowired
	public InfoController(InfoService infoService)
	{
		this.infoService=infoService;
	}

	
	/*editor*/

	@RequestMapping("/ADMIN_infolist") 
	public ModelAndView listAllInfoByEditorId(ModelMap model)
	{
		//HttpServletRequest request,
		
		//Editor editor = (Editor)request.getAttribute("editor");
		//int editorId=editor.getId();
		int editorId = 1;
		
		List<Information> myInfo = new ArrayList<Information>();
		List<Information> myAdver = new ArrayList<Information>();
		
		myInfo.addAll(infoService.getInformationByEditorId(editorId) ); 
		myAdver.addAll(infoService.getAdverByEditorId(editorId));

		if(myInfo==null || myAdver==null)
			return new ModelAndView("error");
		
		model.addAttribute("myInfo", myInfo);
		model.addAttribute("myAdver", myAdver);
		System.out.println("ok to display info list");

		return new ModelAndView("ADMIN_infolist",model);
	}
	

	//直接跳转的页面。其实需要设置session  editor？
	@RequestMapping("/ADMIN_uploadInfo") 
	public ModelAndView newInfo(Model model)
	{
		return new ModelAndView("ADMIN_uploadInfo");
	}
	
	
	/*保存成html文件的方法，并添加一条记录在数据库Information表里*/
	@RequestMapping("/ADMIN_saveInfo")   
	public ModelAndView saveInfo(String title,String contentType,String content)
	{
		Information info = new Information();
		info.setTitle(title);
		info.setState(0);
		Date createTime = new Date();
		info.setCreateTime(createTime);
		info.setNextTime(null);
		//info.setEditor(editor);   
		
		
		
		
		//info.setContent(content);
		info.setContentType(contentType);
		
		infoService.addAnInfo(info);
		return new ModelAndView("ADMIN_infolist") ;  
	}
	
	/*//修改是需要用文本编辑器   打开原来的html的  设置的属性要显示！*/
	@RequestMapping("/ADMIN_ToUpdateInfo/{infoId} ")  
	public ModelAndView toUpdateInfo(@PathVariable int infoId,Model model)
	{
		Information information = infoService.getInformationById(infoId);
		model.addAttribute(information);
		return new ModelAndView( "ADMIN_uploadinfo");//新界面！ 能打开HTML
	}
	
	
	/*在文本编辑器的页面，点击提交，设置的 为调用这个controller*/
	@RequestMapping("/ADMIN_updateInfo")  
	public ModelAndView updateInfo(String title,String contentType,String content)//这个是info 类的对象吗
	{
		Information info = new Information();  
		info.setState(0); //一旦修改之后，就变成未审核状态
		info.setTitle(title);
		Date nextTime = new Date();
		info.setNextTime(nextTime);
		info.setContent(content);
		info.setContentType(contentType);
		infoService.updateAnInfo(info);
		return new ModelAndView("ADMIN_infolist");  
	}
	
	
	@RequestMapping("/ADMIN_deleteInfo/{infoId}") 
	public ModelAndView deleteInfo(@PathVariable int infoId) //delete by primary key
	{
		Information information = new Information();
		information.setId(infoId);
		infoService.deleteAnInfo(information);
		return new ModelAndView("ADMIN_infolist");
	}
	
	
	
	
	/*chiefEditor*/
	
	@RequestMapping("/ADMIN_chiefinfo") 
	public ModelAndView listAllInfoToChiefEditor(ModelMap model)
	{
		List<Information> allInfo = new ArrayList<Information>();
		List<Information> allAdver = new ArrayList<Information>();
		
		allInfo.addAll(infoService.getAllInfo()); 
		allAdver.addAll(infoService.getAllAdver());

		model.addAttribute("allInfo", allInfo);
		model.addAttribute("allAdver", allAdver); 
		System.out.println("ok to display info list");

		return new ModelAndView("ADMIN_cheifinfo",model);
	}
	
	/*修改返回值*/
	@RequestMapping("/ADMIN_chiefLookThrough/{infoId}") 
	public ModelAndView displayInfoToChiefEditor(@PathVariable int infoId)
	{
		Information information = infoService.getInformationById(infoId);

		return new ModelAndView(information.getContent());   //有问题
	}
	
	
	@RequestMapping("/ADMIN_checkInfo/{infoId}") 
	public ModelAndView checkInfo(@PathVariable int infoId)
	{
		infoService.checkInfoById(infoId);
		return new ModelAndView("ADMIN_chiefinfo");  
	}
	
	@RequestMapping("/ADMIN_failInfo/{infoId}") 
	public ModelAndView failInfo(@PathVariable int infoId)
	{
		infoService.failInfoById(infoId);
		return new ModelAndView("ADMIN_chiefinfo"); 
	}
	
		
	/*跳转到该条咨询的页面 */
	@RequestMapping("/ADMIN_TosetDateAndPos/{infoId}") 
	public ModelAndView TosetDateAndPos(@PathVariable int infoId,Model model)
	{
		Information information = infoService.getInformationById(infoId);
		model.addAttribute(information);
		return new ModelAndView("ADMIN_chiefInfoDateAndPos");  
	}
	

	@RequestMapping("/ADMIN_setDateAndPos/{infoId}") 
	public ModelAndView setDateAndPos(HttpServletRequest request,@PathVariable int infoId,Model model)
	{
		int infoColumnId = (Integer)request.getAttribute("infoColumnId");  //!!!
		Date date = (Date)request.getAttribute("date");  //!!!
		
		Information information = infoService.getInformationById(infoId);
		InfoColumn infoColumn = infoService.getInfoColumnById(infoColumnId);
		
		DateAndPos dateAndPos = new DateAndPos();
		dateAndPos.setInformation(information);
		dateAndPos.setInfoColumn(infoColumn);
		dateAndPos.setDate(date);

		model.addAttribute(information);
		infoService.setDateAndPos(dateAndPos);	
		return new ModelAndView("ADMIN_chiefInfoDateAndPos");  
	}
	
	
	@RequestMapping("/ADMIN_deleteDateAndPos/{dateAndPosId}")   //传入的参数！！
	public ModelAndView deleteDateAndPos(@PathVariable int dateAndPosId)
	{
		DateAndPos dateAndPos = new DateAndPos();
		dateAndPos.setId(dateAndPosId);
		infoService.deleteDateAndPos(dateAndPos);	
		return new ModelAndView("ADMIN_chiefInfoDateAndPos");  
	}
	
	
	
}
