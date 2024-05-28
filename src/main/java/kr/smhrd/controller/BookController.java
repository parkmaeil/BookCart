package kr.smhrd.controller;

import kr.smhrd.entity.Book;
import kr.smhrd.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
