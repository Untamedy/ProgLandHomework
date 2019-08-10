package javaPro.homework_2.xmlParser;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 *
 * @author YBolshakova
 */
public class Main {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\YBolshakova\\Documents\\gs-maven\\Homework\\src\\javaPro\\homework_2\\xmlParser\\Timetable.xml");
        TimeTable timeTable = createTimeTable();
        Parser parser = new Parser(file, timeTable);

        parser.saveObject();
        parser.addNewTrain(new Train(8889, "NY", "CA", new Date()));
        
        TimeTable newTimeTable = (TimeTable) parser.getObject(TimeTable.class);

        List<Train> byDate = parser.parsByDate(new Date(System.currentTimeMillis() - 7200000), new Date(System.currentTimeMillis() + 7200000));
        byDate.forEach((d) -> {
            System.out.println(d.toString());
        });
    }

    public static TimeTable createTimeTable() {
        Random random = new Random();

        List<Train> trains = new ArrayList<>();
        long index = 3600000;
        for (int i = 0; i < 10; i++) {
            Date newdate = new Date(System.currentTimeMillis() + index);
            Train train = new Train(random.nextInt(100), String.valueOf(random.nextInt()), String.valueOf(random.nextInt()), newdate);
            trains.add(train);
            index = index * 2;
        }
        TimeTable timeTable = new TimeTable(trains);
        return timeTable;

    }

}
