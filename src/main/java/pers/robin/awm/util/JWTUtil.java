package pers.robin.awm.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Date;

public class JWTUtil {

    // 过期时间5分钟
    private static final long EXPIRE_TIME = 5 * 60 * 1000;

    /**
     * verify token is true of false
     * @param token
     * @param tel
     * @param password
     * @return
     */
    public static boolean verify(String token, String tel, String password) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(password);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("tel", tel)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * get msg from token without password
     * @return token中包含的电话号码
     */
    public static String getTel(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("tel").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * get token, exprie time is 5 min
     * @param tel
     * @param password
     * @return
     */
    public static String sign(String tel, String password) {
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(password);
            // 附带username信息
            return JWT.create()
                    .withClaim("tel", tel)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
}
