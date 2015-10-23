package com.alpha.util;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Application {

    public static Config getConfig() {
        return ConfigFactory.load("application");
    }

}
