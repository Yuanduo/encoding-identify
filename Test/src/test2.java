import java.io.*;


public class test2 {
	public static void test2() throws IOException{
		BufferedReader reader1 = null;
		BufferedReader reader2 = null;

		String filepath;  //文件路径名
		String topath;   //最终结果存放的文件的路径名
		int readflag;  //检测文件是否读完
		String line;   //读取的文件中的一行
		
		reader1 = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("请输入文件路径名（ex：D:/demo.txt）: ");
		filepath = reader1.readLine();
		System.out.print("请输入结果存储的文件路径名（ex：D:/result.txt）: ");
		topath = reader1.readLine();
		
		reader2 = new BufferedReader(new FileReader(filepath));
		while((readflag = reader2.read())!=-1){
			line = reader2.readLine();
			for(int i=0;i<line.length();i++){
				char c = line.charAt(i);       //将文件分成一个一个字符，方便进行判断
				String str = String.valueOf(c);  //将字符转化为字符串
				String test = encode(str);     //将字符串转化为十六进制表示
				//System.out.println(test);     //将每个字符对应的十六进制码输出
				if(test.length()==4){
					int exchange = Integer.parseInt(test,16);
					if((exchange>=45216 && exchange<=63487)||(exchange>=41376 && exchange<=41983)){
						writefile(topath,str,true);   //写入结果文件
					}
				}
				else
					writefile(topath,str,true);
			}//end for
		}//end while
	}//end test2()
	
	
	
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
	
	
	
	public static void writefile(String path, String content, boolean append) {
	    BufferedWriter bw;
	    File writefile;
	    try {
	        // 通过这个对象来判断是否向文本文件中追加内容
	        boolean addStr = append;

	        writefile = new File(path);

	        // 如果文本文件不存在则创建它
	        if (writefile.exists() == false) {
	            writefile.createNewFile();
	            writefile = new File(path); // 重新实例化
	        }
	        FileWriter fw = new FileWriter(writefile, addStr);
	        bw = new BufferedWriter(fw);
	        fw.write(content);
	        fw.flush();
	        fw.close();
	    } catch (Exception d) {
	        System.out.println(d.getMessage());
	    }

	}//end writefile()

}
