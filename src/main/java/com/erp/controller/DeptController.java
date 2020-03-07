package com.erp.controller;

import com.erp.pojo.Dept;
import com.erp.service.DeptService;
import com.erp.util.EasyUiResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Controller
@RestController//是@Controller+@ResponseBody
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @RequestMapping("findAll")
    public List<Dept> findAll(){
        return deptService.findAll();
    }

    @RequestMapping("remove")
    public boolean remove(Integer[] ids){
        deptService.remove(ids);
        return true;
    }

    @RequestMapping("update")
    public boolean update(Dept dept){
        deptService.update(dept);
        return true;
    }

    @RequestMapping("findById")
    public Dept findById(int id){
        return deptService.findById(id);
    }

    @RequestMapping("add")
    //@ResponseBody//返回json
    public boolean add(Dept dept){
        deptService.add(dept);
        return true;
    }

    @RequestMapping("/page")
    //@ResponseBody//返回json对象
    public EasyUiResultUtil<Dept> page(@RequestParam(defaultValue = "1") int pageNum,
                                       @RequestParam(defaultValue = "2") int pageSize){
        return deptService.page(pageNum,pageSize);
    }

}
