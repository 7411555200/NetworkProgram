package com.gd.network.command;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: BinBin
 * @Date: 2023/05/12/12:41
 * @Description:
 */
@SpringBootApplication
@MapperScan("com.gd.network.command.mapper")
public class CommandApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommandApplication.class, args);
    }
}
