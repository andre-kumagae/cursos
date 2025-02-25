package academy.devdojo.maratonajava.javacore.ZZDoptional.test;

import java.util.List;
import java.util.Optional;

public class OptionalTest01 {
    public static void main(String[] args) {
        Optional<String> o1 = Optional.of("Aha Uhu, O DevDojo é foda!!!");
        Optional<String> o2 = Optional.ofNullable(null);
        Optional<String> o3 = Optional.empty();
        System.out.println(o1);
        System.out.println(o2);
        System.out.println(o3);
        System.out.println("----------");
        Optional<String> nameOptional = findName("William");
        nameOptional.ifPresent(s -> System.out.println(s.toUpperCase()));
//        nameOptional.ifPresent(String::toUpperCase); retorna void
        nameOptional = findName("Williaam");
        String empty = nameOptional.orElse("EMPTY");
        System.out.println(empty);

    }

    private static Optional<String> findName(String name) {
        List<String> stringList = List.of("William", "DevDojo");
        int i = stringList.indexOf(name);
        if (i != -1) {
            return Optional.of(stringList.get(i));
        }
        return Optional.empty();
    }
}
