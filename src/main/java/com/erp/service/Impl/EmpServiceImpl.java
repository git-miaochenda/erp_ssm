package com.erp.service.Impl;

import com.erp.mapper.EmpMapper;
import com.erp.mapper.EmpRoleMapper;
import com.erp.mapper.PermissionMapper;
import com.erp.pojo.Emp;
import com.erp.service.EmpService;
import com.erp.util.EasyUiResultUtil;
import com.erp.util.TreeResultUtil;
import com.erp.vo.EmpVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpRoleMapper empRoleMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public void remove(int[] ids) {
        //删除emp表
        empMapper.remove(ids);
        //删除emp_role表
        empRoleMapper.remove(ids);
    }

    @Override
    public void update(Emp emp, int[] roleIds) {
       //先修改emp表
        empMapper.update(emp);
        //在修改emp_role--修改多对多
        //先删除
        empRoleMapper.remove(new int[]{emp.getId()});
        //在增加
        empRoleMapper.add(emp.getId(),roleIds);
    }

    @Override
    public EmpVo findById(int id) {
        return empMapper.findById(id);
    }

    @Override
    public void add(Emp emp, int[] roleIds) {
        //先设置默认的密码 默认为手机号尾号和身份证号后四位
        String tel=emp.getTel();
        String idCardNo=emp.getIdCardNo();
        String password=tel.substring(tel.length()-4)+idCardNo.substring(idCardNo.length()-4);
        //在设置生日 出生年月：默认从身份证中获取
        String birthDate=idCardNo.substring(6,14);//钱不包括后包括
        StringBuilder stringBuilder =new StringBuilder(birthDate);
        stringBuilder.insert(6,"/").insert(4,"/");
        //把它们设置到emp中
        emp.setPassword(password);
        emp.setBirthDate(stringBuilder.toString());
        //再来执行增加
        empMapper.add(emp);
        //获取自动增长主键
        int empId= empMapper.getKey();
        //再向emp_role中增加
        empRoleMapper.add(empId,roleIds);
    }

    @Override
    public EasyUiResultUtil<EmpVo> page(EmpVo wheres, int pageNum, int pageSize) {
        return new EasyUiResultUtil<EmpVo>(empMapper.count(wheres)
                ,empMapper.page(wheres,(pageNum-1)*pageSize,pageSize));
    }

    @Override
    public Emp login(String username, String password) {
        return empMapper.login(username,password);
    }

    @Override
    public List<TreeResultUtil> getPerms(String username) {
        return permissionMapper.getPerms(username);
    }
}
