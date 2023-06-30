package com.xunheng.base.utils;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String DATE_FORMAT_YMD = "yyyyMMdd";
	public static final String DATE_YYYYMM_FORMAT = "yyyy-MM";
	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd hh:mm:ss";  //12小时制
	public static final String DATE_TIME_FORMAT2 = "yyyy-MM-dd HH:mm:ss"; //24小时制
	public static final String DATE_TIME_FORMATS = "yyyyMMddhhmmss";
	public static final String YEAR = "Y";
	public static final String MONTH = "M";
	public static final String DAY = "D";
	public static final int BASE_YEAR = 1900; 
	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat sdfYM = new SimpleDateFormat("yyyy-MM");
	public static final SimpleDateFormat sdfY = new SimpleDateFormat("yyyy");
	public static final SimpleDateFormat sdfM = new SimpleDateFormat("MM");
	public static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日");
	public static final SimpleDateFormat sdfhs = new SimpleDateFormat("yyyy-MM-dd HH:ss");
	public static final SimpleDateFormat sdfhms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * 将字符串转换为日期格式  格式为：yyyy-MM-dd
	 * 举例: Date date = StringHandler.dateFormat("2008-1-22");
	 * @param strDate
	 * @return 返回一个 Date对象
	 */
	public static Date dateFormat(String strDate){
		if(strDate == null || strDate.equals(""))return  null;
		return dateFormat(DATE_FORMAT, strDate);
	}
	
	/**
	 * 将字符串转换为日期格式
	 * 举例: Date date = StringHandler.dateFormat("yyyy-mm-dd","2008-1-22");
	 * @param pattern	日期格式："yyyy-mm-dd"
	 * @param strDate
	 * @return 返回一个 Date对象
	 */
	public static Date dateFormat(String pattern,String strDate)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return sdf.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 将日期格式化为字符串
	 * @param pattern	日期格式："yyyy-MM-dd"等
	 * @param date	日期对象
	 * @return
	 */
	public static String dateFormatToStr(String pattern,Date date){
		if(null==pattern || "".equals(pattern)) pattern="yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		if(null == date) return "";
		return sdf.format(date);
	}
	
	/**
	 * 将日期格式化为字符串  按日期格式："yyyy-MM-dd" 进行转化
	 * @param date	日期对象
	 * @return
	 */
	public static String dateFormatToStr(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		if(null == date) return "";
		return sdf.format(date);
	}
	
	/**
	 * 将日期格式化为字符串  按日期格式："yyyyMMdd" 进行转化
	 * @param date	日期对象
	 * @return
	 */
	public static String getDateToStr(Date date){
	    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_YMD);
	    if(null == date) return "";
	    return sdf.format(date);
	}
	
	/**
	 * 将日期格式化为字符串  按日期格式："yyyy-MM-dd hh:mm:ss" 进行转化
	 * @param date	日期对象
	 * @return
	 */
	public static String getTimeToStr(Date date){
	    SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT);
	    if(null == date) return "";
	    return sdf.format(date);
	}
	
	/**
	 * 将日期格式化为字符串  按日期格式："yyyy-MM-dd" 进行转化
	 * @param  Timestamp date	日期对象
	 * @return
	 */
	public static String dateFormatToStr(Timestamp date){
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		if(null == date) return "";
		return sdf.format(new Date(date.getTime()));
	}
	
	/**
	 * 将日期格式化为字符串 
	 * @param fmt 格式化类型
	 * @param  Timestamp date	日期对象
	 * @return
	 */
	public static String dateFormatToStr(String fmt ,Timestamp date){
		SimpleDateFormat sdf = new SimpleDateFormat(fmt);
		if(null == date) return "";
		return sdf.format(new Date(date.getTime()));
	}
	
	/**
	 * 将日期格式化为字符串  按日期格式："yyyyMMddhhmmss" 进行转化
	 * @param  Timestamp date	日期对象
	 * @return
	 */
	public static String dateFormatToStrs(Date date){
	    SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMATS);
	    if(null == date) return "";
	    return sdf.format(new Date(date.getTime()));
	}
	
	
	
	private static Map<Integer, Integer> month_days = new HashMap<Integer, Integer>(); 
	static{
		month_days.put(1, 31);
		month_days.put(2, 28);
		month_days.put(3, 31);
		month_days.put(4, 30);
		month_days.put(5, 31);
		month_days.put(6, 30);
		month_days.put(7, 31);
		month_days.put(8, 31);
		month_days.put(9, 30);
		month_days.put(10, 31);
		month_days.put(11, 30);
		month_days.put(12, 31);
	}
	
	/*
	 * 获取日期 “yyyy-MM-dd”，不包含具体时间
	 */
	public static Date getDate(){
		Date date = new Date();
		String dateStr = sdf.format(date);
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			return null;
		}
		return date;
	}
	
	
	/*
	 * 获取日期 “yyyy-MM-dd”，不包含具体时间
	 */
	public static String getDateStr(){
		Date date = new Date();
		String dateStr = sdf.format(date);
		return dateStr;
	}

	/**
	 * 日期格式转换  01/02/2010  转 2010-02-01
	 * @param beginDate 开始日期
	 * @param number  数量
	 * @param unit    数量的单位：年，月，日
	 * @throws ParseException 
	 * @throws ParseException 
	 */
	public static String translateDate(String oldDate) throws ParseException{
		if (oldDate == null || "".equals(oldDate))return oldDate;
		String newDate = oldDate;
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date date = df.parse(oldDate);
		newDate = sdf.format(date);
		return newDate;
	}
	/**
	 * 计算终止日期
	 * @param beginDate 开始日期
	 * @param number  数量
	 * @param unit    数量的单位：年，月，日
	 * @throws ParseException 
	 */
	public static Date calculateEndDate(Date beginDate, Integer number, String unit){
		Date endDate = null;
		if (unit.equals(YEAR)){
			endDate = getDateFromYear(beginDate, number);
		}else if (unit.equals(MONTH)){
			try {
				endDate = getDateFromMonth(beginDate, number);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (unit.equals(DAY)){
			endDate = getDateFromDays(beginDate, number);
		}
		return endDate;
	}
	
	/**
	 * 计算从date（如2010年1月某日）开始，number个月后的某年某月某日的总天
	 * 要处理特殊情况，如，从2010-01-31到2010-02-28，2月没有31号
	 * @param param 开始日期
	 * @param mounth  月份数:
	 */
	public static int getTotalDays(Date param,int number){
		int totalDays = 0;
		int year;//年份
		int month;//月份
		int day;//多少号
		int days;//这个月一共有多少天
		int lastMonthDays;//number个月后的最后一个月的总天数
		String dateStr = sdf.format(param);
		String[] date = dateStr.split("-");
		//年份
		year = Integer.parseInt(date[0]);
		//月份，0-11代表1-12月份
		month = Integer.parseInt(date[1]) - 1;
		//多少号
		day = Integer.parseInt(date[2]);
		//这个月一共有多少天
		days = getDaysOfMonth(year, month);
		//计算本月还有多少天
		totalDays += days - day;
		month++;//下个月
		//如果到了12月份，设month=0，即一月份
		if (month > 11){
			month = 0;
			year++;
		}
		//逐月累加(number-1)个月
		for (int i=number; i>1; i--){
			totalDays += getDaysOfMonth(year, month);
			month++;//下个月
			//如果到了12月份，设month=0，即一月份
			if (month > 11){
				month = 0;
				year++;
			}
		}
		
		//开始计算最后一个月,先计算这个月的总天数
		lastMonthDays = getDaysOfMonth(year,month);
		if (lastMonthDays > day){//这个月的总天数大于起始月的号数
			totalDays += day;
		}else{
			totalDays += lastMonthDays;
		}
		return totalDays;
	}
	

	/**
	 * 计算从date（如2010年1月某日，只取年和月，日不记）开始，number个月后的某年某月某日的日期
	 * 要处理特殊情况，如，从2010-01-31到2010-02-28，2月没有31号
	 * @param param 开始日期
	 * @param mounth  月份数:
	 * @throws ParseException 
	 */
	public static Date getDateFromMonth(Date param,int number) throws ParseException{
		int year;//年份
		int month;//月份
		int day;//多少号
		int days;//这个月一共有多少天
		int lastMonthDays;//number个月后的最后一个月的总天数		
		String dateStr = sdf.format(param);
		String[] date = dateStr.split("-");
		//年份
		year = Integer.parseInt(date[0]);
		//月份，0-11代表1-12月份
		month = Integer.parseInt(date[1]) - 1;
		//多少号
		day = Integer.parseInt(date[2]);
		//这个月一共有多少天
		days = getDaysOfMonth(year, month);
		month++;//下个月
		//如果到了12月份，设month=0，即一月份
		if (month > 11){
			month = 0;
			year++;
		}
		//逐月累加(number-1)个月
		for (int i=number; i>1; i--){
			month++;//下个月
			//如果到了12月份，设month=0，即一月份
			if (month > 11){
				month = 0;
				year++;
			}
		}
		
		//开始计算最后一个月,先计算这个月的总天数
		lastMonthDays = getDaysOfMonth(year,month);
		
		if (lastMonthDays < day){//这个月的总天数大于起始月的号数
			day = lastMonthDays;
		}
		String endDateStr = year + "-" + (month+1) + "-" + day;
		Date endDate = sdf.parse(endDateStr);
		return endDate;
	}
	
	/**
	 * 计算一个月有多少天
	 * @param year 年份 如：2010
	 * @param mounth  月份：一月为0，二月为1 以此类推
	 */
	public static int getDaysOfMonth(int year,int month){
		int days = -1;
		Calendar time = Calendar.getInstance();
		time.clear();
		time.set(Calendar.YEAR,year); //year 为 int
		time.set(Calendar.MONTH,month);//注意,Calendar对象默认一月为0          
		days = time.getActualMaximum(Calendar.DAY_OF_MONTH);//本月份的天数
		return days;
	}
	
	/**
	 * 以数组形式返回指定参数日期的年，月，日数据
	 * @param date 要计算年、月、日的日期
	 * @return 返回整型数组 arr[0] = 年,arr[1] = 月,arr[2] = 日
	 */
	public static int[] getYMD(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int[] ymd = new int[3];
		ymd[0] = calendar.get(Calendar.YEAR);
		ymd[1] = calendar.get(Calendar.MONTH)+1;
		ymd[2] = calendar.get(Calendar.DATE);
		return ymd;
	}
	
	/**
	 * 根据天数计算日期
	 * @param date 年份 如：2010
	 * @param days  天数
	 */
	public static Date getDateFromDays(Date date,Integer days){
		Long time = date.getTime();
		Long daysTime = days.longValue() * 24 * 60 * 60 * 1000;
		time += daysTime;
		Date newDate = new Date(time);
		return newDate;
	}
	
	/**
	 * 根据年数计算日期
	 * @param date 年份 如：2010
	 * @param days  年数
	 */
	public static Date getDateFromYear(Date date,Integer year){
		int oldYear = date.getYear();
		int oldMonth = date.getMonth();
		int oldDay = date.getDate();
		Date newDate ;
		int newDay = getDaysOfMonth(oldYear+year, oldMonth);
		if (newDay > oldDay){
			newDate = new Date(oldYear+year, oldMonth, oldDay);
		}else{
			newDate = new Date(oldYear+year, oldMonth, newDay);
		}
		return newDate;
	}
	/**
	 * 比较2个日期大小
	 * @param date1 
	 * @param date2  
	 */
	public static int compareDate(Date date1, Date date2){
		if(date1 == null && date2 == null)return 0;
		else if(date1 == null) return -1;
		else if(date2 == null)return 1;
		String d1 = sdf.format(date1);
		String d2 = sdf.format(date2); 
		return d1.compareTo(d2);
	}
	/**
	 * 日期单位转换
	 * @param limit  期限 
	 * @param type1  期限日期单位（年，月，日）  
	 * @param type2  要转换的日期单位（年，月，日）  type1的单位>=type2  
	 * @param begin  月转日时用到
	 */
	public static Integer transformDate(Integer limit, String type1, String type2, Date begin){
		if (type1.equals(type2)){//单位相等
			return limit;
		}else if (type1.equals(YEAR) && type2.equals(MONTH)){//年转月
			return limit * 12;
		}else if (type1.equals(YEAR) && type2.equals(DAY)){//年转日
			return limit * 365;
		}else if (type1.equals(MONTH) && type2.endsWith(DAY)){//月转日
			return getTotalDays(begin, limit);
		}
		return 0;
	}
	
	/**
	 * 将yyyy-MM-dd HH:ss:mm 转换成 yyyy-MM-dd
	 * @param date   
	 * @throws ParseException 
	 */
	public static Date formatDate(Date date) throws ParseException{
		String dateStr = sdf.format(date);
		Date formatDate = sdf.parse(dateStr);
		return formatDate;
	}
	
	/**
	 * 求商，不能整除则商+1
	 * @param param1  被除数
	 * @param param2  除数:
	 */
	public static Integer division(Integer param1, Integer param2){
		Integer result = 0;
		if ((param1 % param2) == 0){
			result = param1 / param2;
		}else{
			result = (param1 / param2) + 1;
		}
		return result;
	}
	
	
	/**
	 * 更具起始时间，终止时间 和，期限日期类型（年，月，日）计算期限
	 * @param begin  
	 * @param end  
	 * @param type
	 * @throws ServiceException 
	 */
	public static Integer calculateLimitDate(Date begin, Date end, String type){
		Integer result = 0;
		
		try{
			begin = formatDate(begin);
			end = formatDate(end);
			if (DAY.equals(type)){
				Long days = (end.getTime() - begin.getTime())/(86400000L);
				result = days.intValue();
			}else if (MONTH.equals(type)){
				
			}else if (YEAR.equals(type)){
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 获取两个日期字符串之间的月份数
	 *   date2 - date1 = month
	 * @param dateStr1	日期一
	 * @param dateStr2	日期二
	 * @return
	 * @author chengmingwei
	 * @date 2015年4月22日 上午12:04:30
	 */
	public static int monthSpace(String dateStr1, String dateStr2) {
		try {
			Date date1 = sdf.parse(dateStr1);
			Date date2 = sdf.parse(dateStr2);
			return monthSpace(date1, date2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 获取两个日期之间的月份数
	 *   date2 - date1 = month
	 * @param date1	日期一
	 * @param date2	日期二
	 * @return
	 * @author chengmingwei
	 * @date 2015年4月22日 上午12:04:30
	 */
	public static int monthSpace(Date date1, Date date2){
		Calendar bef = Calendar.getInstance();
		Calendar aft = Calendar.getInstance();
		bef.setTime(date1);
		aft.setTime(date2);
		int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
		return result;
	}
	
	/**
	 * 将字符串转换为日期格式
	 * 举例: Date date = StringHandler.dateFormat(true,"2008-1-22");
	 * @param nohasHm 是否包含 HH:mm  true : 将以 "yyyy-MM-dd" 格式化 ,false : "yyyy-MM-dd HH:ss"
	 * @param strDate
	 * @return 返回一个 Date对象
	 */
	public static Date dateFormat(boolean nohasHm,String strDate)
	{
		try {
			return nohasHm ? sdf.parse(strDate) : sdfhs.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 将日期格式化为字符串
	 * @param nohasHm 是否包含 HH:mm  true : 将以 "yyyy-MM-dd" 格式化 ,false : "yyyy-MM-dd HH:ss"
	 * @param date	日期对象
	 * @return
	 */
	public static String dateFormatToStr(boolean nohasHm,Date date){
		if(null == date) return "";
		return nohasHm ? sdf.format(date) : sdfhs.format(date);
	}
	
	/**
	 * 将 Object 转化为 字符串形式的日期
	 * @param val 要转化为字符串日期的 Object 对象
	 * @return
	 */
	public static String dateFormatToStr(Object val){
		String type = val.getClass().getSimpleName();
		if(null==val) val = "";
		if(type.equals("Timestamp")){
			String dateVal = val.toString();
			dateVal = dateVal.substring(0, dateVal.indexOf(" "));
			val = dateVal+"";
		}else if(type.equals("Date")){
			val = dateFormatToStr(true, (Date) val);
		}
		return (String)val;
	}
	
	/**
	 * 将指定的字符串日期以指定的日期格式减去指定的天数后返回一个新日期
	 * @param nohasHm	是否包含 HH:mm  true : 将以 "yyyy-MM-dd" 格式化 ,false : "yyyy-MM-dd HH:ss"
	 * @param strDate	字符串日期
	 * @param days	添加的天数
	 * @return	返回减去天数后的新日期
	 */
	public static Date minusDaysToDate(boolean nohasHm,String strDate,int days){
		Date currDate = dateFormat(nohasHm,strDate);
		return new Date(currDate.getTime()-days*24*60*60*1000);
	}
	
	/**
	 * 将指定的字符串日期以指定的日期格式减去指定的天数后返回一个新日期
	 * @param currDate	要减去天数据日期
	 * @param days	添加的天数
	 * @return	返回减去天数后的新日期
	 */
	public static Date minusDaysToDate(Date currDate,int days){
		return new Date(currDate.getTime()-days*24*60*60*1000);
	}
	
	/**
	 * 将指定的字符串日期以 "yyyy-MM-dd" 的日期格式减去指定的天数后返回一个新日期
	 * @param strDate	字符串日期
	 * @param days	添加的天数
	 * @return	返回添加天数后的新日期字符串
	 */
	public static String minusDays(String strDate,int days){
		Date addDate = minusDaysToDate(true,strDate,days);
		return dateFormatToStr(true,addDate);
	}
	
	/**
	 * 将指定的字符串日期以指定的日期格式减去加上指定的天数后返回一个新日期
	 * @param nohasHm	是否包含 HH:mm  true : 将以 "yyyy-MM-dd" 格式化 ,false : "yyyy-MM-dd HH:ss"
	 * @param strDate	字符串日期
	 * @param days	添加的天数
	 * @return	返回减去天数后的新日期
	 */
	public static Date addDaysToDate(boolean nohasHm,String strDate,int days){
		Date currDate = dateFormat(nohasHm,strDate);
		currDate = plusDays2Date(currDate,days);
		return currDate;
	}
	
	/**
	 * 将指定的日期加上时和分返回一个新日期
	 * @param currDate	当前日期
	 * @param hours	添加的小时
	 * @param minutes 添加的分钟
	 * @return	返回加上时和分后的新日期
	 */
	public static Date addHourAndMinute(Date currDate,int hours, int minutes){
		Calendar cnd = Calendar.getInstance();
		cnd.setTime(currDate);
		int hour = cnd.get(Calendar.HOUR_OF_DAY);
		int minute = cnd.get(Calendar.MINUTE);
		hour += hours;
		minute += minutes;
		cnd.set(Calendar.HOUR_OF_DAY, hour);
		cnd.set(Calendar.MINUTE, minute);
		currDate = cnd.getTime();
		return currDate;
	}
	
	/**
	 * 将指定的日期以指定的日期格式加上指定的天数后返回一个新日期
	 * @param date	日期对象
	 * @param days	添加的天数
	 * @return	返回加上天数后的新日期
	 */
	public static Date addDaysToDate(Date date,int days){
		Date currDate = dateFormat(date);
		currDate = plusDays2Date(currDate,days);
		return currDate;
	}

	/**
	 * 将指定的日期加上指定的天数后返回一个新日期
	 * @param currDate 日期对象
	 * @param days 添加的天数
	 * @return	返回加上天数后的新日期
	 */
	private static Date plusDays2Date(Date currDate,int days) {
		Calendar cnd = Calendar.getInstance();
		cnd.setTime(currDate);
		int currDays = cnd.get(Calendar.DATE);
		currDays += days;
		cnd.set(Calendar.DATE, currDays);
		currDate = cnd.getTime();
		return currDate;
	}
	
	/**
	 * 获取参数日期指定的号数
	 * @param currDate 日期对象
	 * @return	返回指定日期是多少号
	 */
	public static int getDays(Date currDate) {
		Calendar cnd = Calendar.getInstance();
		cnd.setTime(currDate);
		int currDays = cnd.get(Calendar.DATE);
		return currDays;
	}
	
	/**
	 * 将指定的日期以指定的日期格式加上指定的天数后返回一个新日期
	 * @param date	日期对象
	 * @param days	添加的天数
	 * @return	返回加上天数后的新日期
	 */
	public static Date replaceDayToDate(Date date,int days){
		Date currDate = dateFormat(date);
		Calendar cnd = Calendar.getInstance();
		cnd.setTime(currDate);
		int monthTotalDays = getMonthTotalDays(currDate);
		if(days>monthTotalDays) days = monthTotalDays;/*如果替换的天数大于当月最大天数，那就返回当月最后一天*/
		cnd.set(Calendar.DATE, days);
		return cnd.getTime();
	}
	
	/**
	 * 将指定的字符串日期以以 "yyyy-MM-dd" 格式加上指定的天数后返回一个新日期
	 * @param strDate	字符串日期
	 * @param days	添加的天数
	 * @return	返回减去天数后的新日期
	 */
	public static Date addDaysToDate(String strDate,int days){
		return addDaysToDate(true,strDate,days);
	}
	
	/**
	 * 将指定的字符串日期以 "yyyy-MM-dd" 的日期格式加上指定的天数后返回一个新日期
	 * @param strDate	字符串日期
	 * @param days	添加的天数
	 * @return	返回添加天数后的新日期字符串
	 */
	public static String addDays(String strDate,int days){
		Date addDate = addDaysToDate(true,strDate,days);
		return dateFormatToStr(true,addDate);
	}
	

	/**   
	 * 得到某一个日期所在的月份  
	 * @return  返回月份
	 */    
	public static int getMonth(Date date) {   
		int month = 0;
		Calendar cnd = Calendar.getInstance();
		cnd.setTime(date);
		month = cnd.get(Calendar.MONTH)+1;
		return month;
	}  
	
	/**
	 * 将日期对象以 "yyyy-MM-dd" 格式化后并返回新的日期对象
	 * 举例: Date date = StringHandler.dateFormat("yyyy-mm-dd",2008-1-22);
	 * @param date  Date 对象
	 * @return 返回一个 Date对象
	 */
	public static Date dateFormat(Date date)
	{
		String dateStr = dateFormatToStr(date);
		return dateFormat(DATE_FORMAT,dateStr);
	}
	
	/**   
	 * 得到某一个日期的第一天   
	 * @return   
	 */    
	public static String getMonthFirstDay(Date date,String dtFmt) {     
	    Date firstDayDate = getMonthFirstDay2Date(date, dtFmt); 
	    return dateFormatToStr(dtFmt,firstDayDate);     
	}    
	
	/**   
	 * 得到某一个日期的第一天   
	 * @return   
	 */    
	public static Date getMonthFirstDay2Date(Date date,String dtFmt) {     
	    Calendar calendar = Calendar.getInstance();     
	    calendar.setTime(date);
	    calendar.set(Calendar.DAY_OF_MONTH, calendar     
	            .getActualMinimum(Calendar.DAY_OF_MONTH));     
	    return calendar.getTime();     
	}     
	/**
	 * 得到某一个日期的最后一天   
	 * @return   
	 */    
	public static String getMonthLastDay(Date date,String dtFmt) {     
	    Calendar calendar = Calendar.getInstance();  
	    calendar.setTime(date);
	    calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));     
	    return dateFormatToStr(dtFmt, calendar.getTime());     
	} 
	
	/**   
	 * 得到某一个日期加上指定月份的当月总天数   
	 * @return   返回总天数
	 */    
	public static int getPlusMonthTotalDays(Date date,int monthes) {     
	    Calendar calendar = Calendar.getInstance();
	    Date firstDayDate = getMonthFirstDay2Date(date, DATE_FORMAT);
	    calendar.setTime(firstDayDate);
	    int month = calendar.get(Calendar.MONTH);
	    month += monthes;
	    calendar.set(Calendar.MONTH, month);
	    calendar.set(Calendar.DAY_OF_MONTH,  calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
	    int totalDays = calendar.get(Calendar.DAY_OF_MONTH);
	    return totalDays;
	} 
	
	/**   
	 * 得到某一个日期对象指定月份的总天数   
	 * @return   返回总天数
	 */    
	public static int getMonthTotalDays(Date date) {     
	    Calendar calendar = Calendar.getInstance();  
	    calendar.setTime(date);
	    calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
	    int totalDays = 0;
	    totalDays = calendar.get(Calendar.DAY_OF_MONTH);
	    return totalDays;
	} 
	
	/**
	 * 计算从date（如2010年1月某日，只取年和月，日不记）开始，number之前的某年某月某日的日期
	 * 要处理特殊情况，如，从2010-01-31到2010-02-28，2月没有31号
	 * @param param 开始日期
	 * @param mounth  月份数:
	 * @throws ParseException 
	 */
	public static Date getDateFromNegativeMonth(Date param,int number) throws ParseException{
		int year;//年份
		int month;//月份
		int day;//多少号
		int days;//这个月一共有多少天
		int lastMonthDays;//number个月后的最后一个月的总天数		
		String dateStr = sdf.format(param);
		String[] date = dateStr.split("-");
		//年份
		year = Integer.parseInt(date[0]);
		//月份，0-11代表1-12月份
		month = Integer.parseInt(date[1]) - 1;
		//多少号
		day = Integer.parseInt(date[2]);
		//这个月一共有多少天
		days = getDaysOfMonth(year, month);
		month--;//前一个月
		//如果减到0月份（即一月份），设month=11，即十二月份
		if (month <0){
			month = 11;
			year--;
		}
		//逐月减(number-1)个月
		for (int i=number; i>1; i--){
			month--;//下个月
			//如果减到0月份（即一月份），设month=11，即十二月份
			if (month <0){
				month = 11;
				year--;
			}
		}
		
		//开始计算最后一个月,先计算这个月的总天数
		lastMonthDays = getDaysOfMonth(year,month);
		
		if (lastMonthDays < day){//这个月的总天数大于起始月的号数
			day = lastMonthDays;
		}
		String endDateStr = year + "-" + (month+1) + "-" + day;
		Date endDate = sdf.parse(endDateStr);
		return endDate;
	}
	/**
	 * 将指定的日期以减去指定的月份数后返回一个新日期
	 * @param strDate	要减去的日期
	 * @param monthes	月份数
	 * @return	返回减去后的日期
	 */
	public static Date minusMonthToDate(Date date,int monthes){
		Calendar cnd = Calendar.getInstance();
		cnd.setTime(date);
		int month = cnd.get(Calendar.MONTH);
		month -= monthes;
		cnd.set(Calendar.MONTH, month);
		date = cnd.getTime();
		return date;
	}
	
	/**
	 * 将指定的日期以减去指定的月份数后返回一个新日期
	 * @param strDate	要减去的日期
	 * @param monthes	月份数
	 * @param days 号数
	 * @return	返回减去后的日期
	 */
	public static Date minusMonthToDate(Date date,int monthes,int days){
		Calendar cnd = Calendar.getInstance();
		cnd.setTime(date);
		int month = cnd.get(Calendar.MONTH);
		month -= monthes;
		cnd.set(Calendar.MONTH, month);
		int monthTotalDays = getPlusMonthTotalDays(date,month);
		if(days>monthTotalDays) days = monthTotalDays;/*如果替换的天数大于当月最大天数，那就返回当月最后一天*/
		cnd.set(Calendar.DATE, days);
		date = cnd.getTime();
		return date;
	}
	
	public static String minusMonthToDate(Date date,int monthes,String dtFmt){
		
		String dateStr = sdfYM.format(date);
		dateStr = dateStr+"-01";
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar cnd = Calendar.getInstance();
		cnd.setTime(date);
		int month = cnd.get(Calendar.MONTH);
		month -= monthes;
		cnd.set(Calendar.MONTH, month);
		date = cnd.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(dtFmt);
		return sdf.format(date);
	}
	
	/**
	 * 根据小时计算日期
	 * @param date 年份 如：2010
	 * @param days  天数
	 */
	public static Date getDateFromHour(Date date,Integer hour){
		Long time = date.getTime();
		Long hourTime = hour.longValue() * 60 * 60 * 1000;
		time += hourTime;
		Date newDate = new Date(time);
		return newDate;
	}
	/**
	 * 根据分计算日期
	 * @param date 年份 如：2010
	 * @param days  天数
	 */
	public static Date getDateFromMinute(Date date,Integer minute){
		Long time = date.getTime();
		Long minuteTime = minute.longValue() * 60 * 1000;
		time += minuteTime;
		Date newDate = new Date(time);
		return newDate;
	}
	

	/**
	 * 根据星期计算日期
	 * @param date 年份 如：2010
	 * @param days  天数
	 */
	public static Date getDateFromWeek(Date date,Integer week){
		Long time = date.getTime();
		Long weekTime = week.longValue()* 7 * 24 * 60 * 60 * 1000;
		time += weekTime;
		Date newDate = new Date(time);
		return newDate;
	}
	
	/**
	 * 根据 年/月/日 数组返回一个日期格式字符串
	 * @param ymd	年/月/日 数组
	 * @return	返回一个日期格式字符串
	 */
	public static String getDateStr(int[] ymd){
		int year = ymd[0];
		int month = ymd[1];
		int day = ymd[2];
		String dateStr = year + "-";
		if(month < 1) month = 1;
		if(month > 12) month = 12;
		if(month < 10){
			dateStr += "0"+month;  
		}else{
			dateStr += month;
		}
		dateStr += "-";
		int lastDay = getLastDay(year, month);
		if(day < 1) day = 1;
		if(day > lastDay) day = lastDay;
		if(day < 10){
			dateStr += "0"+day;  
		}else{
			dateStr += day;
		}
		return dateStr;
	}
	
	/**
	 * 获取某年某月中最后的一天
	 * @param year	XX年
	 * @param month	XX月
	 * @return	指定XX年XX月的最后一天
	 */
	public static int getLastDay(int year,int month){
		int lastDay = 28;
		if(month == 2 && isLeapYear(year)){	//润年 2月份 29天
			lastDay = 29;
		}else{
			lastDay = month_days.get(new Integer(month));
		}
		return lastDay;
	}
	
	/**
	 * 判断指定的年份是否是润年
	 * @param year	要验证的年份
	 * @return	true : 润年 , false : 平年
	 */
	public static boolean isLeapYear(int year){
		return ((year%4==0 && year%100!=0) || year%400==0) ? true : false;
	}
	
	/**
	 * 获取某月的最后一天的日期
	 * @param date	某个日期对象
	 * @return 返回该月最后一天的日期
	 */
	public static Date getLastDateForMoth(Date date){
	   Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),1,0,0,0);
        cal.add(Calendar.MONTH,1);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        Date newDate = cal.getTime();
        return newDate;
	}
	
	/**
	 * 获取某月的最后一天的日期字符串
	 * @param date	某个日期对象
	 * @return 返回某月的最后一天的日期字符串
	 */
	public static String getLastDateStrForMoth(Date date){
        return dateFormatToStr(getLastDateForMoth(date));
	}

	public static void main(String[] args) throws Exception{
//		Date n_date = addHourAndMinute(new Date(), 2, 2);
//		System.out.println(DateUtil.dateFormatToStr(DateUtil.DATE_TIME_FORMAT, n_date));
//		Date dat1 = dateFormat("2016-01-01");
//		Date dat2 = dateFormat("2016-02-01");
//		int days = minusDateToDays(dat2, dat1);
//		System.out.println(getMonthTotalDays(dat2));
//		System.out.println("days="+days);
//		int[] ymd = getYMD(new Date());
//		System.out.println(ymd[0]);
	/*	Date date1 = DateUtil.dateFormat(DateUtil.DATE_TIME_FORMATS,"20160331170910");
		Date date2 = DateUtil.dateFormat(DateUtil.DATE_TIME_FORMAT2,"2016-07-19 08:41:59");
		long time = date2.getTime() - date1.getTime();
		long second = time/1000;
		System.out.println(time+",秒："+second+",分："+(second/60));*/
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date1 = format.parse("2023-02-28");
			Date date2 = format.parse("2023-03-01");
			System.out.println(date1.compareTo(date2));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 两日期相减得到天数
	 * @param day
	 */
	public static long minusDate(Date date1,Date date2){
		long day=(date1.getTime()-date2.getTime())/(24*60*60*1000);
		return day;
	}
	
	/**
	 * 获取两个日期相差的天数 
	 * 	date1 - date2 = 天数。 注：date1 须大于 date2。否则，返回 0 天
	 * @param date1	第一个日期
	 * @param date2	第二个日期
	 * @return	返回第 date1 - date2 后相差的天数
	 */
	public static int minusDateToDays(Date date1 , Date date2){
		int day = 0;
		long time = date1.getTime() - date2.getTime();
		if(time < 0) return day;
		day  = (int)(time/(24*60*60*1000));
		return day;
	}
	
	/**
	 * 得到当年第一月第一天
	 */
	public static String getCurrYearBeginDay(){
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-01-01");
		Date date=new Date();
		String dateStr = sdf.format(date);
		return dateStr;
	}
	
	/**
	 * 将指定的日期以加上指定的月份并且以 days 作为固定日期数后返回一个新日期
	 * 例如：plusMonthToDate(new Date("2010-01-01") ,1,12) ---> 2010-02-12 
	 * @param date	指定的日期
	 * @param monthes	月份数
	 * @param days 要改变的号数
	 * @return	返回改变后的日期
	 */
	public static Date plusMonthToDate(Date date,int monthes,int days){
		Calendar cnd = Calendar.getInstance();
		Date currDate = dateFormat(date);
		cnd.setTime(currDate);
		int month = cnd.get(Calendar.MONTH);
		month += monthes;
		cnd.set(Calendar.MONTH, month);
		int monthTotalDays = getPlusMonthTotalDays(currDate,monthes);
		if(days>monthTotalDays) days = monthTotalDays;/*如果替换的天数大于当月最大天数，那就返回当月最后一天*/
		cnd.set(Calendar.DATE, days);
	 	date = cnd.getTime();
		return date;
	}
	
	/**
	 * 将指定的日期以加上指定的月份后返回一个新日期
	 * 例如：plusMonthToDate(new Date("2010-01-01") ,1) ---> 2010-02-01
	 * @param date	指定的日期
	 * @param monthes	月份数
	 * @param days 要改变的号数
	 * @return	返回改变后的日期
	 */
	public static Date plusMonthToDate(Date date,int monthes){
		Calendar cnd = Calendar.getInstance();
		cnd.setTime(date);
		int days = cnd.get(Calendar.DATE);
		int totalDays = getPlusMonthTotalDays(date,monthes);
		if(days>totalDays){/*如果批定的日期大于下月的最后一天，则返回下月最后的那一天的天数*/
			cnd.set(Calendar.DATE, totalDays);
		}
		int month = cnd.get(Calendar.MONTH);
		month += monthes;
		cnd.set(Calendar.MONTH, month);
		date = cnd.getTime();
		return date;
	}

	/**
	 * 比较两个日期是否是同一年同一月
	 *  true : 代表年份和月份相同 ，false : 年月不相同
	 * @param date1	要比较的第一个日期对象
	 * @param date2 要比较的第二个日期对象
	 * @return 返回布尔值  true : 代表年份和月份相同 ，false : 年月不相同
	 */
	public static boolean eqSameYearMonth(Date date1 ,Date date2){
		Calendar cnd1 = Calendar.getInstance();
		cnd1.setTime(date1);
		Calendar cnd2 = Calendar.getInstance();
		cnd2.setTime(date2);
		return (cnd1.get(Calendar.YEAR) == cnd2.get(Calendar.YEAR) &&
				cnd1.get(Calendar.MONTH) == cnd2.get(Calendar.MONTH)) ? true : false;
	}


	/**
	 * 根据期数计算出当期的应还日期
	 * @param rstartDate
	 * @param phase
	 * @return
	 */
	public static Date calculateXpayDate(Date rstartDate,Integer phase){
		Date date = null;
		int x = -1;
		int day = getDays(rstartDate);
		if(day == 29){
			rstartDate = addDaysToDate(rstartDate,-1);
			x = 0;
		}else if(day == 30){
			rstartDate = addDaysToDate(rstartDate,-2);
			x = 0;
		}else if(day == 31){
			rstartDate = addDaysToDate(rstartDate,-3);
			x = 0;
		}else if(day == 1){
			x = 0;
			rstartDate = addDaysToDate(rstartDate,27);
			rstartDate = addMonthToDate(rstartDate,-1,0);
		}
		date = addMonthToDate(rstartDate,phase,x);
		return date;
	}

	public static Date addMonthToDate(Date date,int month,int day){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		gc.add(2, month);//2代表月份，1代表在当前的日期添加一个月
		gc.set(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH), gc.get(Calendar.DATE));
		if(day != 0){
			gc.add(5, day);
			gc.set(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH), gc.get(Calendar.DATE));
		}
		return gc.getTime();
	}

	/**
	 * 获取上个月的最后一天
	 * @return
	 */
	public static Date getLastMonthEndTime(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, -1);
		c.set(Calendar.DAY_OF_MONTH,c.getActualMaximum(Calendar.DAY_OF_MONTH));//设置为最后一天
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 999);
		return c.getTime();
	}


	/**
	 * 流程完成时间处理
	 *
	 * @param ms
	 * @return
	 */
	public static String getChineseFormatDate(long ms) {

		long day = ms / (24 * 60 * 60 * 1000);
		long hour = (ms / (60 * 60 * 1000) - day * 24);
		long minute = ((ms / (60 * 1000)) - day * 24 * 60 - hour * 60);
		long second = (ms / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - minute * 60);

		if (day > 0) {
			return day + "天" + hour + "小时" + minute + "分钟";
		}
		if (hour > 0) {
			return hour + "小时" + minute + "分钟";
		}
		if (minute > 0) {
			return minute + "分钟";
		}
		if (second > 0) {
			return second + "秒";
		} else {
			return 0 + "秒";
		}
	}

}
