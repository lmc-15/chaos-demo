package com.lmc.demo.controller;

import com.dev.core.model.Null;
import com.dev.core.model.Result;
import com.dev.lock.annotation.ChaosLock;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @ClassDescription:
 * @JdkVersion: 1.8
 * @Author: lmc
 * @email: mingchao.liu@greatdb.com
 * @Created: 2024/7/13 16:40
 */
@RestController
@RequestMapping(value = "/v1/lock")
@Api(tags = {"分布式锁测试"})
public class LockController {
    private static final Logger log = LoggerFactory.getLogger(LockController.class);

    @ApiOperation(value = "分布式锁测试接口")
    @GetMapping("")
    @ChaosLock(name = "demoTest")
    Result<Null> lock() throws InterruptedException {
        int i = 5;
        while (i > 0) {
            i--;
            TimeUnit.SECONDS.sleep(1);
            log.info("demoTest上锁倒计时时间[{}]", i);
        }
        return Result.ok();
    }

    @ApiOperation(value = "分布式锁测试接口")
    @GetMapping("/test2")
    @ChaosLock(name = "demoTest")
    Result<Null> lock1() {
        log.info("test2获取所成功");
        return Result.ok();
    }
}
