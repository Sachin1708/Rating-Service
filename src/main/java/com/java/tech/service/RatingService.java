package com.java.tech.service;

import java.util.List;

import com.java.tech.entity.Rating;

public interface RatingService {

	Rating createRating(Rating rating);
	 
	Rating findByRatingId(String ratingId);
	
	List<Rating> findAllRating();
	
	List<Rating> getRatingByHotelId(String hotelId);
	
	List<Rating> getRatingByUserId(String userId);
}
