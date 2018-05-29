//package com.quatz.job;
//
//import com.dangdang.ddframe.job.api.ShardingContext;
//import com.dangdang.ddframe.job.api.simple.SimpleJob;
//import com.example.api.model.HaijunTblEmployee;
//import com.example.api.service.UserInfoService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//
///**
// * class $classname
// *
// * @author haijun
// * @date 2018/5/7, 9:30
// */
//@Slf4j
//public class UserInfoSimpleJob implements SimpleJob {
//
//    @Autowired
//    private UserInfoService userInfoService;
//
//    @Override
//    public void execute(final ShardingContext shardingContext) {
//        HaijunTblEmployee haijunTblEmployee = new HaijunTblEmployee();
//        haijunTblEmployee.setId(6);
//        haijunTblEmployee.setPassword("666");
//        String s = userInfoService.saveUserInfo(haijunTblEmployee);
//        log.info("saveUserInfo is ={}",s);
//    }
//}
