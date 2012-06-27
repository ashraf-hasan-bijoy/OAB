package net.therap.domain;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/27/12
 * Time: 10:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class ImportedCard {
    private MultipartFile cardFile;

    public MultipartFile getCardFile() {
        return cardFile;
    }

    public void setCardFile(MultipartFile cardFile) {
        this.cardFile = cardFile;
    }
}
