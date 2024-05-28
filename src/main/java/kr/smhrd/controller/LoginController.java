package kr.smhrd.controller;

import kr.smhrd.entity.Customer;
import kr.smhrd.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login") // {"username":"11111","password":"2222"}
    public String login(String username, String password, HttpSession session){
           Customer cus=loginService.login(username,password);
           if(cus!=null){ // 인증성공
              session.setAttribute("cus", cus);
           }
           // 다시 첫페이지로 이동(/list)
           return "redirect:/list";
    }
}
