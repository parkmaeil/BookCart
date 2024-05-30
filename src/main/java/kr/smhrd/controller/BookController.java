package kr.smhrd.controller;

import kr.smhrd.entity.Book;
import kr.smhrd.entity.CartCusBook;
import kr.smhrd.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {

   private final BookService bookService;

   @GetMapping("/list")
   public String list(Model model){
       List<Book> list=bookService.list();
       model.addAttribute("list", list);
       return "list"; // list.jsp
   }

   @PostMapping("/cartAdd")
   public String cartAdd(Long bookId, Long customerId){
      bookService.cartAdd(bookId,customerId);
      // 장바구니 보기페이지로.....cartList.jsp
      return "redirect:/cartList/"+customerId;
   }

   @GetMapping("/cartList/{customerId}")
   public String cartList(@PathVariable Long customerId, Model model){
     List<CartCusBook> cartList=bookService.cartList(customerId);
       model.addAttribute("cartList", cartList);
     return "cartList"; // cartList.jsp
   }

}
