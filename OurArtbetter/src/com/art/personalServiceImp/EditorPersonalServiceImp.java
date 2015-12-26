package com.art.personalServiceImp;
/*
 * @author 范溢贞 24320132202399
 */
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.art.dao.EditorDao;
import com.art.entity.Editor;
import com.art.personalService.EditorPersonalService;

@Service
public class EditorPersonalServiceImp implements EditorPersonalService{

	@Resource
	private EditorDao editorDao;
		
	public void setEditorDao(EditorDao editorDao) {
		this.editorDao = editorDao;
	}

	@Override
	public Editor findEditor(String name,String password) {
		// TODO Auto-generated method stub
		Editor editor = null;
		try {
			editor = editorDao.findEditorByNameAndPassword(name, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("error in find editor by name and password in service!");//for test
		}
		return editor;
	}

	@Override
	public List<Editor> getAllEditors() {
		// TODO Auto-generated method stub
		return editorDao.getAllEditor();
	}

}
