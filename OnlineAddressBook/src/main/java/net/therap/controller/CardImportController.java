package net.therap.controller;

import net.therap.domain.ImportedCard;
import net.therap.domain.User;
import net.therap.service.AddressCardService;
import net.therap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/27/12
 * Time: 9:42 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/address")
public class CardImportController {
    @Autowired
    AddressCardService addressCardService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired

    UserService userService;

    public AddressCardService getAddressCardService() {
        return addressCardService;
    }

    public void setAddressCardService(AddressCardService addressCardService) {
        this.addressCardService = addressCardService;
    }

    @RequestMapping(value = "/importcard.htm", method = RequestMethod.GET)
    public String cardExportGetAction(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model) {

        model.put("title", "Import Card");
        model.put("importcard", new ImportedCard());
        return "importcard";

    }

    @RequestMapping(value = "/importcard.htm", method = RequestMethod.POST)
    public String cardExportPostAction(@ModelAttribute("importcard") ImportedCard importedCard, HttpServletRequest request, HttpServletResponse response) {
        User user = userService.getUserById(((User)request.getSession().getAttribute("user")).getUserID());
        addressCardService.saveAddressCardByImportedFile(user, importedCard.getCardFile());
        return "redirect:/app/address/cardlist.htm";

    }
}
