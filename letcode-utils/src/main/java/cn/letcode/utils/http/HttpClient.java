package cn.letcode.utils.http;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * HttpClient 工具
 * 
 * @author chensj
 *
 */
public class HttpClient {
	private static CloseableHttpClient	httpclient;
	private static String				default_char_set	= "GBK";

	/**
	 * HttpClient Get 请求方法(默认返回数据编码集为 GBK
	 * 
	 * @param url
	 *            请求地址
	 * @return 请求结果
	 * @throws IOException 抛出IO异常
	 */
	public static String requestGet(String url) throws IOException {
		return requestGet(url, default_char_set);
	}

	/**
	 * HttpClient Get 请求方法
	 * 
	 * @param url
	 *            请求地址
	 * @param encoding
	 *            返回数据编码集
	 * @return 请求返回结果
	 * @throws IOException 数据流异常
	 */
	public static String requestGet(String url, String encoding) throws IOException {
		httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		try {
			CloseableHttpResponse response = httpclient.execute(httpGet);
			return EntityUtils.toString(response.getEntity(), encoding);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpclient.close();
		}
		return "";
	}
}
