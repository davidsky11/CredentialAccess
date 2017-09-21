package com.hrp;

/**
 * Constant
 *
 * @author KVLT
 * @date 2017-09-21.
 */
public class Constant {

    /**
     * C 开头表示客户端接口地址/方法
     */
    // 设置电子凭证库服务地址
    public static final String C_E_VOUCHER_SERVICE_URL = "/realware/services/OCXService?wsdl";
    // 设置电子印章服务地址
    public static final String C_E_STAMP_SERVICE_URL = "/realware/services/AsspEStampService";

    /**
     * S 开头表示服务端地址/方法
     */
    // 3.1.1 写入客户端签章的凭证
    public static final String S_SAVE_STAMP_VOUCHER = "saveStampVoucher";
    // 3.1.2 写入客户端签名车凭证
    public static final String S_SAVE_SIGN_VOUCHER = "saveSignVoucher";
    // 3.1.3 写入指定位置服务器签章的凭证
    public static final String S_SIGN_STAMP_BY_NOS = "signStampByNos";
    // 3.1.4 写入指定位置服务器签名的凭证
    public static final String S_SIGN_BY_NOS = "signByNos";
    // 3.1.5 写入并发送指定位置服务器签章的凭证
    public static final String S_SIGN_STAMP_BY_NOS_AND_SEND = "signStampByNosAndSend";
    // 3.1.6 写入并发送指定位置服务器签名的凭证
    public static final String S_SIGN_BY_NOS_AND_SEND = "signByNosAndSend";
    // 3.1.7 写入并发送服务器签章的凭证(不建议使用)
    public static final String S_WRITE_VOUCHER = "writeVoucher";
    // 3.1.8 写入并发送服务器签名的凭证（不建议使用）
    public static final String S_SAVE_AND_SEND_VOUCHER = "saveAndSendVoucher";

    // 3.2.1 查询未签收的凭证
    public static final String S_READ_VOUCHER_AGAIN = "readVoucherAgain";
    // 3.2.2 批量查询凭证状态
    public static final String S_BATCH_QUERY_ALL_VOUCHER_STATUS = "batchQueryAllVoucherStatus";
    // 3.2.3 批量查询被退回的凭证号（接收失败、签收失败、签收退回）
    public static final String S_BATCH_QUERY_VOUCHER_NOS_By_BACK_STATUS = "batchQueryVoucherNosByBackStatus";
    // 3.2.4 指定凭证类型查询盖章位置及名称
    public static final String S_QUERY_STAMP_POSITION_WITH_NAME = "queryStampPositionWithName";


}
