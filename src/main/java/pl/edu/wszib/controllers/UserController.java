package pl.edu.wszib.controllers;

import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.model.ServiceResponse;
import pl.edu.wszib.model.User;
import pl.edu.wszib.model.UserRole;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ServiceResponse getAllUsers() {
        User user1 = new User();
        user1.setId(1);
        user1.setLogin("Mateusz");
        user1.setPass("tajne");
        List<UserRole> userRoleList = new ArrayList<>();
        userRoleList.add(UserRole.ADMIN);
        userRoleList.add(UserRole.CASHIER);
        user1.setRoles(userRoleList);

        User user2 = new User();
        user2.setId(2);
        user2.setLogin("Janusz");
        user2.setPass("tajne098");
        List<UserRole> userRoleList2 = new ArrayList<>();
        userRoleList2.add(UserRole.ADMIN);
        userRoleList2.add(UserRole.CASHIER);
        userRoleList2.add(UserRole.REPORTER);
        user2.setRoles(userRoleList2);

        List<User> result = new ArrayList<>();
        result.add(user1);
        result.add(user2);

        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setUserList(result);

        return serviceResponse;
    }

    @RequestMapping(value = "/user/{userRole}", method = RequestMethod.GET)
    public List<User> getUsersByRoleWithFilter(@PathVariable String userRole,
                                               @RequestParam("a") String loginFilter) {
        System.out.println(userRole);
        System.out.println(loginFilter);

        User user = new User();
        user.setId(1);
        user.setLogin("Mateusz");
        user.setPass("tajne");
        List<UserRole> userRoleList = new ArrayList<>();
        userRoleList.add(UserRole.ADMIN);
        userRoleList.add(UserRole.CASHIER);
        user.setRoles(userRoleList);

        List<User> result = new ArrayList<>();
        result.add(user);
        return result;
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public User putUser(@RequestBody User user) {
        System.out.println(user.getLogin());
        return user;
    }

    @RequestMapping(value = "/user/header", method = RequestMethod.GET)
    public String getCos(@RequestHeader("header1") String headerParameter) {
        System.out.println(headerParameter);
        return "Poszło !!";
    }
}
