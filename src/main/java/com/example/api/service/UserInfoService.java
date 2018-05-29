package com.example.api.service;

import com.example.api.mapper.HaijunTblEmployeeMapper;
import com.example.api.model.HaijunTblEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * class $classname
 *
 * @author haijun
 * @date 2018/4/19, 13:32
 */
@Service
public class UserInfoService {

    @Autowired
    private HaijunTblEmployeeMapper haijunTblEmployeeMapper;

    public HaijunTblEmployee getUserInfo(Integer id) {
        HaijunTblEmployee haijunTblEmployee = haijunTblEmployeeMapper.selectByPrimaryKey(id);
        if (Objects.isNull(haijunTblEmployee)) {
            return null;
        }
        return haijunTblEmployee;
    }

    public Integer confirmInfo(Integer id, String password) {
        HaijunTblEmployee haijunTblEmployee = new HaijunTblEmployee();
        haijunTblEmployee.setId(id);
        haijunTblEmployee.setPassword(password);
        int count = haijunTblEmployeeMapper.selectCount(haijunTblEmployee);
        return count;
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public String saveUserInfo(HaijunTblEmployee haijunTblEmployee) {
        int insert = haijunTblEmployeeMapper.insert(haijunTblEmployee);
        if (insert != 1) {
            return "fail";
        }
        return "success";
    }
}
