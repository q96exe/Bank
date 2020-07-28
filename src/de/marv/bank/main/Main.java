package de.marv.bank.main;

import de.marv.bank.utils.Data;
import de.marv.bank.utils.MySQLFile;
import de.omel.api.mysql.Database;
import de.omel.api.mysql.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

public class Main extends JavaPlugin {
    public static Main instance;
    private MySQLFile mySQLFile;
    public static Database database;

    @Override
    public void onEnable() {
        instance = this;
        mySQLFile.createNewFile();
        database = new MySQL((String) MySQLFile.cfg.get("MYSQL.HOST"), "3306", (String) MySQLFile.cfg.get("MYSQL.DATABASE"),
                (String)MySQLFile.cfg.get("MYSQL.USER"), (String)MySQLFile.cfg.get("MYSQL.PASSWORD"));

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
