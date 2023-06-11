package ru.incrementstudio.incrementstudioapi.modules.vault;

import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import ru.incrementstudio.incrementstudioapi.Logger;

import java.util.Arrays;
import java.util.List;

public class Permission {
    private net.milkbowl.vault.permission.Permission permission;
    public Permission(Plugin plugin) {
        if (!setupPermissions(plugin)) {
            new Logger(plugin).error("Не удалось зарегистрировать систему разрешений Vault");
        }
    }

    private boolean setupPermissions(Plugin plugin) {
        if (plugin.getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<net.milkbowl.vault.permission.Permission> rsp = plugin.getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
        permission = rsp.getProvider();
        return permission != null;
    }

    public boolean has(Player player, String perm) {
        return permission.has(player, perm);
    }

    public boolean has(CommandSender sender, String perm) {
        return permission.has(sender, perm);
    }

    public List<String> getGroups() {
        return Arrays.asList(permission.getGroups());
    }

    public String getGroup(Player player) {
        return permission.getPrimaryGroup(player);
    }

    public net.milkbowl.vault.permission.Permission getVaultPermission() {
        return permission;
    }
}