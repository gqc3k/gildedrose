/*
 *  Copyright 2016 Robert Gaca 
 *  
 */

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Robert Gaca
 */
public class UpdaterTest {
  
    /**
     * Test of oldUpdateMethod method, of class Updater.
     */
    @Test
    public void testOldUpdateMethod() {
        System.out.println("oldUpdateMethod");
        Updater instance = new Updater();
        
        List<Item> itemsAgedBrie = new ArrayList<Item>();
        itemsAgedBrie.add(new Item("Aged Brie",10,10));
        itemsAgedBrie.add(new Item("Super Aged Brie",2,50));
        itemsAgedBrie.add(new Item("Awesome ultra Aged Brie",0,0));
        
        instance.oldUpdateMethod(itemsAgedBrie);
       
        assertEquals(itemsAgedBrie.get(0).getSellIn(),9);assertEquals(itemsAgedBrie.get(0).getQuality(),11);
//        assertEquals(itemsAgedBrie.get(1).getSellIn(),1);assertEquals(itemsAgedBrie.get(1).getQuality(),50);
//        assertEquals(itemsAgedBrie.get(2).getSellIn(),-1);assertEquals(itemsAgedBrie.get(2).getQuality(),1);
        
        List<Item> itemsDefault = new ArrayList<Item>();
        itemsDefault.add(new Item("Default test",10,10));
        itemsDefault.add(new Item("Regular Item",1,50));
        itemsDefault.add(new Item("Custom object",0,0));
        
        instance.oldUpdateMethod(itemsDefault);
        
        assertEquals(itemsDefault.get(0).getSellIn(),9);assertEquals(itemsDefault.get(0).getQuality(),9);
        assertEquals(itemsDefault.get(1).getSellIn(),0);assertEquals(itemsDefault.get(1).getQuality(),49);
        assertEquals(itemsDefault.get(2).getSellIn(),-1);assertEquals(itemsDefault.get(2).getQuality(),0);
        
        
        List<Item> itemsSulfuras = new ArrayList<Item>();
        itemsSulfuras.add(new Item("Sulfuras one",10,10));
        itemsSulfuras.add(new Item("Sulfuras two",1,80));
        itemsSulfuras.add(new Item("Three Sulfuras",0,0));
        
        instance.oldUpdateMethod(itemsSulfuras);
        
//        assertEquals(itemsSulfuras.get(0).getSellIn(),9);assertEquals(itemsSulfuras.get(0).getQuality(),80);
//        assertEquals(itemsSulfuras.get(1).getSellIn(),0);assertEquals(itemsSulfuras.get(1).getQuality(),80);
//        assertEquals(itemsSulfuras.get(2).getSellIn(),-1);assertEquals(itemsSulfuras.get(2).getQuality(),80);
        
        List<Item> itemsBackstage = new ArrayList<Item>();
        itemsBackstage.add(new Item("Backstage passes to a TAFKAL80ETC concert",20,10));
        itemsBackstage.add(new Item("Some Backstage passes to a TAFKAL80ETC concert",10,48));
        itemsBackstage.add(new Item("lowercase backstage passes to a concert",5,45));
        itemsBackstage.add(new Item("lowercase backstage passes to a concert",4,49));
        itemsBackstage.add(new Item("lowercase backstage passes to a concert",0,43));
        
        instance.oldUpdateMethod(itemsBackstage);
        
        assertEquals(itemsBackstage.get(0).getSellIn(),19);assertEquals(itemsBackstage.get(0).getQuality(),11);
//        assertEquals(itemsBackstage.get(1).getSellIn(),9);assertEquals(itemsBackstage.get(1).getQuality(),50);
//        assertEquals(itemsBackstage.get(2).getSellIn(),4);assertEquals(itemsBackstage.get(2).getQuality(),48);
//        assertEquals(itemsBackstage.get(3).getSellIn(),3);assertEquals(itemsBackstage.get(3).getQuality(),50);
//        assertEquals(itemsBackstage.get(4).getSellIn(),-1);assertEquals(itemsBackstage.get(4).getQuality(),0);//after concert
//        
//        List<Item> itemsConjured = new ArrayList<Item>();
//        itemsConjured.add(new Item("Conjured Mana Cake",20,10));
//        itemsConjured.add(new Item("some Conjured Cake",10,50));
//        itemsConjured.add(new Item("lowercase conjured apple pie",1,1));
//        itemsConjured.add(new Item("double ConJured extra ConJured",4,49));
//        
//        instance.oldUpdateMethod(itemsConjured);
//        
//        assertEquals(itemsConjured.get(0).getSellIn(),19);assertEquals(itemsConjured.get(0).getQuality(),8);
//        assertEquals(itemsConjured.get(1).getSellIn(),9);assertEquals(itemsConjured.get(1).getQuality(),48);
//        assertEquals(itemsConjured.get(2).getSellIn(),0);assertEquals(itemsConjured.get(2).getQuality(),0);
//        assertEquals(itemsConjured.get(3).getSellIn(),3);assertEquals(itemsConjured.get(3).getQuality(),47);

        
    }

    /**
     * Test of updateItems method, of class Updater.
     */
    @Test
    public void testUpdateItems() {
        System.out.println("updateItems");
        Updater instance = new Updater();
        
        List<Item> itemsAgedBrie = new ArrayList<Item>();
        itemsAgedBrie.add(new Item("Aged Brie",10,10));
        itemsAgedBrie.add(new Item("Super Aged Brie",2,50));
        itemsAgedBrie.add(new Item("Awesome ultra Aged Brie",0,0));
        
        instance.updateItems(itemsAgedBrie);
       
        assertEquals(itemsAgedBrie.get(0).getSellIn(),9);assertEquals(itemsAgedBrie.get(0).getQuality(),11);
        assertEquals(itemsAgedBrie.get(1).getSellIn(),1);assertEquals(itemsAgedBrie.get(1).getQuality(),50);
        assertEquals(itemsAgedBrie.get(2).getSellIn(),-1);assertEquals(itemsAgedBrie.get(2).getQuality(),1);
        
        List<Item> itemsDefault = new ArrayList<Item>();
        itemsDefault.add(new Item("Default test",10,10));
        itemsDefault.add(new Item("Regular Item",1,50));
        itemsDefault.add(new Item("Custom object",0,0));
        
        instance.updateItems(itemsDefault);
        
        assertEquals(itemsDefault.get(0).getSellIn(),9);assertEquals(itemsDefault.get(0).getQuality(),9);
        assertEquals(itemsDefault.get(1).getSellIn(),0);assertEquals(itemsDefault.get(1).getQuality(),49);
        assertEquals(itemsDefault.get(2).getSellIn(),-1);assertEquals(itemsDefault.get(2).getQuality(),0);
        
        
        List<Item> itemsSulfuras = new ArrayList<Item>();
        itemsSulfuras.add(new Item("Sulfuras one",10,10));
        itemsSulfuras.add(new Item("Sulfuras two",1,80));
        itemsSulfuras.add(new Item("Three Sulfuras",0,0));
        
        instance.updateItems(itemsSulfuras);
        
        assertEquals(itemsSulfuras.get(0).getSellIn(),9);assertEquals(itemsSulfuras.get(0).getQuality(),80);
        assertEquals(itemsSulfuras.get(1).getSellIn(),0);assertEquals(itemsSulfuras.get(1).getQuality(),80);
        assertEquals(itemsSulfuras.get(2).getSellIn(),-1);assertEquals(itemsSulfuras.get(2).getQuality(),80);
        
        List<Item> itemsBackstage = new ArrayList<Item>();
        itemsBackstage.add(new Item("Backstage passes to a TAFKAL80ETC concert",20,10));
        itemsBackstage.add(new Item("Some Backstage passes to a TAFKAL80ETC concert",10,48));
        itemsBackstage.add(new Item("lowercase backstage passes to a concert",5,45));
        itemsBackstage.add(new Item("lowercase backstage passes to a concert",4,49));
        itemsBackstage.add(new Item("lowercase backstage passes to a concert",0,43));
        
        instance.updateItems(itemsBackstage);
        
        assertEquals(itemsBackstage.get(0).getSellIn(),19);assertEquals(itemsBackstage.get(0).getQuality(),11);
        assertEquals(itemsBackstage.get(1).getSellIn(),9);assertEquals(itemsBackstage.get(1).getQuality(),50);
        assertEquals(itemsBackstage.get(2).getSellIn(),4);assertEquals(itemsBackstage.get(2).getQuality(),48);
        assertEquals(itemsBackstage.get(3).getSellIn(),3);assertEquals(itemsBackstage.get(3).getQuality(),50);
        assertEquals(itemsBackstage.get(4).getSellIn(),-1);assertEquals(itemsBackstage.get(4).getQuality(),0);//after concert
        
        List<Item> itemsConjured = new ArrayList<Item>();
        itemsConjured.add(new Item("Conjured Mana Cake",20,10));
        itemsConjured.add(new Item("some Conjured Cake",10,50));
        itemsConjured.add(new Item("lowercase conjured apple pie",1,1));
        itemsConjured.add(new Item("double ConJured extra ConJured",4,49));
        
        instance.updateItems(itemsConjured);
        
        assertEquals(itemsConjured.get(0).getSellIn(),19);assertEquals(itemsConjured.get(0).getQuality(),8);
        assertEquals(itemsConjured.get(1).getSellIn(),9);assertEquals(itemsConjured.get(1).getQuality(),48);
        assertEquals(itemsConjured.get(2).getSellIn(),0);assertEquals(itemsConjured.get(2).getQuality(),0);
        assertEquals(itemsConjured.get(3).getSellIn(),3);assertEquals(itemsConjured.get(3).getQuality(),47);
        
    }
    
}
