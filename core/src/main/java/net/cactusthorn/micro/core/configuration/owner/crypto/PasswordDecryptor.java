package net.cactusthorn.micro.core.configuration.owner.crypto;

import org.aeonbits.owner.crypto.AbstractDecryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class PasswordDecryptor extends AbstractDecryptor {

    private static final long serialVersionUID = 0L;

    @Override
    public String decrypt(String value) {
        String pass = System.getProperty("pass");
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(pass);
        return encryptor.decrypt(value);
    }

}
