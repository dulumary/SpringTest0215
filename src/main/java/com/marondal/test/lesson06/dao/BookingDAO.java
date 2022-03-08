package com.marondal.test.lesson06.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.marondal.test.lesson06.model.Booking;

@Repository
public interface BookingDAO {
	
	public List<Booking> selectBookingList();
}
