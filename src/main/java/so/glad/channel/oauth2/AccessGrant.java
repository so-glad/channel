package so.glad.channel.oauth2;

import java.io.Serializable;

import com.google.common.base.Objects;
/**
 * @author  Cartoon
 * on 2015/3/26.
 */
public class AccessGrant implements Serializable {

    private final String accessToken;

    private final String scope;

    private final String refreshToken;

    private final Long expireTime;

    public AccessGrant(String accessToken, String scope, String refreshToken, Long expiresIn) {
        this.accessToken = accessToken;
        this.scope = scope;
        this.refreshToken = refreshToken;
        this.expireTime = expiresIn != null ? System.currentTimeMillis() + expiresIn * 1000l : null;
    }
    /**
     * The access token value.
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * The scope of the access grant.
     * May be null if the provider doesn't return the granted scope in the response.
     */
    public String getScope() {
        return scope;
    }

    /**
     * The refresh token that can be used to renew the access token.
     * May be null if the provider does not support refresh tokens.
     */
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * The time (in milliseconds since Jan 1, 1970 UTC) when this access grant will expire.
     * May be null if the token is non-expiring.
     */
    public Long getExpireTime() {
        return expireTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AccessGrant)) {
            return false;
        }
        AccessGrant that = (AccessGrant) o;
        return Objects.equal(accessToken, that.accessToken) &&
                Objects.equal(scope, that.scope) &&
                Objects.equal(refreshToken, that.refreshToken) &&
                Objects.equal(expireTime, that.expireTime);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(accessToken, scope, refreshToken, expireTime);
    }
}
