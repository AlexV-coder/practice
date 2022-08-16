package com.alex.springcloudfunctions;

import java.util.function.Function;

public class ToLowerCase implements Function<String, String> {
    @Override
    public String apply(String s) {
        return new StringBuilder(s).toString().toLowerCase();
    }
}
