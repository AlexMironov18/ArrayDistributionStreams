package TaskForInternship;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TheAction implements TheActionInterface {

    @Override
    public void makeArrays(int[] arrayOfNumbers, DatabaseOfArrays databaseOfArrays) {
        databaseOfArrays.theEnteredArray = Arrays.stream(arrayOfNumbers).boxed().sorted().collect(Collectors.toList());
        databaseOfArrays.dividerByThree = Arrays.stream(arrayOfNumbers).boxed().filter(s -> s % 3 == 0).collect(Collectors.toList());
        databaseOfArrays.dividerBySeven = Arrays.stream(arrayOfNumbers).boxed().filter(s -> s % 7 == 0).collect(Collectors.toList());
        databaseOfArrays.dividerByTwentyone = Arrays.stream(arrayOfNumbers).boxed().filter(s -> s % 21 == 0).collect(Collectors.toList());
        printAll(databaseOfArrays);
    }

    @Override
    public void checkOdds(DatabaseOfArrays databaseOfArrays) {
        List<Integer> mergedList = Stream.concat(Stream.concat(databaseOfArrays.dividerByThree.stream(), databaseOfArrays.dividerBySeven.stream()),
                databaseOfArrays.dividerByTwentyone.stream()).distinct().sorted().collect(Collectors.toList());
        System.out.println(mergedList.equals(databaseOfArrays.theEnteredArray));
    }

    @Override
    public void printAll(DatabaseOfArrays databaseOfArrays) {
        if (databaseOfArrays.dividerByThree.isEmpty()) System.out.println("Список X пуст");
        else System.out.println("Список X: " + databaseOfArrays.dividerByThree);

        if (databaseOfArrays.dividerBySeven.isEmpty()) System.out.println("Список S пуст");
        else System.out.println("Список S: " + databaseOfArrays.dividerBySeven);

        if (databaseOfArrays.dividerByTwentyone.isEmpty()) System.out.println("Список M пуст");
        else System.out.println("Список M: " + databaseOfArrays.dividerByTwentyone);
    }

    @Override
    public void printXthArray(DatabaseOfArrays databaseOfArrays) {
        if (databaseOfArrays.dividerByThree.isEmpty()) System.out.println("Список X пуст");
        else System.out.println("Список X: " + databaseOfArrays.dividerByThree);
    }

    @Override
    public void printSthArray(DatabaseOfArrays databaseOfArrays) {
        if (databaseOfArrays.dividerBySeven.isEmpty()) System.out.println("Список S пуст");
        else System.out.println("Список S: " + databaseOfArrays.dividerBySeven);
    }

    @Override
    public void printMthArray(DatabaseOfArrays databaseOfArrays) {
        if (databaseOfArrays.dividerByTwentyone.isEmpty()) System.out.println("Список M пуст");
        else System.out.println("Список M: " + databaseOfArrays.dividerByTwentyone);
    }

    @Override
    public void clearXthArray(DatabaseOfArrays databaseOfArrays) {
        databaseOfArrays.dividerByThree.clear();
    }

    @Override
    public void clearSthArray(DatabaseOfArrays databaseOfArrays) {
        databaseOfArrays.dividerBySeven.clear();
    }
    @Override
    public void clearMthArray(DatabaseOfArrays databaseOfArrays) {
        databaseOfArrays.dividerByTwentyone.clear();
    }

    @Override
    public void mergeArrays(DatabaseOfArrays databaseOfArrays) {
        if (databaseOfArrays.dividerByThree.isEmpty() && databaseOfArrays.dividerBySeven.isEmpty() &&
                databaseOfArrays.dividerByTwentyone.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            List<Integer> mergedList = Stream.concat(Stream.concat(databaseOfArrays.dividerByThree.stream(), databaseOfArrays.dividerBySeven.stream()),
                    databaseOfArrays.dividerByTwentyone.stream()).distinct().sorted().collect(Collectors.toList());
            System.out.println(mergedList);
            databaseOfArrays.dividerByThree.clear();
            databaseOfArrays.dividerBySeven.clear();
            databaseOfArrays.dividerByTwentyone.clear();
            databaseOfArrays.theEnteredArray.clear();
        }
    }

    @Override
    public void getInfo() {
        System.out.println("Доступны следующие команды:");
        System.out.println("init array - инициализация списков (массивов) набором значений (чисел)" +
                " array, где вместо array записаны числа через пробел");
        System.out.println("print - печать всех списков");
        System.out.println("print type - печать определенного списка, где type принимает значения" +
                " X (числа делющиеся на 3 без остатка), S (числа делющиеся на 7  без остатка) и " +
                "M (числа делющиеся на 21 без остатка)");
        System.out.println("anyMore - выводит true, если все введеные числа были размещены в массивы и " +
                "false, если некоторые из чисел не вошли в эти списки.");
        System.out.println("clear type - чистка списка, где type - значения X, S или M");
        System.out.println("merge - слить все списки в один и вывести его на экран, " +
                "очистить все остальные списки");
    }
}
