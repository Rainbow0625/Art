package com.art.exhibitServiceImp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.art.dao.ArtistDao;
import com.art.dao.ArtworkDao;
import com.art.entity.Artist;
import com.art.entity.Artwork;
import com.art.exhibitService.ArtworkExhibitService;



@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class ArtworkExhibitServiceImp implements ArtworkExhibitService{
	@Resource
	private ArtworkDao productDao;
	
	public void setProductDao(ArtworkDao productDao){
		this.productDao=productDao;
	}
	
	@Override
	public List<Artwork> getAllProduct() {
		List<Artwork> product_list = productDao.getAllProduct();
		return product_list;
	}
	@Resource
	private ArtworkDao auctionDao;
	
	public void setAuctionDao(ArtworkDao auctionDao){
		this.auctionDao=auctionDao;
	}
	
	@Override
	public List<Artwork> getAllAuction() {
		List<Artwork> auction_list = auctionDao.getAllAuction();
		return auction_list;
	}
	@Resource
	private ArtworkDao artwrokDao;
	
	public void setArtworkDao(ArtworkDao artwrokDao){
		this.artwrokDao=artwrokDao;
	}
	@Override
	public List<Artwork> getAllArtwork() {
		List<Artwork> artwork_list = artwrokDao.getAllArtwork();
		return artwork_list;
	}
	@Resource
	private ArtworkDao custommadeDao;
	
	public void setCustommadeDao(ArtworkDao custommadeDao){
		this.custommadeDao=custommadeDao;
	}
	@Override
	public List<Artwork> getAllCustommade() {
		List<Artwork> custommade_list = custommadeDao.getAllCustommade();
		return custommade_list;
	}
}
