package kr.smhrd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private Long id;
    private String username;
    private String password;
    private int age;
    private String rating; // Gold, Silver, VIP
    private String job;
    private int reserves;

}
