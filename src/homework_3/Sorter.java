package homework_3;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author YBolshakova
 */
public class Sorter {

    public static Map<String, Comparator<Student>> createComporatorMap(boolean isRevers) {
        final int reversMulplier = isRevers ? -1 : 1;
        Map<String, Comparator<Student>> ascComparatorMap = new HashMap<>();
        ascComparatorMap.put("Name", (Comparator<Student>) (Student s1, Student s2) -> {
            int result = checkNullForObjects(s1, s2);
            if (result < 2) {
                return result * reversMulplier;
            }
            return s1.getName().compareTo(s2.getName()) * reversMulplier;
        });
        ascComparatorMap.put("Lastname", (Comparator<Student>) (Student s1, Student s2) -> {
            int result = checkNullForObjects(s1, s2);
            if (result < 2) {
                return result * reversMulplier;
            }
            return s1.getLastname().compareTo(s2.getLastname()) * reversMulplier;
        });
        ascComparatorMap.put("Age", (Comparator<Student>) (Student s1, Student s2) -> {
            int result = checkNullForObjects(s1, s2);
            if (result < 2) {
                return result * reversMulplier;
            }
            Integer a = s1.getAge();
            Integer b = s2.getAge();
            return (a.compareTo(b))* reversMulplier;

        });
        ascComparatorMap.put("Height", (Comparator<Student>) (Student s1, Student s2) -> {
            int result = checkNullForObjects(s1, s2);
            if (result < 2) {
                return result * reversMulplier;
            }
            Integer a = s1.getHeight();
            Integer b = s2.getHeight();
            return a.compareTo(b)* reversMulplier;
        });
        ascComparatorMap.put("Weight", (Comparator<Student>) (Student s1, Student s2) -> {
            int result = checkNullForObjects(s1, s2);
            if (result < 2) {
                return result * reversMulplier;
            }
            Integer a = s1.getWeight();
            Integer b = s2.getWeight();
            return a.compareTo(b)* reversMulplier;
        });
        ascComparatorMap.put("Sex", (Comparator<Student>) (Student s1, Student s2) -> {
            int result = checkNullForObjects(s1, s2);
            if (result < 2) {
                return result * reversMulplier;
            }
            Boolean a = s1.isSex();
            Boolean b = s2.isSex();
            return a.compareTo(b)* reversMulplier;
        });

        return ascComparatorMap;

    }

    public static int checkNullForObjects(Student s1, Student s2) {
        if (s1 == null && s2 == null) {
            return 0;
        }
        if (s1 == null) {
            return 1;
        }
        if (s2 == null) {
            return -1;
        }
        return 2;
    }

}
