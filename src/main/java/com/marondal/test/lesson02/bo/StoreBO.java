package com.marondal.test.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondal.test.lesson02.dao.StoreDAO;
import com.marondal.test.lesson02.model.Store;

@Service
public class StoreBO {
	
	@Autowired
	private StoreDAO storeDAO;
	
	public List<Store> getStoreList() {
		return storeDAO.selectStoreList();
	}

}
