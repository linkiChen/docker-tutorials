package com.docker.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class IPUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(IPUtil.class);

    public static String ipv4() {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface anInterface = interfaces.nextElement();
                // 回环接口 || 子接口 || 未运行
                if (anInterface.isLoopback() || anInterface.isVirtual() || !anInterface.isUp()) {
                    continue;
                }
                if (!anInterface.getDisplayName().contains("Intel") &&
                        !anInterface.getDisplayName().contains("Realtek")) {
                    continue;
                }
                Enumeration<InetAddress> addresses = anInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress ipAddress = addresses.nextElement();
                    if (ipAddress != null) {
                        if (ipAddress instanceof Inet4Address) {
                            return ipAddress.getHostAddress();
                        }
                    }
                }
                break;
            }
        } catch (SocketException e) {
            LOGGER.error("获取IP地址异常:", e);
        }
        return null;
    }
}
