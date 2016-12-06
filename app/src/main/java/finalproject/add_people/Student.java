package finalproject.add_people;

/**
 * Created by Sujin on 12/4/2016.
 */

public class Student {
    private int arrivaltime;
    private int time;

    public Student(int arrivaltime, int time)
    {
        this.arrivaltime = arrivaltime;
        this.time = time;
    }

    public int getArrivalTime()
    {
        return arrivaltime;
    }

    public int getTime()
    {
        return time;
    }
}
