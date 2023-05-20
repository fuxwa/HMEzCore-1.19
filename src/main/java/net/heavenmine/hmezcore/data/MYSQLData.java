package net.heavenmine.hmezcore.data;

import net.heavenmine.hmezcore.Main;
import net.heavenmine.hmezcore.file.ConfigFile;
import net.heavenmine.hmezcore.modal.HomePlayerData;
import net.heavenmine.hmezcore.modal.PlayerData;

import java.util.List;

public class MYSQLData {
    private Main main;
    private final ConfigFile configFile;
    public MYSQLData(Main main,ConfigFile configFile) {
        this.main = main;
        this.configFile = configFile;
    }
    public void onLoad() {

    }
    public void insertPlayerData(PlayerData playerData) {

    }
    public void editPlayerData(PlayerData playerData) {

    }
    public void deletePlayerData(String uuid) {

    }
    public PlayerData getPlayerData(String uuid) {

        return  null;
    }

    public void insertHomeData(HomePlayerData homePlayerData) {

    }
    public void editHomeData(HomePlayerData homePlayerData) {

    }
    public void deleteHomeData(String uuid, String name) {

    }
    public HomePlayerData getHomeData(String uuid, String name) {

        return  null;
    }
    public List<HomePlayerData> getListHomeData(String uuid) {
        return null;
    }
}
