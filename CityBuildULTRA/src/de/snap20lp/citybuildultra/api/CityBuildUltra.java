package de.snap20lp.citybuildultra.api;

import de.snap20lp.citybuildultra.main.Main;

public class CityBuildUltra {

    Economy economy;
    MySQL mySQL;

    public CityBuildUltra() {
        if (Main.getInstance().getMySQL().isIsconnected()) {
            economy = new Economy();
            mySQL = new MySQL();
        }
    }

    public Economy getEconomy() {
        return economy;
    }

    public MySQL getMySQL() {
        return mySQL;
    }
}
