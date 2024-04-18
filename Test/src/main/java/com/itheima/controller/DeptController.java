package com.itheima.controller;

import com.itheima.anno.Log;
import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptService deptService;

    //private static Logger log = LoggerFactory.getLogger(DeptController.class);

    /*
        查询数据方法
     */
    //@RequestMapping(value = "/depts",method = RequestMethod.GET)//指定请求方式为GET
    @GetMapping
    public Result list(){
        log.info("查询全部部门数据");

        //调用service查询部门数据
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }


    /*
        删除部门
     */
    @Log
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除部门：{}",id);
        //调用service删除部门
        deptService.delete(id);
        return Result.success();
    }


    /*
        新增部门
     */
    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增部门：{}",dept);
        //调用service方法
        deptService.add(dept);
        return Result.success();
    }

    /*
        查询部门信息
     */
    @GetMapping("/{id}")
    public Result select(@PathVariable Integer id){
        log.info("根据id查询部门信息");
        //调用service查询方法
        Dept dept1 =  deptService.singleSelect(id);
        return Result.success(dept1);

    }

    /*
        修改部门信息
     */
    @Log
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("根据id修改部门信息:{}",dept.getId());
        //调用service修改方法
        deptService.singleUpdate(dept);
        return Result.success();
    }



}
