package com.tsdvip.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.*;



/**
 * Created by IntelliJ IDEA.
 * User: ly
 * Date: 2006-12-19
 * Time: 16:03:03
 */
public class DateUtil {
	private static SimpleDateFormat dateTimeformater;
    /**
     * ��ȡϵͳ������ʱ�䣨Date���ͣ�
     *
     * @return ����
     */
    public static Date getNexDay() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);

        return cal.getTime();
    }
    
    /**
     * ��ȡϵͳ������ʱ�䣨Date���ͣ�
     *
     * @param  formatstr ��ʽ���ַ�������
     * @return ����
     */
    public static String getNexDayStr(String formatstr) {
         String fstr = formatstr;

        if (fstr == null) {
            fstr = "yyyy-MM-dd";
        }

        SimpleDateFormat format = new SimpleDateFormat(fstr);
        Date date = DateUtil.getNexDay();
        String dstr = format.format(date);
           return dstr;
    }

    /**
     * ��ȡϵͳ�ĵ���ʱ�䣨Date���ͣ�
     *
     * @return ����
     */
    public static Date getCureDate() {
        Calendar cal = Calendar.getInstance();

        return cal.getTime();
    }

    
   
    /**
     * ��ȡϵͳ�ĵ���ʱ�䣨�ַ������ͣ�
     * @param formatstr ��ʽ���ַ�������
     *
     * @return ����
     */
    public static String getCureDateStr(String formatstr) {
        String fstr = formatstr;

        if (fstr == null) {
            fstr = "yyyy-MM-dd";
        }

        SimpleDateFormat format = new SimpleDateFormat(fstr);
        Date date = DateUtil.getCureDate();
        String dstr = format.format(date);

        return dstr;
    }

    /**
     * ��ȡָ�����ڵ�ǰ�����N�죨�ַ������ͣ����������Ĳ���Ϊ�գ��򷵻ؿ�
     *
     * @param date ����
     * @param n ��ת���� ����������ǰ�ƣ�������������
     * @param formatstr ��ʽ������
     *
     * @return �����ַ�������
     */
    public static String getMoveDay(String date,int n,String formatstr) {
    	String preday = "";
    	SimpleDateFormat format = new SimpleDateFormat(formatstr);
		try {
			Date ddate = format.parse(date);
			Calendar cal = Calendar.getInstance();
			cal.setTime(ddate);
			cal.add(Calendar.DAY_OF_MONTH, n);
			Date preddate = cal.getTime();
			preday = format.format(preddate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return preday;
    }

    /**
     * ��ȡָ�����ڵ�ǰ�����N�죨Date���ͣ����������Ĳ���Ϊ�գ��򷵻ؿ�
     *
     * @param date ����
     * @param n ��ת���� ����������ǰ�ƣ�������������
     *
     * @return ����������
     */
    public static Date getMoveDay(Date date,int n) {
    	Date preddate = null;
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DAY_OF_MONTH, n);
			preddate = cal.getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return preddate;
    }

    /**
     * ��ȡ��ǰ���ڵ�ǰһ�죨�ַ������ͣ����������Ĳ���Ϊ�գ��򷵻ؿ�
     *
     * @param formatstr ��ʽ������
     *
     * @return ǰһ��
     */
    public static String getPreDay(String formatstr) {
    	String preday = "";
    	SimpleDateFormat format = new SimpleDateFormat(formatstr);
		try {
			Date ddate = DateUtil.getCureDate();
			Calendar cal = Calendar.getInstance();
			cal.setTime(ddate);
			cal.add(Calendar.DAY_OF_MONTH, -1);
			Date preddate = cal.getTime();
			preday = format.format(preddate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return preday;
    }
    
     /**
     * ��ȡָ�����ڵ�ǰһ�죨�ַ������ͣ����������Ĳ���Ϊ�գ��򷵻ؿ�
     *
     * @param date ����
     * @param formatstr ��ʽ������
     *
     * @return ǰһ��
     */
    public static String getPreDay(String date,String formatstr) {
    	String preday = "";
    	if (date == null || date.equals("")) {
            return preday;
        } 
    	SimpleDateFormat format = new SimpleDateFormat(formatstr);
		try {
			Date ddate = format.parse(date);
			Calendar cal = Calendar.getInstance();
			cal.setTime(ddate);
			cal.add(Calendar.DAY_OF_MONTH, -1);
			Date preddate = cal.getTime();
			preday = format.format(preddate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return preday;
    }
    
    /**
     * ��ȡָ�����ڵ�������ͬһ�����գ��������Ĳ���Ϊ�գ��򷵻ؿ�
     *
     * @param date ����
     * @param formatstr ��ʽ������
     * 
     * @return ����ͬһ������
     */
    public static String getPreWeakDay(String date,String formatstr) {
    	String preday = "";
    	if (date == null || date.equals("")) {
            return preday;
        } 
    	SimpleDateFormat format = new SimpleDateFormat(formatstr);
		try {
			Date ddate = format.parse(date);
			Calendar cal = Calendar.getInstance();
			cal.setTime(ddate);
			cal.add(Calendar.DAY_OF_MONTH, -7);
			Date preddate = cal.getTime();
			preday = format.format(preddate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return preday;
    }

    /**
     * �õ��·ݵ����һ��
     *
     * @param year ���
     * @param month �·�
     *
     * @return �������һ��
     */
    public static String getLastDayOfMonth(String year, String month) {
        try {
            String[] monthDays = new String[] {
                    "31", "28", "31", "30", "31", "30", "31", "31", "30", "31",
                    "30", "31"
                };
            int m = Integer.parseInt(month);
            int y = Integer.parseInt(year);

            if (((y % 4) == 0) && (m == 2)) {
                return "28";
            } else {
                return monthDays[m - 1];
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     * ��ȡ��ǰ�����һ�꣬�������Ĳ���Ϊ�գ��򷵻ص�ǰ��
     *
     * @param year �������
     * 
     * @return ��һ��
     */
    public static int getPreYear(String year) {
        if ((year == null) || year.equals("")) {
            return getCureYear();
        } else {
            return Integer.parseInt(year) - 1;
        }
    }

    /**
     * ��ȡ��ǰ��ĺ�һ�꣬�������Ĳ���Ϊ�գ��򷵻ص�ǰ��
     *
     * @param year   �������
     *
     * @return ��һ��
     */
    public static String getNextYear(String year) {
        if ((year == null) || year.equals("")) {
            return getCureYear() + "";
        } else {
            return (Integer.parseInt(year) + 1) + "";
        }
    }

    /**
    * ��ȡ��ǰ��
    *
    * @return ��ǰ��
    */
    public static String getCureYearStr() {
        return String.valueOf(DateUtil.getCureYear());
    }

    /**
     * ��ȡ��ǰ��
     *
     * @return ��ǰ��
     */
    public static int getCureYear() {
        Calendar cal = Calendar.getInstance();

        return cal.get(Calendar.YEAR);
    }

    /**
     * ��ȡ��ǰ��
     *
     * @return ��ǰ��
     */
    public static int getCureQuarter() {
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;
        int quarter = 1;

        switch (month) {
        case 1:
        case 2:
        case 3:
            quarter = 1;

            break;

        case 4:
        case 5:
        case 6:
            quarter = 2;

            break;

        case 7:
        case 8:
        case 9:
            quarter = 3;

            break;

        case 10:
        case 11:
        case 12:
            quarter = 4;

            break;
        }

        return quarter;
    }

    /**
     * ��ȡ��ǰ��
     *
     * @return ��ǰ��
     */
    public static String getCureQuarterStr() {
        return String.valueOf(DateUtil.getCureQuarter());
    }

    /**
     * ��ȡ��һ��
     * @param quarter   ��ʼ����
     *
     * @return ��һ��
     */
    public static String getNextQuarterStr(String quarter) {
        String s = "";

        try {
            s = Integer.parseInt(quarter) + 1 + "";
        } catch (Exception e) {
        }

        return s;
    }

    /**
    * ��ȡ��ǰ�£���ֵ�ͣ�
    *
    * @return ��ǰ��
    */
    public static int getCureMonth() {
        Calendar cal = Calendar.getInstance();

        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * ��ȡ��ǰ��(�ַ���)
     *
     * @return ��ǰ��
     */
    public static String getCureMonthStr() {
        String monthStr = null;
        int month = DateUtil.getCureMonth();
        monthStr = String.valueOf(month);

        if (monthStr.length() < 2) {
            monthStr = "0" + monthStr;
        }

        return monthStr;
    }

    /**
     * ��ȡ��һ�� (�ַ�����)
     *
     * @return ��һ��
     */
    public static String getNextMonthStr(String month) {
        String s = "";

        try {
            if ((Integer.parseInt(month) + 1) < 10) {
                s = "0" + (Integer.parseInt(month) + 1);
            } else {
                s = (Integer.parseInt(month) + 1) + "";
            }

            if ("12".equals(month)) {
                s = "01";
            }
        } catch (Exception e) {
        }

        return s;
    }

    /**
    * ��ȡ��ǰ��
    *
    * @return ��ǰ��
    */
    public static String getStrCureMonth() {
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;

        if (month < 10) {
            return "0" + month;
        } else {
            return month + "";
        }
    }

    /**
    * ��ȡ��ǰ��
    *
    * @return ��ǰ��
    */
    public static int getCureDay() {
        Calendar cal = Calendar.getInstance();

        return cal.get(Calendar.DAY_OF_MONTH);
    }

     /**
    * ��ȡ��ǰ��
    *
    * @return ��ǰ��
    */
    public static String getCureDayStr() {
        Calendar cal = Calendar.getInstance();

        int day = cal.get(Calendar.DAY_OF_MONTH);
         if (day < 10) {
            return "0" + day;
        } else {
            return day + "";
        }
    }
    
    /**
     * ��ȡ��ǰСʱ
     *
     * @return ��ǰСʱ
     */
     public static String getCureHourStr() {
         Calendar cal = Calendar.getInstance();

         int hour = cal.get(Calendar.HOUR_OF_DAY);
          if (hour < 10) {
             return "0" + hour;
         } else {
             return hour + "";
         }
     }
     
     /**
      * ��ȡ��ǰ����
      *
      * @return ��ǰ����
      */
      public static String getCureMinuteStr() {
          Calendar cal = Calendar.getInstance();

          int minute = cal.get(Calendar.MINUTE);
           if (minute < 10) {
              return "0" + minute;
          } else {
              return minute + "";
          }
      }
     
    
    /**
     * ��ȡϵͳ�ĵ��µ�һ��
     *
     * @return DOCUMENT ME!
     */
    public static Date getFirstMonthDay() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);

        return cal.getTime();
    }

    /**
     * ȡ����������֮����������ڼ��ϣ�������ʼ���ںͽ�������
     *
     * @param startdate ��ʼ����
     * @param enddate ��������
     * @param formatstr ��ʽ���ַ���
     *
     * @return ���ڼ���
     */
    public static List<String> getListBetweenDay(String startdate, String enddate,
        String formatstr) {
        List<String> list = new ArrayList<String>();

        if ((startdate == null) || (enddate == null)) {
            return null;
        }

        String fstr = formatstr;

        if (fstr == null) {
            fstr = "yyyy-MM-dd";
        }

        SimpleDateFormat format = new SimpleDateFormat(fstr);

        try {
            Date dstartdate = format.parse(startdate);
            Date denddate = format.parse(enddate);
            Calendar startcal = Calendar.getInstance();
            startcal.setTime(dstartdate);

            for (Date date = dstartdate;
                    date.before(denddate) || date.equals(denddate);) {
                list.add(format.format(date));
                startcal.add(Calendar.DAY_OF_MONTH, 1);
                date = startcal.getTime();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * ȡ����������֮����������ڼ��ϣ�������ʼ���ںͽ�������
     *
     * @param startdate ��ʼ����
     * @param enddate ��������
     *
     * @return ���ڼ���
     */
    public static List<String> getListBetweenDay(String startdate, String enddate) {
        List<String> list = new ArrayList<String>();

        if ((startdate == null) || (enddate == null)) {
            return null;
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date dstartdate = format.parse(startdate);

            Date denddate = format.parse(enddate);
            Calendar startcal = Calendar.getInstance();
            startcal.setTime(dstartdate);

            for (Date date = dstartdate;
                    date.before(denddate) || date.equals(denddate);) {
                list.add(format.format(date));
                startcal.add(Calendar.DAY_OF_MONTH, 1);
                date = startcal.getTime();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * ����ָ�����ں����n������list
     *
     * @param ymd ����
     * @param n ����
     *
     * @return ���ڼ���
     */
    public static List<String> getDays(String ymd, int n) {
        return DateUtil.getDays(ymd,n,"yyyyMMdd");
    }

    /**
     * ����ָ�����ں����n������list
     *
     * @param ymd ����
     * @param n ����
     * @param formatstr ��ʽ���ַ���
     *
     * @return ���ڼ���
     */
    public static List<String> getDays(String ymd, int n,String formatstr) {
         /**���ڷ��ص�list*/
        List<String> dayList = new ArrayList<String>();
        String  toDate = DateUtil.getMoveDay(ymd,n,formatstr);

        if(n >= 0){
            dayList = DateUtil.getListBetweenDay(ymd,toDate,formatstr);
        }else{
            dayList = DateUtil.getListBetweenDay(toDate,ymd,formatstr);
        }
        return dayList;
    }

    /**
	 * ȡ����������֮����������
	 *
	 * @param startdate ��ʼ����
	 * @param enddate ��������
	 * @param formatstr ��ʽ���ַ���
	 *
	 * @return �������
	 */
	public static Integer getDayCountBetweenDay(String startdate, String enddate,
		String formatstr) {
		int dayCOunt = 0;
		List list = DateUtil.getListBetweenDay(startdate,enddate,formatstr);
		if(list != null && list.size() > 0 ){
			dayCOunt =  list.size() -1 ;
		}
		return dayCOunt;
	}

	/**
     * ȡ��ָ�����ȵ��·�
     *
     * @param quarter ����
     *
     * @return �·ݼ���
     */
    public static List<String> getMonthByQuater(String quarter) {
        List<String> list = null;

        if (quarter == null) {
            return null;
        }

        try {
            int iquarter = 1;
            iquarter = Integer.valueOf(quarter).intValue();

            //System.out.print("iquarter"+iquarter);
            switch (iquarter) {
            case 1:
                list = new ArrayList<String>();
                list.add("01");
                list.add("02");
                list.add("03");

                break;

            case 2:
                list = new ArrayList<String>();
                list.add("04");
                list.add("05");
                list.add("06");

                break;

            case 3:
                list = new ArrayList();
                list.add("07");
                list.add("08");
                list.add("09");

                break;

            case 4:
                list = new ArrayList();
                list.add("10");
                list.add("11");
                list.add("12");

                break;

            default:
                list = new ArrayList();
                list.add("01");
                list.add("02");
                list.add("03");

                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * �����·�list
     *
     * @return �·ݼ���
     */
    public List<String> getMonthList() {
        List<String> monthList = new ArrayList<String>();

        for (int j = 1; j <= 12; j++) {
            if (j < 10) {
                monthList.add("0" + j);
            } else {
                monthList.add("" + j);
            }
        }

        return monthList;
    }
    
     /**
     * ����ָ���·����ڵļ���
     *
     * @param month �·�
     *
     * @return ����
     */
    public static String getQuarter(String month) {
        int m = Integer.parseInt(month);

        if (m <= 3) {
            return "1";
        } else if (m <= 6) {
            return "2";
        } else if (m <= 9) {
            return "3";
        } else if (m <= 12) {
            return "4";
        }

        return null;
    }
     /**
     * ����ָ����ݺͼ��ȵ���������
     *
     * @param yq �꼾�ַ���
     *
     * @return ��������
     */
    public static String[] getYms(String yq) {
        String[] yms = new String[3];

        for (int i = 0; i < 3; i++) {
            yms[i] = yq.substring(0, 4) + String.valueOf(((Integer.parseInt(yq.substring(4)) - 1) * 3) + i + 101).substring(1);
        }

        return yms;
    }
    /**
     * ������������
     *
     * @param yq
     *
     * @return ��������
     */
    public static String[] getYmds(String yq) {
        String[] yms = new String[2];
        String year = yq.substring(0,4);
        String q = yq.substring(4);
        int qint = Integer.parseInt(q);
        if(qint == 1){
            yms[0] = year + "0101";
            yms[1] = year + "0331";
        }else if(qint == 2){
            yms[0] = year + "0401";
            yms[1] = year + "0630";
        }else if(qint == 3){
            yms[0] = year + "0701";
            yms[1] = year + "0930";
        }else if(qint == 4){
            yms[0] = year + "1001";
            yms[1] = year + "1231";
        }
        return yms;
    }

    /**
     * ȡ��ָ�����ȵ��·��ַ���
     *
     * @param quarter ����
     *
     * @return �·��ַ���
     */
    public static String getMonthStrByQuater(String quarter) {
        String monthStr = "";
        List monthL = DateUtil.getMonthByQuater(quarter);

        if (monthL != null) {
            for (int i = 0; i < monthL.size(); i++) {
                monthStr += (",'" + (String) monthL.get(i) + "'");
            }
        }

        monthStr = monthStr.substring(1);

        return monthStr;
    }

    /**
     * �����ݿ���ȡ����yyyyMMdd������ת��Ϊyyyy-MM-dd��ʽ��ʾ
     *
     * @param date ��ת�������ַ���
     * @return ת����ʽ�������
     */
    public static String getFormatStrDate(String date) {
        String s = "";

        if ((date == null) || (date.length() < 8)) {
            return s;
        } else {
            s = date.substring(0, 4) + "-" + date.substring(4, 6) + "-" +
                date.substring(6, 8);
        }

        return s;
    }

    /**
     * ��yyyy-MM-dd������ת��ת��ΪyyyyMMdd�ķ�ʽ��ʾ
     *
     * @param date ��ת�������ַ���
     * 
     * @return ת����ʽ�������
     */
    public static String getFormatSysDate(String date) {
        String s = "";

        if ((date == null) || (date.length() < 10)) {
            return s;
        } else {
            s = date.substring(0, 4) +  date.substring(5, 7) +
                date.substring(8, 10);
        }

        return s;
    }

     /**
       * �����ݿ���ȡ����HHmm������ת��ΪHH:mm��ʽ��ʾ
       *
       * @param time ��ת��ʱ���ַ���
       *
       * @return ת����ʽ���ʱ��
       */
    public static String getFormatStrTime(String time) {
        String s = "";

        if ((time == null) || (time.length() < 4)) {
            return s;
        } else {
            s = time.substring(0, 2) + ":" + time.substring(2, 4) ;
        }

        return s;
    }

    /**
     * ��HH:mm������ת��ת��ΪHHmm�ķ�ʽ��ʾ
     *
     * @param time ��ת��ʱ���ַ���
     *
     * @return DOCUMENT ME!
     */
    public static String getFormatSysTime(String time) {
        String s = "";

        if ((time == null) || (time.length() < 5)) {
            return s;
        } else {
            s = time.substring(0, 2) +  time.substring(3, 5);
        }

        return s;
    }

    /**
    * ����Ҫ��ʾ���·ݸ�ʽ��Ϊ��λ�ַ�
    *
    * @param month �·�
    *
    * @return ת����ʽ����·�
    */
    public static String getFormatMonth(String month) {
        String s = "";

        if ((month == null) || (month.length() > 2)) {
            return s;
        } else {
            if (month.length() < 2) {
                s = "0" + month;
            } else {
                s = month;
            }
        }

        return s;
    }

    /**
     * ����Ҫ��ʾ���·ݸ�ʽ��Ϊ��λ�ַ�
     * @param month �·�
     * @return ת����ʽ����·�
     */
    public static String getFormatMonth(int month) {
        String s = "";

        if ((month > 12) || (month < 0)) {
            return s;
        } else {
            if (month < 10) {
                s = "0" + month;
            } else {
                s = month + "";
            }
        }

        return s;
    }

    /**
     * �����·�����
     * @param  year ���
     * @param  month �¶�
     * @return ��������
     */
    public static int countDaysOfMonth(int year, int month) {
        int days = 0;

        try {
            month = month - 1;

            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            calendar.set(Calendar.MONTH, month);
            days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return days;
    }

     /**
     * �����·�����
     * @param  year ���
     * @param  month �¶�
     * @return ��������
     */
    public static int countDaysOfMonth(String year, String month) {
        int days = 0;

        try {
            if ((year != null) && (month != null)) {
                int yearI = Integer.parseInt(year);
                int monthI = Integer.parseInt(month);
                days = DateUtil.countDaysOfMonth(yearI, monthI);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return days;
    }

     /**
     * ���㼾������
     * @param  year ���
     * @param  quarter ����
     * @return ��������
     */
    public static int countDaysOfQuarter(String year, String quarter) {
        int days = 0;

        try {
            if ((year != null) && (quarter != null)) {
                List monthL = DateUtil.getMonthByQuater(quarter);

                if (monthL != null) {
                    for (int i = 0; i < monthL.size(); i++) {
                        String month = (String) monthL.get(i);
                        int dayI = DateUtil.countDaysOfMonth(year, month);
                        days += dayI;

                        //System.out.println(days+" y:"+year+"   m:"+month);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return days;
    }

    /**
    * ���ַ������� ת��Ϊ��������
    * @param  strdate       �ַ�����������
    * @param  formatstr     ��ʽ����������  ��Ϊ��ϵͳĬ�ϲ���yyyy-MM-dd
    * @return    ����
    */
    public static Date getDate(String strdate, String formatstr) {
        String fstr = "yyyy-MM-dd";

        if (formatstr != null) {
            fstr = formatstr;
        }

        SimpleDateFormat format = new SimpleDateFormat(fstr);
        Date date = null;

        if (strdate == null) {
            return date;
        }

        try {
            date = format.parse(strdate);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return date;
    }

    /**
    * ���������� ת��Ϊ�ַ�������
    * @param  date     ����
    * @param  formatstr     ��ʽ���������͡�Ϊ��ϵͳĬ�ϲ���yyyy-MM-dd
    * @return   ����
    */
    public static String getStrDate(Date date, String formatstr) {
        String fstr = "yyyy-MM-dd";

        if (formatstr != null) {
            fstr = formatstr;
        }

        SimpleDateFormat format = new SimpleDateFormat(fstr);
        String strdate = "";

        if (date == null) {
            return strdate;
        }

        try {
            strdate = format.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return strdate;
    }

    /**
     * ��õ�ǰʱ�������һ������ʱ��(96��)
     *
     * @return ʱ��
     */
    public static String getFloorTime() {
        String time = "";
        time = getCureDateStr("HHmm");
        String hour = time.substring(0,2);//��ǰСʱ
        String minute =  time.substring(2,4);//��ǰ����
        int iminute = Integer.parseInt(minute);
        if(iminute>= 0 && iminute < 15){
            time = hour +"00";    
        }
         else if(iminute>= 15 && iminute < 30){
            time = hour +"15";
        }
        else  if(iminute>= 30 && iminute < 45){
            time = hour +"30";
        }
        else  if(iminute>= 45 ){
            time = hour +"45";
        }
        return time;
    }
    
    /**
     * ��õ�ǰʱ�������һ������ʱ��(288��)
     *
     * @return ʱ��
     */
    public static String getFloor288Time() {
        String time = "";
        time = getCureDateStr("HHmm");
        String hour = time.substring(0,2);//��ǰСʱ
        String minute =  time.substring(2,4);//��ǰ����
        int iminute = Integer.parseInt(minute);
        if(iminute>= 0 && iminute < 5){
            time = hour +"00";    
        }else if(iminute>= 5 && iminute < 10){
            time = hour +"05";
        }else if(iminute>= 10 && iminute < 15){
            time = hour +"10";
        }else if(iminute>= 15 && iminute < 20){
            time = hour +"15";
        }else if(iminute>= 20 && iminute < 25){
            time = hour +"20";
        }else if(iminute>= 25 && iminute < 30){
            time = hour +"25";
        }else  if(iminute>= 30 && iminute < 35){
            time = hour +"30";
        }else if(iminute>= 35 && iminute < 40){
            time = hour +"35";
        }else if(iminute>= 40 && iminute < 45){
            time = hour +"40";
        }else if(iminute>= 45 && iminute < 50){
            time = hour +"45";
        }else if(iminute>= 50 && iminute < 55){
            time = hour +"50";
        }else{
        	time = hour +"55";
        }
        return time;
    }

    /**
     * ��õ�ǰʱ���������һ������ʱ��(96��)
     *
     * @return ʱ��
     */
    public static String getPreFloorTime() {
        String time = "";
        time = getCureDateStr("HHmm");
        String hour = time.substring(0,2);//��ǰСʱ
        String minute =  time.substring(2,4);//��ǰ����
        int iminute = Integer.parseInt(minute);
        if(iminute>= 0 && iminute < 15 && Integer.parseInt(hour) ==0){
            time = hour +"00";
        }
        if(iminute>= 0 && iminute < 15 && Integer.parseInt(hour) >0){
            if( (Integer.parseInt(hour)-1)< 10){
                time = "0"+(Integer.parseInt(hour)-1) +"45";
            }else{
                time = (Integer.parseInt(hour)-1) +"45";
            }
        }
         else if(iminute>= 15 && iminute < 30){
            time = hour +"00";
        }
        else  if(iminute>= 30 && iminute < 45){
            time = hour +"15";
        }
        else  if(iminute>= 45 ){
            time = hour +"30";
        }
        return time;
    }

    /**
     * ��ʽ�����֣�����λ���ָ�ʽ��Ϊ˫λ�ַ���ʾ
     * @param number ����
     * @return
     */
    public static String  formatDoubleNumber(int number){
    	String str = "";
    	
    	if(number < 10){
    		str = "0" + number;
    	}else{
    		str = "" + number;
    	}
    	
    	return str;
    }
    
    /**
     * ��ȡһ�������Сʱ��
     * 
     * @return Сʱ����
     */
    public static List<String> getHourList(){
        List<String> hourList = new ArrayList<String>();
        for(int i = 1 ;i < 13;i++){
            if(i < 10){
                hourList.add("0"+i);
            }else{
                hourList.add(""+i);    
            }
        }
        return hourList;
    }
    

    /**
     * ����һ�����ȵ�Сʱ��
     *
     * @param year ���
     * @param quarter ����
     *
     * @return Сʱ����
     */
    public static int getQuarterHours(String year, String quarter) {
        try {
            int y = Integer.parseInt(year);
            int q = Integer.parseInt(quarter);

            if (((y % 4) == 0) && (q == 1)) {
                return (31 + 29 + 31) * 24;
            } else {
                if (q == 1) {
                    return (31 + 28 + 31) * 24;
                } else if (q == 2) {
                    return (30 + 31 + 30) * 24;
                } else if (q == 3) {
                    return (31 + 31 + 30) * 24;
                } else if (q == 4) {
                    return (31 + 30 + 31) * 24;
                }
            }

            return 0;
        } catch (Exception e) {
            e.printStackTrace();

            return 0;
        }
    }

    /**
     * ����һ���Сʱ��
     *
     * @param year ���
     *
     * @return Сʱ����
     */
    public int getYearHours(String year) {
        try {
            int y = Integer.parseInt(year);

            if ((y % 4) == 0) {
                return 366 * 24;
            } else {
                return 365 * 24;
            }
        } catch (Exception e) {
            e.printStackTrace();

            return 0;
        }
    }

    /**
     * ��ȡһ��Сʱ�ڵ����е���
     *
     * @return  ʱ�̵㼯��
     */
     public static List<String> getBreakPointList(){
    	 List<String> minuteList = new ArrayList<String>();
         for(int i = 0 ;i < 60;){
             if(i < 10){
                 minuteList.add("0"+i);
             }else{
                 minuteList.add(""+i);
             }
             i = i+15;
         }
         return minuteList;
    }

    /**
     * ��ȡָ��ʱ��ε����
     *
     * @param fromYmd ��ʼ����
     * @param toYmd ��������
     *
     * @return ��ȼ���
     */
    public static List<String> getYears(String fromYmd, String toYmd) {
        List<String> result = new ArrayList<String>();
        int beginY = Integer.parseInt(fromYmd.substring(0, 4));
        int endY = Integer.parseInt(toYmd.substring(0, 4));

        while (beginY <= endY) {
            result.add(beginY + "");
            beginY++;
        }

        return result;
    }

    /**
     * �õ���������
     *
     * @param fromYmd ��ʼ��
     * @param toYmd ��ֹ��
     *
     * @return ��������
     */
    public static List<String> getYqs(String fromYmd, String toYmd) {
        int fY = 0;
        int tY = 0;
        int fQ = 0;
        int tQ = 0;
        ArrayList<String> yqArr = new ArrayList<String>();

        try {
            fY = Integer.parseInt(fromYmd.substring(0, 4));
            tY = Integer.parseInt(toYmd.substring(0, 4));
            fQ = Integer.parseInt(DateUtil.getQuarter(fromYmd.substring(4, 6)));
            tQ = Integer.parseInt(DateUtil.getQuarter(toYmd.substring(4, 6)));

            for (int y = fY; y <= tY; y++) {
                for (int q = 1; q <= 4; q++) {
                    if ((y == fY) && (q < fQ)) {
                        continue;
                    }

                    if ((y == tY) && (q > tQ)) {
                        break;
                    }

                    yqArr.add(y + String.valueOf(q));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return yqArr;
    }

    /**
     * ����ָ�����ڷ�Χ�ڵ�������������
     *
     * @param fromYm ��ʼ����
     * @param toYm ��������
     *
     * @return ���ڼ���
     */
    public static List<String> getYM(String fromYm, String toYm) {
        List<String> result = new ArrayList<String>();
        int fY = Integer.parseInt(fromYm.substring(0, 4));
        int fM = Integer.parseInt(fromYm.substring(4));
        int tY = Integer.parseInt(toYm.substring(0, 4));
        int tM = Integer.parseInt(toYm.substring(4));

        while (fY <= tY) {
            if (fY == tY) {
                while (fM <= tM) {
                    result.add(fY + (fM + 100 + "").substring(1));
                    fM++;
                }
            } else {
                while (fM <= 12) {
                    result.add(fY + (fM + 100 + "").substring(1));
                    fM++;
                }
            }

            fM = 1;
            fY++;
        }

        return result;
    }
    
    /**
     * ����ָ�����ڣ���һ�������ܵ���������������
     *
     * @param ymd ����
     *
     * @return ����������
     */
    public static List<String> getRestDays(String ymd) {
        /**���ڷ��ص�list*/
        List<String> dayList = new ArrayList<String>();
        String year = null;
        String month = null;
        String day = null;
        String date = null;

        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.YEAR, Integer.parseInt(ymd.substring(0, 4)));
        ca.set(Calendar.MONTH, Integer.parseInt(ymd.substring(4, 6)) - 1);
        ca.set(Calendar.DAY_OF_MONTH, Integer.parseInt(ymd.substring(6)));

        ca.add(Calendar.DAY_OF_MONTH, 5);

        for (int i = 0; i < 2; i++) {
            year = "" + ca.get(Calendar.YEAR);
            month = (ca.get(Calendar.MONTH) + 1 + 100 + "").substring(1);
            day = (ca.get(Calendar.DAY_OF_MONTH) + 100 + "").substring(1);
            date = year + month + day;
            dayList.add(date);
            ca.add(Calendar.DAY_OF_MONTH, 1);
        }

        return dayList;
    }


    /**
    * ����һ���е�������һ����
    * @param year  ���
    * @return  ��һ����
    */
    public List<String> getMondayList(String year) {
        /** ���ڷ��ص�list */
        List<String> mondayList = new ArrayList<String>();
        /**��*/
        String month = null;
        /**��*/
        String day = null;
        /**����*/
        String date = null;

        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.YEAR, Integer.parseInt(year));
        ca.set(Calendar.MONTH, 0);
        ca.set(Calendar.DAY_OF_MONTH, 1);
        if(ca.get(Calendar.DAY_OF_WEEK) == 2) {
            mondayList.add(year + "0101");
        }
        while(Integer.parseInt("" + ca.get(Calendar.YEAR) + (ca.get(Calendar.MONTH) + 1) + ca.get(Calendar.DAY_OF_MONTH)) < Integer.parseInt(year + 12 + 31)) {
            ca.add(Calendar.DAY_OF_MONTH, 1);
            if(ca.get(Calendar.DAY_OF_WEEK) != 2) {
                continue;
            }
            month = (ca.get(Calendar.MONTH) + 1 + 100 + "").substring(1);
            day = (ca.get(Calendar.DAY_OF_MONTH) + 100 + "").substring(1);
            date = year + month + day;
            mondayList.add(date);
        }
        return mondayList;
    }

    /**
     * �õ�ĳ���µ����ڼ�������List
     *
     * @param ym ����
     * @param dateType ���ڼ� 1-������......7-������
     *
     * @return ����list
     */
    public static List<String> getWeekYmds(String ym, int dateType) {
        List<String> dayList = new ArrayList<String>();
        String lastYmd = getLastDayOfMonth(ym.substring(0, 4), ym.substring(4));
        Calendar calendar = Calendar.getInstance();
        Calendar tocalendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, Integer.parseInt(ym.substring(0, 4)));
        calendar.set(Calendar.MONTH, Integer.parseInt(ym.substring(4)) - 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        tocalendar.set(Calendar.YEAR, Integer.parseInt(ym.substring(0, 4)));
        tocalendar.set(Calendar.MONTH, Integer.parseInt(ym.substring(4)) - 1);
        tocalendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(lastYmd));

        do {
            if (calendar.get(Calendar.DAY_OF_WEEK) == dateType) {
                dayList.add(ym.substring(0, 4) + ym.substring(4) +
                    (calendar.get(Calendar.DAY_OF_MONTH) + 100 + "").substring(
                        1));
            }

            calendar.add(Calendar.DATE, 1);
        } while (!calendar.after(tocalendar));

        return dayList;
    }

     /**
     * �õ�ĳ��ĳ��������������������
     *
     * @param yq �꼾
     * @param type ���� 1���� 7����
     *
     * @return ����������
     */
    public static String[] getQSunOrSatYmds(String yq, int type) {
        String year = yq.substring(0, 4);
        String quarter = yq.substring(4);
        String fromYmd = "";
        String toYmd = "";
        String[] ymds = null;
        ArrayList<String> ymdArr = new ArrayList<String>();

        try {
            fromYmd = year + String.valueOf(((Integer.parseInt(quarter) - 1) * 3) + 101).substring(1) + "01";
            toYmd = year + String.valueOf(((Integer.parseInt(quarter) - 1) * 3) + 103).substring(1) +
                    DateUtil.getLastDayOfMonth(year,String.valueOf(((Integer.parseInt(quarter) - 1) * 3) + 103).substring(1));

            int fromY = Integer.parseInt(fromYmd.substring(0, 4));
            int fromM = Integer.parseInt(fromYmd.substring(4, 6)) - 1;
            int fromD = Integer.parseInt(fromYmd.substring(6));
            int toY = Integer.parseInt(toYmd.substring(0, 4));
            int toM = Integer.parseInt(toYmd.substring(4, 6)) - 1;
            int toD = Integer.parseInt(toYmd.substring(6));

            GregorianCalendar fromCal = new GregorianCalendar(fromY, fromM,fromD);
            GregorianCalendar toCal = new GregorianCalendar(toY, toM, toD);

            //�õ�������
            do {
                if (fromCal.get(Calendar.DAY_OF_WEEK) == type) {
                    ymdArr.add("" + fromCal.get(Calendar.YEAR) +String.valueOf(fromCal.get(Calendar.MONTH) + 101) .substring(1) +
                        String.valueOf(fromCal.get(Calendar.DAY_OF_MONTH) + 100).substring(1));
                }

                fromCal.add(Calendar.DATE, 1);
            } while (!fromCal.after(toCal));

            ymds = new String[ymdArr.size()];

            for (int i = 0; i < ymds.length; i++) {
                ymds[i] = (String) ymdArr.get(i);
            }

            return ymds;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * �õ�ĳ��ĳ�����й���������
     *
     * @param yq �꼾
     *
     * @return ����������
     */
    public static String[] getQWorkYmds(String yq) {
        String year = yq.substring(0, 4);
        String quarter = yq.substring(4);
        String fromYmd = "";
        String toYmd = "";
        String[] ymds = null;
        ArrayList<String> ymdArr = new ArrayList<String>();

        try {
            fromYmd = year + String.valueOf(((Integer.parseInt(quarter) - 1) * 3) + 101).substring(1) + "01";
            toYmd = year + String.valueOf(((Integer.parseInt(quarter) - 1) * 3) + 103).substring(1) +
                DateUtil.getLastDayOfMonth(year,String.valueOf(((Integer.parseInt(quarter) - 1) * 3) + 103).substring(1));

            int fromY = Integer.parseInt(fromYmd.substring(0, 4));
            int fromM = Integer.parseInt(fromYmd.substring(4, 6)) - 1;
            int fromD = Integer.parseInt(fromYmd.substring(6));
            int toY = Integer.parseInt(toYmd.substring(0, 4));
            int toM = Integer.parseInt(toYmd.substring(4, 6)) - 1;
            int toD = Integer.parseInt(toYmd.substring(6));

            GregorianCalendar fromCal = new GregorianCalendar(fromY, fromM,fromD);
            GregorianCalendar toCal = new GregorianCalendar(toY, toM, toD);

            //�õ�������
            do {
                if ((fromCal.get(Calendar.DAY_OF_WEEK) >= 2) && (fromCal.get(Calendar.DAY_OF_WEEK) <= 6)) {
                    ymdArr.add("" + fromCal.get(Calendar.YEAR) + String.valueOf(fromCal.get(Calendar.MONTH) + 101).substring(1) +
                        String.valueOf(fromCal.get(Calendar.DAY_OF_MONTH) + 100).substring(1));
                }

                fromCal.add(Calendar.DATE, 1);
            } while (!fromCal.after(toCal));

            ymds = new String[ymdArr.size()];

            for (int i = 0; i < ymds.length; i++) {
                ymds[i] = (String) ymdArr.get(i);
            }

            return ymds;
        } catch (Exception e) {
            return null;
        }
    }

   /**
     * �õ�ĳ��ĳ�µĹ���������
     *
     * @param ym ����
     *
     * @return �������ַ���
     */
    public static String[] getMWorkYmds(String ym) {
        String year = ym.substring(0, 4);
        String month = ym.substring(4);
        String fromYmd = "";
        String toYmd = "";
        String[] ymds = null;
        ArrayList<String> ymdArr = new ArrayList<String>();

        try {
            fromYmd = year + month + "01";
            toYmd = year + month + DateUtil.getLastDayOfMonth(year, month);

            int fromY = Integer.parseInt(fromYmd.substring(0, 4));
            int fromM = Integer.parseInt(fromYmd.substring(4, 6)) - 1;
            int fromD = Integer.parseInt(fromYmd.substring(6));
            int toY = Integer.parseInt(toYmd.substring(0, 4));
            int toM = Integer.parseInt(toYmd.substring(4, 6)) - 1;
            int toD = Integer.parseInt(toYmd.substring(6));

            GregorianCalendar fromCal = new GregorianCalendar(fromY, fromM,fromD);
            GregorianCalendar toCal = new GregorianCalendar(toY, toM, toD);

            //�õ�������
            do {
                if ((fromCal.get(Calendar.DAY_OF_WEEK) >= 2) && (fromCal.get(Calendar.DAY_OF_WEEK) <= 6)) {
                    ymdArr.add("" + fromCal.get(Calendar.YEAR) +String.valueOf(fromCal.get(Calendar.MARCH) + 101).substring(1) +
                        String.valueOf(fromCal.get(Calendar.DAY_OF_MONTH) +100).substring(1));
                }

                fromCal.add(Calendar.DATE, 1);
            } while (!fromCal.after(toCal));

            ymds = new String[ymdArr.size()];

            for (int i = 0; i < ymds.length; i++) {
                ymds[i] = (String) ymdArr.get(i);
            }

            return ymds;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * ����ָ��ʱ��ε��ض�����List.����������һ(�ܶ�������....)
     *
     * @param fromYmd ��ʼ����
     * @param toYmd ��ֹ����
     * @param type ��������:1 ���� 2 ��һ 3 �ܶ�  4 ���� 5 ���� 6 ���� 7 ����
     * @param flag �Ƿ������ʼ��ǰ������һ��ָ���������� 0:������ 1:����
     *
     * @return ���ڼ���
     */
    public static List<String> getSpecificDayList(String fromYmd, String toYmd,
        int type, int flag) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        List<String> resultList = new ArrayList<String>();
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Integer.parseInt(fromYmd.substring(0, 4)), Integer.parseInt(fromYmd.substring(4, 6)) - 1, Integer.parseInt(fromYmd.substring(6)));

        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Integer.parseInt(toYmd.substring(0, 4)), Integer.parseInt(toYmd.substring(4, 6)) - 1, Integer.parseInt(toYmd.substring(6)));

        if ((flag == 1) && (calendar1.get(Calendar.DAY_OF_WEEK) != type)) {
            while (calendar1.get(Calendar.DAY_OF_WEEK) != type) {
                calendar1.add(Calendar.DATE, -1);
            }

            resultList.add(sdf.format(calendar1.getTime()));
            calendar1.add(Calendar.DATE, 1);
        }

        while (!calendar1.after(calendar2)) {
            if (calendar1.get(Calendar.DAY_OF_WEEK) == type) {
                resultList.add(sdf.format(calendar1.getTime()));
            }

            calendar1.add(Calendar.DATE, 1);
        }

        return resultList;
    }
    /**
     * ������ʼ���������ڼ���������
     *
     * @param fromYmd ��ʼ����
     * @param toYmd ��������
     *
     * @return ���ڼ���
     */
    public static List<String>  getYmdList(String fromYmd, String toYmd) {
        List<String> ymdList = new ArrayList<String>();
        Calendar fromCa = Calendar.getInstance();
        Calendar toCa = Calendar.getInstance();

        fromCa.set(Integer.parseInt(fromYmd.substring(0, 4)),
            Integer.parseInt(fromYmd.substring(4, 6)) - 1,
            Integer.parseInt(fromYmd.substring(6)));
        toCa.set(Integer.parseInt(toYmd.substring(0, 4)),
            Integer.parseInt(toYmd.substring(4, 6)) - 1,
            Integer.parseInt(toYmd.substring(6)));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        while (!toCa.before(fromCa)) {
            ymdList.add(sdf.format(fromCa.getTime()));
            fromCa.add(Calendar.DATE, 1);
        }

        return ymdList;
    }
    
    /**
     * ����ǰ���increment���ͬ��ͬ��
     * @param format
     * @param increment
     * @return
     */
    public static String getYMDOfIncrementYear(String format,int increment){
   	 SimpleDateFormat sdf = new SimpleDateFormat(format);
   	 Calendar cal = Calendar.getInstance();
   	 cal.add(Calendar.YEAR, increment);
   	 return sdf.format(cal.getTime());
    }

    /**
   	 * ����yyyyy-MM-dd hh:mm:ss�ַ�����������Ӧ������ʱ��
   	 * 
   	 * @param strTimestamp
   	 *            �� yyyy-M-dd hh:mm ��ʽ��ʱ���ַ���
   	 * @return ת�����ʱ���
   	 */
   	public static java.sql.Timestamp parseTimestamp(String strTimestamp) {
   		return new java.sql.Timestamp(parseDateTime(strTimestamp).getTime());
   	}
   	
   	/**
   	 * ����yyyyy-MM-dd hh:mm:ss�ַ�����������Ӧ������ʱ��
   	 * 
   	 * @param strDateTime
   	 *            �ԡ�yyyy-MM-dd hh:mm:ss��Ϊ��ʽ��ʱ���ַ���
   	 * @return ת���������
   	 */
   	public static java.util.Date parseDateTime(String strDateTime) {
   		java.util.Date date = null;
   		try {
   			date = getDateTimeFormater().parse(strDateTime);
   		}
   		catch (Exception ex) {
   			System.err.println(ex.getMessage());
   		}
   		return date;
   	}
   	
   	/**
   	 * ����yyyyy-MM-dd hh:mm:ss�ַ�����������Ӧ������ʱ��
   	 * 
   	 * @param date
   	 *            ��Ҫת��������
   	 * @return ת������ַ���
   	 */
   	public static String formatDateTime(java.util.Date date) {
   		return getDateTimeFormater().format(date);
   	}
   	
   	private static DateFormat getDateTimeFormater() {
		if (dateTimeformater == null) {
			dateTimeformater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
		return dateTimeformater;
	}
}
