/*
 *  Copyright 2016 Robert Gaca 
 *  
 */

import business.enumTypes.UniqueTypes;
import java.util.List;

/**
 *
 * @author Robert Gaca
 */
public class Updater {
    
    private UpdateCommonType updateCommonType;

    public Updater() {
        updateCommonType = new UpdateCommonType();
    }
    
    /*
    Old function
    */
    public void oldUpdateMethod(List<Item> items) {
        for (int i = 0; i < items.size(); i++) {
            if ((!"Aged Brie".equals(items.get(i).getName())) && !"Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName())) {
                if (items.get(i).getQuality() > 0) {
                    if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName())) {
                        items.get(i).setQuality(items.get(i).getQuality() - 1);
                    }
                }
            } else {
                if (items.get(i).getQuality() < 50) {
                    items.get(i).setQuality(items.get(i).getQuality() + 1);

                    if ("Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName())) {
                        if (items.get(i).getSellIn() < 11) {
                            if (items.get(i).getQuality() < 50) {
                                items.get(i).setQuality(items.get(i).getQuality() + 1);
                            }
                        }

                        if (items.get(i).getSellIn() < 6) {
                            if (items.get(i).getQuality() < 50) {
                                items.get(i).setQuality(items.get(i).getQuality() + 1);
                            }
                        }
                    }
                }
            }

            if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName())) {
                items.get(i).setSellIn(items.get(i).getSellIn() - 1);
            }

            if (items.get(i).getSellIn() < 0) {
                if (!"Aged Brie".equals(items.get(i).getName())) {
                    if (!"Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName())) {
                        if (items.get(i).getQuality() > 0) {
                            if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName())) {
                                items.get(i).setQuality(items.get(i).getQuality() - 1);
                            }
                        }
                    } else {
                        items.get(i).setQuality(items.get(i).getQuality() - items.get(i).getQuality());
                    }
                } else {
                    if (items.get(i).getQuality() < 50) {
                        items.get(i).setQuality(items.get(i).getQuality() + 1);
                    }
                }
            }
        }
    }

    /**
     *For all items in list do update task.
     * @param items which we want to inspect/update
     */
    public void updateItems(List<Item> items) {

        for (Item item : items) {
            updateCommonType.update(findMatchingItem(item), item);
        }

    }
    
    /**
     * Simple encoding type of item
     * by checking if there is a substring
     * matching our common type - described in DESCRIPTION
     * 
     * @param item from system, UI
     * @return matching enum Type
     */
    private static UniqueTypes findMatchingItem(Item item) {
        UniqueTypes uniqueType = UniqueTypes.DefaultItem;

        for (UniqueTypes utype : UniqueTypes.values()) {
            if (item.getName().toLowerCase().contains(utype.getDescription().toLowerCase())) {
                uniqueType = utype;
                break;
            }
        }
        
        return uniqueType;
    }
}
