package java8features.collectionExamples;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyValues {
	InputStream inputStream;
	public String getPropValues() throws IOException {
		Properties prop = new Properties();
		prop.load(getClass().getResourceAsStream("resources/common/configure/application.properties"));

		String propFileName = "application.properties";
//		inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
//		if(inputStream != null) {
//			prop.load(inputStream);
//		} else {
//			throw new FileNotFoundException("property file '" + propFileName + "' not found in classpath");
//		}
		System.out.println(prop);
		inputStream.close();
		
		return null;
	}
}
