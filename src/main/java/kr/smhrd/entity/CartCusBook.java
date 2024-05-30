package kr.smhrd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartCusBook { // JOIN의 결과 테이블 정보

    private Long id;
    private Long book_id;
    private Long customer_id;
    private int quantity;
    private Date cart_date;

    private String title;
    private int price;
    private String author;
    private int page;

    private int amount;
}
