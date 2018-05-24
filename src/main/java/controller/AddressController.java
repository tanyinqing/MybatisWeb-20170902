package controller;

import model.Address;
import model.Book;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import service.AddressService;
import service.BookService;
import service.UserService;

import java.util.Arrays;

/**
 * 控制器
 * 注解方式来写
 * 请求映射
 */
@Controller
@RequestMapping("address")
public class AddressController extends BaseController {

    @Autowired
    private AddressService addressService;
    @Autowired
    private UserService userService;

    @RequestMapping("create")
    private String create(Address address) {
        addressService.create(address);
        User user=userService.queryById(address.getUserId());
        user.setAddressId(address.getId());
        userService.update(user);
        // TODO: 2018-05-24 update user
        return "redirect:/createAddress.jsp";
    }

}
