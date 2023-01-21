package me.lingeringlizzard;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collections;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        String Meteorlore = "Fly like a Meteor";
        createarmourcraft("Meteor Armor",Material.NETHERITE_CHESTPLATE, "* *","*%*","***", Meteorlore);
        createarmourcraft("Meteor Armor",Material.NETHERITE_HELMET, "***", "* *", "   ", Meteorlore);
        createarmourcraft("Meteor Armor",Material.NETHERITE_BOOTS, "   ", "* *", "* *", Meteorlore);
        createarmourcraft("Meteor Armor",Material.NETHERITE_LEGGINGS,"***", "* *","*  *", Meteorlore);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void createarmourcraft(String customName, Material Item,String toprow, String middlerow, String bottomrow, String lore) {

        ItemStack armor = new ItemStack(Item, 1);
        ItemMeta armormeta = armor.getItemMeta();
        assert armormeta != null;
        armormeta.setDisplayName(customName);
        armormeta.setLore(Collections.singletonList(lore));
        armor.setItemMeta(armormeta);
        ShapedRecipe armorrecipe = new ShapedRecipe(new NamespacedKey(this, "armour"), armor);
        armorrecipe.shape(toprow,middlerow,bottomrow);
        armorrecipe.setIngredient('*', Material.OBSIDIAN);
        armorrecipe.setIngredient('%', Material.NETHERITE_INGOT);


        Bukkit.addRecipe(armorrecipe);


    }
}



