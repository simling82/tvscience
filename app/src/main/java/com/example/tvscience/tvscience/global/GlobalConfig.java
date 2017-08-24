package com.example.tvscience.tvscience.global;
/**
 * 全局变量
 * @author admin
 *
 */
public class GlobalConfig {
//	public static final String HTTP_URL = "http://gdsc.cmshop.net/kpmh/index.php?";//接口头
	public static final String HTTP_URL = "http://172.16.147.83:8080/kpmh/goods/";

	public static final String GRIDLIST = HTTP_URL + "search.api?lIndex=0&curr=0&by=playtime&order=asc";

	public static final String ALWAYS_PUT = HTTP_URL + "search/pages.api?lIndex=0&start=0&by=playtime&order=asc&curr:=0&size=10";

}
