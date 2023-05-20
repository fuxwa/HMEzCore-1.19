package net.heavenmine.hmezcore.data;

import net.heavenmine.hmezcore.Main;
import net.heavenmine.hmezcore.file.ConfigFile;
import net.heavenmine.hmezcore.modal.HomePlayerData;
import net.heavenmine.hmezcore.modal.PlayerData;

import java.io.IOException;
import java.util.List;

public class DataManager {
    private final ConfigFile configFile;
    private final MYSQLData mysqlData;
    private final YAMLData yamlData;

    public DataManager(Main main, ConfigFile configFile) {
        this.configFile = configFile;
        this.mysqlData = new MYSQLData(main, configFile);
        this.yamlData = new YAMLData(main, configFile);
    }

    public void onLoad() {
        String typeData = configFile.getTypeData();
        if (typeData.equalsIgnoreCase("mysql")) {
            mysqlData.onLoad();
        } else {
            yamlData.onLoad();
        }
    }

    public void insertPlayerData(PlayerData playerData) throws IOException {
        String typeData = configFile.getTypeData();
        if (typeData.equalsIgnoreCase("mysql")) {
            mysqlData.insertPlayerData(playerData);
        } else {
            yamlData.insertPlayerData(playerData);
        }
    }

    public void editPlayerData(PlayerData playerData) throws IOException {
        String typeData = configFile.getTypeData();
        if (typeData.equalsIgnoreCase("mysql")) {
            mysqlData.editPlayerData(playerData);
        } else {
            yamlData.editPlayerData(playerData);
        }
    }

    public void deletePlayerData(String uuid) throws IOException {
        String typeData = configFile.getTypeData();
        if (typeData.equalsIgnoreCase("mysql")) {
            mysqlData.deletePlayerData(uuid);
        } else {
            yamlData.deletePlayerData(uuid);
        }
    }

    public PlayerData getPlayerData(String uuid) {
        String typeData = configFile.getTypeData();
        if (typeData.equalsIgnoreCase("mysql")) {
            return mysqlData.getPlayerData(uuid);
        } else {
            return yamlData.getPlayerData(uuid);
        }
    }
    public void insertHomeData(HomePlayerData homePlayerData) throws IOException {
        String typeData = configFile.getTypeData();
        if (typeData.equalsIgnoreCase("mysql")) {
            mysqlData.insertHomeData(homePlayerData);
        } else {
            yamlData.insertHomeData(homePlayerData);
        }
    }
    public void editHomeData(HomePlayerData homePlayerData) throws IOException {
        String typeData = configFile.getTypeData();
        if (typeData.equalsIgnoreCase("mysql")) {
            mysqlData.editHomeData(homePlayerData);
        } else {
            yamlData.editHomeData(homePlayerData);
        }
    }
    public void deleteHomeData(String uuid, String name) throws IOException {
        String typeData = configFile.getTypeData();
        if (typeData.equalsIgnoreCase("mysql")) {
            mysqlData.deleteHomeData(uuid, name);
        } else {
            yamlData.deleteHomeData(uuid, name);
        }
    }
    public HomePlayerData getHomeData(String uuid, String name) {
        String typeData = configFile.getTypeData();
        if (typeData.equalsIgnoreCase("mysql")) {
           return mysqlData.getHomeData(uuid, name);
        } else {
           return yamlData.getHomeData(uuid, name);
        }
    }
    public List<HomePlayerData> getListHomeData(String uuid) {
        String typeData = configFile.getTypeData();
        if (typeData.equalsIgnoreCase("mysql")) {
            return mysqlData.getListHomeData(uuid);
        } else {
           return yamlData.getListHomeData(uuid);
        }
    }
}
