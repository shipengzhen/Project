/**
 * @文件名称： MyDruidDataSource.java
 * @文件路径： com.ecton.common.spring
 * @功能描述： TODO
 * @作者： wangguoliang
 * @创建时间：2018年5月11日 下午1:40:10
 */
package com.spz.pet.config;

import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.pool.DruidDataSource;

public class MyDruidDataSource extends DruidDataSource {

    /** @Fields serialVersionUID: */
    private static final long serialVersionUID = -6673397783689488969L;

    /**
     * @功能描述：TODO
     * @参数说明：@param username
     * @作者： wangguoliang
     * @创建时间：2018年5月11日 下午1:42:53
     * @接口方法：@see com.alibaba.druid.pool.DruidAbstractDataSource#setUsername(java.lang.String)
     */
    @Override
    public void setUsername(String username) {
        try {
            String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCRyaG6aCzNbj7wfr32moeKF2iTFhMZXSEnu52br1EvjA9BWO+qtCmaFI/O07CrlfMRjk22PMJU0LZNJocaUZP6V9W5Dz8IuunI8FFRbg6FocCecy+Ilk3q0QogLwSAL6Z7LuO/nBHMnuCNc+2WDodAsMa8gHsXo01WxeFKiwJl3wIDAQAB";
            username = ConfigTools.decrypt(PUBLIC_KEY, username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.setUsername(username);
    }

}
