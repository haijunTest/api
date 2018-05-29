//package com.quatz.config;
//
//import com.dangdang.ddframe.job.event.JobEventConfiguration;
//import com.dangdang.ddframe.job.event.rdb.JobEventRdbConfiguration;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.annotation.Resource;
//import javax.sql.DataSource;
//
///**
// * class $classname
// *
// * @author haijun
// * @date 2018/5/7, 9:55
// */
//@Configuration
//public class JobEventConfig {
//
//    @Resource
//    @Qualifier("ejDataSource")
//    private DataSource dataSource;
//
//    @Bean
//    public JobEventConfiguration jobEventConfiguration() {
//        return new JobEventRdbConfiguration(dataSource);
//    }
//}
