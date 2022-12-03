package com.docker.gateway;

import com.docker.common.utils.IPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;


@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApp {
    private final static Logger LOGGER = LoggerFactory.getLogger(GatewayApp.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(GatewayApp.class);
        ConfigurableEnvironment env = ctx.getEnvironment();
        String port = env.getProperty("server.port");
        String serverName = env.getProperty("spring.application.name");
        String hostIp = IPUtil.ipv4();
        LOGGER.info("********************************");
        LOGGER.info("* {} 服务启动成功...", serverName);
        LOGGER.info("* 服务地址:http://{}:{}", hostIp, port);
        LOGGER.info("********************************");
    }
}
