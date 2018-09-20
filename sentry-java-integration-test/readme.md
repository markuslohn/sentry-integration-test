# sentry-java-integration-test

[sentry.io](https://sentry.io/welcome/) is a solution to track and manage error
situations in your project. In this simple java project a test was made
for the Java SDK and logging framework integration of sentry.

To setup a test system with docker refer to [https://github.com/getsentry/onpremise](https://github.com/getsentry/onpremise).

The class

- SentryHelloWorldTest.java uses the sentry Java SDK.
- SentryLoggerIntegrationTest.java uses a Logger to report errors to sentry. See the logging configuration file.


