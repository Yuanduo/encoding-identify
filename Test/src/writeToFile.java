import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


public class writeToFile {

	/**
	 * 向文本文件中写入内容<br>
	 * 
	 * @param path
	 * @param content
	 * @param append
	 */
	public void writefile(String path, String content, boolean append) {
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

	}
}

