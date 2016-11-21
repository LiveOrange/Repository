package com.taorui.controller.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * java根据url获取json对象
 * 
 * @author openks
 * @since 2013-7-16 需要添加java-json.jar才能运行
 */
public class GetPlaceByIp {
	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONObject readJsonFromUrl(String url) throws IOException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd) + "";
			System.out.println(jsonText);
			// JSONObject a = JSONObject(jsonText);
			JSONObject json = JSONObject.fromObject(jsonText);
			return json;
		} finally {
			is.close();
			// System.out.println("同时 从这里也能看出 即便return了，仍然会执行finally的！");
		}
	}

	public static void main(String[] args) throws IOException {
		// 这里调用百度的ip定位api服务 详见
		// http://api.map.baidu.com/lbsapi/cloud/ip-location-api.htm
		JSONObject json = readJsonFromUrl(
				"http://api.map.baidu.com/location/ip?ak=F454f8a5efe5e577997931cc01de3974&ip=202.198.16.3");
		System.out.println(json);
		System.out.println(((JSONObject) json.get("content")).get("address"));
	}
}
