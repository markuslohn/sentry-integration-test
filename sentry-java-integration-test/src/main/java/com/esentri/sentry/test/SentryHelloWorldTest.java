package com.esentri.sentry.test;

import io.sentry.Sentry;
import io.sentry.event.BreadcrumbBuilder;
import io.sentry.event.UserBuilder;

/**
 * <p>
 * A simple test case sending events to sentry with the Java SDK.</p>
 *
 * @author <a href="mailto:markus.lohn@bimalo.de">Markus Lohn</a>
 */
public class SentryHelloWorldTest {

    /**
     * Executes the business logic.
     */
    public void run() {
        /*
         It is recommended that you use the DSN detection system, which
         will check the environment variable "SENTRY_DSN", the Java
         System Property "sentry.dsn", or the "sentry.properties" file
         in your classpath. This makes it easier to provide and adjust
         your DSN without needing to change your code. See the configuration
         page for more information.
         */
        Sentry.init();

        Sentry.getContext().setUser(new UserBuilder().setUsername("max-mustermann").build());

        Sentry.getContext().recordBreadcrumb(
                new BreadcrumbBuilder().setMessage("user-action-1").build()
        );

        Sentry.getContext().recordBreadcrumb(
                new BreadcrumbBuilder().setMessage("user-action-2").build()
        );

        Sentry.getContext().addTag("CustomerNumber", "004711");

        Sentry.capture("Testmessage send from SentryHelloWorld.");

        Sentry.clearContext();
    }

    public static void main(String[] args) {
        SentryHelloWorldTest hw = new SentryHelloWorldTest();
        hw.run();
    }
}
