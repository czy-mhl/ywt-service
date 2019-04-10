package com.yiwei.ywt.framework.utils;

import java.math.BigDecimal;

/**
 * 数字计算工具类.
 *
 * Created by czy on 15/8/2.
 */
public abstract class NumberUtils {

	/**
	 * 计算两个Double类型数据的和
	 * 
	 * @param d1    第一个数
	 * @param d2    第二个数
	 * @return  相加的结果
	 */
	public static Double add(Double d1, Double d2) {
		if (null == d1 && null == d2) {
			return 0d;
		}
		if (null == d1) {
			return d2;
		}
		if (null == d2) {
			return d1;
		}
		//需要转成字符串，不然会有精度丢失的问题
		BigDecimal bd1 = new BigDecimal(String.valueOf(d1));
		BigDecimal bd2 = new BigDecimal(String.valueOf(d2));
		return bd1.add(bd2).doubleValue();
	}

	/**
	 * 计算两个Double类型数据的减法
	 * 
	 * @param d1    减数
	 * @param d2    被减数
	 * @return  相减的结果
	 */
	public static Double subtract(Double d1, Double d2) {
		if (null == d1 && null == d2) {
			return 0d;
		}
		if (null == d1) {
			return 0d;
		}
		if (null == d2) {
			return d1;
		}
		if (d2 > d1) {
			return 0d;
		}
		BigDecimal bd1 = new BigDecimal(String.valueOf(d1));
		BigDecimal bd2 = new BigDecimal(String.valueOf(d2));
		return bd1.subtract(bd2).doubleValue();
	}
	
	/**
	 * 计算两个Float类型数据的减法
	 * 
	 * @param f1    减数
	 * @param f2    被减数
	 * @return  相减的结果
	 */
	public static Float subtract(Float f1, Float f2) {
		if (null == f1 && null == f2) {
			return 0f;      
		}                   
		if (null == f1) {
			return 0f;
		}
		if (null == f2) {
			return f1;
		}
		if (f2 > f1) {
			return 0f;
		}
		BigDecimal bd1 = new BigDecimal(String.valueOf(f1));
		BigDecimal bd2 = new BigDecimal(String.valueOf(f2));
		return bd1.subtract(bd2).floatValue();
	}

	/**
	 * 计算两个Double类型数据的乘法
	 * 
	 * @param d1    第一个数
	 * @param d2    第二个数
	 * @return  相乘的结果
	 */
	public static Double multiply(Double d1, Double d2) {
		if (null == d1 || null == d2) {
			return 0d;
		}
		BigDecimal bd1 = new BigDecimal(d1);
		BigDecimal bd2 = new BigDecimal(d2);
		return bd1.multiply(bd2).doubleValue();
	}
	
	/**
     * 计算Double类型的数和整型相乘
	 * double * Integer
	 *
	 * @param d1    高精度数
	 * @param i1    整型数
	 * @return  相乘的结果
	 */
	public static Double multiply(Double d1, Integer i1) {
		if (null == d1 || null == i1) {
			return 0d;
		}
		BigDecimal bd1 = new BigDecimal(d1);
		BigDecimal bd2 = new BigDecimal(i1);
		return bd1.multiply(bd2).doubleValue();
	}

    /**
     * 计算Double类型的数和浮点型相乘
     * double * float
     *
     * @param d1    高精度数
     * @param f1    整型数
     * @return  相乘的结果
     */
	public static Double multiply(Double d1, Float f1) {
		if (null == d1 || null == f1) {
			return 0d;
		}
		BigDecimal bd1 = new BigDecimal(d1);
		BigDecimal bd2 = new BigDecimal(f1);
		return bd1.multiply(bd2).doubleValue();
	}

	/**
	 * 计算两个Double类型数据的除法
	 * 
	 * @param d1    除数
	 * @param d2    被除数
	 * @return  相除的结果
	 */
	public static Double divide(Double d1, Double d2) {
		if (null == d1 || null == d2) {
			return 0d;
		}
		BigDecimal bd1 = new BigDecimal(d1);
		BigDecimal bd2 = new BigDecimal(d2);
		return bd1.divide(bd2, 4).doubleValue();
	}

	/**
	 * 计算两个Double类型数据的除法返回整数商
	 */
	public static int divideReturnInt(Double d1, Double d2) {
		if (null == d1 || null == d2) {
			return 0;
		}
		BigDecimal bd1 = new BigDecimal(d1);
		BigDecimal bd2 = new BigDecimal(d2);
		return bd1.divide(bd2, BigDecimal.ROUND_DOWN).intValue();
	}
	
	/**
	 * 汉语中数字大写
	 */
	private static final String[] CN_UPPER_NUMBER = { "零", "壹", "贰", "叁", "肆",
			"伍", "陆", "柒", "捌", "玖" };
	/**
	 * 汉语中货币单位大写，这样的设计类似于占位符
	 */
	private static final String[] CN_UPPER_MONETRAY_UNIT = { "分", "角", "元",
			"拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "兆", "拾",
			"佰", "仟" };
	/**
	 * 特殊字符：整
	 */
	private static final String CN_FULL = "整";
	/**
	 * 特殊字符：负
	 */
	private static final String CN_NEGATIVE = "负";
	/**
	 * 金额的精度，默认值为2
	 */
	private static final int MONEY_PRECISION = 2;
	/**
	 * 特殊字符：零元整
	 */
	private static final String CN_ZEOR_FULL = "零元" + CN_FULL;

	/**
	 * 把输入的金额转换为汉语中人民币的大写
	 * 
	 * @param numberOfMoney
	 *            输入的金额
	 * @return 对应的汉语大写
	 */
	public static String number2CNMontrayUnit(BigDecimal numberOfMoney) {
		StringBuffer sb = new StringBuffer();
		// -1, 0, or 1 as the value of this BigDecimal is negative, zero, or
		// positive.
		int signum = numberOfMoney.signum();
		// 零元整的情况
		if (signum == 0) {
			return CN_ZEOR_FULL;
		}
		// 这里会进行金额的四舍五入
		long number = numberOfMoney.movePointRight(MONEY_PRECISION)
				.setScale(0, 4).abs().longValue();
		// 得到小数点后两位值
		long scale = number % 100;
		int numUnit = 0;
		int numIndex = 0;
		boolean getZero = false;
		// 判断最后两位数，一共有四中情况：00 = 0, 01 = 1, 10, 11
		if (!(scale > 0)) {
			numIndex = 2;
			number = number / 100;
			getZero = true;
		}
		if ((scale > 0) && (!(scale % 10 > 0))) {
			numIndex = 1;
			number = number / 10;
			getZero = true;
		}
		int zeroSize = 0;
		while (true) {
			if (number <= 0) {
				break;
			}
			// 每次获取到最后一个数
			numUnit = (int) (number % 10);
			if (numUnit > 0) {
				if ((numIndex == 9) && (zeroSize >= 3)) {
					sb.insert(0, CN_UPPER_MONETRAY_UNIT[6]);
				}
				if ((numIndex == 13) && (zeroSize >= 3)) {
					sb.insert(0, CN_UPPER_MONETRAY_UNIT[10]);
				}
				sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
				sb.insert(0, CN_UPPER_NUMBER[numUnit]);
				getZero = false;
				zeroSize = 0;
			} else {
				++zeroSize;
				if (!(getZero)) {
					sb.insert(0, CN_UPPER_NUMBER[numUnit]);
				}
				if (numIndex == 2) {
					if (number > 0) {
						sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
					}
				} else if (((numIndex - 2) % 4 == 0) && (number % 1000 > 0)) {
					sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
				}
				getZero = true;
			}
			// 让number每次都去掉最后一个数
			number = number / 10;
			++numIndex;
		}
		// 如果signum == -1，则说明输入的数字为负数，就在最前面追加特殊字符：负
		if (signum == -1) {
			sb.insert(0, CN_NEGATIVE);
		}
		// 输入的数字小数点后两位为"00"的情况，则要在最后追加特殊字符：整
		if (!(scale > 0)) {
			sb.append(CN_FULL);
		}
		return sb.toString();
	}

	/**
	 * 计算两个Integer类型数据的除法返回Float
	 * @return
	 */
	public static Float divideReturnFloat(Integer i1, Integer i2) {
		if (null == i1 || null == i2) {
			return 0f;
		}
		if(i2 == 0){
			return 0f;
		}

		return (float)i1/i2;
	}

}
