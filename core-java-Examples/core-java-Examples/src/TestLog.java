import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.io.*;

public class TestLog {

	public static void main(String[] args) {
		DemoLogger obj = new DemoLogger();
		try {
			FileHandler fileHandler = new FileHandler("default.log", true);
			
			//obj.makeSomeLog();
			LogManager logMgr = LogManager.getLogManager();
			Logger logger = logMgr.getLogger(Logger.GLOBAL_LOGGER_NAME);
			logger.addHandler(fileHandler);
			
			/*logger.log(Level.INFO, "This is log message");
			logger.severe("severe message");

			logger.warning("warning message");

			logger.info("info message");

			logger.config("config message");

			logger.fine("fine message");

			logger.finer("finer message");

			logger.finest("finest message");
			System.out.println(Logger.GLOBAL_LOGGER_NAME + " " + Level.INFO);
			
			fileHandler.setLevel(Level.INFO);
			*/
			fileHandler.flush();
			fileHandler.close();
			
		} catch (SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
/*
 * public class DemoLogger { private final static Logger LOGGER =
 * Logger.getLogger(Logger.GLOBAL_LOGGER_NAME); public static void makeSomeLog()
 * { LOGGER.log(Level.INFO, "My first Log Message");
 * 
 * } }
 */