package starCraft;

public interface ILeagueManager {

    void addPlayer(SC2Player player);
    void removePlayer(SC2Player player);
    SC2Player getPlayer(String name);
    SC2Player[] getAllPlayers();
    SC2Player[] getPlayers(League league);
    SC2Player[] getPlayers(Race race);
    void addPoints(String name, int points);
}
