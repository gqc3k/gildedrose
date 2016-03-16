package business.enumTypes;

/*
 *  Copyright 2016 Robert Gaca    
 */

/**
 *
 * @author Robert Gaca
 */
public enum UniqueTypes {
    
    DefaultItem(QualityUpdateOrder.DESC,"Default Item","Regular",0,true),
    AgedBrie(QualityUpdateOrder.ASC,"Aged Brie","actually increases in Quality the older it gets",0,true),
    Sulfuras(QualityUpdateOrder.DESC,"Sulfuras","Regular",80,false),
    BackstagePasses(QualityUpdateOrder.ASC,"Backstage passes","Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but Quality drops to 0 after the concert",0,true),
    Conjured(QualityUpdateOrder.DESC,"Conjured","items degrade in Quality twice as fast as normal items",0,true),
    OldOne(QualityUpdateOrder.ASC,"OLD","Some old one",0,true)
    
    private UniqueTypes(QualityUpdateOrder updateOrder, String description, String  updateFormula,int constantValue,boolean possibleToSell) {
        this.qualityUpdateOrder = updateOrder;
        this.description = description;
        this.updateFormula = updateFormula;
        this.constantValue = constantValue;
        this.possibleToSell = possibleToSell;
    }
  
    private QualityUpdateOrder qualityUpdateOrder;
    private String description;
    private String  updateFormula;
    //there is no constant value if this value == 0
    private int constantValue;
    private boolean possibleToSell;
    
    public QualityUpdateOrder getUpdateOrder() {
        return qualityUpdateOrder;
    }

    public String getDescription() {
        return description;
    }

    public String getUpdateFormula() {
        return updateFormula;
    }

    public int getConstantValue() {
        return constantValue;
    }

    public boolean isPossibleToSell() {
        return possibleToSell;
    }
    
    
    
}
