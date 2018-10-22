package pers.robin.awm.util;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pers.robin.awm.model.*;
import pers.robin.awm.service.*;

import java.util.*;

@Component
public class FakeUtil {

    private Locale locale = new Locale("zh", "CN");
    private Faker faker = new Faker(locale);
    private List<User> users;
    private List<Customer> customers;
    private List<Address> addresses;
    private List<Shop> shops;
    private List<Cate> cates;
    private List<Dishes> dishes;
    private List<Order> orders;
    private List<OrderDetail> orderDetails;
    private List<Comment> comments;
    private List<ShopMarked> shopMarkeds;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserService userService;

    @Autowired
    private ShopService shopService;

    @Autowired
    private CateService cateService;

    @Autowired
    private DishesService dishesService;



    private class ShopMsg {
        String name;
        String address;
        Map<String, List<Dishes>> cate2dishes;

        public ShopMsg(String name, String address) {
            this.name = name;
            this.address = address;
            cate2dishes = new HashMap<>();
        }

        public void addCateAndDishes(String cate, List<Dishes> dishes) {
            cate2dishes.put(cate, dishes);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

    }

    List<ShopMsg> createShopMsgs() {
        List<ShopMsg> shopMsgs = new ArrayList<>();
        ShopMsg s1 = new ShopMsg("麦当劳", "星达城233号");
        List<Dishes> list = new ArrayList<Dishes>();
        list.add(new Dishes("经典麦辣鸡腿汉堡", "经典，面包，肌肉，生菜，沙拉", 2000));
        list.add(new Dishes("巨无霸", "面包，牛肉，生菜，很大", 2000));
        s1.addCateAndDishes("主食", list);
        List<Dishes> list1 = new ArrayList<Dishes>();
        list1.add(new Dishes("麦趣鸡盒", "那么大鸡排，鸡腿", 9200));
        list1.add(new Dishes("那么大鸡排", "鸡肉，油", 1300));
        s1.addCateAndDishes("小食", list1);
        List<Dishes> list2 = new ArrayList<Dishes>();
        list2.add(new Dishes("香芒芒", "芒果饮料", 1800));
        list2.add(new Dishes("那么大珍珠奶茶", "1杯那么大奶茶", 1800));
        s1.addCateAndDishes("饮品", list2);
        shopMsgs.add(s1);

        ShopMsg s2 = new ShopMsg("张亮麻辣烫", "九龙路788号");
        List<Dishes> list3 = new ArrayList<Dishes>();
        list3.add(new Dishes("宽类", "宽的粉", 200));
        list3.add(new Dishes("红薯粉", "红薯做的粉", 200));
        s2.addCateAndDishes("粉类", list3);
        List<Dishes> list4 = new ArrayList<Dishes>();
        list4.add(new Dishes("金针菇", "", 140));
        list4.add(new Dishes("香菜", "", 150));
        s2.addCateAndDishes("素菜", list4);
        List<Dishes> list5 = new ArrayList<Dishes>();
        list5.add(new Dishes("牛肉丸", "", 168));
        list5.add(new Dishes("热狗", "", 180));
        s2.addCateAndDishes("荤菜", list5);
        shopMsgs.add(s2);

        ShopMsg s3 = new ShopMsg("黄焖鸡米饭", "九龙路411楼");
        List<Dishes> list6 = new ArrayList<Dishes>();
        list6.add(new Dishes("黄焖鸡小份", "", 1200));
        list6.add(new Dishes("黄焖鸡小份+百事可乐", "", 1400));
        s3.addCateAndDishes("小份黄焖鸡", list6);
        List<Dishes> list7 = new ArrayList<Dishes>();
        list7.add(new Dishes("黄焖鸡中份", "", 1400));
        list7.add(new Dishes("黄焖鸡中份+百事可乐", "", 1600));
        s3.addCateAndDishes("黄焖鸡中份", list7);
        List<Dishes> list8 = new ArrayList<Dishes>();
        list8.add(new Dishes("黄焖鸡大份", "", 1600));
        list8.add(new Dishes("黄焖鸡大份+百事可乐", "", 1800));
        s3.addCateAndDishes("黄焖鸡大份", list8);
        shopMsgs.add(s3);

        return shopMsgs;
    }

    private short randshort(int length) {
        return (short) (Integer.parseInt(faker.number().digit()) % length);
    }

    private User fakeUser(short role) {
        User user = new User();
        user.setTel(faker.phoneNumber().cellPhone());
        user.setPassword(faker.code().asin());
        user.setRole(role);
        return user;
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

    @Transactional
    public void createCustomers(int num) {
        customers = new ArrayList<>();
        for (int i = 0; i < num; ++i) {
            Customer customer = fakeCustomer();
            customers.add(customer);
            customerService.register(customer);
        }
    }

    private void fakeShop(ShopMsg shopMsg) {
        User user = fakeUser((short) 1);
        userService.create(user);
        Shop shop = new Shop();
        shop.setUserId(user.getId());
        shop.setName(shopMsg.getName());
        shop.setAddress(shopMsg.getAddress());
        shopService.register(shop);
        System.out.println("shop id is " + shop.getId());

        shopMsg.cate2dishes.forEach((k, v) -> {
            Cate cate = new Cate();
            cate.setShopId(shop.getId());
            cate.setName(k);
            cateService.create(cate);
            v.forEach(o -> {
                o.setProvider(shop.getId());
                o.setCateId(cate.getId());
                o.setStatus((short) 1);
                dishesService.create(o);
            });
        });

    }

    @Transactional
    public void createShop() {
        createShopMsgs().forEach(o -> fakeShop(o));
    }

    public static void main(String[] args) {
    }
}
