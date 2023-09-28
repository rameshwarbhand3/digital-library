package com.ram.library.service;

import com.ram.library.dao.BookRepository;
import com.ram.library.dao.ReviewRepository;
import com.ram.library.entity.Review;
import com.ram.library.requestmodel.ReviewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    public void postReview(String userEmail, ReviewRequest reviewRequest) throws Exception {
        Review validReview = reviewRepository.findByUserEmailAndBookId(userEmail,reviewRequest.getBookId());
        if(validReview!=null){
                throw new Exception("Review already created");
        }
        Review review = new Review();
        review.setBookId(reviewRequest.getBookId());
        review.setRating(reviewRequest.getRating());
        review.setUserEmail(userEmail);
        if(reviewRequest.getReviewDescription().isPresent()){
            review.setReviewDescription(reviewRequest.getReviewDescription().map(Object::toString).orElse(null));
        }
        review.setDate(Date.valueOf(LocalDate.now()));
        reviewRepository.save(review);
    }

    //this service check user already leave a review or not
    public Boolean userReviewListed(String userEmail,Long bookId){
        Review validateReviews = reviewRepository.findByUserEmailAndBookId(userEmail,bookId);
        if(validateReviews!=null){
            return true;
        }
        return false;
    }
}
