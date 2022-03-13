import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.*;

public class DemoLogger {
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	public static void makeSomeLog() {
        LOGGER.log(Level.INFO, "My first Log Message");

	}
}
