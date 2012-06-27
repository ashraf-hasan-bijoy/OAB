package net.therap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/26/12
 * Time: 3:22 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class LogoutController {

    @RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
    public String logoutAction(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/app/login.htm";
    }
}