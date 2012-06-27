package net.therap.controller;

import net.therap.exception.ApplicationException;
import net.therap.service.AddressCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/27/12
 * Time: 9:09 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/address")
public class CardExportController {

    @Autowired
    AddressCardService addressCardService;

    public AddressCardService getAddressCardService() {
        return addressCardService;
    }

    public void setAddressCardService(AddressCardService addressCardService) {
        this.addressCardService = addressCardService;
    }

    @RequestMapping("/exportcard.htm")
    public void cardExportAction(HttpServletRequest request,HttpServletResponse response) {
       if (request.getParameter("cardid") == null || !request.getParameter("cardid").matches("[0-9]+")) {
            throw new ApplicationException(" You are trying to access Illegal resource...");
       }
       String cardData = addressCardService.getCardExportData(Long.valueOf(request.getParameter("cardid")));
       response.setContentType("text/plain; charset=utf-8");
       response.setHeader("Content-Disposition", "attachment; filename=vCard.vcf");
       try{
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(cardData.getBytes());
        outputStream.close();
        outputStream.flush();
       }
       catch (Exception exception){
           throw new ApplicationException("You are trying to access Illegal resource...");
       }
    }
}
