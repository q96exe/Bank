package de.marv.bank.utils;

import de.omel.api.mysql.Database;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class MySQLFile {

    public static File file;
    public static YamlConfiguration cfg;

    public MySQLFile() {

    }

    public void createNewFile() {
        file = new File("plugins/Bank", "mysql.yml");
        cfg = new YamlConfiguration();
        try {
            if(file.createNewFile()) {
                System.out.println("Die MySQL File wurde erfolgreich erstellt!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        cfg.set("MYSQL.HOST", "HOST");
        cfg.set("MYSQL.USER", "USER");
        cfg.set("MYSQL.PASSWORD", "PASSWORD");
        cfg.set("MYSQL.DATABASE", "DATABASE");

        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
