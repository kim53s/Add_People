package finalproject.add_people;

import java.util.LinkedList;

/**
 * Created by Sujin on 12/4/2016.
 */

public class DiningHall {

    private LinkedList<Student> list;
    private int ppl;
    private int capacity;
    private String name;
    private int percentage;

    public DiningHall(String name, int capacity)
    {
        this.name = name;
        this.capacity = capacity;
        ppl = 0;
        list = new LinkedList<Student>();
        percentage = 0;
    }

    public String getName()
    {
        return this.name;
    }

    public void add( Student s )
    {
        list.add(s);
    }

    public int getppl()
    {
        return list.size();
    }

    public Student getFirst()
    {
        return list.getFirst();
    }

    public void delete()
    {
        list.removeFirst();
    }

    public boolean isEmpty()
    {
        return list.isEmpty();
    }

    public int calculatePercentage()
    {
        return (int)ppl/capacity*100;
    }
}
