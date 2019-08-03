package javaOOP.homework_3;

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
        ascComparatorMap.put("Name", getNameComparator(reversMulplier));
        ascComparatorMap.put("Lastname", getLastnameComparator(reversMulplier));
        ascComparatorMap.put("Age", getAgeComparator(reversMulplier));        
        ascComparatorMap.put("Height", getHeightComparator(reversMulplier) );
        ascComparatorMap.put("Weight", getWeightComparator(reversMulplier) );
        ascComparatorMap.put("Sex", getSexComparator(reversMulplier));
        return ascComparatorMap;
    }    
    
    public static Comparator<Student> getNameComparator(int reversMulplier) {        
        Comparator<Student> c = (Student s1, Student s2) -> {
            int result = checkNullForObjects(s1, s2);
            if (result < 2) {
                return result * reversMulplier;
            }
            return s1.getName().compareTo(s2.getName());
        };
        return c;        
    }
    
    public static Comparator<Student> getLastnameComparator(int reversMulplier) {        
        Comparator<Student> c = (Student s1, Student s2) -> {
            int result = checkNullForObjects(s1, s2);
            if (result < 2) {
                return result * reversMulplier;
            }
            return s1.getLastname().compareTo(s2.getLastname());
        };
        return c;        
    }
    
    public static Comparator<Student> getAgeComparator(int reversMulplier) {        
        Comparator<Student> c = (Student s1, Student s2) -> {
            int result = checkNullForObjects(s1, s2);
            if (result < 2) {
                return result * reversMulplier;
            }
            return s1.getAge() - (s2.getAge());
        };
        return c;        
    }
    
    public static Comparator<Student> getHeightComparator(int reversMulplier) {        
        Comparator<Student> c = (Student s1, Student s2) -> {
            int result = checkNullForObjects(s1, s2);
            if (result < 2) {
                return result * reversMulplier;
            }
            return s1.getHeight() - s2.getHeight();
        };
        return c;        
    }
    
    public static Comparator<Student> getWeightComparator(int reversMulplier) {        
        Comparator<Student> c = (Student s1, Student s2) -> {
            int result = checkNullForObjects(s1, s2);
            if (result < 2) {
                return result * reversMulplier;
            }
            return s1.getWeight() - s2.getWeight();
        };
        return c;        
    }
    public static Comparator<Student> getSexComparator(int reversMulplier) {        
        Comparator<Student> c = (Student s1, Student s2) -> {
            int result = checkNullForObjects(s1, s2);
            if (result < 2) {
                return result * reversMulplier;
            }
            Boolean a = s1.isSex();
            Boolean b = s2.isSex();
            return a.compareTo(b) * reversMulplier;            
        };
        return c;        
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
