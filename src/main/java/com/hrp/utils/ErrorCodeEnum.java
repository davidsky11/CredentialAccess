package com.hrp.utils;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * ErrorCodeEnum
 *
 * @author KVLT
 * @date 2017-09-21.
 */
public enum ErrorCodeEnum {

    /**
     * C 开头对应 客户端接口异常
     */
    C_OCX_NOT_LOAD_VOUCHER_104("104", "OCX中未加载凭证"),
    C_OCX_NOT_INITIALIZED_105("105", "OCX未进行初始化"),
    C_SIGN_PLACE_NULL_106("106", "签名位置为空"),
    C_CERT_ID_NULL_107("107", "证书ID为空"),
    C_VOUCHER_ID_NULL_108("108", "凭证编号不存在"),
    C_SIGN_PLACE_SIGNED_109("109", "该签名位置已签名"),
    C_VOUCHER_INDEX_OUT_110("110", "凭证索引越界"),
    C_PROFILE_READ_FAILED_111("111", "读取配置文件失败，请检查配置文件是否存在"),
    C_VOUCHER_SERVER_UNCONNECTED_112("112", "连接凭证服务器失败"),
    C_PACKET_FORMAT_ERROR_113("113", "获取报文格式错误"),
    C_SEAL_FORMAT_ERROR_114("114", "印章格式错误"),
    C_START_VOUCHER_INDEX_OUT_115("115", "起始凭证索引越界"),
    C_END_VOUCHER_INDEX_OUT_116("116", "终止索引越界"),
    C_SEAL_PLACE_SIGNED_117("117", "该签章位置已签章"),
    C_BASE64_FAIL_118("118", "Base64失败"),
    C_VOUCHER_TEMPLATE_NULL_119("119", "凭证模板不存在"),
    C_SEAL_DLL_LOAD_FAIL_120("120", "印章动态库加载失败"),
    C_VOUCHER_TEMP_SEAL_NO_CONFIG_121("121", "凭证模板签章位置表未配置或输入凭证类型不存在"),
    C_VOUCHER_TEMP_SIGN_NO_CONFIG_122("122", "凭证模板签名位置表未配置或输入凭证类型不存在"),
    C_RESOLVE_SEAL_FAIL_123("123", "解析已签章信息失败"),
    C_RESOLVE_LOG_PACKGET_FAIL_124("124", "解析日志报文失败"),
    C_SHOW_SEAL_ERROR_125("125", "显示签章信息发生错误"),
    C_VERIFY_SEAL_ERROR_126("126", "验章过程发生错误"),
    C_FIRST_PAGE_127("127", "已是第一联"),
    C_LAST_PAGE_128("128", "已是末联"),
    C_VOUCHER_DATA_NULL_129("129", "凭证数据不存在"),
    C_NO_VOUCHER_PAGE_130("130", "无此凭证联"),
    C_MODIFY_PIN_FAIL_131("131", "修改Pin码失败"),
    C_FETCH_VERSION_FAIL_132("132", "获取版本信息失败"),
    C_OCX_LASTEST_VERSION_133("133", "当前OCX已经是最新版本"),
    C_DLL_FUNC_URL_NULL_134("134", "动态库中函数地址不存在"),
    C_VERIFY_SEAL_ORIGINAL_FALSIFY_135("135", "验章时发现原文被篡改"),
    C_SEAL_SYSTEM_NO_ADAPTED_136("136", "未适配的印章系统"),

    /**
     * S 开头对应 服务端接口异常
     */
    S_UNDEFINED_EXCEPTION_999("EVS999", "未定义异常信息"),
    S_INITIALIZED_PARAM_ERROR_001("EVS001", "初始化系统控制参数异常"),
    S_LOCAL_QUEUE_NO_CONFIG_002("EVS002", "未配置本地队列"),
    S_CONNECT_REMOTE_QUEUE_FAIL_003("EVS003", "获取远程队列失败"),
    S_PARAM_ILLEGAL_100("EVS100", "参数不合法"),
    S_YEAR_ILLEGAL_103("EVS103", "业务年度不合法"),
    S_PARAM_NULL_111("EVS111", "参数存在空值"),
    S_VOUCHER_TYPE_NO_AUTHORITY_112("EVS112", "凭证类型无对应证书id权限");


    private String code;
    private String message;

    ErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 序列化enum
     * @return
     */
    @JsonValue
    private Map<String, Object> serialize() {
        Map<String, Object> valueMap = new HashMap<String, Object>();
        valueMap.put("code", this.code);
        valueMap.put("message", this.message);
        return valueMap;
    }

    public static Map<String, String> toMap() {
        Map<String, String> dataMap = new TreeMap<String, String>();
        for (ErrorCodeEnum error : ErrorCodeEnum.values()) {
            dataMap.put(error.getCode(), error.getMessage());
        }
        return dataMap;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
