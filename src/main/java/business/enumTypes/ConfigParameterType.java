package business.enumTypes;

/*
 *  Copyright 2016 Robert Gaca 
 *  
 */

/**
 *
 * @author Robert Gaca
 */
public enum ConfigParameterType {
    
    MaxQualityValue(Integer.class,"50"),
    MinQualityValue(Integer.class,"0");
            
    private Class classType ;
    private String defaultValue;

    private ConfigParameterType(Class classType, String defaultValue) {   
        this.classType = classType;
        this.defaultValue = defaultValue;
    }

    public Class getClassType() {
        return classType;
    }

    public String getDefaultValue() {
        return defaultValue;
    }
    
    
    
}
