package com.erp.service;

import com.erp.pojo.Role;
import com.erp.util.EasyUiResultUtil;
import com.erp.util.TreeResultUtil;

import java.util.List;

public interface RoleService {
    /**
     *
     * @return
     */
    List<TreeResultUtil> permissionList();

    /**
     * 删除
     * @param ids
     */
    void remove(int[] ids);

    /**
     *
     * @param role
     */
    void update(Role role);

    /**
     *
     * @param role
     */
    void add(Role role);

    /**
     *
     * @param role
     * @param pageNum
     * @param pageSize
     * @return
     */
    EasyUiResultUtil<Role> page(Role role, int pageNum, int pageSize);

    /**
     * 数据回显
     * @return
     */
    List<Role> findAll();

    /**
     * 根据id查询所有拥有的权限id
     * @param roleId
     * @return
     */
    List<Integer> findPermissionIdsByRoleId(int roleId);

    /**
     * 修改权限
     * @param roleId
     * @param permIds
     */
    void updatePerm(Integer roleId, int[] permIds);

}
