package pers.robin.awm.util;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class CommonUtil {

    public static Map<String, Object> getParameterMap(HttpServletRequest request) {
        Map<String, String[]> properties = request.getParameterMap();
        Map<String, Object> map = new HashMap<String, Object>();
        Set<String> keySet = properties.keySet();
        for (String key : keySet) {
            String[] values = properties.get(key);
            String value = values[0];
            map.put(key, value);
        }
        return map;
    }

    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }
}
