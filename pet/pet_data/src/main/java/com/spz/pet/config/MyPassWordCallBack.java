/**
 * @文件名称： MyPassWordCallBack.java
 * @文件路径： com.ecton.common.spring
 * @功能描述： TODO
 * @作者： wangguoliang
 * @创建时间：2018年5月11日 下午1:44:53
 */
package com.spz.pet.config;

import java.util.Properties;

import org.apache.commons.lang.StringUtils;

import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.util.DruidPasswordCallback;

public class MyPassWordCallBack extends DruidPasswordCallback {

    /** @Fields serialVersionUID: */
    private static final long serialVersionUID = -2603930097137254639L;

    public static void main(String[] args) throws Exception {
        String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCRyaG6aCzNbj7wfr32moeKF2iTFhMZXSEnu52br1EvjA9BWO+qtCmaFI/O07CrlfMRjk22PMJU0LZNJocaUZP6V9W5Dz8IuunI8FFRbg6FocCecy+Ilk3q0QogLwSAL6Z7LuO/nBHMnuCNc+2WDodAsMa8gHsXo01WxeFKiwJl3wIDAQAB";

        String PRIVATE_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJHJobpoLM1uPvB+vfaah4oXaJMWExldISe7nZuvUS+MD0FY76q0KZoUj87TsKuV8xGOTbY8wlTQtk0mhxpRk/pX1bkPPwi66cjwUVFuDoWhwJ5zL4iWTerRCiAvBIAvpnsu47+cEcye4I1z7ZYOh0CwxryAexejTVbF4UqLAmXfAgMBAAECgYBo/XmAQhfJ1hRzpALwPrdPxq3kB2i3wm7nK2FExkxEXqx51i+7ksXHFfm+7Ir19yY2xXHHxRf6dthi1VVEqe1TrNTvru/w/SJFbTlX1oTpmUrnFZY0nRgMIfEDF3OE8eqrXCoT5s3duStqrc4Ly3v2QMwwPW+fNe1HdWM9rr9ScQJBAM752QdZJUzZj+rNwSiNUv1RMyG8TgiBafveLg85K8aQlYWzHDjE382tssUgdXCJtf93B+JKorCVv4UejDdAyKcCQQC0UZSEgHmSxEQyp4DNg8HhUVc2wbVkKl2ZFT7xXcWrD4W3IgaCD8mX0nEwVcc8hAROnM2ZCucHmOCsz1UVfOgJAkEAogng62vTU/MQRReInaLm0gN8MHEn9mi6/MDY9nof13jiVqX+9kLLpE7Uopfi2ZQ2tCYQOg2MiQrzwdhElg1WCQJAXjrjqfqZjaETIoV2Qe/AucaQFQVVjWq2TvFTWz7ttV7/OZyGWiF17+kBTYkF/RHgTlSS/I89/DJf9u7CP+BuQQJBAMVxxWO2bRs51O+Z9FvrQDo2/FWJLD6RRqU+ULnkcyj9O1aYXMQl5UDr4yhRxG7FKFHntjNwJD80ZBBtG/Gb9tg=";
        
        String str = "ROOT";
        //加密
        String jiami = ConfigTools.encrypt(PRIVATE_KEY, str);
        System.out.println(jiami);
        String jiemi = ConfigTools.decrypt(PUBLIC_KEY, jiami);
        System.out.println(jiemi);
        //解密
        if (str.equals(jiemi)) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }
    }

    /**
     * @功能描述：解密密码
     * @参数说明：@param properties
     * @作者： wangguoliang
     * @创建时间：2018年5月11日 下午1:46:21
     * @接口方法：@see com.alibaba.druid.util.DruidPasswordCallback#setProperties(java.util.Properties)
     */
    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
        String pwd = properties.getProperty("spring.datasource.password");
        System.out.println("------------------spring解密开始--------------");
        if (StringUtils.isNotBlank(pwd)) {
            try {
                String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCRyaG6aCzNbj7wfr32moeKF2iTFhMZXSEnu52br1EvjA9BWO+qtCmaFI/O07CrlfMRjk22PMJU0LZNJocaUZP6V9W5Dz8IuunI8FFRbg6FocCecy+Ilk3q0QogLwSAL6Z7LuO/nBHMnuCNc+2WDodAsMa8gHsXo01WxeFKiwJl3wIDAQAB";
                String password = ConfigTools.decrypt(PUBLIC_KEY, pwd);
                setPassword(password.toCharArray());
            } catch (Exception e) {
                setPassword(pwd.toCharArray());
            }
        }
    }

}
