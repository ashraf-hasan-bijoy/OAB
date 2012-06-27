package net.therap.controller;

import net.therap.domain.AddressCard;
import net.therap.domain.ImportedCard;
import net.therap.domain.User;
import net.therap.exception.ApplicationException;
import net.therap.service.AddressCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
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

    public AddressCardService getAddressCardService() {
        return addressCardService;
    }

    public void setAddressCardService(AddressCardService addressCardService) {
        this.addressCardService = addressCardService;
    }

    @RequestMapping(value = "/importcard.htm",method = RequestMethod.GET)
    public String cardExportGetAction(HttpServletRequest request,HttpServletResponse response,Map<String, Object> model) {

        model.put("title","Import Card");
        model.put("importcard",new ImportedCard());
        return "importcard";

    }

    @RequestMapping( value = "/importcard.htm",method = RequestMethod.POST)
    public String cardExportPostAction(@ModelAttribute("importcard") ImportedCard importedCard, HttpServletRequest request,HttpServletResponse response) {

        addressCardService.saveAddressCardByImportedFile((User) request.getSession().getAttribute("user"), importedCard.getCardFile());
        return "redirect:/app/address/cardlist.htm";

    }
}
