package com.github.lilia7766.emojilogger;

public interface Logger {
    void info(String msg);
    void warn(String msg);
    void error(String msg);
    void debug(String msg);
}