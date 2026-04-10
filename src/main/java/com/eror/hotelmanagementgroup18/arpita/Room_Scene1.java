package com.eror.hotelmanagementgroup18.arpita;

public class Room_Scene1 {
    private int roomNo;
    private String roomType;
    private String roomStatus;

    public Room_Scene1(int roomNo, String roomType, String roomStatus) {
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.roomStatus = roomStatus;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    @Override
    public String toString() {
        return "Room_Scene1{" +
                "roomNo=" + roomNo +
                ", roomType='" + roomType + '\'' +
                ", roomStatus='" + roomStatus + '\'' +
                '}';
    }
}
