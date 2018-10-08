package pers.robin.awm.util;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.robin.awm.model.Customer;
import pers.robin.awm.model.User;
import pers.robin.awm.service.CustomerService;
import pers.robin.awm.service.UserService;
import pers.robin.awm.service.impl.CustomerServiceImpl;
import pers.robin.awm.service.impl.UserServiceImpl;

import java.util.Locale;

@Component
public class FakeUtil {

    private Locale locale = new Locale("zh", "CN");
    private Faker faker = new Faker(locale);

    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserService userService;

    private short randshort(int length) {
        return (short) (Integer.parseInt(faker.number().digit()) % length);
    }

    private void fakeUser(short role) {
        User user = new User();
        user.setTel(faker.phoneNumber().cellPhone());
        user.setPassword(faker.code().asin());
        user.setRole(role);
    }

    private Customer fakeCustomer() {
        Customer customer = new Customer();
        customer.setName(faker.name().name());
        customer.setGender(randshort(2));
        customer.setSid(faker.code().ean8());
        customer.setRole((short) 0);
        customer.setTel(faker.phoneNumber().cellPhone());
        customer.setPassword(faker.code().asin());
        return customer;
    }

    public void createCustomers(int num) {
        for (int i = 0; i < num; ++i) {
//            System.out.println(fakeCustomer());
            customerService.register(fakeCustomer());
        }
    }

    public static void main(String[] args) {
    }
}
