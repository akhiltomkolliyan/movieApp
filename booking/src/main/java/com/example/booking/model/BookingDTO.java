package com.example.booking.model;

import com.example.booking.entity.BookingEntity;

public class BookingDTO {

	Integer seatsBooked;
	float totalCost;
	
    public Integer getSeatsBooked() {
        return seatsBooked;
    }
    
    public void setSeatsBooked(Integer seatsBooked ) {
        this.seatsBooked = seatsBooked;
    }
 
    public float getTotalCost(){
    	return totalCost;
        }
 
    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }
	public static BookingDTO valueOf(BookingEntity booking) {
		// TODO Auto-generated method stub
		BookingDTO bookingDTO = new BookingDTO();
		bookingDTO.setSeatsBooked(booking.getSeatsBooked());
		bookingDTO.setTotalCost(booking.getTotalCost());
		return bookingDTO;
	}
}
