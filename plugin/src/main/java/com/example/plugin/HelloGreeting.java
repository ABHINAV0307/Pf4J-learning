package com.example.plugin;

import com.example.app.GreetingExtensionPoint;
import org.pf4j.Extension;

@Extension
public class HelloGreeting implements GreetingExtensionPoint {
    @Override
    public String greet() {
        return "Hello from Plugin!";
    }
}