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
        String encodeUserInfo = "JVKaXcwvsywXBTqo1aKmyVHt/XeX5LATt4kr9levgt3ICsQ7H6xjiALOmgeLhj28RJaiaEWmUn4P2/mkSwaI9oeS3RumcI8h3GXVdn6wVY76m0Na/JZUuNwaS6k85DA1m7X3PKE891kcwIncI1AywF5s+bRIkx0DX71RSnYSjp4ff+f1+q1tezIw8UXxBWJ5CQuqVaq1X8t+8dddHXKd30vh1xOaEqA34kNLoBLwL50jg1uLYo1xFYuex2K9wK0AxWinGEARwoidQ1jA6sQNi/QptbTFIlzGGyGxhL56hSD2tOXpaeCOPmCuT2FgdxsPmskwllb8tXFJ3CZjIv1Nv3GpCsa9GKrVgF7AZ/mpBIj5+HI/3nUy03zA/+bzRbfrC4y1rDzSX/IluzmusnNEYtRPCu09UE+KgrtLwS+b0pHtC03thdyM8WsDm5OvJElSDbolx0mlo+NdKBKqPTDO/vbvYNQeHntriVsZ5cDMDR1AksDXxTu5nL6rA4sHHnCJe5DXSuohjs5p3yCj8iPhHpLdh+T3KsJa0Yf99geJV6rgo1C1 L8+7licqSYjh2GSYkp9HW3uNKAmvWkKQi7yclJAL3O9enw8l+ZG2YFbrqODMyJC8q8maHbU5A3c28xDgwsw4JWR6ifY6KaUAzBVLg1AJqUIrF1dbjw0blAFuo+jpFjNgQnSz/0WU3KRfmXzCynxzpSfe9+Zamgo9embE2PCV9OlRYDfkyPfPAUNrnVUUV9PEnjHngFG9vJR4y/oTr8mr3p21+/FPhZUNw g1YGrmLaZtd1Pp/h7WBWvturS5YGIb90bJNr6NTd09oTuu4+ZZbL3+k9MvVru2i81nfYcIYy1O9qjJDQCKvW5XNrNBg7Btp1dWFBHchFFeHef4joDbZPyZlkEt+/UCQuZCE65y0bacw1qqqBt8qDF/F+v4PS7recTu/+J9QSjb43//HrrFR8mAPX+wfMaYa5GfoMDsz2jBowGAENre6usOeB/0lLB p7gThd/xRtrd46dM8Mj68jS49T3IgR3EcolJ4pIg==";
        String encodeAesKey = "QITLRAs7Cu0nizoAxqbTjbvWd6QQGOOSHVgv0CG103hC6kwHmYcQ2bS+ZPA3KWwyNRmtCAACp1blHSTi2lKsB9aZBozRvytpURfYzDL1PRzRCYkCre/aoYiUTgJ8zwhxB2mpMAeRx/1i2ejmU42VNuq7x/iLIaxCp0Voq30C8PnY7u5DoXMCvQgbUbCioc0BfdU4jvX8wCxmN5xHC4gShxfgfHFfxmlg1S0K38JNJcbZlpxDlQLg4GryI6cicp7rlGBp1YfAdIbz/YT6Emd4G62aXCh6vyQYwTzGnHm1IayE1tw+PPWXXpr4xVNndzGoG0LufL0wKCn7WDKBAzdugg==";
        String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDHt8bm77Isbs8jH1+FKKkIfXngIOAsVtyu3lncg1tu39z9VLZ5+H3s5CTb/s81A9u4ysnaIkgs1I5rFgTmbNWkpyd/dTLC+HhRcH8hQLJGbtZX1/DfxhJrKtm4JAo3uPefbyT6S1zi0VTDBv9HL0fHV34jX57EE1AKpX8y9Y51VrGZ6JoKFnh24NweAbca0KiVD1RXVdL7hOHg/Ovl9+7zO9tcWsheTR2o/2l+SjGz5qjZ1BbYrWNUTQ5hHFlm24Z60/gR50XxKB8KT5xZxOwQ5eHOy0njrOWQizXQXlEbmfB4u7bGMP1X5L9uwZIfATpI2haxKkDDPH+tvqWx3D4dAgMBAAECggEADW7W+gF1QnfRhtM9YX9ynxeRcvnDGjhdb4WVFbfgFn0IKCHihCGqlpxhvkpNNYuk47EAEqPrpthFG/7HJZh8Zi64AWKon2SG8zNV2a64TvR1hkMH+IUiCANB0Zja9xSB0z9uhUc8YCUkRlnaIbeUZFwGJ+ruitGhuJWZEJxjkJC9xnjNlr2mh+nTXJrixM6VpsYsHDfBhq9hMXVXc3e071JwBkNwewPW3yBVLX9gCAONuJwqPHgi+SernMmVq/E7FbXlSh0gwq96XykUWTnupmxsW6xc7ysXtvU1B1DJgPlDgHCseASEuNtWPKdbfZlHXJIP+5cssM/MuKsQpCJhAQKBgQDi1CRLg6cLXkpwY1jfPL8pwmQNvcez7+DPkHDWCcm43mFlBUMWujnvLYVbN9NjP18KEQg7EYHqYGiIbPs9t6+GL3sLhQXPuzFRigUUfsvXqyrVT0CAGYb3zLaD/LPTbbyTg0ZbF9S12Jorez18m4V58fN+AC/aFfS4INsI+tJ6uQKBgQDhZxGpJomaTf87gDhxq8/Xt3/mSWrxI799l0DECrC+RL6fplb0K313t+wZjUj0H8M4ywKEZP/U3tTqDOqbIYeV9c1d6iB7VRQ+evrg7TFN/QPUvUsZ9kjW4UevtKn6jpM68X/CUdiE+mjUiFSveeoKVlp8BZYHbsMLWzAyXahchQKBgBt7IDqV5LMX5WTgZHAHaBGjH4Qargs60L3U/hawcOQY7SvUC2DBhytXFIUMqmunzdfmYFznrhm7PG7q5TWA/57+OaYXo7CbOUprslndUsz6S+I0C9h5P0TeZG5xO0guT15/1RJMPNUbPPJvp+9k2DMCAUIOu71sU43LTT41RTLhAoGBAIKykgID74wCp/lnatM2rcjGhSoR7imu8c0wFATYsg1RrTrDZ+4i/ZialBNo4iFz/W4EAQylx9Y18z1Xif2z3nus0I0hQf5hoeBszOX5gzpWeI81x8NhFHFMpZWTa3B2lZZ7C/qwHJ1W2cxK1Nf/GB8wXT1Gu+zJY91E3diGiCZFAoGAZxeOJBxZaCnbuXWCyYPks1yJmyvo3QDuV4c3w7aTRMXT8JTqza/lepN0z1zQNnMQI+3JAD5Ty1g2QhST6uDzDLevcmjvMnZXCVVVOKKGJ0iuF8WM6xH5bv9BfHEt1NFfSKA4T+2Vs2Gu0mLKPSspkIR1Vh6r4vA/CXrdE5F4Bqw=";

        byte[] bytePrivateKey = Base64.decodeBase64(privateKey);
        PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(bytePrivateKey);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyFactory.generatePrivate(privateKeySpec);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, rsaPrivateKey);
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
