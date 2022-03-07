package com.marondal.test.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marondal.test.lesson06.bo.FavoriteBO;
import com.marondal.test.lesson06.model.Favorite;

@Controller
@RequestMapping("/lesson06")
public class FavoriteController {
	
	@Autowired
	private FavoriteBO favoriteBO;

	@GetMapping("/favorite_list")
	public String favoriteList(Model model) {
		// 데이터베이스 조회
		List<Favorite> favoriteList = favoriteBO.getFavoriteList();
		
		// 모델에 셋팅
		model.addAttribute("favoriteList", favoriteList);
		
		// jsp 경로 리턴
		return "lesson06/favoriteList";
	}
	
	@PostMapping("/add_favorite")
	@ResponseBody
	public Map<String, String> addFavorite(
			@RequestParam("name") String name,
			@RequestParam("url") String url) {
		
		int count = favoriteBO.addFavorite(name, url);
		
		// 성공시
		// {"result":"success"}
		
		// 실패시
		// {"result":"fail"}
		Map<String, String> resultMap = new HashMap<>();
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	@GetMapping("/favorite_input")
	public String favoriteInput() {
		return "lesson06/favoriteInput";
	}
	
	@PostMapping("/url_duplicate")
	@ResponseBody
	public Map<String, Boolean> urlDuplicate(@RequestParam("url") String url) {
		
		boolean isDuplicate = favoriteBO.urlDuplicate(url);
		
		// 중복시
		// {"is_duplicate":true}
		// 비 중복시 
		// {"is_duplicate":false}
		
		Map<String, Boolean> result = new HashMap<>();
//		if(isDuplicate) {
//			result.put("is_duplicate", true);
//		} else {
//			result.put("is_duplicate", false);
//		}
		
		result.put("is_duplicate", isDuplicate);
		
		return result;
		
	}
	
	
	@GetMapping("/delete_favorite")
	@ResponseBody
	public Map<String, String> deleteFavorite(@RequestParam("id") int id) {
		
		int count = favoriteBO.deleteFavorite(id);
		
		// {"result":"success"}
		// {"result":"fail"}
		
		Map<String, String> result = new HashMap<>();
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
		
	}
	
	
	
	
	
}
