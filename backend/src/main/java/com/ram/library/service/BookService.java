package com.ram.library.service;

import com.ram.library.dao.BookRepository;
import com.ram.library.dao.CheckoutRepository;
import com.ram.library.entity.Book;
import com.ram.library.entity.Checkout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
@Transactional
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CheckoutRepository checkoutRepository;


    public Book checkoutBook(String userEmail, Long bookId) throws Exception {
        Optional<Book> book = bookRepository.findById(bookId);
        Checkout validCheckout = checkoutRepository.findByUserEmailAndBookId(userEmail, bookId);
        if (!book.isPresent() || validCheckout != null || book.get().getCopiesAvailable() <= 0) {
            throw new Exception("Book doesn't exist or already checkout by user");
        }
        book.get().setCopiesAvailable(book.get().getCopiesAvailable() - 1);
        bookRepository.save(book.get());

        Checkout checkout = new Checkout(userEmail, LocalDate.now().toString(), LocalDate.now().plusDays(7).toString(), book.get().getId());
        checkoutRepository.save(checkout);
        return book.get();
    }

    public Boolean checkoutBookByUser(String userEmail, Long bookId) {
        Checkout validCheckout = checkoutRepository.findByUserEmailAndBookId(userEmail, bookId);
        if (validCheckout != null) {
            return true;
        }
        return false;
    }

    public int currentLoanCount(String userEmail) {
        return checkoutRepository.findBookByUserEmail(userEmail).size();
    }
}
