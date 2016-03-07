package ca.ljz.resq.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {

	private static Properties prop = new Properties();

	private DaoFactory() {
		try (InputStream in = DaoFactory.class.getClassLoader().getResourceAsStream("ca/ljz/resq/factory/dao.properties")) {
			prop.load(in);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static final DaoFactory instance = new DaoFactory();

	public static DaoFactory getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	public <T> T createDao(Class<T> interfaceClass) {
		try {
			String key = interfaceClass.getSimpleName();
			String className = prop.getProperty(key);
			return (T) Class.forName(className).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
