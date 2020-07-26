package de.marv.bank.main;

import de.marv.bank.utils.Data;
import de.omel.api.mysql.Database;
import de.omel.api.mysql.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

public class Main extends JavaPlugin {
    public static Main instance;
    public static Database database;

    @Override
    public void onEnable() {
        instance = this;
        database = new MySQL("localhost", "3306", "bank", "root", "Mine#497");

        try {
            if(database.checkConnection()) {
                Bukkit.getConsoleSender().sendMessage(Data.prefix + "§aDas Plugin wurde erfolgreich aktiviert");
                Bukkit.getConsoleSender().sendMessage(Data.prefix + "§aMySQL erfolgreich verbunden");
                database.updateSQL("CREATE TABLE IF NOT EXISTS UUID(VARCHAR (100), Guthaben int);");
            }
        } catch (SQLException | ClassNotFoundException e) {
            Bukkit.getConsoleSender().sendMessage(Data.prefix + "§cMySQL Verbindung fehlgeschlagen! Bitte überprüfe die MySQL Daten!");
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(Data.prefix + "§cDas Plugin wurde erfolgreich deaktiviert");
    }

    public void init() {
        //COMMANDS

        //EVENTS

    }

    public static Main getInstance() {
        return instance;
    }
}
