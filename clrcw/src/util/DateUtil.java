package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 *<p>Title: </p>
 *
 *<p>Description: </p>
 *
 *<p>Company: 航天四创</p>
 *
 * @author 李滨
 *
 * @version 1.0
 */
public class DateUtil {
	 //每一天的毫秒数
    private static final long MS_EVERY_DAY = 1000 * 60 * 60 *24;

    //默认的pattern
    private static final String PATTERN = "yyyyMMdd";
    
    private static final String PATTERN_TIME = "yyyy-MM-dd HH:mm:ss.S";
    
    private static final String PATTERN_TIME2 = "yyyy-MM-dd";
    
    public static final String PATTERN_TIME3 = "yyyy-MM-dd";
    
    // 日期格式化
    private static SimpleDateFormat dateFormat;


    static {
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }
    /**
     *
     */
    public DateUtil() {
        super();
    }

    /**
     * 返回昨天的日期
     * @return
     */
    public static String getYesterdayDate(){

        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        java.util.Date beginDate = calendar.getTime();
        SimpleDateFormat dateFmt = new SimpleDateFormat(PATTERN);
        String yesterdayDate = dateFmt.format(beginDate);

        return yesterdayDate;
    }

    /**
     * 由日期型转化为"yyyyMMdd"形式的String类型
     * @param date
     * @return
     */
    public static String dateToString(Date date){

        SimpleDateFormat dateFmt = new SimpleDateFormat(PATTERN);
        return dateFmt.format(date);
    }

    /**
     * 由日期型转化为"yyyyMMdd"形式的String类型
     * @param date
     * @return
     */
    public static String dateToString(Date date , String pattern){

        SimpleDateFormat dateFmt = new SimpleDateFormat( pattern );
        return dateFmt.format(date);
    }
    /**
     * 由String类型，转化为日期型
     * @param strDate
     * @return
     * @throws ParseException
     */
    public static Date stringToDate( String strDate ) throws ParseException{
        DateFormat df = new SimpleDateFormat(PATTERN);
        Date date = df.parse( strDate );
        return date;
    }

    /**
     * 由String类型，转化为日期型
     * @param strDate
     * @return
     * @throws ParseException
     */
    public static Date stringToDate_Time( String strDate ) throws ParseException{
        DateFormat df = new SimpleDateFormat(PATTERN_TIME);
        Date date = df.parse( strDate );
        return date;
    }

    /**
     * 由String类型，转化为日期型
     * @param strDate zhs加
     * @return
     * @throws ParseException
     */
    public static Date stringToDate_Time2( String strDate ) throws ParseException{
        DateFormat df = new SimpleDateFormat(PATTERN_TIME2);
        Date date = df.parse( strDate );
        return date;
    }
    
    /**
     * 由String类型，转化为日期型
     * @param strDate 
     * @return
     * @throws ParseException
     */
    public static Date stringTo_Date_Time2( String strDate ) throws ParseException{
        DateFormat df = new SimpleDateFormat(PATTERN_TIME3);
        Date date = df.parse( strDate );
        return date;
    }
    
    /**
     * 由String类型，转化为日期型
     * @param strDate
     * @return
     * @throws ParseException
     */
    public static Date stringToDate( String strDate, String pattern ) throws ParseException{
        DateFormat df = new SimpleDateFormat(pattern);
        Date date = df.parse( strDate );
        return date;
    }

    /**
     * 得到两个日期型数据之间所差的天数,此处为闭区间
     * @param beginDate 起始的日期
     * @param endDate 结束的日期
     * @return 相差的天数
     */
    public static long compare( Date beginDate, Date endDate ){
        long beginTime = beginDate.getTime();
        long endTime = endDate.getTime();
        long betweenDays = (endTime - beginTime) / MS_EVERY_DAY ;
        if( betweenDays >= 0)
            return betweenDays + 1;
        
        return betweenDays -1;
    }

    /**
     * 取date后第n天的Date
     * @param date
     * @param n
     * @return
     */
    public static Date nextDate( Date date , int n ){
        long day = n * MS_EVERY_DAY ;
        Date d = new Date( date.getTime() + day );
        return d ;
    }

     /**
     * 取得n天时间
     *
     * @param n n=0 今天 n=1 明天；n=0 今天 n=-1 昨天
     * @return String 返回n天时间 yyyy-mm-dd
     */
    public static String getDateList(int n) {

        GregorianCalendar gcDate = new GregorianCalendar();
        String sbDateTodayTime;
        int year = gcDate.get(1);
        int month = gcDate.get(2);
        int date = gcDate.get(5);
        GregorianCalendar oneWeek = new GregorianCalendar(year, month, date);
        oneWeek.add(5, n);
        java.util.Date date2 = oneWeek.getTime();
        sbDateTodayTime = dateFormat.format(date2);
        return sbDateTodayTime;
    }
    
    /**
     * 获取当前时间，返回时间格式(如果调用参数为true时返回yyyy-MM-dd HH:mm:ss
     * ，否则为false时返回yyyy-MM-DD不带日期格式)
     * @param time boolean
     * @return String
     * 
     */
    public static String getNowTime(boolean time){
        Date now = new Date();
        String format = "";
        //yyyy-MM-dd HH:mm:ss:S 年月日时分秒毫杪
        if (time) {
            format = "yyyy-MM-dd ";
        } else {
            format = "yyyy-MM-dd HH:mm:ss.s";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String nowtime = sdf.format(now);
        return nowtime;
    }
}
