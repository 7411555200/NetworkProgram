package utils;

import com.gd.network.auth.utils.RsaUtils;
import org.junit.Test;

/**
 * @author Robod
 * @date 2020/8/9 23:14
 */
public class RsaUtilsTest {

    private String privateFilePath = "/Users/binbini/Documents/workspace/NetworkProgram/auth_key/id_key_rsa";
    private String publicFilePath = "/Users/binbini/Documents/workspace/NetworkProgram/auth_key/id_key_rsa.pub";

    private String secretKeyFilePath = "/Users/binbini/Documents/workspace/NetworkProgram/auth_key/id_key";

    @Test
    public void generateKey() throws Exception {
        RsaUtils.generateKey(secretKeyFilePath,"iMusicLee");
    }

    @Test
    public void getPublicKey() throws Exception {
        System.out.println(RsaUtils.getSecretKey("/Users/binbini/Documents/workspace/iMusic/auth_key/id_key"));
    }

}