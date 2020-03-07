package com.erp.service;

import com.erp.pojo.Goods;
import com.erp.util.EasyUiResultUtil;

public interface GoodsService {

    /**
     *查询
     * @param goods
     * @return
     */
    EasyUiResultUtil<Goods> selectByExample(Goods goods, int pageNum, int pageSize,String ceshi);

    /**
     * 增加
     * @param goods
     * @return
     */
    int insert(Goods goods);

    /**
     * 删除
     * @param uuids
     * @return
     */
    int deleteByPrimaryKey(Integer[] uuids);

    /**
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(Goods record);


    /**
     * 根据id查询
     * @param uuid
     * @return
     */
    Goods selectByPrimaryKey(Integer uuid);

}
