package com.example.booking.model;

public class AddShowDTO {
	private float unitPrice;
	private Integer availableSeats;
	private String showTime;
	private String showDate;

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
	public String getShowTime() {
        return showTime;
    }
    
	public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
	public String getShowDate() {
        return showDate;
    }
    
	public void setShowDate(String showDate) {
        this.showDate = showDate;
	}
}
