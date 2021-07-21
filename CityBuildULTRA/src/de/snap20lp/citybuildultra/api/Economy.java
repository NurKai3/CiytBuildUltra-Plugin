package de.snap20lp.citybuildultra.api;

import de.snap20lp.citybuildultra.main.Main;
import org.bukkit.entity.Player;

public class Economy {

    public int getMoney(Player player) {
        if (Main.getInstance().getMySQL().isIsconnected()) {
            return Main.getInstance().getMySQL().getMoney(Main.getInstance().getUuidFetcher().getUUID(player.getName()));
        }
        return 0;
    }

    public int getMoney(String playerName) {
        if (Main.getInstance().getMySQL().isIsconnected()) {
            return Main.getInstance().getMySQL().getMoney(Main.getInstance().getUuidFetcher().getUUID(playerName));
        }
        return 0;
    }

    /**
     * @param onlyPositiveRange if true the Money of fromPlayer can only decrease to 0 and not lower
     */
    public void removeMoney(Player player, int money, boolean onlyPositiveRange) {

        if (Main.getInstance().getMySQL().isIsconnected()) {
            if (onlyPositiveRange) {
                if (getMoney(player) <= money) {
                    Main.getInstance().getMySQL().resetMoney(Main.getInstance().getUuidFetcher().getUUID(player.getName()));
                    return;
                }
            }
            Main.getInstance().getMySQL().removeMoney(Main.getInstance().getUuidFetcher().getUUID(player.getName()), money);
        }
    }

    /**
     * @param onlyPositiveRange if true the Money of fromPlayer can only decrease to 0 and not lower
     */
    public void removeMoney(String playerName, int money, boolean onlyPositiveRange) {
        if (Main.getInstance().getMySQL().isIsconnected()) {
            if (onlyPositiveRange) {
                if (getMoney(playerName) <= money) {
                    Main.getInstance().getMySQL().resetMoney(Main.getInstance().getUuidFetcher().getUUID(playerName));
                    return;
                }
            }
            Main.getInstance().getMySQL().removeMoney(Main.getInstance().getUuidFetcher().getUUID(playerName), money);
        }
    }

    public void addMoney(Player player, int money) {
        if (Main.getInstance().getMySQL().isIsconnected()) {
            Main.getInstance().getMySQL().giveMoney(Main.getInstance().getUuidFetcher().getUUID(player.getName()), money);
        }
    }

    public void addMoney(String playerName, int money) {
        if (Main.getInstance().getMySQL().isIsconnected()) {
            Main.getInstance().getMySQL().giveMoney(Main.getInstance().getUuidFetcher().getUUID(playerName), money);
        }
    }

    public void resetMoney(Player player) {
        if (Main.getInstance().getMySQL().isIsconnected()) {
            Main.getInstance().getMySQL().resetMoney(Main.getInstance().getUuidFetcher().getUUID(player.getName()));
        }
    }

    public void resetMoney(String playerName) {
        if (Main.getInstance().getMySQL().isIsconnected()) {
            Main.getInstance().getMySQL().resetMoney(Main.getInstance().getUuidFetcher().getUUID(playerName));
        }
    }


    /**
     * Returns the value if the transfer succeeded or not (true/false)
     *
     * @param fromPlayer        The player where the money will be removed from.
     * @param toPlayer          The player where the money will be added to.
     * @param money             The Amount of money that will be transferred
     * @param onlyPositiveRange if true the Money of fromPlayer can only decrease to 0 and not lower
     * @return The boolean if the transfer succeeded or not
     */
    public boolean transferMoney(Player fromPlayer, Player toPlayer, int money, boolean onlyPositiveRange) {
        if (Main.getInstance().getMySQL().isIsconnected()) {
            if (getMoney(fromPlayer) >= money) {
                removeMoney(fromPlayer, money, onlyPositiveRange);
                addMoney(toPlayer, money);
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the value if the transfer succeeded or not (true/false)
     *
     * @param fromPlayerName    The player where the money will be removed from.
     * @param toPlayerName      The player where the money will be added to.
     * @param money             The Amount of money that will be transferred
     * @param onlyPositiveRange if true the Money of fromPlayer can only decrease to 0 and not lower
     * @return The boolean if the transfer succeeded or not
     */
    public boolean transferMoney(String fromPlayerName, String toPlayerName, int money, boolean onlyPositiveRange) {
        if (Main.getInstance().getMySQL().isIsconnected()) {
            if (getMoney(fromPlayerName) >= money) {
                removeMoney(fromPlayerName, money, onlyPositiveRange);
                addMoney(toPlayerName, money);
                return true;
            }
        }
        return false;
    }

}
