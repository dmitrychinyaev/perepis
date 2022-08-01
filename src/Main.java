import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Evan", "Billy", "Cameron", "Josh", "Sam", "Mid");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        long count = persons.stream()
                .filter(x -> x.getAge() < 18)
                .count();
        System.out.println("Количество несовершеннолетних: " + count + " человек");

        List<String> famile = persons.stream()
                .filter(x -> x.getAge() >= 18 && x.getAge() <= 27)
                .map(Person::getFamily)
                .collect(Collectors.toList());

        List<String> abc = persons.stream()
                .filter(x -> (((x.getSex() == Sex.MAN) && (x.getAge() >= 18) && (x.getAge() <= 65)) ||
                        ((x.getSex() == Sex.WOMAN) && (x.getAge() >= 18) && (x.getAge() <= 60))))
                .filter(x -> x.getEducation() == Education.HIGHER)
                .map(Person::getFamily)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

    }
}

