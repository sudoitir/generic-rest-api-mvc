package ir.sudoit.infrastructure.crud.utility;

import ir.sudoit.infrastructure.exception.InputException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class PropertiesConfig {
    public String getResult(String codeOrMessage) {

        try (InputStream inputStream = InputException.class.getClassLoader().getResourceAsStream("keyvalue.properties")) {
            Properties prop = new Properties();
            if (inputStream == null) {
                Logger.getLogger("Sorry, unable to find " + "keyvalue.properties");
            }
            prop.load(inputStream);
            return prop.getProperty(codeOrMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
