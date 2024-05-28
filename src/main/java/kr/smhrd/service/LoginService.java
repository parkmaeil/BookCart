package kr.smhrd.service;

import kr.smhrd.entity.Customer;
import kr.smhrd.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final LoginRepository loginRepository;
    //                          Customer customer
    public Customer login(String username, String password){
        return loginRepository.login(username,password);
    }

}
