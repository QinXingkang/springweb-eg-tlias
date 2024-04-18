package com.itheima.service;

import com.itheima.pojo.Dept;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeptService {

    /*
        查询全部部门数据
     */
    List<Dept> list();

    /*
        删除部门
     */
    void delete(Integer id);


    /*
        新增部门
     */
    void add(Dept dept);

    /*
        修改部门信息
        1.根据id查询部门信息
     */
    Dept singleSelect(Integer id);


    /*
    修改部门信息
    2.修改部门
 */
    void singleUpdate(Dept dept);
}
