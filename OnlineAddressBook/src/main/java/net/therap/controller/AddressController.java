package net.therap.controller;

import net.therap.domain.AddressCard;
import net.therap.domain.User;
import net.therap.exception.ApplicationException;
import net.therap.service.AddressCardService;
import net.therap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/26/12
 * Time: 1:27 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/address")
@SessionAttributes({"addresscard", "addresscardeditform"})
public class AddressController {

    @Autowired
    UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private AddressCardService addressCardService;

    public AddressCardService getAddressCardService() {
        return addressCardService;
    }

    public void setAddressCardService(AddressCardService addressCardService) {
        this.addressCardService = addressCardService;
    }


    @RequestMapping(value = "/delete.htm", method = RequestMethod.GET)
    public String deleteAddressCardAction(HttpServletRequest request, Map<String, Object> model) {

        if (request.getParameter("cardid") == null || !request.getParameter("cardid").matches("[0-9]+")) {
            throw new ApplicationException(" You are trying to access Illegal resource...");
        }

        Long id = Long.valueOf(request.getParameter("cardid"));
        boolean isDeleted = addressCardService.deleteAddressCardById(id, (User) request.getSession().getAttribute("user"));

        if (isDeleted == false) {
            throw new ApplicationException(" You are trying to access Illegal resource...");
        }

        model.put("title", "Address List");
        return "redirect:/app/address/cardlist.htm";
    }


    @RequestMapping(value = "/search.htm", method = RequestMethod.GET)
    public String searchAddressCardGetAction(Map<String, Object> model) {

        model.put("title", "Address Card Search");
        return "cardsearch";
    }

    @RequestMapping(value = "/search.htm", method = RequestMethod.POST)
    public String searchAddressCardPostAction(HttpServletRequest request, Map<String, Object> model) {

        if (request.getParameter("pattern") == null || request.getParameter("pattern").trim().length() == 0) {
            return "redirect:/app/address/search.htm?error=1";
        }

        User user = (User) request.getSession().getAttribute("user");
        List<AddressCard> addressCardList = addressCardService.getAddressCardsByPattern(request.getParameter("pattern"), user);
        model.put("addresscardlist", addressCardList);
        model.put("title", "Address Card Search");
        return "cardsearch";

    }


    @RequestMapping(value = "/view.htm", method = RequestMethod.GET)
    public String viewAddressCardAction(HttpServletRequest request, Map<String, Object> model) {

        if (request.getParameter("cardid") == null || !request.getParameter("cardid").matches("[0-9]+")) {
            throw new ApplicationException(" You are trying to access Illegal resource...");
        }

        AddressCard addressCard = addressCardService.getAddressCardById(Long.valueOf(request.getParameter("cardid")));
        model.put("addresscard", addressCard);
        model.put("title", "Address Card Details");
        return "viewaddresscard";

    }


    @RequestMapping(value = "/edit.htm", method = RequestMethod.GET)
    public String editAddressCardGetAction(HttpServletRequest request, Map<String, Object> model) {

        if (request.getParameter("cardid") == null || !request.getParameter("cardid").matches("[0-9]+")) {
            throw new ApplicationException(" You are trying to access Illegal resource...");
        }

        AddressCard addressCard = addressCardService.getAddressCardById(Long.valueOf(request.getParameter("cardid")));
        model.put("addresscardeditform", addressCard);
        return "editaddresscard";

    }

    @RequestMapping(value = "/edit.htm", method = RequestMethod.POST)
    public String editAddressCardPostAction(@ModelAttribute("addresscardeditform") @Valid AddressCard addressCard, BindingResult bindingResult, HttpServletRequest request, Map<String, Object> model) {

        if (bindingResult.hasErrors()) {
            return "editaddresscard";
        } else {
            User user = (User) request.getSession().getAttribute("user");
            addressCardService.updateAddressCard(user, addressCard);
            return "redirect:/app/address/view.htm?cardid=" + addressCard.getAddressCardId();
        }

    }


    @RequestMapping(value = "/cardlist.htm", method = RequestMethod.GET)
    public String cardListAction(HttpServletRequest request, Map<String, Object> model) {

        int currentPage;
        long pageCount;
        User user = (User) request.getSession().getAttribute("user");

        if (request.getParameter("curr") == null || !request.getParameter("curr").matches("[0-9]+")) {
            currentPage = 1;
        } else {
            currentPage = Integer.valueOf(request.getParameter("curr"));
        }

        pageCount = addressCardService.getPageCountByUser(user);
        List<AddressCard> addressCards = addressCardService.getAddressCardListByUser(user, currentPage);

        model.put("cardlist", addressCards);
        model.put("pagecount", pageCount);
        model.put("title", "Address List");
        return "cardlist";


        /*User modelUser = userService.getUserById(((User)request.getSession().getAttribute("user")).getUserID());
       model.put("modelUser",modelUser);
       model.put("title","Address List");
       return "cardlist";*/

    }

    @RequestMapping(value = "/create.htm", method = RequestMethod.GET)
    public String createAddressCardGetAction(Map<String, Object> model) {

        AddressCard addressCard = new AddressCard();
        model.put("addresscard", addressCard);
        model.put("title", "Add New Card");
        return "createaddresscard";

    }

    @RequestMapping(value = "/create.htm", method = RequestMethod.POST)
    public String createAddressCardPostAction(@ModelAttribute("addresscard") @Valid AddressCard addressCard, BindingResult bindingResult, HttpServletRequest request, Map<String, Object> model) {

        if (bindingResult.hasErrors()) {
            model.put("title", "Add New Card");
            return "createaddresscard";
        } else {
            User user = (User) request.getSession().getAttribute("user");
            addressCardService.saveAddressCard(user, addressCard);
            return "redirect:/app/address/cardlist.htm";
        }

    }
}
