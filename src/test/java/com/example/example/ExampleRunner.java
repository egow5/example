package com.example.example;

import java.util.Collections;
import org.apache.pulsar.client.api.Schema;
import org.apache.pulsar.common.functions.FunctionConfig;
import org.apache.pulsar.functions.LocalRunner;

class ExampleRunner {
    public static void main(String[] args) throws Exception {
        System.out.println(Schema.AVRO(Example.class).getSchemaInfo().getSchemaDefinition());
        FunctionConfig functionConfig = new FunctionConfig();
        functionConfig.setName(Function.class.getSimpleName());
        functionConfig.setInputs(Collections.singletonList("persistent://example/example/example"));
        functionConfig.setSubName("example-sub");
        functionConfig.setOutput("persistent://example/example/out");
        functionConfig.setClassName(Function.class.getName());
        functionConfig.setRuntime(FunctionConfig.Runtime.JAVA);

        LocalRunner localRunner = LocalRunner.builder().functionConfig(functionConfig).build();
        localRunner.start(false);
    }
}
