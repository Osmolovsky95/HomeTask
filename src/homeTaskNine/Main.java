package homeTaskNine;
import java.io.*;
import java.util.stream.*;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.*;

public class Main {




    public static void main(String[] args) throws IOException, ClassNotFoundException {

        AtomicInteger id= new AtomicInteger(1);
        String [] arrayName={"Петя","Вася","Федя","Алеша","Иван","Ашот","Хабиб","Инакентий","Степан","Николай"};
        String [] arraySurName={"Петросян","Навальный","Иванов","Петров","Сидоров","Батрак","Сивко","Климович","Степанов","Путин"};

        Map<Integer,Person> students;
        students =  Stream.generate(()->{
                String name=arrayName[(int) (Math.random()*10)]+" "+arraySurName[(int) (Math.random()*10)];
                float score =(float) (Math.round((Math.random()*10) * 100.0) / 100.0);
                 return new Person(name, id.getAndIncrement(),score);
            })
                    .limit(10000)
                    .collect(Collectors.toMap(Person::getId,p->p));

       students=students
               .entrySet()
               .stream()
               .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(oldValue, newValue) -> newValue,
                TreeMap::new));

        List <Person>topStudents=new ArrayList();
       students.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue()).forEach((p)->{
                    topStudents.add(p.getValue());
       });


File topStudentsFile=new File ("topStudents.txt");

int countPerson=0;
      // Write topStudents to topStudents.txt
      try {
          FileOutputStream fileOutputStream = new FileOutputStream(topStudentsFile);
          ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
          for(int i=topStudents.size()-100;i<topStudents.size();i++){
              objectOutputStream.writeObject(topStudents.get(i));
              countPerson++;
          }
          objectOutputStream.close();
      }
      catch (IOException e){
          e.printStackTrace();
      }

      //ReadFile
      TopStudentsReader.topStudentsReader(topStudentsFile.getAbsolutePath(),countPerson,34);

    }
    }


