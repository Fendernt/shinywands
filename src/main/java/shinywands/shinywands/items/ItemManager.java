package shinywands.shinywands.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ItemManager {

    public static ItemStack ShinyWand;

    public static void initializeItems(){
        createWand();
    }

    private static void createWand(){
        //todo create a wand interface to automate this for future wands.

        ItemStack item = new ItemStack(Material.BLAZE_ROD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE+"Shiny "+ChatColor.LIGHT_PURPLE+"Wand");
        meta.setLore(Arrays.asList(ChatColor.MAGIC+""+ChatColor.DARK_PURPLE+"idk what to put here"));
        meta.addEnchant(Enchantment.LUCK,1,false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        ShinyWand = item;
    }

}
