/*
 *  Copyright 2016 Robert Gaca 
 *  
 */

import business.enumTypes.UniqueTypes;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Robert Gaca
 */
public class UpdateCommonTypeTest {
    
    /**
     * Test of update method, of class UpdateCommonType.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        
        //Default value
        UniqueTypes uniqueTypeDefault = UniqueTypes.DefaultItem;
        Item itemDefault = new Item("Name not important here - unique type defined",10,40);
        UpdateCommonType instance = new UpdateCommonType();
        instance.update(uniqueTypeDefault, itemDefault);
        assertEquals(itemDefault.getSellIn(),9);
        assertEquals(itemDefault.getQuality(),39);
        
        UniqueTypes uniqueTypeDefault1 = UniqueTypes.DefaultItem;
        Item itemDefault1 = new Item("Name not important here - unique type defined",2,3);
        instance.update(uniqueTypeDefault1, itemDefault1);
        assertEquals(itemDefault1.getSellIn(),1);
        assertEquals(itemDefault1.getQuality(),2);
        

        //Aged Brie
        UniqueTypes uniqueTypeAgedBrie1 = UniqueTypes.AgedBrie;
        Item itemAgedBrie1 = new Item("Name not important here - unique type defined",2,0);
        instance.update(uniqueTypeAgedBrie1, itemAgedBrie1);
        assertEquals(itemAgedBrie1.getSellIn(),1);
        assertEquals(itemAgedBrie1.getQuality(),1);
        
        //Aged Brie border check
        UniqueTypes uniqueTypeAgedBrie2 = UniqueTypes.AgedBrie;
        Item itemAgedBrie2 = new Item("Name not important here - unique type defined",0,49);
        instance.update(uniqueTypeAgedBrie2, itemAgedBrie2);
        assertEquals(itemAgedBrie2.getSellIn(),-1);
        assertEquals(itemAgedBrie2.getQuality(),50);
        
        //Aged Brie border check
        UniqueTypes uniqueTypeAgedBrie3 = UniqueTypes.AgedBrie;
        Item itemAgedBrie3 = new Item("Name not important here - unique type defined",1,50);
        instance.update(uniqueTypeAgedBrie3, itemAgedBrie3);
        assertEquals(itemAgedBrie3.getSellIn(),0);
        assertEquals(itemAgedBrie3.getQuality(),50);
        
        //Sulfuras default check
        UniqueTypes uniqueTypeSulfuras = UniqueTypes.Sulfuras;
        Item itemSulfuras = new Item("Name not important here - unique type defined",40,80);
        instance.update(uniqueTypeSulfuras, itemSulfuras);
        assertEquals(itemSulfuras.getSellIn(),39);
        assertEquals(itemSulfuras.getQuality(),80);
        
        //Sulfuras with corrupted value
        UniqueTypes uniqueTypeSulfuras1 = UniqueTypes.Sulfuras;
        Item itemSulfuras1 = new Item("Name not important here - unique type defined",1,49);
        instance.update(uniqueTypeSulfuras1, itemSulfuras1);
        assertEquals(itemSulfuras1.getSellIn(),0);
        assertEquals(itemSulfuras1.getQuality(),80);
        
        //Conjured default
        UniqueTypes uniqueTypeConjured = UniqueTypes.Conjured;
        Item itemConjured = new Item("Name not important here - unique type defined",20,50);
        instance.update(uniqueTypeConjured, itemConjured);
        assertEquals(itemConjured.getSellIn(),19);
        assertEquals(itemConjured.getQuality(),48);
        
        //Conjured border
        UniqueTypes uniqueTypeConjured1 = UniqueTypes.Conjured;
        Item itemConjured1 = new Item("Name not important here - unique type defined",1,1);
        instance.update(uniqueTypeConjured1, itemConjured1);
        assertEquals(itemConjured1.getSellIn(),0);
        assertEquals(itemConjured1.getQuality(),0);
        
        //Conjured
        UniqueTypes uniqueTypeConjured2 = UniqueTypes.Conjured;
        Item itemConjured2 = new Item("Name not important here - unique type defined",3,3);
        instance.update(uniqueTypeConjured2, itemConjured2);
        assertEquals(itemConjured2.getSellIn(),2);
        assertEquals(itemConjured2.getQuality(),1);
        
        //Backstage passes
        UniqueTypes uniqueTypeBackstage = UniqueTypes.BackstagePasses;
        Item itemBackstage = new Item("Name not important here - unique type defined",20,20);
        instance.update(uniqueTypeBackstage, itemBackstage);
        assertEquals(itemBackstage.getSellIn(),19);
        assertEquals(itemBackstage.getQuality(),21);
        
        //Backstage passes  10 days or less
        UniqueTypes uniqueTypeBackstage1 = UniqueTypes.BackstagePasses;
        Item itemBackstage1 = new Item("Name not important here - unique type defined",10,20);
        instance.update(uniqueTypeBackstage1, itemBackstage1);
        assertEquals(itemBackstage1.getSellIn(),9);
        assertEquals(itemBackstage1.getQuality(),22);
        
        //Backstage passes 5 days or less
        UniqueTypes uniqueTypeBackstage2 = UniqueTypes.BackstagePasses;
        Item itemBackstage2 = new Item("Name not important here - unique type defined",5,20);
        instance.update(uniqueTypeBackstage2, itemBackstage2);
        assertEquals(itemBackstage2.getSellIn(),4);
        assertEquals(itemBackstage2.getQuality(),23);
        
        //Backstage passes after the concert
        UniqueTypes uniqueTypeBackstage3 = UniqueTypes.BackstagePasses;
        Item itemBackstage3 = new Item("Name not important here - unique type defined",0,20);
        instance.update(uniqueTypeBackstage3, itemBackstage3);
        assertEquals(itemBackstage3.getSellIn(),-1);
        assertEquals(itemBackstage3.getQuality(),0);
        
    }
}
