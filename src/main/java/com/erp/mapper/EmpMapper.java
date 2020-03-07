package com.erp.mapper;

import com.erp.pojo.Emp;
import com.erp.util.TreeResultUtil;
import com.erp.vo.EmpVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {

    /**
     * 根据id进行删除
     * @param ids
     */
    void remove(@Param("ids") int[] ids);

    /**
     * 修改员工信息
     * @param emp
     */
    void update(@Param("emp") Emp emp);
    /**
     * 根据id查询Vo员工信息
     * @param id
     * @return
     */
    EmpVo findById(@Param("id") int id);
    /**
     * 增加员工信息
     * @param emp
     */
    void add(@Param("emp") Emp emp);

    /**
     *
     * @param wheres
     * @return
     */
    int count(@Param("wheres") EmpVo wheres);

    /**
     *
     * @param wheres 查询条件
     * @param start 分页的起始位置
     * @param pageSize 每页展示数量
     * @return
     */
    List<EmpVo> page(@Param("wheres") EmpVo wheres,@Param("start") int start,@Param("pageSize") int pageSize);

    /**
     * 获得自动增长主键
     * @return
     */
    int getKey();

    /**
     * 根据账号和名称完成登录
     * @param username
     * @param password
     * @return
     */
    Emp login(@Param("username") String username,@Param("password") String password);


}
