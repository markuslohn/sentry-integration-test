package com.esentri.sentry.test;

import io.sentry.Sentry;
import io.sentry.event.BreadcrumbBuilder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * <p>
 * Test the error capture process with logging framework integration.</p>
 *
 * @author <a href="mailto:markus.lohn@bimalo.de">Markus Lohn</a>
 */
public class SentryLoggerIntegrationTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(SentryLoggerIntegrationTest.class);

    /**
     * Runs this program.
     */
    public void run() {
        LOGGER.info("Start program execution...");
        try {
            MDC.put("CustomerNumber", "004711");
            FileInputStream fis = new FileInputStream("/tmp/testfile.txt");

        } catch (FileNotFoundException ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
    }

    public static void main(String[] args) {
        SentryLoggerIntegrationTest hw = new SentryLoggerIntegrationTest();
        hw.run();
    }
}
