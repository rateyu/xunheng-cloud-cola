package com.xunheng.base.utils;

import java.math.BigDecimal;

/**
 * @作者: hhqkkr
 * @时间: 2019/8/19 14:25
 * @描述:
 */
public class BigDecimalHandler {

    public static BigDecimal getBigDecimal(BigDecimal val){
        if(val == null)return new BigDecimal(0);
        return val;
    }

    public static BigDecimal getBigDecimal(String val){
        if(val == null || val.equals(""))return new BigDecimal(0);
        return new BigDecimal(val);
    }

    public  static BigDecimal add(BigDecimal... vals){
        BigDecimal total = new BigDecimal(0);
        for (BigDecimal val : vals) {
            if(val == null)val = new BigDecimal(0);
            total = total.add(val);
        }
        return total;
    }

    public  static BigDecimal sub(BigDecimal... vals){
        BigDecimal total = vals[0];
        if(total == null)total = new BigDecimal(0);
        for (int i = 1; i < vals.length; i++) {
            BigDecimal val = vals[i];
            if(val == null)val = new BigDecimal(0);
            total = total.subtract(val);
        }
        return total;
    }

    public  static BigDecimal multiply(BigDecimal... vals){
        BigDecimal total = new BigDecimal(0);
        for (int i = 0; i < vals.length; i++) {
            BigDecimal val = vals[i];
            if(val == null)return new BigDecimal(0);
            if(i == 0)total = val;
            else total = total.multiply(val);
        }

        return total;
    }

    /**
     * 是否大于0
     * @param val
     * @return
     */
    public static Boolean  isGreatThanZero(BigDecimal val){
       if(val == null)return false;
       if(val.compareTo(new BigDecimal(0)) == 1){
           return true;
       }else{
           return false;
       }
    }

    /**
     * 数字金额大写转换，思想先写个完整的然后将如零拾替换成零
     * 要用到正则表达式
     */
    public static String digitUppercase(double n){
        String fraction[] = {"角", "分"};
        String digit[] = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
        String unit[][] = {{"元", "万", "亿"},
                {"", "拾", "佰", "仟"}};

        String head = n < 0? "负": "";
        n = Math.abs(n);

        String s = "";
        for (int i = 0; i < fraction.length; i++) {
            s += (digit[(int)(Math.floor(n * 10 * Math.pow(10, i)) % 10)] + fraction[i]).replaceAll("(零.)+", "");
        }
        if(s.length()<1){
            s ="整";
        }
        int integerPart = (int)Math.floor(n);

        for (int i = 0; i < unit[0].length &&  integerPart > 0; i++) {
            String p ="";
            for (int j = 0; j < unit[1].length &&  n > 0; j++) {
                p = digit[integerPart%10]+unit[1][j] + p;
                integerPart = integerPart/10;
            }
            s = p.replaceAll("(零.)*零$", "").replaceAll("^$", "零") + unit[0][i] + s;
        }
        s=s.replaceAll("(零.)*零元", "元");
        s=s.replaceAll("(零.)+", "零");
        for(int i=0;i<s.length();i++){
            if(s.substring(0, 1).equals("零")){
                s=s.substring(1);
            }else{
                break;
            }
        }
        s=s.replaceAll("^整$", "零元整");
        String rmb =head + s;//.replaceAll("(零.)*零元", "元").replaceFirst("(零.)+", "").replaceAll("(零.)+", "零").replaceAll("^整$", "零元整");
        int a =rmb.indexOf("元整");
        if(a>0) rmb=rmb.substring(0,rmb.indexOf("元整"));
        return rmb;
    }

    public static void main(String[] args) {
        BigDecimal multiply = BigDecimalHandler.multiply(null, null);
        System.out.println(multiply);
    }
}
