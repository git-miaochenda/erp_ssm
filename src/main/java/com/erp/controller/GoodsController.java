package com.erp.controller;

import com.erp.pojo.Goods;
import com.erp.service.GoodsService;
import com.erp.util.EasyUiResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping("list")
    public EasyUiResultUtil<Goods> selectByExample(Goods goods,
                                                   @RequestParam(defaultValue = "1") int pageNum,
                                                   @RequestParam(defaultValue = "2") int pageSize,
                                                   String ceshi){
        if(ceshi!=null){
            System.out.println("qujian");
            String[] split = ceshi.split("~");
            System.out.println(Arrays.toString(split));
        }
       return goodsService.selectByExample(goods,pageNum,pageSize,ceshi);
    }

    @RequestMapping("add")
    public boolean insert(Goods goods){
        goodsService.insert(goods);
        return true;
    }

    @RequestMapping("remove")
    public boolean deleteByPrimaryKey(Integer[] uuid){
        System.out.println(uuid);
        goodsService.deleteByPrimaryKey(uuid);
        return true;
    }

    @RequestMapping("update")
    public boolean updateByPrimaryKey(Goods record){
        goodsService.updateByPrimaryKey(record);
        return true;
    }

    @RequestMapping("findById")
    public Goods selectByPrimaryKey(Integer uuid){
        return goodsService.selectByPrimaryKey(uuid);
    }
}
