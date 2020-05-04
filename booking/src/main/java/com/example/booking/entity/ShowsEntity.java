package com.example.booking.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "show",schema="public")
public class ShowsEntity implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "showid")
	Integer showId;
	@Column(name="movieid", nullable = false)
	Integer movieId;
	@Column(name="theaterid", nullable = false)
	Integer theaterId;
	@Column(name="unitprice", nullable = false)
	float unitPrice;
	@Column(name="availableseats", nullable = false)
	Integer availableSeats;
	@Column(name="showtime", nullable = false)
	Time showTime;
	@Column(name="showdate", nullable = false)
	Date showDate;
	
	public ShowsEntity() {
		super();
	}
	
	public Integer getShowId() {
        return showId;
    }
    
	public void setShowId(Integer showId) {
        this.showId = showId;
    }

    public Integer getMovieId() {
        return movieId;
    }
    
    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }
    
    public Integer getTheaterId() {
        return theaterId;
    }
    
	public void setTheaterId(Integer theaterId) {
        this.theaterId = theaterId;
    }
 
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

}
