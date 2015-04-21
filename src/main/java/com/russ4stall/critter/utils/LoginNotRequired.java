package com.russ4stall.critter.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Actions with this annotation don't require a
 * user to be logged in.
 *
 * This is used in the LoginCheckInterceptor.
 *
 * @author Russ Forstall
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface LoginNotRequired {
}
