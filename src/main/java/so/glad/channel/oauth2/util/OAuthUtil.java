package so.glad.channel.oauth2.util;

import jdk.nashorn.internal.ir.LiteralNode;
import jdk.nashorn.internal.ir.ObjectNode;
import jdk.nashorn.internal.ir.PropertyNode;
import jdk.nashorn.internal.parser.JSONParser;
import jdk.nashorn.internal.runtime.ErrorManager;
import jdk.nashorn.internal.runtime.Source;
import so.glad.channel.oauth2.AccessGrant;

/**
 * @author palmtale
 *         on 2015/4/11.
 */
public interface OAuthUtil {

    AccessGrant fromJson(String json);

    OAuthUtil DEFAULT_INSTANCE = new OAuthUtil() {
        @Override
        public AccessGrant fromJson(String json) {
            if(json == null || json.trim().equals("")){
                return null;
            }
            ObjectNode node;
            try{
                node = (ObjectNode) new JSONParser(Source.sourceFor("accessGrant", json), new ErrorManager()).parse();
            } catch (Exception e){
                return null;
            }
            String accessToken = null, refreshToken = null, scope = null;
            long expireTime = 0l;
            for(PropertyNode propertyNode: node.getElements()){
                if(propertyNode.getKeyName().startsWith("access")){
                    accessToken = ((LiteralNode)propertyNode.getValue()).getString();
                }
                if(propertyNode.getKeyName().startsWith("refresh")){
                    refreshToken = ((LiteralNode)propertyNode.getValue()).getString();
                }
                if(propertyNode.getKeyName().startsWith("expire")){
                    expireTime = ((LiteralNode)propertyNode.getValue()).getLong();
                }
                if(propertyNode.getKeyName().startsWith("scope")) {
                    scope = ((LiteralNode)propertyNode.getValue()).getString();
                }
            }
            return new AccessGrant(accessToken, scope, refreshToken, expireTime);
        }
    };
}
