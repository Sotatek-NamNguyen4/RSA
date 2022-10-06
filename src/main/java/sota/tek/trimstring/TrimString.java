package sota.tek.trimstring;

public class TrimString {
    public static void main(String[] args) {
        String priKey = "MIIEpAIBAAKCAQEAwRvqfdxSIsdVkA/cLAYIl0egq/gq8izJSWoLqwdQVBriFPa0\n" +
                "Tj+tF5OV36M00s83QL+Vx/2gYCyUTHgZe6t1O0k9bCAfBZnPcmtteNslwX08e3MI\n" +
                "oUu6fUmd3GZROhflqYJAPSTsOvEOqaTH2r30UcKtkmEVIUZukDqCpd5iX1kl1sYO\n" +
                "LfgkqfFB7OMClu4HIUKCrdoVE9qkA5Xj0cPQ2xuqsftMKmoD0bqn74BdA/fVWZow\n" +
                "iNX+Ua2KxQGq1vsW/bsYYf9vRISghfUIwgQupT9It9IyvcEAaz/JfCphpFImtDX1\n" +
                "pCvczmzVKfeTipm2HVNOA9Xx54Gt4uPdGyHKcQIDAQABAoIBAQCf6z9g5ZD7jjoU\n" +
                "aJ37sy9wIHg1kfn2vhIfgvuQsijazbyGgdvFpUPx713Ba0X2gnYOX9ppWWdz3dce\n" +
                "EKOB3/bglwGPxnYKTFsYNVDeMhXtS4pH7XarJKyWzt01RWJlCp89pkkOmcIr+a8b\n" +
                "3ANJ6d8nymG1hEJcYRh0xo+lTyoGLLm/i8ybYc31Ch3nGACwNJsz7IcYOyOED9lM\n" +
                "LWEoPXqJd0ADVcsP57jpheWRQ4eDoPxcb8Z8lAetTaIH/ZnRdg1omqhufUrMpLds\n" +
                "Or+JhQkIl/3mx60oAhB+JlNl+K5ExusYfRPoz/IL6M84W6k3CtY5JetwhOcVtS+n\n" +
                "ApsNY3zlAoGBAPnNw30ZdQQxB2VPJ0i4n8YFrYP5TkClE0Uw/uIKbx5p3OFzf9mU\n" +
                "rtlU40W3UsVmJPXebaNh28twkkI8ghzyBbUb9ygmPnrk5i/88YFjIcC/Jc6mzl2q\n" +
                "lGhFC1Am7q178B+vUQi1vuXNKR+o1OyW4IjXd3wiN2JO4IHwOz2AWCZ/AoGBAMXm\n" +
                "JRbFLA+RVSEClyNcWWEqfRlcj5Xtn7CwXGN2bHY413XVHMhJnZi8BmkiNz1F6Gt3\n" +
                "lqru3NvEIkqC59+/EEiNxXY4h1dQvUh18oGx6Jd3QdFt3A4YHdBeb5j+/Tj+JZ+b\n" +
                "1YN3gjqyoTwm8IEQCK3I5LCGrkZXB8uh+GP7rfcPAoGAYq3++I8y44n+su2Wxipw\n" +
                "q0gY6FZ2rCDJwP5+4YpfpPMK12DJ84jBnYbkFOk7YFFebmYEh5MjwXThwhqnB4ov\n" +
                "6QB4HTsmWWPM7s4MFSG09rBL3huUz/mPkLUdp/cJOC0KiWm3KCqrk5n9Ec2e9ysO\n" +
                "3d/ICph1qncgRxRAQqZNrD8CgYEAhYdwZxjLTgXF5uwUhqt9M26z0jT+PS+EnHej\n" +
                "Hwl8zZg06TDOpuXlDHVx7eZEV3egB0M9ykA5jZ+dc6E4S2Rj3FCsd8RUrbmwvf+3\n" +
                "jYM5aVnycxkpbekf1MSjkBwdSCNTx4oiWv58RJba6/dqN+tVr8zpYaK+XH/EpsW3\n" +
                "D9911kkCgYAbLq/zTvmGkewaRROr58YCXVUY5zPBgrjiN63h+RDE1KjKRmzR7QqA\n" +
                "2JwYuOYk9b4S/m02U4ztaiJTDmbJlpFJ1yWk8p9dVKJE9/8KwDDBrGFf/OGe4TdZ\n" +
                "Mc3qFk19GMAhaO9x3S5Vma+6RI7iWnl5e+JyljjndT5uPf20nxWpEA==";
        String pubKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwRvqfdxSIsdVkA/cLAYI\n" +
                "l0egq/gq8izJSWoLqwdQVBriFPa0Tj+tF5OV36M00s83QL+Vx/2gYCyUTHgZe6t1\n" +
                "O0k9bCAfBZnPcmtteNslwX08e3MIoUu6fUmd3GZROhflqYJAPSTsOvEOqaTH2r30\n" +
                "UcKtkmEVIUZukDqCpd5iX1kl1sYOLfgkqfFB7OMClu4HIUKCrdoVE9qkA5Xj0cPQ\n" +
                "2xuqsftMKmoD0bqn74BdA/fVWZowiNX+Ua2KxQGq1vsW/bsYYf9vRISghfUIwgQu\n" +
                "pT9It9IyvcEAaz/JfCphpFImtDX1pCvczmzVKfeTipm2HVNOA9Xx54Gt4uPdGyHK\n" +
                "cQIDAQAB";

        System.out.println("priKey: " + priKey.replaceAll("\n", ""));
        System.out.println("pubKey: " + pubKey.replaceAll("\n", ""));


    }
}
