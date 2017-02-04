package com.wawa.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.codec.binary.Hex;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VerifyCodeUtil {

	private static Logger logger = LoggerFactory.getLogger( VerifyCodeUtil.class );
	
	
	static Random r = new Random();
	
	public static String verifyCode(int length) {
		String randomNum = "";
		for (int i = 0; i < length; i ++) {
			randomNum += r.nextInt(10);
		}
		return randomNum;
	}
	
	private static Map<String, String> parseResult(String result) {
		Map<String, String> map = new HashMap<>();
		String[] params =result.split( "&");
		for (String param : params) {
			String[] split = param.split( "=");
			map.put(split[0], split[1]);
		}
		return map;
	}
	
	public static boolean sendMessage(String msisdn, String msgContent) {
		String mlinkUrl="http://esms100.10690007.net/sms/mt";
		String mlinkSpid="9864";
		String mlinkPwd="0CnZCCrR";		
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpPost post = new HttpPost(mlinkUrl);
			List<BasicNameValuePair> params = new ArrayList<> ();
			params.add(new BasicNameValuePair("command", "MT_REQUEST"));
			params.add(new BasicNameValuePair("spid", mlinkSpid));
			params.add(new BasicNameValuePair("sppassword", mlinkPwd));
			params.add(new BasicNameValuePair("da", msisdn));
			params.add(new BasicNameValuePair("dc", "15"));
			params.add(new BasicNameValuePair("sm", Hex.encodeHexString(msgContent.getBytes("GBK"))));
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params);
			post.setEntity(entity);
			CloseableHttpResponse response = httpClient.execute(post);
			String result = EntityUtils.toString(response.getEntity(), "GBK");
			logger.info("sms server result:"+result);
			Map<String, String> parseResult = parseResult(result);
			if ("000".equals(parseResult.get("mterrcode"))) {
				return true;
			}
		} catch (Exception e) {
			logger.error("{msisdn: "+msisdn + " ,msgContent:"+msgContent+"}");
			logger.error("message send error: ", e.getMessage());
		}
		return false;
	}
}
