package com.erp.mapper;

import com.erp.util.TreeResultUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionMapper {
    /**
     * 查询条件，把所有信息封装为一个树
     * @return
     */
    List<TreeResultUtil> list();

    /**
     * 查询方法
     * @param roleId
     * @return
     */
    List<Integer> findPermissionIdsByRoleId(@Param("roleId") int roleId);

    /**
     * 先删除权限
     * @param roleId
     */
    void deleteRolePermByRoleId(@Param("roleId") Integer roleId);

    /**
     * 在增加权限
     * @param roleId
     * @param permIds
     */
    void addRolePerm(@Param("roleId") Integer roleId,@Param("permIds") int[] permIds);

    /**
     * 用户名称显示
     * @param username
     * @return
     */
    List<TreeResultUtil> getPerms(@Param("username") String username);
}
