package pers.robin.awm.config;

import java.util.ArrayList;
import java.util.List;

public class RoleConfig {

    private static List<String> roleList = new ArrayList<>();

    static {
        roleList.add("customer");
        roleList.add("shop");
        roleList.add("admin");
    }

    public static String getRoleName(int id) {
        return roleList.get(id);
    }

    public static void main(String[] args) {
        System.out.println(getRoleName(0));
    }
}
