package com.core.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import com.core.utils.Log;

public class PropertiesUtil {
	private static Log log = new Log(PropertiesUtil.class);

	private PropertiesUtil() {
	}

	// 1.使用Java.util.Properties类的load()方法
	public static Properties getProperties(String file) {
		Properties properties = new Properties();
		try {
			File files = new File(file);
			FileInputStream in = new FileInputStream(files);
			InputStreamReader reader = new InputStreamReader(in, "UTF-8"); // 处理中文字符流
			BufferedReader buffer = new BufferedReader(reader);
			properties.load(buffer);
		} catch (IOException e) {
			log.error(e.toString());
		}
		return properties;
	}

}