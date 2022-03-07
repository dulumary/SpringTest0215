package com.marondal.test.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondal.test.lesson06.dao.FavoriteDAO;
import com.marondal.test.lesson06.model.Favorite;

@Service
public class FavoriteBO {
	
	@Autowired
	private FavoriteDAO favoriteDAO;
	
	public List<Favorite> getFavoriteList() {
		return favoriteDAO.selectFavoriteList();
	}
	
	public int addFavorite(String name, String url) {
		return favoriteDAO.insertFavorite(name, url);
	}
	
	public boolean urlDuplicate(String url) {
		int count = favoriteDAO.selectUrlCount(url);
		
//		if(count == 0) {
//			return false;
//		} else {
//			return true;
//		}
		
		return count != 0;
		
	}
	
	public int deleteFavorite(int id) {
		return favoriteDAO.deleteFavorite(id);
	}

}
