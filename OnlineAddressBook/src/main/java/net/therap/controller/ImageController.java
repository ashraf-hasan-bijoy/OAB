package net.therap.controller;

import net.therap.exception.ApplicationException;
import net.therap.service.AddressCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/13/12
 * Time: 3:05 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/image")
public class ImageController {

    @Autowired
    private AddressCardService addressCardService;

    public AddressCardService getAddressCardService() {
        return addressCardService;
    }

    public void setAddressCardService(AddressCardService addressCardService) {
        this.addressCardService = addressCardService;
    }

    @RequestMapping(value = "/cardimage.htm", method = RequestMethod.GET)
    public void getFlatImageAction(HttpServletRequest request, HttpServletResponse response) {

        if (request.getParameter("cardid") == null || !request.getParameter("cardid").matches("[0-9]+")) {
            throw new ApplicationException(" You are trying to access Illegal resource...");
        }

        try {

            byte[] imageBytes = addressCardService.getImageData(Long.valueOf(request.getParameter("cardid")));
            response.setContentType("image/jpg");
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(imageBytes);
            outputStream.flush();
            outputStream.close();

        } catch (Exception e) {
            throw new ApplicationException(" You are trying to access Illegal resource...");
        }

    }
}
