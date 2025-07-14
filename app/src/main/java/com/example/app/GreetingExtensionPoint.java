package com.example.app;

import org.pf4j.ExtensionPoint;

public interface GreetingExtensionPoint extends ExtensionPoint {
    String greet();
}