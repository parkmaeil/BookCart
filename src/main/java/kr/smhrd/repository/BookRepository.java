package kr.smhrd.repository;

import kr.smhrd.entity.Book;
import kr.smhrd.entity.Cart;
import kr.smhrd.entity.CartCusBook;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//@Repository
//@Mapper
public interface BookRepository {

    //@Select("select * from book order by id desc")
    public List<Book> list(); // 책 전체 리스트 -> SQL(xml파일)
    public void cartAdd(@Param("book_id") Long bookId,
                        @Param("customer_id") Long customerId);

    public Cart checkAdd(@Param("book_id") Long bookId,
                         @Param("customer_id") Long customerId);

    public void cartQuantity(@Param("book_id") Long bookId,
                             @Param("customer_id") Long customerId);

    public List<CartCusBook> cartList(Long customerId);

    public void cartCancel(Long cartId);

    public void quantityUpdate(@Param("cartId") Long cartId,
                               @Param("quantity") int quantity);

    public Integer totalAmount(Long customerId);

    public int totalCount(Long customerId);
}
