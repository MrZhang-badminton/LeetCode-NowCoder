package oj.lc.q500.lc151;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {


	public static String reverseWords(String s) {
		String[] strings = s.split(" ");
		List<String> list = Arrays.asList(strings);
		Collections.reverse(list);
		StringBuilder sb = new StringBuilder();
		for(String str : list){
			if(!"".equals(str)){
				sb.append(str + " ");
			}
		}
		return sb.substring(0,sb.length()-1).toString();
	}


	public static void main(String[] args) {
		System.out.println(reverseWords(" hello world "));
	}
}
