package com.example.app;

import org.pf4j.DefaultPluginManager;
import org.pf4j.PluginManager;
import org.pf4j.PluginWrapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@RestController
public class AppApplication {

    private static PluginManager pluginManager;

    public static void main(String[] args) {
        // Set plugins directory
        pluginManager = new DefaultPluginManager(Paths.get("plugins"));
        pluginManager.loadPlugins();
        pluginManager.startPlugins();

        SpringApplication.run(AppApplication.class, args);
    }

    @GetMapping("/greetings")
    public List<String> greetings() {
        List<GreetingExtensionPoint> greetings = pluginManager.getExtensions(GreetingExtensionPoint.class);
        return greetings.stream().map(GreetingExtensionPoint::greet).collect(Collectors.toList());
    }
}