package starCraft;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class SC2Player implements Comparable {
    private String nickName;
    private int points;
    private League league;
    private Race race;

    public SC2Player(String name, League league, int points, Race race) {
        this.nickName = name;
        this.points = points;
        this.league = league;
        this.race = race;
    }

    public int getPoints() {
        return points;
    }
    public String getNickName() {
        return nickName;
    }
    public League getLeague() {
        return league;
    }
    public Race getRace() {
        return race;
    }

    public void addPoints(int value) {
        this.points += value;
        if(points < 0) points = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SC2Player sc2Player = (SC2Player) o;
        return points == sc2Player.points &&
                Objects.equals(nickName, sc2Player.nickName) &&
                league == sc2Player.league &&
                race == sc2Player.race;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickName, points, league, race);
    }

    @Override
    public int compareTo(@NotNull Object o) {
        if(!(o instanceof SC2Player))
            throw new IllegalArgumentException("Comparing with incorrect type.");

        SC2Player obj =  (SC2Player)o;

        return getPoints() < obj.getPoints() ? -1 :
                getPoints() < obj.getPoints() ? 1 : 0;
    }

//    @Override
//    public int compareTo(@NotNull Object o) {
//        if(!(o instanceof SC2Player))
//            throw new IllegalArgumentException("Comparing with incorrect type.");
//
//        SC2Player obj =  (SC2Player)o;
//
//        return Integer.compare(getLeague().ordinal(), obj.getLeague().ordinal());
//    }

    public String toString() {
        return "SC2Player{" + "league=" + league + ", nickName='" +
                nickName + '\'' + ", points=" + points + ", race=" +
                race + '}';
    }

}


