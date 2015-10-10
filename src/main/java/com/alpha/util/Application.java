package com.alpha.util;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

/**
 * Created by erwinschens on 10.10.15.
 */
public class Application {

    public static Config getConfig() {
        return ConfigFactory.load("application");
    }

}
