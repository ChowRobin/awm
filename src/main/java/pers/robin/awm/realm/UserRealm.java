package pers.robin.awm.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.robin.awm.bean.JWTToken;
import pers.robin.awm.config.RoleConfig;
import pers.robin.awm.model.User;
import pers.robin.awm.service.UserService;
import pers.robin.awm.util.JWTUtil;

@Service
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;


    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * check the role and permission of user
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String tel = JWTUtil.getTel(principalCollection.toString());
        User user = userService.findByTel(tel);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRole(RoleConfig.getRoleName(user.getRole()));
        return simpleAuthorizationInfo;
    }

    /**
     * check tel is true or not
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();

        String tel = JWTUtil.getTel(token);
        if (tel == null) {
            throw new AuthenticationException("token invalid");
        }

        User user = userService.findByTel(tel);
        if (user == null) {
            throw new AuthenticationException("User didn't existed!");
        }

        if (!JWTUtil.verify(token, tel, user.getPassword())) {
            throw new AuthenticationException("Tel of Password error");
        }

        return new SimpleAuthenticationInfo(token, token, "user_realm");
    }
}
