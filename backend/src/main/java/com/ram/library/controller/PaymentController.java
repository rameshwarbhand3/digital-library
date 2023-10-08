package com.ram.library.controller;

import com.ram.library.requestmodel.PaymentInfoRequest;
import com.ram.library.service.PaymentService;
import com.ram.library.utils.ExtractJwt;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments/secure")
@CrossOrigin("http://localhost:3000")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment-intent")
    public ResponseEntity<String> createPaymentIntent(@RequestBody PaymentInfoRequest paymentInfoRequest) throws StripeException{
        PaymentIntent paymentIntent = paymentService.createPaymentIntent(paymentInfoRequest);
        String paymentStr = paymentIntent.toJson();
        return new ResponseEntity<>(paymentStr, HttpStatus.OK);
    }

    @PutMapping("/payment-complete")
    public ResponseEntity<String> stripePaymentComplete (@RequestHeader (value = "Authorization") String token) throws Exception {
        String userEmail = ExtractJwt.payLoadJwtExtraction(token,"\"sub\"");
        if(userEmail ==  null){
            throw new Exception("user Email is missing");
        }
        return paymentService.stripePayment(userEmail);
    }


}
