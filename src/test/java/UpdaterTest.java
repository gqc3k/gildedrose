/*
 *  Copyright 2016 Robert Gaca 
 *  
 */

import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
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
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Aged Brie",10,10));
        items.add(new Item("Aged Brie",2,50));
        items.add(new Item("Sulfuras tested", 40, 80));
        Updater instance = new Updater();
        instance.oldUpdateMethod(items);
       
        assertEquals(items.get(0).getQuality(),11);
        assertEquals(items.get(1).getQuality(),50);
        assertEquals(items.get(2).getSellIn(),39);
        assertEquals(items.get(2).getQuality(),80); //error SULFURAS has constant Value but method try to decrease it
        
    }

    /**
     * Test of updateItems method, of class Updater.
     */
    @Test
    public void testUpdateItems() {
        System.out.println("updateItems");
        List<Item> items = new ArrayList<Item>();
        
        items.add(new Item("Aged Brie",10,10));
        items.add(new Item("Aged Brie",2,50));
        items.add(new Item("Sulfuras tested", 40, 80));
        
        
        Updater instance = new Updater();
        instance.updateItems(items);
       
        assertEquals("should be 10",items.get(0).getQuality(),11);
        assertEquals(items.get(1).getQuality(),50);
        assertEquals(items.get(2).getSellIn(),39);
        assertEquals(items.get(2).getQuality(),80);
    }
    
}
