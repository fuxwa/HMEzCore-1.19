package net.heavenmine.hmezcore;

import net.heavenmine.hmezcore.file.ConfigFile;
import net.heavenmine.hmezcore.modal.HomeAmount;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;

public class Helper {
    private final ConfigFile configFile;

    public Helper(ConfigFile configFile) {
        this.configFile = configFile;
    }

    public String Print (String string, final boolean has_prefix) {
        String prefix = configFile.getPrefix();
        return ChatColor.translateAlternateColorCodes('&', has_prefix ? prefix + string : string);
    }
    public String Print (String string) {
        String prefix = configFile.getPrefix();
        return ChatColor.translateAlternateColorCodes('&', string);
    }
    public int getMaxHome(List<HomeAmount> homeAmounts, Player player) {
        int maxHome = 1;
        for (HomeAmount item : homeAmounts) {
            String name = item.getName();
            int amount = item.getAmount();

            if(player.hasPermission("hmezcore.home.multihome." + name)) {
                if(maxHome < amount)  {
                    maxHome = amount;
                }
            }
        }
        return maxHome;
    }
}
