package com.peppermintchain.core.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Identifies the methods in a PCContract class which can be invoked as SmartContracts.
 * <pre><code>
 * &#064;PCContract
 * public class SmartContract {
 *
 * 	&#064;PCEndPoint("addCashBalance")
 * 	String addCashBalance() {
 * 		....
 * 	}
 * }
 * </code></pre>
 * @author Pramod Chandersekhar
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface PMCEndPoint {
    String value();
}
