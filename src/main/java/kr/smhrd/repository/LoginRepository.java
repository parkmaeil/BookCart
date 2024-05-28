package kr.smhrd.repository;

import kr.smhrd.entity.Customer;
import org.apache.ibatis.annotations.Param;

public interface LoginRepository {
    public Customer login(@Param("username")String username,
                          @Param("password") String password);
}
