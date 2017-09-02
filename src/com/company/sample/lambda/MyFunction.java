package com.company.sample.lambda;

/**
 * Created by rikim on 2017. 9. 2..
 */
public interface MyFunction<P, R> {

    R doAnything(P input);

    default String doMoreThanAnything(P input) {
        R any = doAnything(input);
        return new StringBuilder(String.valueOf(any)).append(" who is more than anything").toString();
    }
}
