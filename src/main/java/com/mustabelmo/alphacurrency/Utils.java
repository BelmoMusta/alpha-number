package com.mustabelmo.alphacurrency;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Belmokhtar on 25/10/2017.
 */
public class Utils {
    public static final String COMA = "virgule ";
    public static final String CENT = "cent";
    static final int NB_DECIMALS = 2;
    public static final String NUM_KEY = "num.%s";
    public static final String UNITS_KEY = "units.%s";
    private static Properties PROPERTIES;

    static {
        loadProperties();
    }

    private static Properties loadProperties() {
        if (PROPERTIES == null)
            try {
                PROPERTIES = new Properties();
                ClassLoader classLoader = AlphaNumber.class.getClassLoader();
                File file = new File(classLoader.getResource("french.properties").getFile());
                PROPERTIES.load(new FileInputStream(file));
            } catch (IOException e) {
                e.printStackTrace();
            }
        return PROPERTIES;
    }

    public static String getAlphaFor(int number) {
        return PROPERTIES.get(String.format(NUM_KEY, number)).toString();
    }

    public static String getUnitAtRange(int number) {
        return PROPERTIES.get(String.format(UNITS_KEY, number)).toString();
    }
}
