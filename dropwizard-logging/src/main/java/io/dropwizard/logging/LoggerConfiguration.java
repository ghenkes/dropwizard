package io.dropwizard.logging;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import ch.qos.logback.classic.spi.ILoggingEvent;
import com.google.common.collect.ImmutableList;
import ch.qos.logback.classic.Logger;

import ch.qos.logback.classic.Level;

import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

/**
 * Individual {@link Logger} configuration
 */
public class LoggerConfiguration {

    @NotNull
    private Level level = Level.INFO;

    @Valid
    @NotNull
    private ImmutableList<AppenderFactory<ILoggingEvent>> appenders = ImmutableList.of();

    private boolean additive = true;

    @NotNull
    private TimeZone timeZone = TimeZone.getTimeZone("UTC");

    private Optional<String> logFormat = Optional.empty();

    public boolean isAdditive() {
        return additive;
    }

    public void setAdditive(boolean additive) {
        this.additive = additive;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public ImmutableList<AppenderFactory<ILoggingEvent>> getAppenders() {
        return appenders;
    }

    public void setAppenders(List<AppenderFactory<ILoggingEvent>> appenders) {
        this.appenders = ImmutableList.copyOf(appenders);
    }

    public String getLogFormat() {
        return logFormat.orElse(getDefaultLogFormat(timeZone));
    }

    public void setLogFormat(String logFormat) {
        this.logFormat = Optional.ofNullable(logFormat);
    }

    private static String getDefaultLogFormat(TimeZone timeZone) {
        return "%-5p [%d{ISO8601," + timeZone.getID() + "}] %c: %m%n%rEx";
    }
}
