package com.goit.hotelonlinebooking.entity;

public class Hotel {
    private long hotelId;
    private String hotelName;
    private String cityName;
    //private int price;


    public Hotel(long hotelId, String hotelName, String cityName) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public String getHotelName() {
        return hotelName;
    }

    public long getHotelId() {
        return hotelId;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Hotel{" +
                "cityName='" + cityName + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", hotelId=" + hotelId +
                '}';
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Hotel)) return false;
        if (!super.equals(object)) return false;

        Hotel hotel = (Hotel) object;

        if (getHotelId() != hotel.getHotelId()) return false;
        if (getCityName() != null ? !getCityName().equals(hotel.getCityName()) : hotel.getCityName() != null)
            return false;
        if (getHotelName() != null ? !getHotelName().equals(hotel.getHotelName()) : hotel.getHotelName() != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getCityName() != null ? getCityName().hashCode() : 0);
        result = 31 * result + (getHotelName() != null ? getHotelName().hashCode() : 0);
        result = 31 * result + (int) (getHotelId() ^ (getHotelId() >>> 32));
        return result;
    }
}