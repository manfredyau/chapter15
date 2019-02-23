package com.ssm.chapter14.converter;

import com.ssm.chapter14.pojo.Role;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

public class StringToRoleConverter implements Converter<String, Role> {
    @Override
    public Role convert(String str) {
        // 空串
        if (StringUtils.isEmpty(str)) {
            return null;
        }

        // 不包含指定字符
        if (!str.contains("-")) {
            return null;
        }

        String[] arr = str.split("-");

        // 字符串數組長度不對
        if (arr.length != 3) {
            return null;
        }

        Role role = new Role();
        role.setId(Long.parseLong(arr[0]));
        role.setRoleName(arr[1]);
        role.setNote(arr[2]);
        return role;
    }
}
