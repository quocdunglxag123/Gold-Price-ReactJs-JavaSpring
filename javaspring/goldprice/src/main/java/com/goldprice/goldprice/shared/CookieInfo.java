package com.goldprice.goldprice.shared;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieInfo {
	/*
	 * Get Value Of Cookie
	 * 
	 * @param name name of cookie
	 * 
	 * @return value value of cookie
	 */
	public String getValueCookie(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();

		if (cookies != null && name != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					return cookie.getValue();
				}
			}
		}
		return "";
	}

	/*
	 * Get Cookie
	 * 
	 * @param name String name of cookie
	 * 
	 * @param value String value of cookie
	 * 
	 * @param maxage Long max age of cookie (second)
	 * 
	 */
	public void setCookie(HttpServletRequest request, HttpServletResponse response, String name, String value,
			Long maxage) {
		Cookie cookie = new Cookie(name, value);

		response.addCookie(cookie);
	}
}
