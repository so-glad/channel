package so.glad.channel.oauth2;

import com.google.common.base.Objects;

/**
 * @author palmtale
 *         on 15/6/16.
 */
public class AuthorizeParameters {

    private String appKey;

    private String appSecret;

    private String accessToken;

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AuthorizeParameters)) {
            return false;
        }
        AuthorizeParameters that = (AuthorizeParameters) o;
        return Objects.equal(appKey, that.appKey) &&
                Objects.equal(appSecret, that.appSecret) &&
                Objects.equal(accessToken, that.accessToken);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(appKey, appSecret, accessToken);
    }
}
