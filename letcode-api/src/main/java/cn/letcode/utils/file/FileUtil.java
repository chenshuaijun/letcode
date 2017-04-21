package cn.letcode.utils.file;

import java.io.File;

/**
 * 文件处理工具类
 * 
 * @author chensj
 *
 */
public class FileUtil {
	/**
	 * 递归删除文件<br>
	 * 通过自己调用自己的方式删除文件或者文件夹
	 * 
	 * @param file
	 *            需要删除的文件或者文件夹
	 */
	public static void deleteFiles(File file) {
		if (file.isDirectory()) {
			File[] lf = file.listFiles();
			for (File f : lf)
				deleteFiles(f);
			file.delete();
		} else {
			file.delete();
		}
	}
}
