package kr.smhrd.controller;

import kr.smhrd.entity.Book;
import kr.smhrd.entity.CartCusBook;
import kr.smhrd.entity.Customer;
import kr.smhrd.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
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
       // 총액
       int totalAmount=0;  // Integer->int : Unboxing
       if(bookService.totalAmount(customerId)!=null) {
           totalAmount = bookService.totalAmount(customerId);
       }
       model.addAttribute("total", totalAmount);
       return "cartList"; // cartList.jsp <-- ${total}
   }

   @GetMapping("/cartCancel/{cartId}")
   public String cartCancel(@PathVariable Long cartId, HttpSession session){
       bookService.cartCancel(cartId); // 삭제성공?
       // 다시 장바구니 리스트보기 이동
       Customer cus = (Customer) session.getAttribute("cus");
       return "redirect:/cartList/"+cus.getId();
   }

   @GetMapping("/quantityUpdate/{cartId}/{quantity}")
   public String quantityUpdate(@PathVariable Long cartId,
                                 @PathVariable int quantity,
                                 HttpSession session){
       bookService.quantityUpdate(cartId, quantity); // 수량 수정후에
       Customer cus = (Customer) session.getAttribute("cus");


       return "redirect:/cartList/"+cus.getId();

   }
}
