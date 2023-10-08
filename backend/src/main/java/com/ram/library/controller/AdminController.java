package com.ram.library.controller;

import com.ram.library.requestmodel.AddBookRequest;
import com.ram.library.service.AdminService;
import com.ram.library.utils.ExtractJwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;


    @PutMapping("/secure/increase/book/quantity")
    public void increaseBookQuantity(@RequestHeader(value = "Authorization") String token,@RequestParam Long bookId) throws Exception{
        String admin = ExtractJwt.payLoadJwtExtraction(token,"\"userType\"");
        if(admin == null || !admin.equals("admin")){
            throw new Exception("Admin Page only");
        }
        adminService.increaseBookQuantity(bookId);
    }

    @PutMapping("/secure/decrease/book/quantity")
    public void decreaseBookQuantity(@RequestHeader(value = "Authorization") String token,@RequestParam Long bookId) throws Exception{
        String admin = ExtractJwt.payLoadJwtExtraction(token,"\"userType\"");
        if(admin == null || !admin.equals("admin")){
            throw new Exception("Admin Page Only");
        }
        adminService.decreaseBookQuantity(bookId);
    }

    @PostMapping("/secure/add/book")
    public void addBook(@RequestHeader(value = "Authorization") String token, @RequestBody AddBookRequest addBookRequest) throws Exception {
        String admin = ExtractJwt.payLoadJwtExtraction(token, "\"userType\"");
        if (admin == null || !admin.equals("admin")) {
            throw new Exception("Admin Page only");
        }
        adminService.postBook(addBookRequest);
    }

    @DeleteMapping("/secure/delete/book")
    public void deleteBook(@RequestHeader(value = "Authorization") String token,@RequestParam Long bookId) throws Exception{
        String admin = ExtractJwt.payLoadJwtExtraction(token,"\"userType\"");
        if(admin == null || !admin.equals("admin")){
            throw  new Exception("Admin Page only");
        }
        adminService.deleteBook(bookId);
    }
}
