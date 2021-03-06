package com.hrp.utils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

/**
 * IPUtil
 *
 * @author KVLT
 * @date 2017-09-21.
 */
public final class IPUtil {
    private IPUtil() {
        throw new Error("工具类不能实例化！");
    }

    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        if (!StringUtil.isNullOrBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        } else {
            ip = request.getHeader("X-Forwarded-For");
            if (!StringUtil.isNullOrBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
                int index = ip.indexOf(44);
                return index != -1 ? ip.substring(0, index) : ip;
            } else {
                return request.getRemoteAddr();
            }
        }
    }

    public static List<String> getLocalIpList() throws Exception {
        ArrayList ips = new ArrayList();
        String hostName = "";
        InetAddress addr = InetAddress.getLocalHost();
        hostName = addr.getHostName();
        if (hostName.length() > 0) {
            InetAddress[] addrs = InetAddress.getAllByName(hostName);
            int length = addrs.length;
            if (length > 0) {
                for (int i = 0; i < length; ++i) {
                    ips.add(addrs[i].getHostAddress());
                }
            }
        }

        return ips;
    }

}
