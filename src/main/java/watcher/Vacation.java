package watcher;

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

    public String toSQLString() {
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

    public String toCSVString(String delimiter){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(hhId).append(delimiter);
        stringBuilder.append(name).append(delimiter);
        stringBuilder.append(company).append(delimiter);
        stringBuilder.append(location).append(delimiter);
        stringBuilder.append(date).append(delimiter);
        stringBuilder.append(experience).append("\n");
        return stringBuilder.toString();
    }
}
