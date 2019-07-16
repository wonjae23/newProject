/**
 * Copyright (c) 2013 EPASSKOREA. All Rights Reserved.
  * Project: Epasskorea B2B LMS Renewal(2013.07~)
*/
package com.won.project.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Class Name : StringUtil
 * Description : String Utils
 * Modification Information
 * Date			    Autor					Contents
 * -----------  --------------  --------------------------------
 * 2013.10.00   dolcoms	 	    	
 * 
 * @author: dolcoms
 * @version: 1.0
*/
public class StringUtil {
	private final static Log log = LogFactory.getLog("StringUtil");
	/**
	 * String null check
	 * String.valueOf() 硫붿꽌�뱶瑜� �씠�슜�븳 null媛� 泥댄겕�뒗 null媛� �옄泥대�� String�쑝濡� 諛섑솚 �븯湲곕븣臾몄뿉 true瑜� 由ы꽩�븯吏� �븡�뒗�떎.
	 * String�삎 null媛� 異붽�
	 * @param str
	 * @return
	 */
	public static boolean getNullCheck(String str){
		if(("null").equals(str) || str == null || ("").equals(str))
			return true;
		else return false;
	}
	/**
	 * 荑쇰━ �듅�닔臾몄옄 寃��깋
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
	 * 荑쇰━ �듅�닔臾몄옄 寃��깋 �썑 由ы꽩 媛믪� �떎�떆 �썝�옒 臾몄옄濡� 蹂�寃�
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
	 * �븳湲� �씤肄붾뵫 蹂��솚
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
	 * commandMap�쓽 媛믪쓣 QueryString �삎�떇�쑝濡� �깮�꽦 諛섑솚�븳�떎.
	 * @param commandMap
	 * @param removeParams �젣嫄고븯怨좎옄�븯�뒗 �뙆�씪硫뷀꽣紐� (ex param1,params2,param3...)
	 * @return
	 */
	public static String getQueryString(Map<String, Object> commandMap, String removeParams){
		// 湲곕낯 �젣嫄� 媛� 
		//removeParams = "," + removeParams + ",authsGrade,lang_code,";
		removeParams = "," + removeParams + ",";
		
		StringBuilder result = new StringBuilder();
		for(String key : commandMap.keySet()){
			// �젣嫄곌컪�뿉 �냽�븯吏� �븡怨� 諛곗뿴媛믪씠 �븘�땺 寃쎌슦留� �뙆�씪硫뷀꽣濡� �깮�꽦
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
	 * @param type : template(T)/content(C)/webpage(W)/layout(L) 援щ텇 
	 * @param maxKey : last key
	 * @return
	 */
	public static String getMakeTCPCodeKey(String type, String maxKey){
		
		if(!getNullCheck(type) && !getNullCheck(maxKey)){
			int tmp = Integer.valueOf(maxKey.replace(type, ""));   //援щ텇�젣嫄�
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
	    	/*
			try { 
	    		//buf.append(java.net.URLEncoder.encode(key));
				buf.append(new String(key.getBytes("8859_1"), "EUC-KR"));	    		
				buf.append('=');				
				//buf.append(java.net.URLEncoder.encode(value));
				buf.append(new String(value.getBytes("8859_1"), "EUC-KR"));				
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			*/
			//System.out.println("## �씤肄붾뵫 key==> "+key);
	    //	System.out.println("## �씤肄붾뵫 value ==> "+value);
	    	//log.info("##[FileDownloadView] ==> value : " + value);
	    }
	    System.out.println("## encoding ==> "+System.getProperty("file.encoding"));
	   
	    return buf.toString();
	  }

	
	/**
	 * �뀈�룄 由ъ뒪�듃
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
	 * String[]�삎�쓣 String�삎�쑝濡�
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
	 * Xss  �븘�꽣 �쟻�슜
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
	 * 媛믪껜�겕 鍮덈Ц�옄�씠嫄곕굹 null 媛앹껜�씤 寃쎌슦 鍮덈Ц�옄 諛섑솚
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