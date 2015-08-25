import java.io.*;
import java.math.BigInteger;
dsfa
public class Test {
	/**
sdf	 * @param args
sdf	 dsfsadf*/sdf
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
dsfsdfsadfdasfsdaf
		test2 t = new test2();
		t.test2();
		
		
		BufferedReader reader  = null;
		String str = null;
		String test;
		String st;
		writeToFile wf = new writeToFile(); 
		int re;
		reader  = new BufferedReader(new FileReader("D:/demo.txt"));
		while((re = reader.read())!=-1){
			str = reader.readLine();
			System.out.println(str);
			System.out.println(str.length());
			
			for(int i=0;i<str.length();i++)
				System.out.print(str.charAt(i)+" ");
			
			test = encode(str);
			System.out.println(test);
			
			st = convert(test);
			System.out.println(st);
			
			wf.writefile("D:/result.txt", test, true);
		}//end while
	}//end main()
	
	 public static String encode(String str){ 
	    	String hexString="0123456789ABCDEF";

	    	byte[] bytes=str.getBytes();
	    	StringBuilder sb=new StringBuilder(bytes.length*2);
	   
	    	//将字节数组中每个字节拆解成2位十六进制数组
	    	for(int i=0;i<bytes.length;i++){
	    		sb.append(hexString.charAt((bytes[i]&0xf0)>>4));
	    		sb.append(hexString.charAt((bytes[i]&0x0f)>>0));
	    	}//end for
	    	return sb.toString();
	    }//end encode()
	 
	 /**
		 * 16进制转2进制
		 * @param hexString
		 * @return
		 */
		public static String convert(String hexString) {
			BigInteger decVal = new BigInteger(hexString, 16);
			return decVal.toString(2);
		}

}
