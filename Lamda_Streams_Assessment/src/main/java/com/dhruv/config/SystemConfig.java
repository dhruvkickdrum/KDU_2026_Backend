package com.dhruv.config;

import org.w3c.dom.ranges.Range;

import java.lang.reflect.Field;

public class SystemConfig {
    @RangeCheck(min = 1, max = 16)
    private int maxThreads;

    @RangeCheck(min = 100 , max = 5000)
    private int timeoutSeconds;

    public SystemConfig(int maxThreads, int timeoutSeconds) {
        this.maxThreads = maxThreads;
        this.timeoutSeconds = timeoutSeconds;
        validate();
    }

    private void validate() {
        for(Field field : this.getClass().getDeclaredFields()) {
            if(field.isAnnotationPresent(RangeCheck.class)) {
                field.setAccessible(true);
                RangeCheck range = field.getAnnotation(RangeCheck.class);

                try {
                    int value = field.getInt(this);
                    if(value < range.min() || value > range.max()) {
                        throw new ConfigValidationException(
                                field.getName() + " must be between " + range.min() + " and " + range.max()
                        );
                    }
                    logSuccess(field.getName() + " validated ");
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }



    public static void logSuccess(String message) {
        System.out.println("SUCCESS:" + message);
    }
}
