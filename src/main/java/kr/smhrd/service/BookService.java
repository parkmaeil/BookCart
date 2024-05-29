package kr.smhrd.service;

import kr.smhrd.entity.Book;
import kr.smhrd.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> list(){
        return bookRepository.list();
    }

    public void cartAdd(Long bookId, Long customerId){
        bookRepository.cartAdd(bookId, customerId);
    }
}
