//package com.quatz.config;
//
//import com.dangdang.ddframe.job.api.simple.SimpleJob;
//import com.dangdang.ddframe.job.config.JobCoreConfiguration;
//import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
//import com.dangdang.ddframe.job.event.JobEventConfiguration;
//import com.dangdang.ddframe.job.lite.api.JobScheduler;
//import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
//import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
//import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
//import com.quatz.job.UserInfoSimpleJob;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.annotation.Resource;
//
///**
// * class $classname
// *
// * @author haijun
// * @date 2018/5/7, 9:36
// */
//@Configuration
//public class SimpleJobConfig {
//
//    @Resource
//    private ZookeeperRegistryCenter zookeeperRegistryCenter;
//    @Resource
//    private JobEventConfiguration jobEventConfiguration;
//
//    @Bean
//    public SimpleJob simpleJob() {
//        return new UserInfoSimpleJob();
//    }
//
//    @Bean(initMethod = "init")
//    public JobScheduler userSimpleJob(final SimpleJob userSimpleJob,
//                                      @Value("${couponExpiringSimpleJob.cron}") final String cron,
//                                      @Value("${couponExpiringSimpleJob.shardingTotalCount}") final int shardingTotalCount,
//                                      @Value("${couponExpiringSimpleJob.shardingItemParameters}") final String shardingItemParameters) {
//        return new SpringJobScheduler(userSimpleJob,zookeeperRegistryCenter,getLiteJobConfiguration(userSimpleJob.getClass(),cron,shardingTotalCount,shardingItemParameters),jobEventConfiguration);
//    }
//
//    private LiteJobConfiguration getLiteJobConfiguration(final Class<? extends SimpleJob> userInfoSimpleJob,
//                                                         final String cron,
//                                                         final int shardingTotalCount,
//                                                         final String shardingItemParameters) {
//        return LiteJobConfiguration.newBuilder(new SimpleJobConfiguration(
//                JobCoreConfiguration.newBuilder(userInfoSimpleJob.getName(), cron, shardingTotalCount)
//                        .shardingItemParameters(shardingItemParameters).build(),
//                userInfoSimpleJob.getCanonicalName())).overwrite(true).build();
//    }
//}
