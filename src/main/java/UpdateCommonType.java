/*
 *  Copyright 2016 Robert Gaca 
 *  
 */

import business.configuration.Configuration;
import business.enumTypes.ConfigParameterType;
import business.enumTypes.QualityUpdateOrder;
import business.enumTypes.UniqueTypes;

/**
 *
 * @author Robert Gaca
 */
public class UpdateCommonType {

    private int qualityMultiplier;

    /**
     * After match to unique type function change SellIn and Quality depends on
     * type in switch statement
     *
     * @param uniqueType common type from system
     * @param item to update
     */
    public void update(UniqueTypes uniqueType, Item item) {
        qualityMultiplier = 1;

        switch (uniqueType) {

            case DefaultItem:
            case AgedBrie: {
                item.setQuality(calculateQuality(uniqueType.getUpdateOrder(), item.getQuality(), qualityMultiplier));
            }
            break;

            case BackstagePasses: {
                //after the concert
                if (item.getSellIn() <= 0) {
                    item.setQuality(0);
                } else {
                    //ten day or less
                    if (item.getSellIn() <= 10) {
                        qualityMultiplier = 2;
                    }
                    //five day or less
                    if (item.getSellIn() <= 5) {
                        qualityMultiplier = 3;
                    }
                    item.setQuality(calculateQuality(uniqueType.getUpdateOrder(), item.getQuality(), qualityMultiplier));
                }
            }
            break;
            case Conjured: {
                //"Conjured" items degrade in Quality twice as fast as normal items
                qualityMultiplier = 2;
                item.setQuality(calculateQuality(uniqueType.getUpdateOrder(), item.getQuality(), qualityMultiplier));
            }
            break;

            default:
            case Sulfuras: {
                //Do nothing, Sulfuras or not matched type.
                //Sulfuras has constant quality equals 80 but sellIn changes as regular item - there is no info about constant sellIn value
            }

        }
        // After calculate quality change the sellInDate
        item.setSellIn(calculateSellInDate(item.getSellIn()));
    }
    
    /**
     * If quality is between 0(minimum parameter) and 50(maximum parameter) change it depends on order.
     * When value is equal minminmal or maximum quality parameter
     * check the order and update quality if it is possible.
     * 
     * @param order ASC/DESC
     * @param oldQuality 
     * @param multiply
     * @return 
     */
    private int calculateQuality(QualityUpdateOrder order, int oldQuality, int multiply) {
        int updatedQuality = oldQuality;
        int qualityDiffValue = 1 * multiply;

        //new quality depends on order
        //default case
        if (oldQuality > Configuration.findIntConfigurationParameter(ConfigParameterType.MinQualityValue)
                && oldQuality < Configuration.findIntConfigurationParameter(ConfigParameterType.MaxQualityValue)) {
            updatedQuality = order.equals(QualityUpdateOrder.DESC) ? oldQuality - qualityDiffValue : oldQuality + qualityDiffValue;
        } 
        //when value is equal minimal quality value or maximum check the order
        else if ((oldQuality == Configuration.findIntConfigurationParameter(ConfigParameterType.MinQualityValue) && order.equals(QualityUpdateOrder.ASC))
                || (oldQuality == Configuration.findIntConfigurationParameter(ConfigParameterType.MaxQualityValue) && order.equals(QualityUpdateOrder.DESC))) {
            updatedQuality = order.equals(QualityUpdateOrder.DESC) ? oldQuality - qualityDiffValue : oldQuality + qualityDiffValue;
        }
        
        updatedQuality = checkForExtreme(updatedQuality);
        
        return updatedQuality;
    }
    
    private int calculateSellInDate(int oldSellIn) {
        return oldSellIn - 1;
    }
    /**
     * In case after update with multiply more than 1 
     * the value is too high or too low
     * @param updatedQuality
     * @return 
     */
    private int checkForExtreme(int updatedQuality) {
        if( updatedQuality>Configuration.findIntConfigurationParameter(ConfigParameterType.MaxQualityValue))
                return Configuration.findIntConfigurationParameter(ConfigParameterType.MaxQualityValue);
        if( updatedQuality<Configuration.findIntConfigurationParameter(ConfigParameterType.MinQualityValue))
                return Configuration.findIntConfigurationParameter(ConfigParameterType.MinQualityValue);
        return updatedQuality;
    }

}
