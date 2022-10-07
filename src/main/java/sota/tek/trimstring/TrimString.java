package sota.tek.trimstring;

public class TrimString {
    public static void main(String[] args) {
        String priKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC5nHGCKufUhouCrZeWMPurheCVUrCVM8kdW0Y/vLQv3DsolO8hclBl/uHyHk2gjYXIHmR86ROkNS6B2Bm/wU4jCuRfheN2Xznwp7TQ9mrrS/6x1tLhs5F724OFSsF2jR+SEzrZsXyyZpu5pvgEap3mdxsZIQYzWORfZ4Cik0eTzE5PfC48LyIYKgpZWmLHu/zGAum8XrySIrziD9afBB67sXewTsE+MXho++6hqh4MQR39sm2eP3mXWsnYA61eoDmNuMOF0lIA/jevt0Nla+1FEtq/NBeMFwIlsJrZqn3dQh/mNWOyBOJCHFkJL4pu/wOBn3X0viDZgX4fhc0aVVi1AgMBAAECggEBALEwMn/Du8p7ooTeeL5NBoPIawvBg4b7h7s5ngdMemrR/7uO6fVw7mVf+4wp94sUbykKMn239yMkDcCwbmxK+e+j/z1dUDZ5U5N0Vb3B73Gt+3cEEA6cYH7voE9HfQZSVFgbeWvF7rdUEscZKNz2dsRC4aCMkSHFc0XMRdVtacAhgbOAdd0Mcpkq7IL3KFVBjDbGb8IR6cT/O2c2+WwHuspZm84dBmAT8U5TCQWtt/ZsKvBBoHmS1NcUM5TiD3UoV/Mc4UjG/uEIxvdlD3pFFgo/suurlQAzzR+yLuYvLeNig1EanuRa3N9zeAJt8FlGqwpWOJUCX9tqQFD41kOF40UCgYEA5kvMRhmlsCqT5hrRnE70OL6YDOlfrnQkHZ22NMwvViQDbMRYi4NAqbfAqTjejNnMdwgLLnHlsl1ZBiwjGmyXIQ4U1Wrdzsiwg8xugE//2nSk4mS8Sdn9uFDHUGIfeB++bTndygwRdXS42R1LOdCvVRUF1Ziw57RlQPkwOC0GB2sCgYEAzlPe8P7upZClRUMXAwFcBDzDv4t1mwmiKRVoFguKNK3W/lcg8HiB/E2oj0K82rDQ+99Yn1sl8dsqTMLaxkCpZxTJKyt03jC9Mrb9VC8vt5Ftk50vF5uuIhTHteTANEh29xpsDShr3DkIQMnPkvisDM+9t5JkVfC60hKYLyonyF8CgYADOAP+5tTeBXpTuQQ8/w2CzYcqhwiDU7Q9hbrKOiBfP9mcZ5IlQQxiUuMqelUB+vlUoJQnbggb2hoob+19rQ7fs2avJPM8tKli7jSNLpEQ6Jh1YZsQHS/ip55hjT2LXEY5GJn0/P4xehQrVLF8eWI5+jU+qwet9WOE6Pa3kkmHSQKBgHH8Z9ggHtuc85E2JUplv94fa80wUIKcadfkmaJEMdA0keflXq87BCTNCmhK6Gaw9GOR2jX/dxEMkWvi4lZQdsYZ96E/2sq9hmi0K3QMtYHmd/DrD48tVKBDdqmIfJ7lwcN192e1gxEg+OxCEckSVIqnYho+Z+wKmEtiNm0oDt5lAoGAbGauRDheJEFoaDJNopq+FaoKobdBtzsBt+/XufNZnFMQEWOlt5Th5a9HdvBW1yFJ2pd4hGBxDM3gisLNZ4Ll9Mv266aQrlzD6i5/aXPGdLLRg1KU9FWpRTzy/K8WK2ia3D+ZEdupvH3Khw1bvtYlS2EvWrHdrji7231ibB+V7gE=";
        String aes = "QITLRAs7Cu0nizoAxqbT jbvWd6QQGOOSHVgv0CG103hC6kwHmYcQ2bS+ZPA3KWwyNRmtCAACp1blHSTi2lKsB9aZBozRvytp URfYzDL1PRzRCYkCre/aoYiUTgJ8zwhxB2mpMAeRx/1i2ejmU42VNuq7x/iLIaxCp0Voq30C8 PnY7u5DoXMCvQgbUbCioc0BfdU4jvX8wCxmN5xHC4gShxfgfHFfxmlg1S0K38JNJcbZlpxDlQLg4 GryI6cicp7rlGBp1YfAdIbz/YT6Emd4G62aXCh6vyQYwTzGnHm1IayE1tw+PPWXXpr4xVNndzGo G0LufL0wKCn7WDKBAzdugg==";
        System.out.println("priKey: " + priKey.replaceAll("\n", "").replaceAll("_", "").replaceAll(" ", ""));
        System.out.println("pubKey: " + aes.replaceAll("\n", "").replaceAll("_", "").replaceAll(" ", ""));


    }
}
