package kr.smhrd.service;

import kr.smhrd.entity.Book;
import kr.smhrd.entity.Cart;
import kr.smhrd.entity.CartCusBook;
import kr.smhrd.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> list(){
        return bookRepository.list();
    }
    @Transactional
    public void cartAdd(Long bookId, Long customerId){
        // 장바구니에 저장된 기존 데이터를 검색->있다면 -> 수량을 업데이트
        //                                         28      1
        Cart cart=bookRepository.checkAdd(bookId,customerId);
        if(cart!=null){
            bookRepository.cartQuantity(bookId, customerId);
        }else {
            bookRepository.cartAdd(bookId, customerId);
        }
    }

    public List<CartCusBook> cartList(Long customerId){
        return bookRepository.cartList(customerId);
    }

    public void cartCancel(Long cartId){
        bookRepository.cartCancel(cartId);
    }

}
