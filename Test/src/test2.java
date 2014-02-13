import java.io.*;


public class test2 {
	public static void test2() throws IOException{
		BufferedReader reader1 = null;
		BufferedReader reader2 = null;

		String filepath;  //�ļ�·����
		String topath;   //���ս����ŵ��ļ���·����
		int readflag;  //����ļ��Ƿ����
		String line;   //��ȡ���ļ��е�һ��
		
		reader1 = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("�������ļ�·������ex��D:/demo.txt��: ");
		filepath = reader1.readLine();
		System.out.print("���������洢���ļ�·������ex��D:/result.txt��: ");
		topath = reader1.readLine();
		
		reader2 = new BufferedReader(new FileReader(filepath));
		while((readflag = reader2.read())!=-1){
			line = reader2.readLine();
			for(int i=0;i<line.length();i++){
				char c = line.charAt(i);       //���ļ��ֳ�һ��һ���ַ�����������ж�
				String str = String.valueOf(c);  //���ַ�ת��Ϊ�ַ���
				String test = encode(str);     //���ַ���ת��Ϊʮ�����Ʊ�ʾ
				//System.out.println(test);     //��ÿ���ַ���Ӧ��ʮ�����������
				if(test.length()==4){
					int exchange = Integer.parseInt(test,16);
					if((exchange>=45216 && exchange<=63487)||(exchange>=41376 && exchange<=41983)){
						writefile(topath,str,true);   //д�����ļ�
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
   
    	//���ֽ�������ÿ���ֽڲ���2λʮ����������
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
	        // ͨ������������ж��Ƿ����ı��ļ���׷������
	        boolean addStr = append;

	        writefile = new File(path);

	        // ����ı��ļ��������򴴽���
	        if (writefile.exists() == false) {
	            writefile.createNewFile();
	            writefile = new File(path); // ����ʵ����
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
