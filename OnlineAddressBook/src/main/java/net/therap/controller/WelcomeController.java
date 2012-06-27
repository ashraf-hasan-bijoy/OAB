package net.therap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/26/12
 * Time: 10:37 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping({"/welcome.htm"})
public class WelcomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String welcomeAction() {
        return "welcome";
    }

}
