package com.marondal.test.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondal.test.lesson06.dao.BookingDAO;
import com.marondal.test.lesson06.model.Booking;

@Service	
public class BookingBO {
	
	@Autowired
	private BookingDAO bookingDAO;

	public List<Booking> getBookingList() {
		return bookingDAO.selectBookingList();
	}
	
	public int addBooking(
			String name,
			String date,
			int day,
			int headcount,
			String phoneNumber) {
		
		return bookingDAO.insertBooking(name, date, day, headcount, phoneNumber, "대기중");
	}
			
	
	public Booking getBooking(String name, String phoneNumber) {
		return bookingDAO.selectBooking(name, phoneNumber);
	}
	
	public int changeState(int id) {
		return bookingDAO.updateState(id);
	}
			
}
