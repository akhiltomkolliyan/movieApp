package com.example.booking.model;
import java.sql.Date;
import java.sql.Time;

import com.example.booking.entity.ShowsEntity;

public class ShowsDTO {

	private float unitPrice;
	private Integer availableSeats;
	private Time showTime;
	private Date showDate;

    public float getUnitPrice(){
    	return unitPrice;
        }
 
    public void setUnitPrice(float unitPrice) {
        this.unitPrice= unitPrice;
    }
    public Integer getAvailableSeats() {
        return availableSeats;
    }
    
	public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }
	public Time getShowTime() {
        return showTime;
    }
    
	public void setShowTime(Time showTime) {
        this.showTime = showTime;
    }
	public Date getShowDate() {
        return showDate;
    }
    
	public void setShowDate(Date showDate) {
        this.showDate = showDate;
    }
	public static ShowsDTO valueOf(ShowsEntity shows) {
		// TODO Auto-generated method stub
		ShowsDTO showsDTO = new ShowsDTO();
		showsDTO.setUnitPrice(shows.getUnitPrice());
		showsDTO.setAvailableSeats(shows.getAvailableSeats());
		showsDTO.setShowTime(shows.getShowTime());
		return showsDTO;
	}
}


