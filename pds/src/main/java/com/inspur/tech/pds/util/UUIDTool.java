package com.inspur.tech.pds.util;

import java.util.UUID;

/**
 * @Author: HP
 * @Date: 2019/1/9 15:26
 * @Description:自动生成UUID32位
 */
public class UUIDTool {
    public UUIDTool() {
    }

    /**
     * 自动生成32位的UUid，对应数据库的主键id进行插入用。
     *
     * @return
     */
    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "");
    }
}
