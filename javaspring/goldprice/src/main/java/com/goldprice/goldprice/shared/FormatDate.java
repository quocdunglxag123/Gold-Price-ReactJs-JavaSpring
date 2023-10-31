package com.goldprice.goldprice.shared;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDate {
	/*
	 * convert String To Date With Format
	 * 
	 * @param dateNeedFormat String date need convert and Format
	 * 
	 * @param type String type need to format
	 * 
	 * return date Date Format By Type
	 */
	public Date convertStringToDate(String dateNeedFormat, String type) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(type);
		Date date1 = simpleDateFormat.parse(dateNeedFormat);
		return date1;
	}

}
