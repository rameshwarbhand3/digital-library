package com.ram.library.service;
import com.ram.library.dao.BookRepository;
import com.ram.library.dao.CheckoutRepository;
import com.ram.library.dao.ReviewRepository;
import com.ram.library.entity.Book;
import com.ram.library.requestmodel.AddBookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AdminService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CheckoutRepository checkoutRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    public void increaseBookQuantity(Long bookId) throws  Exception{
        Optional<Book> book = bookRepository.findById(bookId);

        if(!book.isPresent()){
            throw new Exception("Book not found");
        }
        book.get().setCopiesAvailable(book.get().getCopiesAvailable()+1);
        book.get().setCopies(book.get().getCopies()+1);
        bookRepository.save(book.get());
    }

    public void decreaseBookQuantity(Long bookId) throws Exception{
        Optional<Book> book = bookRepository.findById(bookId);
        if(!book.isPresent() || book.get().getCopiesAvailable() <= 0 || book.get().getCopies() <= 0){
            throw new Exception("Book not found");
        }
        book.get().setCopiesAvailable((book.get().getCopiesAvailable()-1));
        book.get().setCopies(book.get().getCopies()-1);
        bookRepository.save(book.get());
    }

    public void postBook(AddBookRequest addBookRequest){
        Book book = new Book();
        book.setTitle(addBookRequest.getTitle());
        book.setAuthor(addBookRequest.getAuthor());
        book.setDescription(addBookRequest.getDescription());
        book.setCopies(addBookRequest.getCopies());
        book.setCopiesAvailable(addBookRequest.getCopies());
        book.setCategory(addBookRequest.getCategory());
        book.setImg(addBookRequest.getImg());
        bookRepository.save(book);
    }

    public void deleteBook(Long bookId) throws Exception {

        Optional<Book> book = bookRepository.findById(bookId);

        if (!book.isPresent()) {
            throw new Exception("Book not found");
        }

        bookRepository.delete(book.get());
        checkoutRepository.deleteAllByBookId(bookId);
        reviewRepository.deleteAllByBookId(bookId);
    }
}
