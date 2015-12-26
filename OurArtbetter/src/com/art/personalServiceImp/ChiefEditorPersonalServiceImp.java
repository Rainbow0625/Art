package com.art.personalServiceImp;
/*
 * @author 范溢贞 24320132202399
 */
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.art.dao.ChiefEditorDao;
import com.art.entity.ChiefEditor;
import com.art.personalService.ChiefEditorPersonalService;

@Service
public class ChiefEditorPersonalServiceImp implements ChiefEditorPersonalService{
	
	@Resource
	private ChiefEditorDao chiefEditorDao;

	public void setChiefEditorDao(ChiefEditorDao chiefEditorDao) {
		this.chiefEditorDao = chiefEditorDao;
	}

	@Override
	public ChiefEditor findChiefEditor(String name, String password) {
		// TODO Auto-generated method stub
		ChiefEditor chiefEditor = null;
		try {
			chiefEditor = chiefEditorDao.findChiefEditorByNameAndPassword(name, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("error in find chiefEditor by name and password in service!");//for test
		}
		return chiefEditor;
	}

	@Override
	public List<ChiefEditor> getAllChiefEditors() {
		// TODO Auto-generated method stub
		return chiefEditorDao.getAllChiefEditor();
	}

}
