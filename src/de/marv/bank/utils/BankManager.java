package de.marv.bank.utils;

import org.bukkit.entity.Player;

import java.util.UUID;

public class BankManager {

    private UUID uuid;
    private Player player;

    public BankManager(Player player, UUID uuid) {
        this.uuid = uuid;
        this.player = player;
    }

    public void openBankGUI(Player player) {
        //TODO - Open Bank GUI
    }

    public void createBankAccount(UUID uuid) {
        //TODO - create bank Account
    }

    public void saveMoneyToBank(UUID uuid, Integer amount) {
        //TODO - Save Money to Bank
    }

    public void removeMoneyFromBank(UUID uuid, Integer amount) {
        //TODO - Remove Money from Bank, add it to Wallet
    }

    public void deleteBankAccount(UUID uuid) {
        //TODO - delete Bank Account
    }
}
