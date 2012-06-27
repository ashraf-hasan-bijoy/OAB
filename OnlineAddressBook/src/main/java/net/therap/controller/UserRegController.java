package net.therap.controller;

import net.therap.domain.User;
import net.therap.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 5/31/12
 * Time: 4:11 PM
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("/userreg.htm")
@SessionAttributes({"userForm"})
public class UserRegController {



    private static final Logger log = LoggerFactory.getLogger(UserRegController.class);


    @Autowired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String customerRegAction(Map<String, Object> model) {
        model.put("userForm", new User());
        model.put("title", "User Registration Form");
        return "userreg";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveFlatOwnerAction(@ModelAttribute("userForm") @Valid User user, BindingResult bindingResult) {

        if (userService.isEmailExists(user.getEmail()) == true) {
            bindingResult.rejectValue("email", "email.exists");
        }

        if (!user.getPassword().equals(user.getConfirmPassword())) {
            bindingResult.rejectValue("confirmPassword", "password.mismatch");
        }

        if (bindingResult.hasErrors()) {
            return "userreg";
        } else {
            userService.saveUser(user);
            return "redirect:/app/login.htm";
        }

    }

}
