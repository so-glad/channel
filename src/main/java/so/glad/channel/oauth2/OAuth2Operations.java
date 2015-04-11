package so.glad.channel.oauth2;

import java.util.Map;

/**
 * @author Cartoon
 * on 2015/3/26.
 */
public interface OAuth2Operations {

    String buildAuthorizeUrl(GrantType grantType, OAuth2Parameters parameters);

    AccessGrant refreshAccess(String grantType, Map<String, String> paramters);

}
