package de.marv.bank.utils;

import de.marv.bank.main.Main;
import de.omel.api.mysql.Database;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class BankManager {

    BankInventory bankInventory = new BankInventory();
    Database database = Main.database;
    private UUID uuid;
    private Player player;

    public BankManager(Player player, UUID uuid) {
        this.uuid = uuid;
        this.player = player;
    }

    public void openBankGUI(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 9*3, "Bank");
        bankInventory.addMainItems(inventory);
        player.openInventory(inventory);
    }

    public void createBankAccount(String uuid) {
        if (!playerExists(uuid)) {
            try {
                database.updateSQL("INSERT INTO 'GUTHABEN'('UUID', 'GUTHABEN') VALUES ('" + uuid + "', '0');");
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public boolean playerExists(String uuid) {
        try {
            ResultSet rs = database.querySQL("SELECT * FROM 'GUTHABEN' WHERE 'UUID' = '" + uuid +"'");
            if(rs.next()) {
                return (rs.getString("UUID") != null);
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public int getGuthaben(String uuid) {
        int guthaben = 0;
        if(playerExists(uuid)) {
            try {
                ResultSet rs = database.querySQL("SELECT * FROM GUTHABEN WHERE UUID= '" + uuid + "'");
                if(!rs.next()) {
                    guthaben = rs.getInt("GUTHABEN");
                } else {
                    rs.getInt("GUTHABEN");
                }
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        } else {
            createBankAccount(uuid);
            getGuthaben(uuid);
        }
        return guthaben;
    }

    public void saveMoneyToBank(String uuid, Integer amount) {
        if(playerExists(uuid)) {
            int add = getGuthaben(uuid) + amount;
            try {
                database.updateSQL("UPDATE BANK SET GUTHABEN= '" + add + "' WHERE UUID= '" + uuid + "';");
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }

        } else {
            createBankAccount(uuid);
            saveMoneyToBank(uuid, amount);
        }
    }

    public void removeMoneyFromBank(String uuid, Integer amount) {
        if(playerExists(uuid)) {
            int removed = getGuthaben(uuid) - amount;
            try {
                database.updateSQL("UPDATE BANK SET GUTHABEN= '" + removed + "' WHERE UUID= '\" + uuid + \"';");
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        } else {
            createBankAccount(uuid);
            saveMoneyToBank(uuid, amount);
        }
    }

    public void resetBankAccount(String uuid) {
        if(playerExists(uuid)) {
            try {
                database.updateSQL("UPDATE BANK SET GUTHABEN= '0' WHERE UUID= '" + uuid + "';");
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void deleteBankAccount(String uuid) {
        if(playerExists(uuid)) {
            try {
                database.updateSQL("DELETE * FROM TABLE BANK WHERE UUID= '" + uuid + "';");
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
