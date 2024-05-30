package kr.smhrd.controller;

import kr.smhrd.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BookRestController {
    // GET : http://localhost:8081/cart/api/cnt/1
    private final BookService bookService;
    @GetMapping("/cnt/{customerId}")
    public ResponseEntity<?> totalCount(@PathVariable Long customerId){
        int cnt=bookService.totalCount(customerId);
        return new ResponseEntity<>(cnt, HttpStatus.OK); // 1
    }
}
