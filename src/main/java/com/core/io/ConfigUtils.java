package com.core.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import com.core.utils.Log;

/**
 * 这个类的方法用于获取配置信息的, config.properties
 */
public class ConfigUtils {
	private static final Log log = new Log(ConfigUtils.class);

	/**
	 * 私有构造方法，不需要创建对象
	 */
	private ConfigUtils() {
		log.info("无法调用哦");
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
