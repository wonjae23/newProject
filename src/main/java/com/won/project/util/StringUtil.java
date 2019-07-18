package com.won.project.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class StringUtil {
	private final static Log log = LogFactory.getLog("StringUtil");

	/**
	 * String null check
	 * String.valueOf() 메서드를 이용한 null값 체크는 null값 자체를 String으로 반환 하기때문에 true를 리턴하지 않는다.
	 * String형 null값 추가
	 * @param str
	 * @return
	 */
	public static boolean getNullCheck(String str){
		if(("null").equals(str) || str == null || ("").equals(str))
			return true;
		else return false;
	}
	
	/**
	 * 쿼리 특수문자 검색
	 * @param params
	 * @return
	 */
	public static String getQuerySpecialString(String str){
		String query="";
		
		if(!getNullCheck(str)){
			query = str.replace("!", "!!").replace("[", "![").replace("]", "!]").replace("%", "!%").replace("&", "!&");
		}		
		
		return query;
	}
	
	/**
	 * 쿼리 특수문자 검색 후 리턴 값은 다시 원래 문자로 변경
	 * @param params
	 * @return
	 */
	public static String getQuerySpecialStringBack(String str){
		String query="";
		
		if(!getNullCheck(str)){
			query = str.replace("![", "[").replace("!]", "]").replace("!%", "%").replace("!&", "&").replace("!!", "!");
		}		
		
		return query;
	}
	
	/**
	 * 한글 인코딩 변환
	 * @param params
	 * @return
	 */
	public static String getEncodingChange(String params){
		String rParam = "";
		try {
			rParam = new String(params.getBytes("8859_1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return rParam;
	}
	
	
	/**
	 * commandMap의 값을 QueryString 형식으로 생성 반환한다.
	 * @param commandMap
	 * @param removeParams 제거하고자하는 파라메터명 (ex param1,params2,param3...)
	 * @return
	 */
	public static String getQueryString(Map<String, Object> commandMap, String removeParams){
		// 기본 제거 값 
		//removeParams = "," + removeParams + ",authsGrade,lang_code,";
		removeParams = "," + removeParams + ",";
		
		StringBuilder result = new StringBuilder();
		for(String key : commandMap.keySet()){
			// 제거값에 속하지 않고 배열값이 아닐 경우만 파라메터로 생성
			if (removeParams.indexOf("," + key + ",") == -1){
				if(String.valueOf(commandMap.get(key)).startsWith("[Ljava.lang.String")){
					String[] valueArr = (String[]) commandMap.get(key);
					for(int i=0;i<valueArr.length;i++){
						result.append("&" + key + "=" + valueArr[i]);
					}						
				}else{
					result.append("&" + key + "=" + commandMap.get(key));
				}
			}
		}

		if (result.length() > 0)
			return result.toString().substring(1);
		else
			return "";
	}
	
	/**
	 * last key + 1 return
	 * @param type : template(T)/content(C)/webpage(W)/layout(L) 구분 
	 * @param maxKey : last key
	 * @return
	 */
	public static String getMakeTCPCodeKey(String type, String maxKey){
		
		if(!getNullCheck(type) && !getNullCheck(maxKey)){
			int tmp = Integer.valueOf(maxKey.replace(type, ""));   //구분제거
			String zStr = "";
			for(int i=0; i<(maxKey.length() - String.valueOf(tmp+1).length()-1); i++){
				zStr = zStr + "0";
			}
			
			return type + zStr + String.valueOf(tmp + 1);			
		}else{
			return type + "0000001";
		}
	}
	
	
	
	@SuppressWarnings("rawtypes")
	public static String url_encoding(java.util.Hashtable hash){
	    if ( hash == null ) throw new IllegalArgumentException("argument is null");
	    java.util.Enumeration enums = hash.keys();
	    StringBuffer buf = new StringBuffer();
	    boolean isFirst = true;
	    while(enums.hasMoreElements()){
	    	if (isFirst) isFirst = false;
	    	else buf.append('&');
	    	String key = (String)enums.nextElement();
	    	String value = (String)hash.get(key);
	    	
	    	buf.append(key);
			buf.append('=');
			//buf.append(value);			
			try {
				buf.append(java.net.URLEncoder.encode(value,"EUC-KR"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	    	
	    }
	    System.out.println("## encoding ==> "+System.getProperty("file.encoding"));
	   
	    return buf.toString();
	  }

	
	/**
	 * 년도 리스트
	 * @param start
	 * @param end
	 * @param seed
	 * @return
	 * @throws Exception
	 */
	public static List<Map<String, String>> descList(int start, int end, int seed) throws Exception{
		
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		
		Map<String, String> map;
		int addValue = end;
		for (int i = start ; i <= end ;)
		{
			map = new HashMap<String, String>();
			map.put("value", String.valueOf(addValue));
			map.put("text", String.valueOf(addValue));
			
			result.add(map);
			
			addValue = addValue - seed;
			i = i + seed;
		}
		
		return result;
	}
	
	/**
	 * String[]형을 String형으로
	 * @param obj
	 * @return returnStr
	 * @throws Exception
	 */
	public static String getStringField(Object obj) {
		String returnStr = "";

		if (obj != null) {
			if (obj.getClass().getCanonicalName().equals("java.lang.String[]")) {
				String[] tempObj =	(String[])obj;
				returnStr = tempObj[0];
			} else {
				returnStr = (String)obj;
			}
		} else {
			returnStr = null;
		}

		return returnStr;
	}
	
	/**
	 * Xss  필터 적용
	 * @param obj
	 * @return returnStr
	 * @throws Exception
	 */
	public static String cleanXSS(String value) {   

		value = value.replaceAll("(?i)&lt;script[^&gt;]*&gt;(.*?)&lt;/SCRIPT&gt;","");
		value = value.replaceAll("(?i)<script[^>]*>(.*?)</SCRIPT>","");
		
	     //value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");   

	     value = value.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");   

	     value = value.replaceAll("'", "&#39;");             

	     value = value.replaceAll("eval\\((.*)\\)", "");   

	     value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");   

	     value = value.replaceAll("(?i)script", "");   

	     return value;   

	 } 

	/**
	 * 값체크 빈문자이거나 null 객체인 경우 빈문자 반환
	 * @param obj
	 * @return returnStr
	 * @throws Exception
	 */
	public static String NVL(String string) {
		String result = null;
		
		if(string == null){
			result = "";
		}
		else if( "null".equals(string)){
			result = "";
		}
		else{
			result = string;
		}
		
		return result;
	}
	
	public static String NVL(Object obj) {
		String result = null;
		
		if(obj == null){
			result = "";
		}
		else if( "null".equals(obj)){
			result = "";
		}
		else{
			result = String.valueOf(obj);
		}
		
		return result;
	}
}