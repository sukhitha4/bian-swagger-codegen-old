package org.bian.swaggercodegen.config;

import static java.util.ServiceLoader.load;

import java.util.ServiceLoader;

import org.bian.swaggercodegen.languages.JavaBianCodegen;

import io.swagger.codegen.CodegenConfig;

public class CodegenConfigLoader {
    /**
     * Tries to load config class with SPI first, then with class name directly from classpath
     *
     * @param name name of config, or full qualified class name in classpath
     * @return config class
     */
    public static CodegenConfig forName(String name) {
        try {
            return (CodegenConfig) JavaBianCodegen.class.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Can't load config class with name ".concat(name));
        }
    }
}
