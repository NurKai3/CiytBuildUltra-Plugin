package de.snap20lp.citybuildultra.api;

import de.snap20lp.citybuildultra.main.Main;

public class MySQL {

    public final String HOST = Main.getInstance().getConfig().getString("host");
    public final String DATABASE = Main.getInstance().getConfig().getString("database");
    public final String USER = Main.getInstance().getConfig().getString("user");
    public final String PASSWORD = Main.getInstance().getConfig().getString("password");

    public void connectMySQL() {
        Main.getInstance().getMySQL().connect();
    }

    public void closeMySQL() {
        Main.getInstance().getMySQL().close();
    }

    public void reconnectMySQL() {
        Main.getInstance().getMySQL().close();
        Main.getInstance().getMySQL().connect();
    }

}
