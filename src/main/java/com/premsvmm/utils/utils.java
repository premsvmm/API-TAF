package com.premsvmm.utils;

import org.testng.asserts.SoftAssert;

import java.util.Map;

public class utils {

    public static void assertCommonObject(Map<Object, Object> actual, Map<Object, Object> expected) {
        SoftAssert softAssert = new SoftAssert();
        actual.entrySet().stream().forEach(
                (e1) -> {
                    Object key = e1.getKey();
                    if (expected.containsKey(key)) {
                        softAssert.assertEquals(actual.get(key), expected.get(key), "Actual:" + actual.get(key) + " Expected:" + expected.get(key));
                    }
                }
        );
        softAssert.assertAll();
    }
}
