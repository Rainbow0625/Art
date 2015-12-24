package com.art.controller;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
	
	public InfoController(){}

	@RequestMapping("/ADMIN_welcome") 
	public ModelAndView toadmin()
	{
		
		return new ModelAndView("ADMIN_welcome");
	}
	
	/*+editor session*/
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
	

	//+直接跳转的页面。后期设置session  editor id等
	@RequestMapping("/ADMIN_uploadinfo") 
	public ModelAndView newInfo()
	{
		return new ModelAndView("ADMIN_uploadinfo");
	}
	
	
	/*+  editor session*/
	@RequestMapping("/ADMIN_saveInfo")   
	public ModelAndView saveInfo(@RequestParam("uploadImage") MultipartFile uploadImage,HttpServletRequest request,Model model )
	{
		String title = request.getParameter("title");
		String contentType = request.getParameter("contentType");
		String content = request.getParameter("content");
		String Imagepath=request.getSession().getServletContext().getRealPath("/")+"images//"+ uploadImage.getOriginalFilename();
		
		
		Information info = new Information();
		info.setTitle(title);
		info.setState("未审核");
		Date createTime = new Date();
		info.setCreateTime(createTime);
		info.setNextTime(null);	
		info.setContentType(contentType);
		
		Editor editor= new Editor();
		editor.setId(1);
		
		info.setEditor(editor);  
		info.setContent(content);
		
		
		File db= new File(request.getSession().getServletContext().getRealPath("/")+"images/");
		String ImageDB = db.getPath();
		System.out.println(ImageDB);
		info.setImage(ImageDB);
		
		//保存图片
		try 
		{
			File image = new File(Imagepath);
			uploadImage.transferTo(image);
		} 
		catch (IllegalStateException | IOException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//HTML保存 
		try
	    { 	
		    FileWriter fileWriter = new FileWriter(request.getSession().getServletContext().getRealPath("/")+"infoHTML//"+title+".html"); 		    
		    fileWriter.write(content); 
		    fileWriter.flush();  
		    fileWriter.close();
	    }
	    catch(FileNotFoundException e)
		{
	    	e.printStackTrace();
		}
	    catch(IOException e) 
	    {
	    	// TODO Auto-generated catch block
	    	e.printStackTrace();
	    }  
		
		infoService.addAnInfo(info);
		int message=1;
		model.addAttribute("message",message);
		return new ModelAndView("ADMIN_EditorSuccess") ;  
	}
	
	@RequestMapping("/ADMIN_ToUpdateInfo")  
	public ModelAndView toUpdateInfo(@RequestParam int id,Model model)
	{
		Information information = infoService.getInformationById(id);
		model.addAttribute("information",information);
		return new ModelAndView("ADMIN_updateInfo");
	}
	
	

	@RequestMapping("/ADMIN_updateinfo")  
	public ModelAndView updateinfo(@RequestParam("uploadImage") MultipartFile uploadImage, @RequestParam("id") int id,HttpServletRequest request,Model model)
	{
		String Imagepath=request.getSession().getServletContext().getRealPath("/")+"images//"+ uploadImage.getOriginalFilename();
		String title = request.getParameter("title");
		String contentType = request.getParameter("contentType");
		String content = request.getParameter("content");
		
		File db= new File(request.getSession().getServletContext().getRealPath("/")+"images/",uploadImage.getOriginalFilename());
		String ImageDB = db.getPath();  //变为相对路径
		System.out.println(ImageDB);
		
		Information info = new Information();  	
		info.setId(id);
		info.setTitle(title);
		info.setContentType(contentType);
		Date nextTime = new Date();
		info.setNextTime(nextTime);
		info.setContent(content);
		info.setImage(ImageDB);
		info.setState("未审核");
		
		
		//保存图片
		try 
		{
			File image = new File(Imagepath);
			uploadImage.transferTo(image);
		} 
		catch (IllegalStateException | IOException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//从文件中写入
		try 
		{	
			FileWriter fileWriter = new FileWriter(request.getSession().getServletContext().getRealPath("/")+"infoHTML//"+title+".html"); 		    
		    fileWriter.write(content); 
		    fileWriter.flush();  
		    fileWriter.close();
		} 
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		infoService.updateAnInfo(info);
		
		int message=2;
		model.addAttribute("message",message);
		return new ModelAndView("ADMIN_EditorSuccess");
	}
	
	
	@RequestMapping("/ADMIN_deleteInfo") 
	public ModelAndView deleteInfo(@RequestParam int id, Model model) //delete by primary key
	{
		infoService.deleteAnInfo(id);
		int message=3;
		model.addAttribute("message",message);
		return new ModelAndView("ADMIN_EditorSuccess");
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

		return new ModelAndView("ADMIN_chiefinfo",model);
	}
	
	
	@RequestMapping("/ADMIN_chiefInfoDateAndPos") 
	public ModelAndView chiefInfoDateAndPos(ModelMap model,@RequestParam int id)
	{
		Information info = infoService.getInformationById(id);
		List<DateAndPos>  dateAndPosList  = new ArrayList<DateAndPos>();
		dateAndPosList.addAll(infoService.getDateAndPosByInformationId(id));
		model.addAttribute("dateAndPosList",dateAndPosList);
		model.addAttribute("info",info);
		return new ModelAndView("ADMIN_chiefInfoDateAndPos",model);  
	}
	
	
	
	
	@RequestMapping("/ADMIN_chiefLookThrough") 
	public ModelAndView displayInfoToChiefEditor(@RequestParam int id,Model model )
	{
		Information information = infoService.getInformationById(id);
		model.addAttribute("information", information);
		return new ModelAndView("infoContent");   
	}
	
	
	
	@RequestMapping("/ADMIN_checkInfo") 
	public ModelAndView checkInfo(@RequestParam int id,Model model )
	{
		infoService.checkInfoById(id);
		int message= 1;
		model.addAttribute("message",message);
		return new ModelAndView("ADMIN_ChiefEditorSuccess");  
	}
	
	@RequestMapping("/ADMIN_failInfo") 
	public ModelAndView failInfo(@RequestParam int id,Model model)
	{
		infoService.failInfoById(id);
		int message= 2;
		model.addAttribute("message",message);
		return new ModelAndView("ADMIN_ChiefEditorSuccess"); 
	}
	
		
	@RequestMapping("/ADMIN_TosetDateAndPos") 
	public ModelAndView TosetDateAndPos(@RequestParam int id,ModelMap model)
	{
		Information info = infoService.getInformationById(id);
		List<DateAndPos>  dateAndPosList  = new ArrayList<DateAndPos>();
		dateAndPosList.addAll(infoService.getDateAndPosByInformationId(id));
		model.addAttribute("dateAndPosList",dateAndPosList);
		model.addAttribute("info",info);
		return new ModelAndView("ADMIN_chiefInfoDateAndPos",model);  
	}
	

	@RequestMapping("/ADMIN_setDateAndPos")   
	public ModelAndView setDateAndPos(HttpServletRequest request,@RequestParam int id,Model model)
	{
		
		try {
			int infoColumnId =Integer.parseInt( request.getParameter("columnId") );    //为什么这么用详见getParameter 与getAttribute 的区别！
			String date =request.getParameter("startDate");
			//System.out.println(date);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
			Date update = sdf.parse(date);

			Information information = infoService.getInformationById(id);
			InfoColumn infoColumn = infoService.getInfoColumnById(infoColumnId);
			
			DateAndPos dateAndPos = new DateAndPos();
			dateAndPos.setInformation(information);
			dateAndPos.setInfoColumn(infoColumn);
			dateAndPos.setDate(update);
			
			int message= 3;
			model.addAttribute("message",message);
			model.addAttribute("id",id);
			Boolean flag = infoService.setDateAndPos(dateAndPos);
			if(flag==false)
			{
				return new ModelAndView("error");
			}
			
		} catch (ParseException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("ADMIN_ChiefEditorSuccess");
		
	}
	
	@RequestMapping("/ADMIN_deleteDateAndPos")   
	public ModelAndView deleteDateAndPos(@RequestParam int id,Model model )
	{
		Boolean flag = infoService.deleteDateAndPos(id);	
		if(flag==true)
		{
			int message=4;
			model.addAttribute("message",message);
		//model.addAttribute("id",infoId);  加入session后，就可以得到了
		return new ModelAndView("ADMIN_ChiefEditorSuccess"); 
		}
		else
			return new ModelAndView("error");

	}
}
