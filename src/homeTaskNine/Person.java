package homeTaskNine;

import java.io.Serializable;
import java.util.Comparator;

public class Person implements Comparable<Person>, Serializable {
    private String name;
    private int id;
    private float score;

    public Person(String name, int id, float score) {
        this.name = name;
        this.id = id;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public float getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", score=" + score +
                '}';
    }


    @Override
    public int compareTo(Person person) {
        if(!(this.getScore()==person.getScore())){
        if(this.getScore()>person.getScore()) return 1;
        if(this.getScore()<person.getScore()) return -1;
        return 0;
    }
        else
        {
           return this.getName().compareTo(person.getName());

        }
    }
}
