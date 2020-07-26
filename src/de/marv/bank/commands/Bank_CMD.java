package de.marv.bank.commands;

import de.marv.bank.utils.Data;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Bank_CMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("bank")) {
            if(args.length == 0) {
                //TODO - Open Bank
            } else {
                p.sendMessage(Data.use + "bank");
            }
        }
        return false;
    }
}
