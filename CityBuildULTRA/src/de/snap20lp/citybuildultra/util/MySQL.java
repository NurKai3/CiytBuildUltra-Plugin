package de.snap20lp.citybuildultra.util;

import de.snap20lp.citybuildultra.main.Main;
import org.bukkit.Bukkit;

import java.sql.*;
import java.util.UUID;

public class MySQL {

    private static Connection con;
    private final String HOST = Main.getInstance().getConfig().getString("host");
    private final String DATABASE = Main.getInstance().getConfig().getString("database");
    private final String USER = Main.getInstance().getConfig().getString("user");
    private final String PASSWORD = Main.getInstance().getConfig().getString("password");
    private boolean isconnected;

    public MySQL() {
        connect();
    }

    public boolean isIsconnected() {
        return isconnected;
    }

    public void connect() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + HOST + ":3306/" + DATABASE + "?autoReconnect=true", USER, PASSWORD);
            update("CREATE TABLE IF NOT EXISTS moneytable(UUID varchar(64),Money int)");
            isconnected = true;
        } catch (SQLException e) {
            isconnected = false;
        }
    }

    public void close() {
        try {
            if (con != null) {
                con.close();
                Bukkit.getConsoleSender().sendMessage("§8[§aMySQL§8] §a§lDie Verbindung zur MySQL wurde Erfolgreich beendet!");
            }
        } catch (SQLException e) {
            Bukkit.getConsoleSender().sendMessage("§8[§aMySQL§8] §Fehler beim beenden der Verbindung zur MySQL! Fehler:" + "e.getMessage()");
        }
    }

    public boolean update(String qry) {
        try {
            Statement st = con.createStatement();
            st.executeUpdate(qry);
            st.close();
        } catch (SQLException e) {
            connect();
            System.err.println(e);
        }
        return false;
    }

    public int queryUpdate(String qry) {
        int rs = 0;
        try {
            Statement st = con.createStatement();
            rs = st.executeUpdate(qry);
        } catch (SQLException e) {
            connect();
            System.err.println(e);
        }
        return rs;
    }

    public ResultSet query(String qry) {
        ResultSet rs = null;

        try {
            Statement st = con.createStatement();
            rs = st.executeQuery(qry);
        } catch (SQLException e) {
            connect();
            System.err.println(e);
        }
        return rs;
    }


    public boolean playerExist(String uuid, String table) {
        try {
            ResultSet rs = query("SELECT * FROM " + table + " WHERE UUID= '" + uuid + "'");
            if (rs.next()) {
                return rs.getString("UUID") != null;
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void giveMoney(UUID uuid, int money) {
        queryUpdate("UPDATE moneytable SET Money = Money+" + money + " WHERE UUID = '" + uuid.toString() + "'");
    }

    public void removeMoney(UUID uuid, int money) {
        queryUpdate("UPDATE moneytable SET Money = Money-" + money + " WHERE UUID = '" + uuid.toString() + "'");
    }

    public void resetMoney(UUID uuid) {
        queryUpdate("UPDATE moneytable SET Money = Money-" + getMoney(uuid) + " WHERE UUID = '" + uuid.toString() + "'");
    }

    public int getMoney(UUID uuid) {
        try {
            ResultSet rs = query("SELECT * FROM moneytable WHERE UUID= '" + uuid + "'");
            if (rs.next()) {
                return rs.getInt("Money");
            }
        } catch (SQLException ex) {
            return 0;
        }
        return 0;
    }
}