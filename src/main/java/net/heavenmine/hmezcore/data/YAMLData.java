package net.heavenmine.hmezcore.data;

import net.heavenmine.hmezcore.Main;
import net.heavenmine.hmezcore.file.ConfigFile;
import net.heavenmine.hmezcore.modal.HomePlayerData;
import net.heavenmine.hmezcore.modal.PlayerData;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class YAMLData {
    private final Main main;
    private final ConfigFile configFile;
    public YAMLData(Main main,ConfigFile configFile) {
        this.main = main;
        this.configFile = configFile;
    }
    public void onLoad() {
            main.createPlayerFile();
    }
    public void insertPlayerData(PlayerData playerData) throws IOException {
        File file = new File(main.getDataFolder(), "players.yml");
        YamlConfiguration player = YamlConfiguration.loadConfiguration(new File(main.getDataFolder(), "players.yml"));
        String uuid = playerData.getUUID();
        player.set(uuid + ".username", playerData.getUserName());
        player.set(uuid + ".IPAddress", playerData.getIPAddress());
        player.set(uuid + ".firstJoin", playerData.getFirstJoin());
        player.set(uuid + ".lastOnline", playerData.getLastJoin());
        player.set(uuid + ".world", playerData.getWorld());
        player.set(uuid + ".x", playerData.getX());
        player.set(uuid + ".y", playerData.getY());
        player.set(uuid + ".z", playerData.getZ());
        player.save(file);
    }
    public void editPlayerData(PlayerData playerData) throws IOException {
        File file = new File(main.getDataFolder(), "players.yml");
        YamlConfiguration player = YamlConfiguration.loadConfiguration(new File(main.getDataFolder(), "players.yml"));
        String uuid = playerData.getUUID();
        player.set(uuid + ".username", playerData.getUserName());
        player.set(uuid + ".IPAddress", playerData.getIPAddress());
        player.set(uuid + ".firstJoin", playerData.getFirstJoin());
        player.set(uuid + ".lastOnline", playerData.getLastJoin());
        player.set(uuid + ".world", playerData.getWorld());
        player.set(uuid + ".x", playerData.getX());
        player.set(uuid + ".y", playerData.getY());
        player.set(uuid + ".z", playerData.getZ());
        player.save(file);
    }
    public void deletePlayerData(String uuid) throws IOException {
        File file = new File(main.getDataFolder(), "players.yml");
        YamlConfiguration player = YamlConfiguration.loadConfiguration(new File(main.getDataFolder(), "players.yml"));
        player.set(uuid,null);
        player.save(file);
    }
    public PlayerData getPlayerData(String uuid) {
        YamlConfiguration player = YamlConfiguration.loadConfiguration(new File(main.getDataFolder(), "players.yml"));
        String uuid_find = player.getString(uuid);
        if(uuid_find != null) {
            String id = player.getString(uuid +".id");
            String username = player.getString(uuid +".username");
            String ip_address = player.getString(uuid +".IPAddress");
            String firstjoin = player.getString(uuid +".firstJoin");
            String lastjoin = player.getString(uuid +".lastOnline");
            String world = player.getString(uuid +".world");
            String x = player.getString(uuid +".x");
            String y = player.getString(uuid +".y");
            String z = player.getString(uuid +".z");
            return new PlayerData(id,username,uuid,ip_address,firstjoin,lastjoin,world,x,y,z);
        }
        return  null;
    }
    public void insertHomeData(HomePlayerData homePlayerData) throws IOException {
        File file = new File(main.getDataFolder(), "players.yml");
        YamlConfiguration player = YamlConfiguration.loadConfiguration(new File(main.getDataFolder(), "players.yml"));
        String uuid = homePlayerData.getUuid();
        String name = homePlayerData.getHomeName();
        String path = uuid + ".home." + name;
        player.set(path + ".world", homePlayerData.getWorld());
        player.set(path + ".x", homePlayerData.getX());
        player.set(path + ".y", homePlayerData.getY());
        player.set(path + ".z", homePlayerData.getZ());
        player.save(file);
    }
    public void editHomeData(HomePlayerData homePlayerData) throws IOException {
        File file = new File(main.getDataFolder(), "players.yml");
        YamlConfiguration player = YamlConfiguration.loadConfiguration(new File(main.getDataFolder(), "players.yml"));
        String uuid = homePlayerData.getUuid();
        String name = homePlayerData.getHomeName();
        String path = uuid + ".home." + name;
        player.set(path + ".world", homePlayerData.getWorld());
        player.set(path + ".x", homePlayerData.getX());
        player.set(path + ".y", homePlayerData.getY());
        player.set(path + ".z", homePlayerData.getZ());
        player.save(file);
    }
    public void deleteHomeData(String uuid, String name) throws IOException {
        File file = new File(main.getDataFolder(), "players.yml");
        YamlConfiguration player = YamlConfiguration.loadConfiguration(new File(main.getDataFolder(), "players.yml"));
        player.set(uuid + ".home." + name, null);
        player.save(file);
    }
    public HomePlayerData getHomeData(String uuid, String name) {
        YamlConfiguration player = YamlConfiguration.loadConfiguration(new File(main.getDataFolder(), "players.yml"));
        String path = uuid + ".home." + name;
        String home_find = player.getString(path);
        if(home_find != null) {
            String username = player.getString(uuid +".username");
            String world = player.getString(path +".world");
            String x = player.getString(path +".x");
            String y = player.getString(path +".y");
            String z = player.getString(path +".z");
            return new HomePlayerData(null,username,uuid,name,world,x,y,z);
        }
        return  null;
    }
    public List<HomePlayerData> getListHomeData(String uuid) {
        YamlConfiguration player = YamlConfiguration.loadConfiguration(new File(main.getDataFolder(), "players.yml"));
        ConfigurationSection homeSection = player.getConfigurationSection(uuid + ".home");
        List<HomePlayerData> homeList = new ArrayList<>();
        if(homeSection != null) {
            for (String key : homeSection.getKeys(false)) {
                ConfigurationSection home = homeSection.getConfigurationSection(key);
                if(home != null) {
                    String world = home.getString("world");
                    String x = home.getString("x");
                    String y = home.getString("y");
                    String z = home.getString("z");
                    HomePlayerData homePlayerData = new HomePlayerData(null, player.getString(uuid+".username"),uuid, key, world, x, y, z );
                    homeList.add(homePlayerData);
                }
            }
        }

        return homeList;
    }
}
