package com.hrp.client;

import com.hrp.Constant;
import org.eclipse.swt.SWT;
import org.eclipse.swt.ole.win32.OleAutomation;
import org.eclipse.swt.ole.win32.OleControlSite;
import org.eclipse.swt.ole.win32.OleFrame;
import org.eclipse.swt.ole.win32.Variant;
import org.eclipse.swt.widgets.Shell;

/**
 * AsspOcx
 *
 * @author KVLT
 * @date 2017-09-21.
 */
public class AsspOcx {

    private static final String GETVOUCHERSTAMP = "";

    private OleFrame _frame;  // 盛放ocx的最外层容器
    private OleControlSite _site;  // 存放ocx的空间，最后会放入oleframe中去
    private OleAutomation _auto;  // 用于执行方法
    private Shell shell;
    private String url;

    public AsspOcx() {}

    public AsspOcx(Shell shell) {
        this.shell = shell;
        _frame = new OleFrame(shell, SWT.BORDER);
        _site = new OleControlSite(_frame, SWT.NONE, "{4FC4CDDF-84E5-437C-8527-B23F6D70866C}");
        _auto = new OleAutomation(_site);
        execActiveMethod("Initialize", new Object[]{url});  // 初始化OCX
    }

    /**
     * 封装获取签章信息方法
     * @param certID
     * @param admDivCode
     * @param stYear
     * @param vtCode
     * @param stamp
     * @param voucher
     * @return
     */
    public String getVoucherStamp(String certID, String admDivCode, long stYear, String vtCode, String stamp, String voucher) {
        Variant v = execActiveMethod(AsspOcx.GETVOUCHERSTAMP, new Object[]{certID, admDivCode, new Long(stYear), vtCode, stamp, voucher});

        if (null == v) {
            return null;
        } else {
            return v.getString();
        }
    }

    /**
     * 封装执行OCX方法
     * @param methodName
     * @param params
     * @return
     */
    public Variant execActiveMethod(String methodName, Object[] params) {
        int[] methodIDs = _auto.getIDsOfNames(new String[]{methodName});
        int activeXMethodID = methodIDs[0];
        Variant[] paramVariant = null;
        if (params == null) {
            paramVariant = new Variant[0];
        } else {
            paramVariant = new Variant[params.length];
        }

        for(int i=0,n=params.length; i<=n-1; i++){
            if( params[i] == null ){
                paramVariant[i] = Variant.NULL;
            }else if( params[i] instanceof String ){
                paramVariant[i] = new Variant((String)params[i]);
            } else if( params[i] instanceof Long  ){
                Long l = (Long)params[i];
                paramVariant[i] = new Variant( l.longValue() );
            }else if( params[i] instanceof Short ){
                Short l = (Short)params[i];
                paramVariant[i] = new Variant( l.shortValue() );
            }else if( params[i] instanceof Integer ){
                Integer l = (Integer)params[i];
                paramVariant[i] = new Variant( l.intValue() );
            }
        }
        Variant variant = _auto.invoke(activeXMethodID, paramVariant);
        return variant;
    }

    public static void main(String[] args) {
        String certID = "";
        String admDivCode = "";
        long stYear = 2017;
        String vtCode = "";
        String stamp = "";
        String voucher = "";
        String s = Constant.C_E_STAMP_SERVICE_URL;

        AsspOcx ocxOperator = new AsspOcx();
        String signedXml = ocxOperator.getVoucherStamp(certID, admDivCode, stYear, vtCode, new String(stamp), new String(voucher));
    }
}
