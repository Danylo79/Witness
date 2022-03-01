package dev.dankom.witness.logger.abztract;

import dev.dankom.logger.interfaces.ILogger;
import dev.dankom.logger.type.LogLevel;
import dev.dankom.util.general.ColorUtil;

import java.util.Date;

public class AbstractLogger {
    private final ILogger logger;

    public AbstractLogger(ILogger logger) {
        this.logger = logger;
    }

    public AbstractLogger() {
        this.logger = new DefaultLogger();
    }

    public void log(LogLevel level, String loc, Object msg) {
        logger.log(level, loc, msg);
    }

    public void info(String loc, Object msg) {
        logger.log(LogLevel.INFO, loc, msg);
    }

    public void error(String loc, Object msg) {
        logger.log(LogLevel.ERROR, loc, msg);
    }

    public void fatal(String loc, Object msg) {
        logger.log(LogLevel.FATAL, loc, msg);
    }

    public void important(String loc, Object msg) {
        logger.log(LogLevel.IMPORTANT, loc, msg);
    }

    public void test(String loc, Object msg) {
        logger.log(LogLevel.TEST, loc, msg);
    }

    public void warning(String loc, Object msg) {
        logger.log(LogLevel.WARNING, loc, msg);
    }

    public void testColors() {
        info("Test Colors", "Yellow");
        error("Test Colors", "Red");
        fatal("Test Colors", "Red");
        important("Test Colors", "Purple");
        test("Test Colors", "Green");
    }

    public static void main(String[] args) {
        new AbstractLogger((level, loc, msg) -> {
            try {
                Date date = new Date();
                String time = "[" + date.getHours() + ":" + date.getMinutes() + "." + date.getSeconds() + "]";
                loc = "[" + loc + "]";
                String print = level.getColor() + time + " [" + level.getName() + "] " + loc + " " + msg + ColorUtil.ANSI_RESET;
                System.out.println(print);
            } catch (NullPointerException e) {
            }
        }).testColors();
    }
}
