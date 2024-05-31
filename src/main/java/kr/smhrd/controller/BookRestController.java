package kr.smhrd.controller;

import kr.smhrd.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriUtils;

import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

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
    // http://localhost:8081/cart/api/search/{bookname}
    @GetMapping("/search/{bookname}")
    public ResponseEntity<?> bookSearch(@PathVariable String bookname){
        System.out.println(bookname);
        String url="https://dapi.kakao.com/v3/search/book";
        HttpHeaders headers=new HttpHeaders();
        headers.set("Authorization" , "KakaoAK 9bc81f16e40c74c5c91a5f0d8f80670a");

            UriComponents builder = UriComponentsBuilder.fromHttpUrl(url)
                    .queryParam("target", "title")
                    .queryParam("query", bookname)
                    .encode().build();
            // 요청을 시도
            HttpEntity<?> entity = new HttpEntity<>(headers);
            // HttpURLConnection -> 연결 -> 스트림(IO) - JavaSE(Network)
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<?> response = restTemplate.exchange(
                    builder.toUri(), HttpMethod.GET, entity, String.class);

            return response;
    }
}
