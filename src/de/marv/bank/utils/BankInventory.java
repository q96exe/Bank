package de.marv.bank.utils;

import de.omel.api.itemstack.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

public class BankInventory {

    public BankInventory() {
    }

    public void addMainItems(Inventory inventory) {

        for (int i = 0; i < inventory.getSize(); i++) {
            inventory.setItem(i, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (short) 15).setDisplayname("").build());
        }
        inventory.setItem(10, new ItemBuilder(Material.CHEST).setDisplayname("§6Geld einzahlen").build());
        inventory.setItem(14, new ItemBuilder(Material.DISPENSER).setDisplayname("§eGeld abheben").build());
    }
}
