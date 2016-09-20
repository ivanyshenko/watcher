/**
 * Created by alex on 14.09.2016.
 */
public class Vacation {
    private Integer hhId;
    private String name;
    private String company;
    private String location;
    private String date;
    private String experience;

    public Vacation(Integer hhId, String name, String company, String location, String date, String experience) {
        this.hhId = hhId;
        this.name = name;
        this.company = company;
        this.location = location;
        this.date = date;
        this.experience = experience;
    }

    public String toString (){
        String result = null;
        result = "(" + hhId.toString()
                + ", '" + name + "'"
                + ", '" + company + "'"
                + ", '" + location + "'"
                + ", '" + date + "'"
                + ", '" + experience + "'"
                + ")";
        return result;
    }

}
