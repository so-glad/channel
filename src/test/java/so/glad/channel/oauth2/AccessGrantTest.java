package so.glad.channel.oauth2;

import org.junit.Assert;
import org.junit.Test;
import so.glad.channel.oauth2.util.OAuthUtil;

/**
 * @author palmtale
 *         on 2015/4/11.
 */
public class AccessGrantTest {

    private OAuthUtil authUtil = OAuthUtil.DEFAULT_INSTANCE;

    @Test
    public void testFromJSONString(){
        String json = "";
        AccessGrant accessGrant = authUtil.fromJson(json);
        Assert.assertNull(accessGrant);
        json = "j";
        accessGrant = authUtil.fromJson(json);
        Assert.assertNull(accessGrant);
        json = "{\"accessToken\":\"\", \"expireIn\": 121321321,\"refresh_Token\": \"fdajjvnz;lfda\", \"scope\":\"L\"}";
        accessGrant = authUtil.fromJson(json);
        Assert.assertNotNull(accessGrant);
        Assert.assertEquals(new AccessGrant("", "L", "fdajjvnz;lfda", 121321321l), accessGrant);
    }
}
