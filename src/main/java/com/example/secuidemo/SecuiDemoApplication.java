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
        String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC5nHGCKufUhouCrZeWMPurheCVUrCVM8kdW0Y/vLQv3DsolO8hclBl/uHyHk2gjYXIHmR86ROkNS6B2Bm/wU4jCuRfheN2Xznwp7TQ9mrrS/6x1tLhs5F724OFSsF2jR+SEzrZsXyyZpu5pvgEap3mdxsZIQYzWORfZ4Cik0eTzE5PfC48LyIYKgpZWmLHu/zGAum8XrySIrziD9afBB67sXewTsE+MXho++6hqh4MQR39sm2eP3mXWsnYA61eoDmNuMOF0lIA/jevt0Nla+1FEtq/NBeMFwIlsJrZqn3dQh/mNWOyBOJCHFkJL4pu/wOBn3X0viDZgX4fhc0aVVi1AgMBAAECggEBALEwMn/Du8p7ooTeeL5NBoPIawvBg4b7h7s5ngdMemrR/7uO6fVw7mVf+4wp94sUbykKMn239yMkDcCwbmxK+e+j/z1dUDZ5U5N0Vb3B73Gt+3cEEA6cYH7voE9HfQZSVFgbeWvF7rdUEscZKNz2dsRC4aCMkSHFc0XMRdVtacAhgbOAdd0Mcpkq7IL3KFVBjDbGb8IR6cT/O2c2+WwHuspZm84dBmAT8U5TCQWtt/ZsKvBBoHmS1NcUM5TiD3UoV/Mc4UjG/uEIxvdlD3pFFgo/suurlQAzzR+yLuYvLeNig1EanuRa3N9zeAJt8FlGqwpWOJUCX9tqQFD41kOF40UCgYEA5kvMRhmlsCqT5hrRnE70OL6YDOlfrnQkHZ22NMwvViQDbMRYi4NAqbfAqTjejNnMdwgLLnHlsl1ZBiwjGmyXIQ4U1Wrdzsiwg8xugE//2nSk4mS8Sdn9uFDHUGIfeB++bTndygwRdXS42R1LOdCvVRUF1Ziw57RlQPkwOC0GB2sCgYEAzlPe8P7upZClRUMXAwFcBDzDv4t1mwmiKRVoFguKNK3W/lcg8HiB/E2oj0K82rDQ+99Yn1sl8dsqTMLaxkCpZxTJKyt03jC9Mrb9VC8vt5Ftk50vF5uuIhTHteTANEh29xpsDShr3DkIQMnPkvisDM+9t5JkVfC60hKYLyonyF8CgYADOAP+5tTeBXpTuQQ8/w2CzYcqhwiDU7Q9hbrKOiBfP9mcZ5IlQQxiUuMqelUB+vlUoJQnbggb2hoob+19rQ7fs2avJPM8tKli7jSNLpEQ6Jh1YZsQHS/ip55hjT2LXEY5GJn0/P4xehQrVLF8eWI5+jU+qwet9WOE6Pa3kkmHSQKBgHH8Z9ggHtuc85E2JUplv94fa80wUIKcadfkmaJEMdA0keflXq87BCTNCmhK6Gaw9GOR2jX/dxEMkWvi4lZQdsYZ96E/2sq9hmi0K3QMtYHmd/DrD48tVKBDdqmIfJ7lwcN192e1gxEg+OxCEckSVIqnYho+Z+wKmEtiNm0oDt5lAoGAbGauRDheJEFoaDJNopq+FaoKobdBtzsBt+/XufNZnFMQEWOlt5Th5a9HdvBW1yFJ2pd4hGBxDM3gisLNZ4Ll9Mv266aQrlzD6i5/aXPGdLLRg1KU9FWpRTzy/K8WK2ia3D+ZEdupvH3Khw1bvtYlS2EvWrHdrji7231ibB+V7gE=";
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
        Cipher aesCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        aesCipher.init(Cipher.DECRYPT_MODE, aesKey, ivSpec);
        byte[] byteDecodeUserInfo =
                aesCipher.doFinal(Base64.decodeBase64(encodeUserInfo));
        String decodeUserInfo = new String(byteDecodeUserInfo);
        System.out.println("userinfo : " + decodeUserInfo);
    }

}
