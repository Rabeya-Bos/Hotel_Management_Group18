package com.eror.hotelmanagementgroup18.Rabeya;

public class ReceptionistModel2 {

    private String alias;
    private String privacyLevel;
    private String villa;
    private String room;
    private String amenities;

    public ReceptionistModel2(String alias, String privacyLevel,
                              String villa, String room, String amenities) {
        this.alias = alias;
        this.privacyLevel = privacyLevel;
        this.villa = villa;
        this.room = room;
        this.amenities = amenities;
    }

    public String getAlias() {
        return alias;
    }

    public String getPrivacyLevel() {
        return privacyLevel;
    }

    public String getVilla() {
        return villa;
    }

    public String getRoom() {
        return room;
    }

    public String getAmenities() {
        return amenities;
    }
}