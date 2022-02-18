package com.marondal.test.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondal.test.lesson03.dao.RealEstateDAO;
import com.marondal.test.lesson03.model.RealEstate;

@Service
public class RealEstateBO {
	
	@Autowired
	private RealEstateDAO realEstateDAO;
	
	public RealEstate getRealEstate(int id) {
		return realEstateDAO.selectRealEstate(id);
	}
	
	public List<RealEstate> getRealEstateByRentPrice(int rentPrice) {
		return realEstateDAO.selectRealEstateByRentPrice(rentPrice);
	}

	public List<RealEstate> getRealEstateByAreaPrice(int area, int price) {
		return realEstateDAO.selectRealEstateByAreaPrice(area, price);
	}
	
	public int addRealEstateByObject(RealEstate realEstate) {
		return realEstateDAO.insertRealEstate(realEstate);
	}
	
	public int addRealEstateByField(
			int realtorId, String address, int area, String type, int price, int rentPrice) {
		return realEstateDAO.insertRealEstateByField(realtorId, address, area, type, price, rentPrice);
	}
}
