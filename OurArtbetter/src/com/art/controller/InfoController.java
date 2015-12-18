package com.art.controller;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.hibernate.sql.Template;
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
	

	//ֱ����ת��ҳ�档��������session  editor id��
	@RequestMapping("/ADMIN_uploadInfo") 
	public ModelAndView newInfo(Model model)
	{
		return new ModelAndView("ADMIN_uploadInfo");
	}
	
	
	/*�����һ����¼�����ݿ�Information����*/
	@SuppressWarnings({ "unused", "resource" })
	@RequestMapping("/ADMIN_saveInfo")   
	public ModelAndView saveInfo(HttpServletRequest request)
	{
		String title = request.getParameter("title");
		String contentType = request.getParameter("contentType");
		String content = request.getParameter("content");
		Information info = new Information();
		info.setTitle(title);
		info.setState(0);
		Date createTime = new Date();
		info.setCreateTime(createTime);
		info.setNextTime(null);	
		info.setContentType(contentType);
		
		Editor editor= new Editor();
		editor.setId(1);
		info.setEditor(editor);  
		
		info.setContent(content);
		
		//�ļ����� 
		/*
		//System.out.printf("%s", content);	
		 !!!   application.getRealPath(request.getRequestURI());
		 request.getRequestURI()
		 System.out.printf("%s", System.getProperty("user.dir") );
		 //System.out.printf("%s", Thread.currentThread().getContextClassLoader().getResource(""));
		//String  request.getContextPath();
		 */
		try
	    { /*
			String head = null;
			String middle = null;
			String tail = null;
			FileReader fileReader = new FileReader("C:\\Users\\Hz\\Desktop\\Art\\OurArtbetter\\WebContent\\infoHTML\\head.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String temp;
			while (  ( temp = bufferedReader.readLine() )!=null   )
			 {
				head+= temp;
			 }
	    	
			fileReader = new FileReader("C:\\Users\\Hz\\Desktop\\Art\\OurArtbetter\\WebContent\\infoHTML\\middle.txt");
			BufferedReader bufferedReader2 = new BufferedReader(fileReader);

			while (  ( temp = bufferedReader2.readLine() )!=null   )
			 {
				middle+= temp;
			 }
			
			fileReader = new FileReader("C:\\Users\\Hz\\Desktop\\Art\\OurArtbetter\\WebContent\\infoHTML\\tail.txt");
			BufferedReader bufferedReader3 = new BufferedReader(fileReader);

			while (  ( temp = bufferedReader3.readLine() )!=null   )
			 {
				tail+= temp;
			 }
			bufferedReader.close();
			
			*/
				
		    FileWriter fileWriter = new FileWriter("C:\\Users\\Hz\\Desktop\\Art\\OurArtbetter\\WebContent\\infoHTML\\"+title+".html"); 		    
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
		return new ModelAndView("ADMIN_infolist") ;  
	}
	
	/*//�޸�����Ҫ���ı��༭��   ��ԭ����HTML��  ���õ�����Ҫ��ʾ��*/
	@RequestMapping("/ADMIN_ToUpdateInfo/{infoId} ")  
	public ModelAndView toUpdateInfo(@PathVariable int infoId,Model model)
	{
		Information information = infoService.getInformationById(infoId);
		model.addAttribute(information);
		return new ModelAndView( "");//�½��棡 �ܴ�HTML
	}
	
	
	/*���ı��༭����ҳ�棬����ύ�����õ� Ϊ�������controller*/
	@RequestMapping("/ADMIN_updateInfo")  
	public ModelAndView updateInfo(String title,String contentType,String content)//�����info ��Ķ�����
	{
		Information info = new Information();  
		info.setState(0); //һ���޸�֮�󣬾ͱ��δ���״̬
		info.setTitle(title);
		Date nextTime = new Date();
		info.setNextTime(nextTime);
		info.setContent(content);
		
		
		
		
		//���ļ��ж�ȡ
				try 
				{
					FileReader fileReader = new FileReader("c1.txt");
					BufferedReader bufferedReader = new BufferedReader(fileReader);
				
					String str;
			    	str= bufferedReader.readLine();
			    	String[] integer = str.split(" ");
			    	for(int j=0;j<10;j++)
			    		System.out.printf("%s ",integer[j]);

					bufferedReader.close();
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
	
	/*�޸ķ���ֵ*/
	@RequestMapping("/ADMIN_chiefLookThrough/{infoId}") 
	public ModelAndView displayInfoToChiefEditor(@PathVariable int infoId)
	{
		Information information = infoService.getInformationById(infoId);

		return new ModelAndView(information.getContent());   //������
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
	
		
	/*��ת��������ѯ��ҳ�� */
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
		//int infoColumnId =Integer.parseInt( request.getParameter("infoColumnId") );    //Ϊʲô��ô�����getParameter ��getAttribute ������
		//Date date = Date.parse(request.getParameter("date"));  
		
		Information information = infoService.getInformationById(infoId);
		//InfoColumn infoColumn = infoService.getInfoColumnById(infoColumnId);
		
		DateAndPos dateAndPos = new DateAndPos();
		dateAndPos.setInformation(information);
		//dateAndPos.setInfoColumn(infoColumn);
		//dateAndPos.setDate(date);

		model.addAttribute(information);
		infoService.setDateAndPos(dateAndPos);	
		return new ModelAndView("ADMIN_chiefInfoDateAndPos");  
	}
	
	
	@RequestMapping("/ADMIN_deleteDateAndPos/{dateAndPosId}")   //����Ĳ�������
	public ModelAndView deleteDateAndPos(@PathVariable int dateAndPosId)
	{
		DateAndPos dateAndPos = new DateAndPos();
		dateAndPos.setId(dateAndPosId);
		infoService.deleteDateAndPos(dateAndPos);	
		return new ModelAndView("ADMIN_chiefInfoDateAndPos");  
	}
	
	
	
}
