import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

public class hextobin {
	private hextobin() {

	}

	/**
	 * 16进制转2进制
	 * @param hexString
	 * @return
	 */
	public static String convert(String hexString) {
		BigInteger decVal = new BigInteger(hexString, 16);
		return decVal.toString(2);
	}

	/*
	 * 16进制转2进制 转换后的结果按每4位一组用指定分隔符分割
	 */
	public static String convert(String hexString, String delimiter) {
		// 获得指定16进制的二进制形式
		String binVal = convert(hexString);

		// 将16进制的2进制形式用分割符分割
		return groupBinString(binVal, delimiter, 4);
	}

	
	/*
	 * 16进制转2进制 转换后的结果按每4位一组用指定分隔符分割, 并且16进制的0转化后的结果为0000
	 */
	public static String beautifFormatConvert(String hexString, String delimiter) {
		// 获得指定16进制的二进制形式
		String binVal = convert(hexString);

		// 将16进制的0用二进制的0000表示, 得到16进制的二进制表示结果
		int hexLen = hexString.length();
		int binLen = binVal.length();
		int fillLen = 4 * hexLen - binLen;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < fillLen; i++) {
			sb.append("0");
		}

		sb.append(binVal);

		// 给结果加入间隔符
		return groupBinString(sb.toString(), delimiter, 4);
	}

	/*
	 * 将16进制转化为2进制后的结果,用指定的分隔符分割
	 */
	public static String groupBinString(String binStr, String delimiter,
			int oneGroupCount) {
		String val = binStr;

		int len = val.length();

		StringBuilder sb = new StringBuilder();

		int remainder = len % oneGroupCount;

		if (remainder != 0) {
			sb.append(val, 0, remainder);

		} else {
			sb.append(val, 0, oneGroupCount);
			remainder = oneGroupCount;
		}

		for (int i = remainder; i < val.length(); i += oneGroupCount) {
			sb.append(delimiter);
			sb.append(val, i, i + oneGroupCount);
		}

		return sb.toString();
	}

}