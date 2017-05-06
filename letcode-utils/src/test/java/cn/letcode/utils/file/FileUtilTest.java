package cn.letcode.utils.file;

import java.io.File;

import cn.letcode.utils.file.FileUtil;

/**
 * 删除长文件
 * 
 * @author chensj
 *
 */
public class FileUtilTest {

	public static void main(String[] args) {
		testDeleteFile();

	}

	/**
	 * 测试删除文件
	 */
	public static void testDeleteFile() {
		String filePath = "D:\\workspaces\\kayak";
		File file = new File(filePath);
		FileUtil.deleteFiles(file);
	}

}
