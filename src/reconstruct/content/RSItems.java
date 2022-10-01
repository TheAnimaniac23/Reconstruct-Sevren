package reconstruct.content;

import arc.graphics.Color;
import mindustry.type.Item;

public class RSItems {
    
    public static Item
        gold, cobalt, plasteel;
    
    public static void load() {
        gold = new Item("gold", Color.valueOf("FFD700"));
        cobalt = new Item("cobalt", Color.valueOf("0047ab"));
        plasteel = new Item("plasteel", Color.valueOf("678b59"));
    }
}