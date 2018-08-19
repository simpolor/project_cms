package com.simpolor.cms.util;

public class StringUtil {

	/***
	 * 입력된 String[]형의 문자열 배열을 String형으로 반환
	 * 기본값으로 ", "로 구분되어 리턴됩니다.
	 * @param strArr
	 * @return String
	 */
	public static String getStrArr(String[] strArr){
		return getStrArr(strArr, ", ");
	}
	
	/***
	 * 입력된 String[]형의 문자열 배열을 String형으로 반환 ( 구분자 사용가능 )
	 * 예)getString(new String[]{"일", "이", "삼"}, "|") ->반환값 : "일|이|삼"  
	 * @param strArr : 문자열 배열
	 * @param splitStr : 구분자
	 * @return String
	 */
	public static String getStrArr(String[] strArr, String splitStr){
		StringBuffer sb = new StringBuffer();
		try{
			for(int i=0 ; i<strArr.length; i++){
				if(!isEmpty(splitStr) && i > 0) sb.append(splitStr);
				sb.append(strArr[i]);
			}
			return sb.toString();
		}catch (Exception e) { 
			return null;
		}
	}
	
	/***
	 * 입력된 String형의 문자가 null 또는 공백("")인지 여부를 확인 
	 * @param str
	 * @return boolean
	 */
	public static boolean isEmpty(String str){
		if(str == null || str.trim().length() <= 0){
			return true;
		}
		
		return false;
	}
	
	/***
	 * 입력된 String형의 문자의 길이를 int형으로 반환
	 * null일 경우 0을 반환
	 * @param str
	 * @return int
	 */
	public static int getLength(String str){
		if(isEmpty(str)){
			return 0;
		}
		return str.length();
	}
	
	/**
	 * 입력된 두 String형의 문자의 값이 동일한지 여부를 확인 ( 대소문자 구분 )
	 * 하나의 값이라도 null인 경우 false를 반환
	 * @param str1
	 * @param str2
	 * @return boolean
	 */
	public static boolean isEquals(String str1, String str2){
		if(str1 != null && str2 != null){
			if(str1.equals(str2)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 입력된 두 String형의 문자의 값이 동일한지 여부를 확인 ( 대소문자 무시 )
	 * 하나의 값이라도 null인 경우 false를 반환
	 * @param str1
	 * @param str2
	 * @return boolean 
	 */
	public static boolean isIgnoreEquals(String str1, String str2){
		if(str1 != null && str2 != null){
			String lowwer1 = str1.toLowerCase();
			String lowwer2 = str2.toLowerCase();
			if(lowwer1.equals(lowwer2)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 입력된 String형의 문자의 값을 입력된 index만큼 사이의 String형의 문자로 반환
	 * @param str
	 * @param beginIndex : 시작 위치
	 * @param endIndex	 : 종료 위치
	 * @return 원하는 index사이의 문자열 
	 */
	public static String substring(String str, int beginIndex, int endIndex){
		try{
			return str.substring(beginIndex, endIndex);
		}catch (Exception e) {
			return null;
		}
		
	}
	
	/**
	 * 입력된 String형의 문자의 값을 입력된 끝에서부터 index만큼 문자열 반환
	 * @param str
	 * @param index : 반환할 위치
	 * @return 원하는 문자열 
	 */
    public static String lastSubString( String str, int index ){
    	try{
    		return str.substring(str.length()-index, str.length());
    	}catch (Exception e) {
			return null;
		}
		
    }
    
	/**
	 * 입력된 String형의 문자의 값을 입력된 끝에서부터 index만큼 문자열을 삭제
	 * ( 마지막에 "," 와 같은 문자를 삭제할 경우 사용 )
	 * @param str
	 * @param index : 삭제 위치
	 * @return 원하는 문자열 
	 */
    public static String lastRemove(String str, int index){
    	try {
    		return str.substring(0, str.length()-index);
		} catch (Exception e) {
			return null;
		}
		
    }
    
}