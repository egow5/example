package com.example.example;

import org.apache.pulsar.functions.api.Context;

class Function implements org.apache.pulsar.functions.api.Function<Example, Example> {

    @Override public Example process(Example input, Context context) {
        return input;
    }
}
