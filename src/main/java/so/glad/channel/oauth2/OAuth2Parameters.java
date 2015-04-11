package so.glad.channel.oauth2;

import com.google.common.base.Objects;

/**
 * @author Cartoon
 * on 2015/3/26.
 */
public class OAuth2Parameters {

    private String state;

    private String scope;

    private String redirectUrl;

    private String display;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OAuth2Parameters)) return false;
        OAuth2Parameters that = (OAuth2Parameters) o;
        return Objects.equal(state, that.state) &&
               Objects.equal(scope, that.scope) &&
               Objects.equal(redirectUrl, that.redirectUrl) &&
               Objects.equal(display, that.display);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(state, scope, redirectUrl, display);
    }
}
