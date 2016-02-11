/*
 *  Copyright 2016 Robert Gaca 
 *  
 */

import business.enumTypes.UniqueTypes;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Robert Gaca
 */
public class UpdateCommonTypeTest {

    public UpdateCommonTypeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of update method, of class UpdateCommonType.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        UniqueTypes uniqueType = UniqueTypes.Sulfuras;
        
        
        Item item = new Item("Sulfuras asd", 30, 80);
        UpdateCommonType instance = new UpdateCommonType();
        instance.update(uniqueType, item);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//        assertEquals(new Item("Sulfuras asd",29,80), item);
        assertEquals(item.getQuality(), 80);
        assertEquals(item.getSellIn(), 29);

        UniqueTypes uniqueType1 = UniqueTypes.AgedBrie;
        Item item1 = new Item("Aged Brie", 30, 49);
        instance.update(uniqueType1, item1);

        assertEquals(item1.getQuality(), 50);
        assertEquals(item1.getSellIn(), 29);

        UniqueTypes uniqueType2 = UniqueTypes.Conjured;
        Item item2 = new Item("Aged Brie", 9, 45);
        instance.update(uniqueType2, item2);

        assertEquals(item2.getQuality(), 43);
        assertEquals(item2.getSellIn(), 8);

        UniqueTypes uniqueType3 = UniqueTypes.BackstagePasses;
        Item item3 = new Item("Backstage passes", 6, 40);
        instance.update(uniqueType3, item3);

        assertEquals(item3.getQuality(), 42);
        assertEquals(item3.getSellIn(), 5);

        UniqueTypes uniqueType4 = UniqueTypes.BackstagePasses;
        Item item4 = new Item("Backstage passes", 2, 40);
        instance.update(uniqueType4, item4);

        assertEquals(item4.getQuality(), 43);
        assertEquals(item4.getSellIn(), 1);

        UniqueTypes uniqueType5 = UniqueTypes.BackstagePasses;
        Item item5 = new Item("Backstage passes", 1, 49);
        instance.update(uniqueType5, item5);

        assertEquals(item5.getQuality(), 50);
        assertEquals(item5.getSellIn(), 0);
    }
}
