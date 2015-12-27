package com.art.businessServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.art.businessService.CustomizationService;
import com.art.dao.ArtworkDao;
import com.art.dao.OrderDao;

@Service
@Transactional
public class CustomizationServiceImp implements CustomizationService
{
	@Autowired
	private ArtworkDao artworkDao;
	@Autowired
	private OrderDao orderDao;
	
	public CustomizationServiceImp(){}
	
	
	
}
