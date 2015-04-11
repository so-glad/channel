package so.glad.channel.oauth2;

/**
 * @author Cartoon
 * on 2015/3/26.
 */
public enum GrantType {

    /**
     * AUTHORIZATION_CODE denotes the server-side authorization flow, and is associated
     * with the response_type=code parameter value
     */
    AUTHORIZATION_CODE,

    /**
     * IMPLICIT_GRANT denotes the client-side authorization flow and is associated with
     * the response_type=token parameter value
     */
    IMPLICIT_GRANT
}
