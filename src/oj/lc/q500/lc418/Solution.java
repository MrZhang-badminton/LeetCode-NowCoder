package oj.lc.q500.lc418;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/10/30 20:01
 */
public class Solution {




	public static String validIPAddress(String queryIP) {
		String NEITHER = "Neither";
		if (queryIP.startsWith(".") || queryIP.endsWith(".") || queryIP.startsWith(":") || queryIP.endsWith(":")) {
			return NEITHER;
		}
		if (queryIP.contains(".")) {
			// IPv4
			String[] items = queryIP.split("\\.");
			// 不是三个. false
			if (items.length != 4) {
				return NEITHER;
			}
			for (String s : items) {
				// 长度大于3 false
				if (s.length() > 3) {
					return NEITHER;
				}
				// 前导0、空校验
				if (s.startsWith("0") && s.length() != 1 || "".equals(s)) {
					return NEITHER;
				}
				char[] chars = s.toCharArray();
				for (char ch : chars) {
					// 不是数字 false
					if (!Character.isDigit(ch)) {
						return NEITHER;
					}
				}
				// 大于255 false
				if (Integer.parseInt(s) > 255) {
					return NEITHER;
				}
			}
			return "IPv4";
		}

		// IPv6
		String[] items = queryIP.split(":");
		if (items.length != 8) {
			return NEITHER;
		}
		for (String s : items) {
			// 空校验、长度校验
			if ("".equals(s) || s.length() > 4) {
				return NEITHER;
			}
			char[] chars = s.toCharArray();
			for (char ch : chars) {
				// 单个字符串校验
				if (!Character.isDigit(ch) && !('a' <= Character.toLowerCase(ch) && Character.toLowerCase(ch) <= 'f')) {
					return NEITHER;
				}
			}

		}
		return "IPv6";

	}


	/**
	 * 依次判断
	 * <p>
	 * 对于IPv4:
	 * 1. 对于整个IPv4是否，前后是否有.
	 * 2. 长度是否在1~3之间
	 * 3. 是否只包含数字
	 * 4. 他的值是否在[0,255]之间
	 * 5. 否否不包含前导0,如果包含0,只能一个0
	 * <p>
	 * 对于IPv6:
	 * 1. 对于整个IPv4，前后是否有:
	 * 2. 长度是否在1~4
	 * 3. 是否只包含数字, a~z, A~Z
	 *
	 * @param queryIP
	 * @return
	 * @resource 官方题解
	 */
	public static String validIPAddress2(String queryIP) {
		String NEITHER = "Neither";
		if (queryIP.indexOf('.') >= 0) {
			// IPv4
			int last = -1;
			for (int i = 0; i < 4; ++i) {
				int cur = (i == 3 ? queryIP.length() : queryIP.indexOf('.', last + 1));
				// 判断是否存在空
				if (cur < 0) {
					return NEITHER;
				}
				if (cur - last - 1 < 1 || cur - last - 1 > 3) {
					return NEITHER;
				}
				int addr = 0;
				for (int j = last + 1; j < cur; ++j) {
					if (!Character.isDigit(queryIP.charAt(j))) {
						return NEITHER;
					}
					addr = addr * 10 + (queryIP.charAt(j) - '0');
				}
				if (addr > 255) {
					return NEITHER;
				}
				if (addr > 0 && queryIP.charAt(last + 1) == '0') {
					return NEITHER;
				}
				if (addr == 0 && cur - last - 1 > 1) {
					return NEITHER;
				}
				last = cur;
			}
			return "IPv4";
		} else {
			// IPv6
			int last = -1;
			for (int i = 0; i < 8; ++i) {
				int cur = (i == 7 ? queryIP.length() : queryIP.indexOf(':', last + 1));
				if (cur < 0) {
					return NEITHER;
				}
				if (cur - last - 1 < 1 || cur - last - 1 > 4) {
					return NEITHER;
				}
				for (int j = last + 1; j < cur; ++j) {
					if (!Character.isDigit(queryIP.charAt(j)) && !('a' <= Character.toLowerCase(queryIP.charAt(j)) && Character.toLowerCase(queryIP.charAt(j)) <= 'f')) {
						return NEITHER;
					}
				}
				last = cur;
			}
			return "IPv6";
		}
	}

	/**
	 * 正则表达式
	 *
	 * @param queryIP
	 * @return
	 * @resource 题解评论
	 */
	public static String validIPAddress3(String queryIP) {
		String ipv4Pattern = "((2(5[0-5]|[0-4]\\d))|(1([0-9][0-9]))|[1-9][0-9]?|[0-9])(.((2(5[0-5]|[0-4]\\d))|(1([0-9][0-9]))|[1-9][0-9]?|[0-9])){3}";
		String ipv6Pattern = "([0-9a-fA-F]{1,4})(:[0-9a-fA-F]{1,4}){7}";

		if (queryIP.indexOf(".") > 0 && (queryIP.matches(ipv4Pattern))) {
			return "IPv4";
		}
		if (queryIP.indexOf(":") > 0 && (queryIP.matches(ipv6Pattern))) {
			return "IPv6";
		}
		return "Neither";
	}

	public static void main(String[] args) {
		System.out.println(validIPAddress3("2001:0db8:85a3:0:0:8A2E:0370:7334"));

	}
}
