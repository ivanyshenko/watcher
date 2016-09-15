/**
 * Created by alex on 14.09.2016.
 */
public class Vacation {
    private String name;
    private String company;
    private String location;
    private String date;
    private String experience;

    public Vacation(String name, String company, String location, String date, String experience) {
        this.name = name;
        this.company = company;
        this.location = location;
        this.date = date;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}
