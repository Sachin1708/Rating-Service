package com.java.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.tech.entity.Rating;
import com.java.tech.service.RatingService;


@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/createRating")
	public ResponseEntity<Rating> createUser(@RequestBody Rating rating) {		
		Rating ratingData=ratingService.createRating(rating);	
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingData);
	}
	
	@GetMapping("/{ratingId}")
	public ResponseEntity<Rating> findUserByUserId(@PathVariable String ratingId) {
		
		Rating ratingData= ratingService.findByRatingId(ratingId);
		return ResponseEntity.ok(ratingData);
	}
	
	@GetMapping("/findAllRating")
	public ResponseEntity<List<Rating>> findAllRating(){
		
		List<Rating> ratingDataList= ratingService.findAllRating();
		return ResponseEntity.ok(ratingDataList);
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId) {
		
		List<Rating> ratingData= ratingService.getRatingByUserId(userId);
		return ResponseEntity.ok(ratingData);
	}
	
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId) {
		
		List<Rating> ratingData= ratingService.getRatingByHotelId(hotelId);
		return ResponseEntity.ok(ratingData);
	}
}
