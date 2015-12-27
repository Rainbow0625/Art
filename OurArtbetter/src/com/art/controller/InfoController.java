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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

	/**
	 * 进入欢迎界面
	 * **/
	@RequestMapping("/ADMIN_welcome") 
	public ModelAndView toadmin()
	{
		return new ModelAndView("ADMIN_welcome");
	}
	
	
	/**
	 * editor看到的所有自己编辑的软文
	 * **/
	@RequestMapping("/ADMIN_infolist") 
	public ModelAndView listAllInfoByEditorId(ModelMap model,HttpSession session)
	{
		//Editor editor  = (Editor)session.getAttribute("editor");
		//int editorId=editor.getId();
		int editorId=1;
		
		List<Information> myInfo = new ArrayList<Information>();
		List<Information> myAdver = new ArrayList<Information>();
		
		myInfo.addAll(infoService.getInformationByEditorId(editorId) ); 
		myAdver.addAll(infoService.getAdverByEditorId(editorId));

		if(myInfo==null || myAdver==null)
			return new ModelAndView("error");
		
		model.addAttribute("myInfo", myInfo);
		model.addAttribute("myAdver", myAdver);

		return new ModelAndView("ADMIN_infolist",model);
	}
	
	/**
	 * editor新编一条软文
	 * **/
	//+直接跳转的页面。后期设置session  editor id等
	@RequestMapping("/ADMIN_uploadinfo") 
	public ModelAndView newInfo()
	{
		return new ModelAndView("ADMIN_uploadinfo");
	}
	

	/**
	 * 保存软文
	 * **/
	@RequestMapping("/ADMIN_saveInfo")   
	public ModelAndView saveInfo(@RequestParam("uploadImage") MultipartFile uploadImage,HttpServletRequest request,Model model ,HttpSession session)
	{
		String title = request.getParameter("title");
		String contentType = request.getParameter("contentType");
		String content = request.getParameter("content");
		String Imagepath = "C:/Users/Hz/Desktop/Art/OurArtbetter/WebContent/images//"+uploadImage.getOriginalFilename();
		//String Imagepath=request.getSession().getServletContext().getRealPath("/")+"images//"+ uploadImage.getOriginalFilename();
		
		Information info = new Information();
		info.setTitle(title);
		info.setState("δ���");
		Date createTime = new Date();
		info.setCreateTime(createTime);
		info.setNextTime(null);	
		info.setContentType(contentType);
		
		Editor editor  = (Editor)session.getAttribute("editor");
		editor.setId(editor.getId());
		
		info.setEditor(editor);  
		info.setContent(content);
		
		//File db= new File("images/",uploadImage.getOriginalFilename());
		String ImageDB = "images/"+uploadImage.getOriginalFilename();
		info.setImage(ImageDB);
		
		//����ͼƬ
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
		
		//HTML���� 
		try
	    { 	
		    //FileWriter fileWriter = new FileWriter(request.getSession().getServletContext().getRealPath("/")+"infoHTML//"+title+".html"); 		    
			FileWriter fileWriter = new FileWriter("C:/Users/Hz/Desktop/Art/OurArtbetter/WebContent/infoHTML//"+title+".html");
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
	
	
	/**
	 * 跳转到更新的页面，能够显示原来的信息
	 * **/
	@RequestMapping("/ADMIN_ToUpdateInfo")  
	public ModelAndView toUpdateInfo(@RequestParam int id,Model model)
	{
		Information information = infoService.getInformationById(id);
		model.addAttribute("information",information);
		return new ModelAndView("ADMIN_updateInfo");
	}
	
	
	/**
	 * 更新软文的页面
	 * **/
	@RequestMapping("/ADMIN_updateinfo")  
	public ModelAndView updateinfo(@RequestParam("uploadImage") MultipartFile uploadImage, @RequestParam("id") int id,HttpServletRequest request,Model model)
	{
		String Imagepath="C:/Users/Hz/Desktop/Art/OurArtbetter/WebContent/images//"+uploadImage.getOriginalFilename();
		String title = request.getParameter("title");
		String contentType = request.getParameter("contentType");
		String content = request.getParameter("content");
		/*
		File db= new File(request.getSession().getServletContext().getRealPath("/")+"images/",uploadImage.getOriginalFilename());
		String ImageDB = db.getPath();  //��Ϊ���·��
		System.out.println(ImageDB);
		*/
		Information info = new Information();  	
		String ImageDB = "images/"+uploadImage.getOriginalFilename();
		info.setImage(ImageDB);
				
		info.setId(id);
		info.setTitle(title);
		info.setContentType(contentType);
		Date nextTime = new Date();
		info.setNextTime(nextTime);
		info.setContent(content);
		info.setState("δ���");
		
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
			FileWriter fileWriter = new FileWriter("C:/Users/Hz/Desktop/Art/OurArtbetter/WebContent/infoHTML//"+title+".html"); 		    
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
	
	/**
	 * 删除软文
	 * **/
	@RequestMapping("/ADMIN_deleteInfo") 
	public ModelAndView deleteInfo(@RequestParam int id, Model model) //delete by primary key
	{
		infoService.deleteAnInfo(id);
		int message=3;
		model.addAttribute("message",message);
		return new ModelAndView("ADMIN_EditorSuccess");
	}

	
	/**
	 * 主编打开看到所有的软文
	 * **/
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

		return new ModelAndView("ADMIN_chiefinfo",model);
	}
	
	/**
	 * 主编到当条咨询的软文设置上线页面
	 * **/
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
	
	

	/**
	 * 主编显示单条咨询的页面，进而审核一下
	 * **/
	@RequestMapping("/ADMIN_chiefLookThrough") 
	public ModelAndView displayInfoToChiefEditor(@RequestParam int id,Model model )
	{
		Information information = infoService.getInformationById(id);
		model.addAttribute("information", information);
		return new ModelAndView("infoContent");   
	}
	
	/**
	 * 主编审核通过
	 * **/
	@RequestMapping("/ADMIN_checkInfo") 
	public ModelAndView checkInfo(@RequestParam int id,Model model )
	{
		infoService.checkInfoById(id);
		int message= 1;
		model.addAttribute("message",message);
		return new ModelAndView("ADMIN_ChiefEditorSuccess");  
	}
	
	
	/**
	 * 主编审核不通过
	 * **/
	@RequestMapping("/ADMIN_failInfo") 
	public ModelAndView failInfo(@RequestParam int id,Model model)
	{
		infoService.failInfoById(id);
		int message= 2;
		model.addAttribute("message",message);
		return new ModelAndView("ADMIN_ChiefEditorSuccess"); 
	}
	
	/**
	 * 主编到设置DateAndPos的页面
	 * **/
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
	
	/**
	 * 主编设置DateAndPos
	 * **/
	@RequestMapping("/ADMIN_setDateAndPos")   
	public ModelAndView setDateAndPos(HttpServletRequest request,@RequestParam int id,Model model)
	{
		
		try {
			int infoColumnId =Integer.parseInt( request.getParameter("columnId") );    //Ϊʲô��ô�����getParameter ��getAttribute ������
			
			String temp =request.getParameter("days");
			int days = Integer.parseInt(temp);
			
			String date =request.getParameter("startDate");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
			Date update = sdf.parse(date);

			Information information = infoService.getInformationById(id);
			InfoColumn infoColumn = infoService.getInfoColumnById(infoColumnId);
			
			DateAndPos dateAndPos = new DateAndPos();
			dateAndPos.setInformation(information);
			dateAndPos.setInfoColumn(infoColumn);
			dateAndPos.setDate(update);
			dateAndPos.setDays(days);
			
			int message= 3;
			model.addAttribute("message",message);
			model.addAttribute("id",id);    //use
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
	
	
	/**
	 * 主编删除设置的DateAndPos
	 * **/
	@RequestMapping("/ADMIN_deleteDateAndPos")   
	public ModelAndView deleteDateAndPos(@RequestParam int id,Model model )
	{
		Boolean flag = infoService.deleteDateAndPos(id);	
		if(flag==true)
		{
			int message=4;
			model.addAttribute("message",message);
		//model.addAttribute("id",infoId);  ����session�󣬾Ϳ��Եõ���
		return new ModelAndView("ADMIN_ChiefEditorSuccess"); 
		}
		else
			return new ModelAndView("error");

	}
	
	/**
	 * Ajax
	 * **/
	@RequestMapping("/ADMIN_info")   
	public void ajaxInfo(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		System.out.println(request.getParameter("message"));
		String info=request.getParameter("message");//是时间和天数
		String []message=info.split(" ");
		String date=message[0];//开始时间
		String day=message[1];//天数
		String title=message[2];//标题
		
		System.out.println(date+day+title);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		
		try {
			Date realDate = sdf.parse(date);
			int days =  Integer.parseInt(day);
			String result= infoService.getUnavailableColumnId(realDate,days) ; //result里放不可用的咨询位置的value 123456那个！不可用的呀！
			
			response.getWriter().write(result);
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	
	
}
