package com.erp.service.Impl;

import com.erp.mapper.GoodsMapper;
import com.erp.pojo.Goods;
import com.erp.pojo.GoodsExample;
import com.erp.service.GoodsService;
import com.erp.util.EasyUiResultUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public EasyUiResultUtil<Goods> selectByExample(Goods goods, int pageNum, int pageSize,String ceshi) {

        GoodsExample example = new GoodsExample();
        GoodsExample.Criteria criteria=example.createCriteria();
        System.out.println(example);
        //添加模糊查询
        if (goods.getName()!=null){
            criteria.andNameLike("%"+goods.getName()+"%");
        }
        if (goods.getOrigin()!=null){
            criteria.andOriginLike("%"+goods.getOrigin()+"%");
        }
        if (goods.getProducer()!=null){
            criteria.andProducerLike("%"+goods.getProducer()+"%");
        }
        if (ceshi!=null&&ceshi!=""){
            String[] split = ceshi.split("~");
            criteria.andInPriceBetween(Integer.parseInt(split[0]),Integer.parseInt(split[1]));
        }
        int count = (int) goodsMapper.countByExample(example);
        //在查询之前设置分页-自动处理
        PageHelper.startPage(pageNum,pageSize);
        return new EasyUiResultUtil<Goods>(count,
                goodsMapper.selectByExample(example));
    }

    @Override
    public int insert(Goods goods) {
        return goodsMapper.insert(goods);
    }

    @Override
    public int deleteByPrimaryKey(Integer[] uuids) {

        return goodsMapper.deleteByPrimaryKey(uuids);
    }

    @Override
    public int updateByPrimaryKey(Goods record) {
        return goodsMapper.updateByPrimaryKey(record);
    }


    @Override
    public Goods selectByPrimaryKey(Integer uuid) {
        return goodsMapper.selectByPrimaryKey(uuid);
    }
}
