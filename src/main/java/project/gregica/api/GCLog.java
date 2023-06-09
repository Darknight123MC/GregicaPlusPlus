package project.gregica.api;

import org.apache.logging.log4j.Logger;

public class GCLog {
    public static Logger logger;

    public GCLog() {
    }

    public static void init(Logger modLogger) {
        logger = modLogger;
    }
    
    public static void info(String info){
        logger.info(info);
    }
}
