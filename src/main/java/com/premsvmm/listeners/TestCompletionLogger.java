package com.premsvmm.listeners;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.util.Arrays;

public class TestCompletionLogger extends TestListenerAdapter {

    @Override
    public void onTestStart(ITestResult tr) {
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        logbold("# Test class name    : " + tr.getTestClass().getName());
        log("Test method name : " + tr.getName());
        log("Description      : " + tr.getMethod().getDescription());
        log("Parameters       : " + Arrays.toString(tr.getParameters()));
        System.out.println();
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        int seconds = (int) (tr.getEndMillis() - tr.getStartMillis());
        logpas("Result           : PASSED ; Time taken (ms) : " + seconds);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        int seconds = (int) (tr.getEndMillis() - tr.getStartMillis());
        logerr("Result           : FAILED ; Time taken (ms) : " + seconds);
        logerr("Error Description: " + tr.getThrowable().getMessage());
        logerr("Stack Trace      : " + Arrays.toString(tr.getThrowable().getStackTrace()).toString());
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        int seconds = (int) (tr.getEndMillis() - tr.getStartMillis());
        log("Result                 : SKIPPED , Time taken (ms) : " + seconds);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
    }

    private void log(String methodName) {
        System.out.println(methodName);
    }

    private void logbold(String methodName) {
        System.out.println((char) 27 + "[1m" + methodName + (char) 27 + "[0m");
    }

    private void logerr(String methodName) {
        System.out.println((char) 27 + "[31m" + methodName + (char) 27 + "[0m");
    }

    private void logpas(String methodName) {
        System.out.println((char) 27 + "[32m" + methodName + (char) 27 + "[0m");
    }
}
