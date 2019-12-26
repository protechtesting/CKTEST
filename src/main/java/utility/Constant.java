package utility;

public final class Constant {
	//public static final String baseURL="https://staging.cashkaro.com/";
	//public static final String BASEURL="https://paytmcashback.com/";
	public static final String BASEURL=Utils.getConfigData(0, "FrontendURL");
	
	//public static final String BASEURL="http://wpdevchn15.com/";
	//Beta Env URL = https://cashkaro.iamsavings.co.uk/
	public static final String WINDOWCAPTCHAURL=BASEURL+"/getcode.php?page=join";
	public static final String POPUPCAPTCHAURL=WINDOWCAPTCHAURL+"p";
	public static final String OTPURL=BASEURL+"/getcode.php?page=signupotp_app&mobile=9456455645";
	public static final String LOGINCAPTCHAURL="";
	public static final String LOGINOTPURL="";
	public static final String BETAADMIN=Utils.getConfigData(0, "AdminURL");;
	
}
