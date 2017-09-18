package com.core.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import com.core.utils.Log;

public class TextFileUtil {
	private static String currentDir = System.getProperty("user.dir");
	private static Log log = new Log(TextFileUtil.class);

	/**
	 * 读取文件到list数组中
	 */
	public static List<String> readFile(String relativePath) {
		String path = currentDir + relativePath;
		File file = new File(path);
		List<String> list = new ArrayList<>();
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			InputStreamReader io = new InputStreamReader(fileInputStream);
			BufferedReader reader = new BufferedReader(io);
			String terminalInfo = null;
			while ((terminalInfo = reader.readLine()) != null) {
				String terList = terminalInfo;
				list.add(terList);
			}
			reader.close();
			io.close();
			fileInputStream.close();
		} catch (Exception e) {
			log.error(e.toString());
		}
		return list;

	}

	/**
	 * 读取单行字符串
	 */
	public static String readline(String relativepath) {
		String path = currentDir + relativepath;
		File file = new File(path);
		String str = "";
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(file);
			InputStreamReader io = new InputStreamReader(fileInputStream);
			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(io);
			str = reader.readLine();
		} catch (FileNotFoundException e) {
			log.error(e.toString());
			log.error("没有找到文件: O(∩_∩)O哈哈~[ " + path + " ]");
		} catch (IOException e) {
			log.error(e.toString());
		}
		return str;

	}

	/**
	 * 将内容输出到文件中,文件会被更新而不是刷新
	 */
	public static void outputFile(String relativeOutputPath, String txtfie) throws IOException {
		String path = currentDir + relativeOutputPath;
		FileOutputStream fs = new FileOutputStream(new File(path));
		PrintStream p = new PrintStream(fs);
		p.println(txtfie);
		p.close();
	}

	/**
	 * 追加文件：使用FileOutputStream，在构造FileOutputStream时，把第二个参数设为true
	 * 
	 * @param fileName
	 * @param content
	 */
	public static void method1(String file, String conent) {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
			out.write(conent);
		} catch (Exception e) {
			log.error(e.toString());
		}
	}

	/**
	 * 追加文件：使用FileWriter
	 * 
	 * @param fileName
	 * @param content
	 */
	public static void method2(String fileName, String content) {
		try {
			// 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
			FileWriter writer = new FileWriter(currentDir+fileName, true);
			writer.write("\r\n" + content);
			writer.close();
		} catch (IOException e) {
			log.error(e.toString());
		}
	}

	/**
	 * 追加文件：使用RandomAccessFile
	 * 
	 * @param fileName
	 *            文件名
	 * @param content
	 *            追加的内容
	 */
	public static void method3(String fileName, String content) {
		try {
			// 打开一个随机访问文件流，按读写方式
			RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
			// 文件长度，字节数
			long fileLength = randomFile.length();
			// 将写文件指针移到文件尾。
			randomFile.seek(fileLength);
			randomFile.writeBytes(content);
			randomFile.close();
		} catch (IOException e) {
			log.error(e.toString());
		}
	}

}