package com.corvaisinc.amuseum;

/**
 * This is a class with the different fields to store the information about a specific museum.
 *
 * Created by quent on 20/11/2017.
 */


public class Museum {

    private String name;
    private String city;
    private String adress;
    private String site;
    private String phone;
    private String close;
    private String lat;
    private String lon;


    /**
     * This is the constructor that initializes the values of the {@link Museum} fields.
     * @param name name of the museum
     * @param city city of the museum
     * @param adress address of the museum
     * @param site web site of the museum
     * @param phone phone number of the museum
     * @param close the annual closure of the museum
     * @param lat   the latitude coordinate of the museum's position
     * @param lon the longitude coordinate of the museum's position
     */
    public Museum(String name, String city, String adress, String site, String phone, String close, String lat, String lon)
    {
        this.name=name;
        this.city=city;
        this.adress=adress;
        this.site=site;
        this.phone=phone;
        this.close=close;
        this.lat=lat;
        this.lon=lon;
    }

    /**
     * This constructor without any parameters is needed to ake this class persistant.
     *
     * However it is an empty constructor.
     */
    public Museum(){}

    /**
     *
     * @return name of the museum
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name of the museum.
     * @param name name of the museum
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return the city of the museum
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the name of the museum's city.
     * @param city city of the museum
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return the address of the museum
     */
    public String getAdress() {return adress;}

    /**
     * Sets the address of the museum
     * @param adress address of the museum
     */
    public void setAdress(String adress) {this.adress = adress;}

    /**
     *
     * @return the web site of the museum
     */
    public String getSite() {return site;}

    /**
     * Sets the web site's link as a {@link String} of the musueum.
     * @param site web site of the museum
     */
    public void setSite(String site) {this.site = site;}

    /**
     *
     * @return the phone number of the museum
     */
    public String getPhone() {return phone;}

    /**
     * Sets the phone number of the museum.
     * @param phone the phone number of the museum
     */
    public void setPhone(String phone) {this.phone = phone;}

    /**
     *
     * @return the dates for the annual closure of the museum
     */
    public String getClose() {return close;}

    /**
     * Sets the dates for the annual closure of the museum.
     * @param close the dates for the annual closure
     */
    public void setClose(String close) {this.close = close;}

    /**
     *
     * @return the latitude coordinate of the museum's position
     */
    public String getLat() {return lat;}

    /**
     * Sets the latitude of the museum's position
     * @param lat the latitude coordinate of the museum's position
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     *
     * @return the longitude coordinate of the museum's position
     */
    public String getLon() {return lon;}

    /**
     * Sets the longitude coordinate of the museum's position
     * @param lon the longitude coordinate of the museum's position
     */
    public void setLon(String lon) {
        this.lon = lon;
    }



}
