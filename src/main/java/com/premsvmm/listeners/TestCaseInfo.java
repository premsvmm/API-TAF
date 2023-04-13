package com.premsvmm.listeners;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface TestCaseInfo {
    public String service() default "";

    public String feature() default "";

    public String usecase() default "";

    public String testDescription() default "";

    public String author() default "";

}
