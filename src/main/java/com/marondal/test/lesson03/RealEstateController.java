package com.marondal.test.lesson03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marondal.test.lesson03.bo.RealEstateBO;
import com.marondal.test.lesson03.model.RealEstate;

@Controller
@RequestMapping("/lesson03")
public class RealEstateController {
	
	@Autowired
	private RealEstateBO realEstateBO;
	
	@RequestMapping("/test01/1")
	@ResponseBody
	public RealEstate realEstate(@RequestParam("id") int id) {
		
		return realEstateBO.getRealEstate(id);
	}
	
	@ResponseBody
	@RequestMapping("/test01/2")
	public List<RealEstate> realEstateByRentPrice(@RequestParam("rent") int rentPrice) {
		
		 return realEstateBO.getRealEstateByRentPrice(rentPrice);
	}
	
	@RequestMapping("/test01/3")
	@ResponseBody
	public List<RealEstate> realEstateByAreaPrice(
			@RequestParam("area") int area,
			@RequestParam("price") int price) {
		
		return realEstateBO.getRealEstateByAreaPrice(area, price);
	}
	
	@RequestMapping("/test02/1")
	@ResponseBody
	public String addRealEstate() {
		
		RealEstate realEstate = new RealEstate();
		realEstate.setRealtorId(3);
		realEstate.setAddress("푸르지용 리버 303동 1104호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(100000);
		
		int count = realEstateBO.addRealEstateByObject(realEstate);
		
		return "삽입 결과 : " + count;
	}
	
	@RequestMapping("/test02/2")
	@ResponseBody
	public String addRealEstateWithParameter(@RequestParam("realtorId") int realtorId) {
		
		int count = realEstateBO.addRealEstateByField(realtorId, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
		
		return "삽입결과 : " + count;
		
	}
	
	@RequestMapping("/test02/3")
	@ResponseBody
	public String updateRealEstate() {
		int count = realEstateBO.updateRealEstate(24, "전세", 70000);
		
		return "업데이트 결과 : " + count;
	}
	
	
	@RequestMapping("/test02/4")
	@ResponseBody
	public String deleteRealEstate(@RequestParam("id") int id) {
		
		int count = realEstateBO.deleteRealEstate(id);
		
		return "삭제 결과 : " + count;
		
	}

}
