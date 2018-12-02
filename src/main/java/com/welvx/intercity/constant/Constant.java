package com.welvx.intercity.constant;

//wx支付
public class Constant {
    public static final String DOMAIN = "https://i-test.com.cn";

    public static final String APP_ID = "wx4c12176f068ed8c9";

    public static final String APP_SECRET = "36015cb7cdbec9eb0e7bc0e1bd4725b6";

    public static final String APP_KEY = "填写自己的";

    public static final String MCH_ID = "填写自己的";  //商户号

    public static final String URL_UNIFIED_ORDER = "https://api.mch.weixin.qq.com/pay/unifiedorder";

    public static final String URL_NOTIFY = Constant.DOMAIN + "/wxpay/views/payInfo.jsp";

    public static final String TIME_FORMAT = "yyyyMMddHHmmss";

    public static final int TIME_EXPIRE = 2;  //单位是day
}
