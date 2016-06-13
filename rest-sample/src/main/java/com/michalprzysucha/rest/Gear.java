package com.michalprzysucha.rest;

/**
 * @author Michal Przysucha
 * @since 2014-11-11
 */
public class Gear {

    private String shaft;
    private String gearbox;
    private String clutch;

    public String getShaft() {
        return shaft;
    }

    public void setShaft(String shaft) {
        this.shaft = shaft;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public String getClutch() {
        return clutch;
    }

    public void setClutch(String clutch) {
        this.clutch = clutch;
    }

    @Override
    public String toString() {
        return "Gear{" +
                "shaft='" + shaft + '\'' +
                ", gearbox='" + gearbox + '\'' +
                ", clutch='" + clutch + '\'' +
                '}';
    }
}
