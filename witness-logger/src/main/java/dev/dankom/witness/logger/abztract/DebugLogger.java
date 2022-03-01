package dev.dankom.witness.logger.abztract;

import dev.dankom.logger.type.LogLevel;

public class DebugLogger extends DefaultLogger {
    private final boolean seeTest;

    public DebugLogger(boolean seeTest) {
        this.seeTest = seeTest;
    }

    @Override
    public void log(LogLevel level, String loc, Object msg) {
        if (seeTest) {
            super.log(level, loc, msg);
        }
    }
}
