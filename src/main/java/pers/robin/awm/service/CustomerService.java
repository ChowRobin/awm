package pers.robin.awm.service;

import org.springframework.web.multipart.MultipartFile;
import pers.robin.awm.model.Customer;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface CustomerService {

    List<Customer> findByCondition(Map<String, Object> map, int pageId);

    Customer findById(Integer id);

    int create(Customer customer);

    int updateById(Customer customer);

    int deleteById(Integer id);

    int register(Customer customer);

    String login(String tel, String password);

    String updateAvatar(Customer customer, MultipartFile img, String basePath);
}
