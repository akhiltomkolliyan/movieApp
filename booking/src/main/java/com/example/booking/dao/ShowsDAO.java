package com.example.booking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.booking.entity.ShowsEntity;

@Repository
@Transactional
public interface ShowsDAO extends JpaRepository<ShowsEntity, Integer> {

	ShowsEntity findByMovieIdAndTheaterId(Integer movieId, Integer theaterId);
	ShowsEntity findByShowId(Integer showId);
	
}

