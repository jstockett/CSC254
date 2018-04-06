public class City {

    private String city;
    private String region;
    private String country;
    private double latitude;
    private double longitude;

    City(String city, String region, String country, double latitude, double longitude) {
        setCity(city);
        setCountry(country);
        setRegion(region);
        setLatitude(latitude);
        setLongitude(longitude);
    }

    City() {
        this("", "", "", 0.0, 0.0);
    }


    public void setCity(String city) {
        if (city.length() > 0)
            this.city = city;
        else
            this.city = "??";
    }

    public void setRegion(String region) {
        if (region.length() > 0)
            this.region = region;
        else
            this.region = "??";
    }

    public void setCountry(String country) {
        if (country.length() > 0)
            this.country = country;
        else
            this.country = "??";
    }

    public void setLatitude(double latitude) {
        if (latitude >= -90 && latitude <= 90)
            this.latitude = latitude;
        else
            this.latitude = 0.0;
    }

    public void setLongitude(double longitude) {
        if (longitude >= -180 && longitude <= 180)
            this.longitude = longitude;
        else
            this.longitude = 0.0;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        String result;
        if(country.equalsIgnoreCase("usa") || country.equalsIgnoreCase("us")
                || country.equalsIgnoreCase("canada") || country.equalsIgnoreCase("??")){

            result = String.format("%s, %s %s (%1.1f, %1.1f)", city, region, country, roundToOneDec(latitude),
                    roundToOneDec(longitude));

        }else{
            result = String.format("%s %s (%1.1f, %1.1f)", city, country, roundToOneDec(latitude),
                    roundToOneDec(longitude));
        }
        return result;
    }

    /**This method rounds a double to one decimal place*/
    private double roundToOneDec(Double num){
        num = ((double)(Math.round(num * 10))/10);
        return num;
    }
}



