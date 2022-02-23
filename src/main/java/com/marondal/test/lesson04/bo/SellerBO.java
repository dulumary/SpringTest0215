package com.marondal.test.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondal.test.lesson04.dao.SellerDAO;
import com.marondal.test.lesson04.model.Seller;

@Service
public class SellerBO {
	
	@Autowired
	private SellerDAO sellerDAO;
	
	public int addSeller(String nickName, String profileUrl, double temperature) {
		return sellerDAO.insertSeller(nickName, profileUrl, temperature);
	}
	
	public Seller getLastSeller() {
		return sellerDAO.selectLastSeller();
	}
	
	public Seller getSeller(int id) {
		return sellerDAO.selectSellelr(id);
	}
	
}
