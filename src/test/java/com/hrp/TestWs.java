package com.hrp;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

/**
 * TestWs
 *
 * @author KVLT
 * @date 2017-09-21.
 */
public class TestWs {

    public static void main(String[] args) {
        Call call = null;
        try {
            String url = "http://127.0.0.1:8080/realware/services/AsspFinanceService";
            // 创建服务对象
            Service service = new Service();
            call = (Call) service.createCall();
            // 设置远程地址
            call.setTargetEndpointAddress(url);
            // 设置调用函数
            call.setOperationName("queryVoucherType");
            // 设置参数
            String param1CertId = "000000";
            String param2AdmdivCode = "500000";
            int param3Year = 2012;
            // 调用接口
            call.invoke(new Object[]{param1CertId, param2AdmdivCode, param3Year});
            System.out.println("调用成功");
        } catch (ServiceException e) {
            System.out.println("调用失败");
            e.printStackTrace();
        } catch (RemoteException e) {
            System.out.println("调用失败");
            e.printStackTrace();
        }
    }
}
