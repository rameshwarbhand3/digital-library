package com.ram.library.dao;

import com.ram.library.entity.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message,Long> {
    Page<Message>findByUserEmail(@RequestParam("user_email")String userEmail, Pageable pageable);

    Page<Message>findByClosed(@RequestParam("closed") Boolean closed,Pageable pageable);

}
