package Swing.table.Objeto;
import Swing.table.AuxAction.EventAction;
import Swing.table.AuxAction.ModelAction;
import java.text.DecimalFormat;

public class Data {

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public Data( String name, String gender, String course, double fees) {
        this.name = name;
        this.gender = gender;
        this.course = course;
        this.fees = fees;
    }

    public Data() {
    }

    private String name;
    private String gender;
    private String course;
    private double fees;
    
    

    public Object[] toRowTable(EventAction event) {
        DecimalFormat df = new DecimalFormat("$#,##0.00");
        return new Object[]{name, gender, course, df.format(fees), new ModelAction(this, event)};
    }
}
