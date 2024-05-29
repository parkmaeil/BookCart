package kr.smhrd.repository;

import kr.smhrd.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
//@Mapper
public interface BookRepository {

    //@Select("select * from book order by id desc")
    public List<Book> list(); // 책 전체 리스트 -> SQL(xml파일)
    public void cartAdd(@Param("book_id") Long bookId,
                        @Param("customer_id") Long customerId);

}
