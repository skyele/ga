package chapter5;

public class Timeslot {
    private  final int timeslotId;
    private final String timeslot;

    public Timeslot(int timeslotId, String timeslot){
        this.timeslotId = timeslotId;
        this.timeslot = timeslot;
    }

    public int getTimeslotId(){
        return this.timeslotId;
    }

    public java.lang.String getTimeslot() {
        return this.timeslot;
    }
}
