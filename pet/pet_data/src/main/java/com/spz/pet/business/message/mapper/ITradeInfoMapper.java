package com.spz.pet.business.message.mapper;

import com.spz.pet.business.message.domain.TradeInfo;

/**  
 * Copyright © 2018Company. All rightsreserved.
 * @文件名 IMessageMapper.java
 * @项目名 pet_data
 * @包名 com.spz.pet.mapper
 * @类名 IMessageMapper
 * @功能描述 TODO
 * @创建人 施鹏振 
 * @创建时间 2018年11月27日上午10:00:23
 * @版本 TODO
 */
public interface ITradeInfoMapper {

    /**
     * @方法名 insertMessage
     * @param tradeInfo
     * @return int
     * @功能描述 新增交易信息
     * @创建人 施鹏振 
     * @创建时间 2018年11月27日上午10:29:13
     */
    public int insertTradeInfo(TradeInfo tradeInfo);
}
