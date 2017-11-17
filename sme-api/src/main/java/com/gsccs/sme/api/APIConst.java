package com.gsccs.sme.api;

/**
 * 公用常量类。
 * 
 * @author x.d zhang
 * @since 1.0
 */
public abstract class APIConst {

	
	/** TOP默认时间格式 **/
	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/** TOP Date默认时区 **/
	public static final String DATE_TIMEZONE = "GMT+8";

	/** UTF-8字符集 **/
	public static final String CHARSET_UTF8 = "UTF-8";

	/** GBK字符集 **/
	public static final String CHARSET_GBK = "GBK";

	/** TOP JSON 应格式 */
	public static final String FORMAT_JSON = "json";
	/** TOP XML 应格式 */
	public static final String FORMAT_XML = "xml";

	/** MD5签名方式 */
	public static final String SIGN_METHOD_MD5 = "md5";
	/** HMAC签名方式 */
	public static final String SIGN_METHOD_HMAC = "hmac";

	/** TQL分隔符 */
	public static final String TQL_SEPERATOR = "top_tql_seperator";

	/** 授权地址 */
	public static final String PRODUCT_CONTAINER_URL = "";

	/** SDK版本号 */
	public static final String SDK_VERSION = "top-sdk-java-20150301";

	/** 返回的错误码 */
	public static final String ERROR_RESPONSE = "error_response";
	public static final String ERROR_CODE = "code";
	public static final String ERROR_MSG = "msg";
	public static final String ERROR_SUB_CODE = "sub_code";
	public static final String ERROR_SUB_MSG = "sub_msg";

	
	/** 请求参数不完整 **/
	public static final String ERROR_CODE_0001 = "error0001";
	public static final String ERROR_MSG_0001 = "请求参数不完整";
	
	/** 数据已存在 **/
	public static final String ERROR_CODE_0002 = "error0003";
	public static final String ERROR_MSG_0002 = "数据已存在！";
	
	/** 数据不存在 **/
	public static final String ERROR_CODE_0003 = "error0002";
	public static final String ERROR_MSG_0003 = "数据不存在";
	
	/** 退货单不存在 **/
	public static final String ERROR_CODE_0004 = "error0004";
	public static final String ERROR_MSG_0004 = "退货单不存在";
	
	/**
     * 订单状态
     * <li>-------ORDER_NO_CREATE_PAY(没有创建支付宝交易,1)
     * <li>ORDER_DESTROY(订单销毁-1)
	 * <li>ORDER_WAIT_BUYER_PAY(等待买家付款,1)
	 * <li>ORDER_WAIT_SELLER_SEND_GOODS(等待卖家发货,即:买家已付款,2)
	 * <li>ORDER_WAIT_BUYER_CONFIRM_GOODS(等待买家确认收货,即:卖家已发货,3)
	 * <li>ORDER_BUYER_SIGNED(买家已签收,货到付款专用,4)
	 * <li>ORDER_CLO SED(付款以后用户退款成功，交易自动关闭,5)
	 * <li>ORDER_PAY_PENDING(国际信用卡支付付款确认中,6)
	 * <li>ORDER_FINISHED(交易成功,0)
     */
	public static final String ORDER_DESTROY="-1";
    public static final String ORDER_WAIT_BUYER_PAY ="1";
    public static final String ORDER_WAIT_SELLER_SEND_GOODS ="2";
    public static final String ORDER_WAIT_BUYER_CONFIRM_GOODS ="3";
    public static final String ORDER_BUYER_SIGNED ="4";
    public static final String ORDER_CLOSED ="5";
    public static final String ORDER_PAY_PENDING ="6";
    public static final String ORDER_FINISHED ="0";
    
    /**
     * 退单状态
     * <li>RETURNORDER_BUYER_APPLY(买家创建退单,等待卖家处理1)
	 * <li>RETURNORDER_SELLER_AGREE_REFUND(卖家同意退货,等待买家发货。2)
	 * <li>RETURNORDER_BUYER_REFUND(买家已经发货,等待卖家确认收货。3)
	 * <li>RETURNORDER_SELLER_AGREE_MOMEY(卖家确认收货,退款成功。0)
     */
    public static final String RETURNORDER_BUYER_APPLY="1";
    public static final String RETURNORDER_SELLER_AGREE_REFUND="2";
    public static final String RETURNORDER_BUYER_REFUND="3";
    public static final String RETURNORDER_SELLER_AGREE_MOMEY="0";
    
    /**
     * 产品是否理解上线
     * <li>PRODUCT_STATUS_OK(产品是立即上线)</li>
     * <li>PRODUCT_STATUS_NO(产品否立即上线)</li>
     */
    public static final String PRODUCT_STATUS_OK="0";
    public static final String PRODUCT_STATUS_NO="1";
    
    /**
     * 配送方式的类型 0 货到付款 1 先付款后发货
     */
    public static final String DELIVERTYPE_HASCOD_COD_OK="0";
    public static final String DELIVERTYPE_HASCOD_COD_NO="1";
    
    /**
     * 配送方式状态 0=关闭  1=开启
     */
    public static final String DELIVERTYPE_STATUS_OK="1";
    public static final String DELIVERTYPE_STATUS_NO="0";
    
    
    /**
     * 支付途径
     **/
    public static final String PAYMENT_TYPE_ALIPAY="alipay";
    public static final String PAYMENT_TYPE_UNIONPAY="unionpay";
    public static final String PAYMENT_TYPE_WXPAY="wxpay";
    
}
