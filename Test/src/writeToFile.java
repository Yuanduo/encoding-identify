import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


public class writeToFile {

	/**
	 * ���ı��ļ���д������<br>
	 * 
	 * @param path
	 * @param content
	 * @param append
	 */
	public void writefile(String path, String content, boolean append) {
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

	}
}

