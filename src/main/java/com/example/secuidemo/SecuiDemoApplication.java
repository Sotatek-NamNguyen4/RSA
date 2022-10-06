package com.example.secuidemo;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

@SpringBootApplication
public class SecuiDemoApplication {

    public static void main(String[] args)  throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException, InvalidAlgorithmParameterException {
        SpringApplication.run(SecuiDemoApplication.class, args);
        String encodeUserInfo = "a4956GlzN/ATFrQofQNhlcuDqUUOfTIyhTys9HL6h1IuHf4wDv8T+ouSQCI7vYi8p56xSA8cc8BXl7tAE9JmLecpU5R8EtW1vf672vjKIhscbKXAn/hXeZokDLeZv5LIlQR3iE7FMq5m3RJUltyx4Q1nO8Nxm3lVV1iE/wHEvtO+paE5PR7bpenQRrfTZtTnMqJug51T3TVka6tqc7CCPuB1rOVif7CwskdRLUDpdEAHKq9+8ZWT2MUEM3sJynlPlNkbl5WS9Kx3LzKZOjnm1uQ+3ArCT1n7TNohZedXGz2w1U53HkjJTOVEUOqyAzCBq8kTKIIwY6pT7GXgNrqTmg==";
        String encodeAesKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzIoVVK1bCJ7kKN2pm4SiA32ha1Hi+T68khy3Tn1juNVkjQ1X2GvW7c56FEaQMc5mOyBuGZO8gt27qXg3p1+i+N43/NGIBqIUlhs0zxbsCv8js4btFj17Raa66izHXwKcNyOSjRCfQslfqSBZy2HM/bFONQmzNxLTDcJfRcHoIyNB7yEFp8htmBZjnvErJOxGiiGRU33gExfy7G6j5KcfJOEJhMm7FLxMhnEQkRKBUlqUdWVWDdbReXH43HuZpvdZhKPTUiAxfKruB70j8aG+AhgX2VanFdtggoczMzHvAyBdyCmN1VaNZ566HtFwmJVPSUOarSHQw1pD0a/VyuO2JQIDAQAB";
        String privateKey = "MIIEogIBAAKCAQEAzIoVVK1bCJ7kKN2pm4SiA32ha1Hi+T68khy3Tn1juNVkjQ1X2GvW7c56FEaQMc5mOyBuGZO8gt27qXg3p1+i+N43/NGIBqIUlhs0zxbsCv8js4btFj17Raa66izHXwKcNyOSjRCfQslfqSBZy2HM/bFONQmzNxLTDcJfRcHoIyNB7yEFp8htmBZjnvErJOxGiiGRU33gExfy7G6j5KcfJOEJhMm7FLxMhnEQkRKBUlqUdWVWDdbReXH43HuZpvdZhKPTUiAxfKruB70j8aG+AhgX2VanFdtggoczMzHvAyBdyCmN1VaNZ566HtFwmJVPSUOarSHQw1pD0a/VyuO2JQIDAQABAoIBAFZLg8hgA2JVtylOq/pDMR+L54ih2cMSpvh2SRhCaspWrb+c+40BooJedL8NLlT1IcicXBdKb2Q/LKfJYqGpBdc92h0+QceapljWTad5okjZcDSUHn8dnV67g2y9S7hYH5Rb277MXoUM9OEkFv5p2tTF85sI5qW7uXO6p/uEXe5EdrvXOXjUasjrbymQ5/z7vRmAXdJxJbRyQleZ5vqhPtF+nw2cJplQjUlI8ceHXF2dRKKpg0gt6mkXQ/jdYuNzHuU1brLL8ITTvE3BIpTwcpfiGByaNV4fgOSqi7zDHal3asajtf+DJATXsM/DOASUW6ZyH6XgiwmbSe7nr5iYvhkCgYEA5hd5PZ/0dYbMxZGHtgfN2F1xrwxEClDBoySLchNedeelS0XGTow7nppnivNottl3UQ30SVgUGApzULHhaZSAhLUmxxoNX3W7IPRtnzY7BOx3XxwCJekno8GznRAWyVxbB6auhL5OBuipAS51r8YqRO5M+ZyXAJtXcuhF3FrpHe8CgYEA45IMuZFy3lW03j4AGU58+nMAcJy/b2GkChoZ+0eNDNYUUKQM69y+ww03xJtgBPo7z2UDtMsU0vWeHfP2y2LwlBvB+DMpGlkdFWiDa0UtlVMisZqgPXkFl6SqxVgFLojIEyKWTi9MfN3+IeY6rv3kmoXLtJmpAZPHKHDQqn7+QSsCgYByAiWP9GbzqQRjzLVa68kCMWL4InLATb10sdHqh1BhyZLsljkpiHCuKMGvZuZ225A0eF6XzO2/78WtsUYIw41etEfvlagUqcg8DwEWR4+849JOLRmfYUTD7mGqLGOuCHYOd3e3zHfrEnNTY4rqup0NJKq9b+qeYVpWVGLxSZaCvwKBgHexi6vWypoSbi0uYxLsa2O3NRYF+9JzgrolfGDkA1YrC0hW4Mz1sAgbXae1KU2059xvfwGKhwtmUKHkfXwAMBVWfDE1h3rqQBfQfr7fBdiyf172uy1aCAz4eTGO2Drfiow19uRskEhk4pOl6lu8Ao8brEbzQycnOOsWW0oxvT09AoGAX5+0TNPAhlrESqVXk2vBfc6V43UKJoSwtzs7yYaEcd206Amw5FTYA01mWRqLL5XDsWB8zl+VcsDAhtXMOOvpxuBPmLpYtUFI5wXE3vANnkmBX+F5xCaCYONTewxi1F4wIWg6idyyxrBX6WTX/Bn217l7X3jEdu59puZUfgnL8P8=";

        byte[] bytePrivateKey = Base64.decodeBase64(privateKey);
        PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(bytePrivateKey);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyFactory.generatePrivate(privateKeySpec);
        System.out.println("privatekey rsa: " + rsaPrivateKey.toString());
        Cipher cipher = Cipher.getInstance("RSA");
        System.out.println("cipher b4 init: " + cipher.toString());
        cipher.init(Cipher.DECRYPT_MODE, rsaPrivateKey);
        System.out.println("cipher after init: " + cipher.toString());
        byte[] decodeAesKey = cipher.doFinal(Base64.decodeBase64(encodeAesKey));

        byte[] ivBytes = { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
                0x00, 0x00, 0x00, 0x00, 0x00, 0x00 , 0x00 };
        SecretKey aesKey = new SecretKeySpec(decodeAesKey, "AES");
        AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivBytes);
        Cipher aesCipher = Cipher.getInstance("AES/CBC/PCKS5Padding");
        aesCipher.init(Cipher.DECRYPT_MODE, aesKey, ivSpec);
        byte[] byteDecodeUserInfo =
                aesCipher.doFinal(Base64.decodeBase64(encodeUserInfo));
        String decodeUserInfo = new String(byteDecodeUserInfo);
        System.out.println("userinfo : " + decodeUserInfo);
    }

}
