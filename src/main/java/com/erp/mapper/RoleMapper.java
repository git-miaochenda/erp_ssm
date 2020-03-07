package com.erp.mapper;

import com.erp.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {

    /**
     *删除--可以删除多个
     * @param ids
     */
    void remove(@Param("ids")int[] ids);

    /**
     * 修改
     * @param role
     */
    void update(@Param("role") Role role);

    /**
     *增加
     * @param role
     */
    void add(@Param("role")Role role);

    /**
     * 查询总条数
     * @param role
     * @return
     */
    int count(@Param("role") Role role);


    /**
     * 返回一个Role集合 数据回显
     * @return
     */
    List<Role> findAll();

    /**
     *
     * @param role
     * @param start
     * @param pageSize
     * @return
     */
    List<Role> page(@Param("role") Role role
            ,@Param("start") int start,@Param("pageSize") int pageSize);
}
