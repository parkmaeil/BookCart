package kr.smhrd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart { // 장바구니
    private Long id; // 장바구니 아이디
    private Long book_id;  // ? 책id
    private Long customer_id; // 고객id
    // 수량, 일자
    private int quantity; // quantity
    private Date cart_date;
}
