package de.marv.bank.utils;

import org.bukkit.entity.Player;

import java.util.UUID;

public class BankManager {

    private UUID uuid;
    private Player player;

    public BankManager(UUID uuid) {
        this.uuid = uuid;
    }

    public void openBankGUI(Player player) {
        this.player = player;
        //TODO - Open Bank GUI
    }

    public void createBankAccount(UUID uuid) {
        this.uuid = uuid;
        //TODO - create bank Account
    }

    public void saveMoneyToBank(UUID uuid, Integer amount) {
        this.uuid = uuid;
        //TODO - Save Money to Bank
    }

    public void removeMoneyFromBank(UUID uuid, Integer amount) {
        this.uuid = uuid;
        //TODO - Remove Money from Bank, add it to Wallet
    }

    public void deleteBankAccount(UUID uuid) {
        this.uuid = uuid;
        //TODO - delete Bank Account
    }
}
