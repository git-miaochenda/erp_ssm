package com.erp.service;

import com.erp.pojo.Dept;
import com.erp.util.EasyUiResultUtil;

import java.util.List;

public interface DeptService {

    /**
     *根据id进行批量删除
     * @param ids
     */
    void remove(Integer[] ids);
    /**
     *修改内容
     * @param dept
     */
    void update(Dept dept);
    /**
     *根据id查找内容
     * @param id
     * @return
     */
    Dept findById(int id);
    /**
     *增加功能
     * @param dept
     */
    void add(Dept dept);
    /**
     *
     * @param pageNum 页码
     * @param pageSize
     * @return
     */
    EasyUiResultUtil<Dept> page(int pageNum, int pageSize);

    /**
     * 返回一个Dept集合 数据回显
     * @return
     */
    List<Dept> findAll();
}
