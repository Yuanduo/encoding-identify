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
	 * 16����ת2����
	 * @param hexString
	 * @return
	 */
	public static String convert(String hexString) {
		BigInteger decVal = new BigInteger(hexString, 16);
		return decVal.toString(2);
	}

	/*
	 * 16����ת2���� ת����Ľ����ÿ4λһ����ָ���ָ����ָ�
	 */
	public static String convert(String hexString, String delimiter) {
		// ���ָ��16���ƵĶ�������ʽ
		String binVal = convert(hexString);

		// ��16���Ƶ�2������ʽ�÷ָ���ָ�
		return groupBinString(binVal, delimiter, 4);
	}

	
	/*
	 * 16����ת2���� ת����Ľ����ÿ4λһ����ָ���ָ����ָ�, ����16���Ƶ�0ת����Ľ��Ϊ0000
	 */
	public static String beautifFormatConvert(String hexString, String delimiter) {
		// ���ָ��16���ƵĶ�������ʽ
		String binVal = convert(hexString);

		// ��16���Ƶ�0�ö����Ƶ�0000��ʾ, �õ�16���ƵĶ����Ʊ�ʾ���
		int hexLen = hexString.length();
		int binLen = binVal.length();
		int fillLen = 4 * hexLen - binLen;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < fillLen; i++) {
			sb.append("0");
		}

		sb.append(binVal);

		// �������������
		return groupBinString(sb.toString(), delimiter, 4);
	}

	/*
	 * ��16����ת��Ϊ2���ƺ�Ľ��,��ָ���ķָ����ָ�
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