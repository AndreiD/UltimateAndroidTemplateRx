package com.androidadvance.ultimateandroidtemplaterx.model;


    import com.google.gson.annotations.Expose;
    import com.google.gson.annotations.SerializedName;

public class IPInfo {

  @SerializedName("as")
  @Expose
  private String as;
  @SerializedName("city")
  @Expose
  private String city;
  @SerializedName("country")
  @Expose
  private String country;
  @SerializedName("countryCode")
  @Expose
  private String countryCode;
  @SerializedName("isp")
  @Expose
  private String isp;
  @SerializedName("lat")
  @Expose
  private Double lat;
  @SerializedName("lon")
  @Expose
  private Double lon;
  @SerializedName("org")
  @Expose
  private String org;
  @SerializedName("query")
  @Expose
  private String query;
  @SerializedName("region")
  @Expose
  private String region;
  @SerializedName("regionName")
  @Expose
  private String regionName;
  @SerializedName("status")
  @Expose
  private String status;
  @SerializedName("timezone")
  @Expose
  private String timezone;
  @SerializedName("zip")
  @Expose
  private String zip;

  public String getAs() {
    return as;
  }

  public void setAs(String as) {
    this.as = as;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public String getIsp() {
    return isp;
  }

  public void setIsp(String isp) {
    this.isp = isp;
  }

  public Double getLat() {
    return lat;
  }

  public void setLat(Double lat) {
    this.lat = lat;
  }

  public Double getLon() {
    return lon;
  }

  public void setLon(Double lon) {
    this.lon = lon;
  }

  public String getOrg() {
    return org;
  }

  public void setOrg(String org) {
    this.org = org;
  }

  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getRegionName() {
    return regionName;
  }

  public void setRegionName(String regionName) {
    this.regionName = regionName;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getTimezone() {
    return timezone;
  }

  public void setTimezone(String timezone) {
    this.timezone = timezone;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  @Override public String toString() {
    return "IPInfo{"
        + "as='"
        + as
        + '\''
        + ", city='"
        + city
        + '\''
        + ", country='"
        + country
        + '\''
        + ", countryCode='"
        + countryCode
        + '\''
        + ", isp='"
        + isp
        + '\''
        + ", lat="
        + lat
        + ", lon="
        + lon
        + ", org='"
        + org
        + '\''
        + ", query='"
        + query
        + '\''
        + ", region='"
        + region
        + '\''
        + ", regionName='"
        + regionName
        + '\''
        + ", status='"
        + status
        + '\''
        + ", timezone='"
        + timezone
        + '\''
        + ", zip='"
        + zip
        + '\''
        + '}';
  }
}