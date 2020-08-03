package TaskForInternship;

import java.util.Arrays;
import java.util.regex.Pattern;

public class DefiningAction {

    TheActionInterface theAction = new TheAction();

    public void defineAction(String message, DatabaseOfArrays databaseOfArrays) {

        if (Pattern.matches("init [0-9\\s]+", message)) {
            message = message.substring(5);
            int[] arrayOfNumbers = Arrays.stream(message.split("\\s")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(arrayOfNumbers);
            theAction.makeArrays(arrayOfNumbers, databaseOfArrays);
        }

        //проверка на заполненность массивов всеми введеными числами
        if (message.equals("anyMore")) {
            theAction.checkOdds(databaseOfArrays);
        }

        //выводит на экран массивы
        if (message.equals("print")) {
            theAction.printAll(databaseOfArrays);
        }

        if (message.equals("print X")) {
            theAction.printXthArray(databaseOfArrays);
        }
        if (message.equals("print S")) {
            theAction.printSthArray(databaseOfArrays);
        }
        if (message.equals("print M")) {
            theAction.printMthArray(databaseOfArrays);
        }

        //очистка массивов
        if (message.equals("clear X")) {
            theAction.clearXthArray(databaseOfArrays);
        }
        if (message.equals("clear S")) {
            theAction.clearSthArray(databaseOfArrays);
        }
        if (message.equals("clear M")) {
            theAction.clearMthArray(databaseOfArrays);
        }

        //сливание масиивов в 1, его вывод на экран и очистка массивов
        if (message.equals("merge")) {
            theAction.mergeArrays(databaseOfArrays);
        }

        if (message.equals("help")) {
            theAction.getInfo();
        }
    }
}
