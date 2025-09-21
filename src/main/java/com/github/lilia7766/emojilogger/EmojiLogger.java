package com.github.lilia7766.emojilogger;

import java.util.concurrent.ConcurrentHashMap;

public class EmojiLogger implements Logger {

    private static final ConcurrentHashMap<String, EmojiLogger> INSTANCES = new ConcurrentHashMap<>();

    private static final String INFO_EMOJI = "✅";
    private static final String INFO_COLOR = "\u001B[32m";
    private static final String WARN_EMOJI = "⚠️";
    private static final String ERROR_EMOJI = "🔴";
    private static final String DEBUG_EMOJI = "🔍";

    private final String className;

    private EmojiLogger(Class<?> clazz) {
        this.className = clazz.getSimpleName();
    }

    public static Logger getLogger(Class<?> clazz) {
        return INSTANCES.computeIfAbsent(clazz.getName(), k -> new EmojiLogger(clazz));
    }

    @Override
    public void info(String msg) {
        System.out.printf("%s%s INFO  [%s] %s%n\u001B[0m", INFO_COLOR, INFO_EMOJI, className, msg);
    }

    @Override
    public void warn(String msg) {
        System.err.printf("%s WARN  [%s] %s%n", WARN_EMOJI, className, msg);
    }

    @Override
    public void error(String msg) {
        System.err.printf("%s ERROR [%s] %s%n", ERROR_EMOJI, className, msg);
    }

    @Override
    public void debug(String msg) {
        System.out.printf("%s DEBUG [%s] %s%n", DEBUG_EMOJI, className, msg);
    }
}