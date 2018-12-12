package starCraft;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class LeagueManager implements ILeagueManager {

    private HashMap<String,SC2Player> mLeague;

    public LeagueManager() {
        mLeague = new HashMap<>();
    }
    public LeagueManager(Collection<SC2Player> collection) {
        this();
        for(SC2Player p :
        collection) {
            mLeague.put(p.getNickName(), p);
        }
    }

    @Override
    public void addPlayer(SC2Player player) {
        if(player == null || mLeague.containsKey(player.getNickName()))
            return;
        mLeague.put(player.getNickName(), player);
    }

    @Override
    public void removePlayer(SC2Player player) {
        if(player == null || !mLeague.containsKey(player.getNickName()))
            return;
        mLeague.remove(player.getNickName(), player);
    }

    @Override
    public SC2Player getPlayer(String name) {
        return mLeague.get(name); //return null, if name is invalid
    }

    @Override
    public SC2Player[] getAllPlayers() {
        return new ArrayList<>(mLeague.values()).toArray(new SC2Player[0]);
    }

    @Override
    public SC2Player[] getPlayers(League league) {
        ArrayList<SC2Player> tmp = new ArrayList<>();
        for (SC2Player p:
             mLeague.values()) {
            if(p.getLeague() == league)
                tmp.add(p);
        }
        return tmp.toArray(new SC2Player[0]);
    }

    @Override
    public SC2Player[] getPlayers(Race race) {
        ArrayList<SC2Player> tmp = new ArrayList<>();
        for (SC2Player p:
                mLeague.values()) {
            if(p.getRace() == race)
                tmp.add(p);
        }
        return tmp.toArray(new SC2Player[0]);
    }

    @Override
    public void addPoints(String name, int points) {
        mLeague.get(name).addPoints(points);
    }
}


