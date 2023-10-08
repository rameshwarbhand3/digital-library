package com.ram.library.controller;

import com.ram.library.requestmodel.ReviewRequest;
import com.ram.library.service.ReviewService;
import com.ram.library.utils.ExtractJwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping("/secure")
    public void postReview(@RequestHeader(value = "Authorization")String token, @RequestBody ReviewRequest reviewRequest) throws Exception {

        String userEmail = ExtractJwt.payLoadJwtExtraction(token,"\"sub\"");
        if(userEmail == null){
            throw new Exception("User Email is missing.");
        }
        reviewService.postReview(userEmail,reviewRequest);
    }

    @GetMapping("/secure/user/book")
    public Boolean reviewBookByUser(@RequestHeader(value = "Authorization") String token,@RequestParam Long bookId) throws Exception {
        String userEmail = ExtractJwt.payLoadJwtExtraction(token,"\"sub\"");
        if(userEmail == null){
            throw new Exception("User Email is missing");
        }
        return  reviewService.userReviewListed(userEmail,bookId);
    }

}
