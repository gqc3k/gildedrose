package business.configuration;


import business.enumTypes.ConfigParameterType;

/*
 *  Copyright 2016 Robert Gaca 
 *  
 */

/**
 *
 * @author Robert Gaca
 */
public class Configuration {

    public static int findIntConfigurationParameter(ConfigParameterType cfp) {
        if (cfp.getClassType() != Integer.class) {
            throw new RuntimeException("Wrong parameter class!");
        }

        return Integer.valueOf(cfp.getDefaultValue());
    }
    
    public static String findStringConfigurationParameter(ConfigParameterType cfp) {
        if (cfp.getClassType() != String.class) {
            throw new RuntimeException("Wrong parameter class!");
        }

        return String.valueOf(cfp.getDefaultValue());
    }
    
    /*
    ... Other types : boolean, float if necessary in future .
    */
    
}
