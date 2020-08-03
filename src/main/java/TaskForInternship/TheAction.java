package TaskForInternship;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class TheAction implements TheActionInterface {

    @Override
    public void makeArrays(int[] arrayOfNumbers, DatabaseOfArrays databaseOfArrays) {
        if (arrayOfNumbers.length != 0){
            for (int i : arrayOfNumbers) {
                databaseOfArrays.theEnteredArray.add(Integer.valueOf(i));
            }
            for (int i = 0; i < arrayOfNumbers.length; i++) {
                if (arrayOfNumbers[i] % 3 == 0) {
                    databaseOfArrays.dividerByThree.add(arrayOfNumbers[i]);
                }
                if (arrayOfNumbers[i] % 7 == 0) {
                    databaseOfArrays.dividerBySeven.add(arrayOfNumbers[i]);
                }
                if (arrayOfNumbers[i] % 21 == 0) {
                    databaseOfArrays.dividerByTwentyone.add(arrayOfNumbers[i]);
                }
            }
        }
        printAll(databaseOfArrays);
    }

    @Override
    public void checkOdds(DatabaseOfArrays databaseOfArrays) {
        HashSet<Integer> enteredSet = new HashSet<>(databaseOfArrays.theEnteredArray);
        ArrayList<Integer> mergedArrays = new ArrayList<>();
        mergedArrays.addAll(databaseOfArrays.dividerByThree);
        mergedArrays.addAll(databaseOfArrays.dividerBySeven);
        mergedArrays.addAll(databaseOfArrays.dividerByTwentyone);
        HashSet<Integer> mergedSet = new HashSet<>(mergedArrays);
        System.out.println(enteredSet.equals(mergedSet));
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
            databaseOfArrays.theEnteredArray.clear();
            ArrayList<Integer> mergedArray = new ArrayList<>(databaseOfArrays.dividerByThree);
            mergedArray.addAll(databaseOfArrays.dividerBySeven);
            mergedArray.addAll(databaseOfArrays.dividerByTwentyone);
            databaseOfArrays.dividerByThree.clear();
            databaseOfArrays.dividerBySeven.clear();
            databaseOfArrays.dividerByTwentyone.clear();
            HashSet setOfNumber = new HashSet(mergedArray);
            mergedArray = new ArrayList<>(setOfNumber);
            Collections.sort(mergedArray);
            System.out.println(mergedArray);
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
