package TaskForInternship;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //создание пустых массивов
        DatabaseOfArrays databaseOfArrays = new DatabaseOfArrays();
        databaseOfArrays.createArrays();

        System.out.println("Данная программа распределяет введеные числа на три списка: X - числа делющиеся на 3 без остатка," +
                " S - на 7 без остатка и M - на 21 соответственно. \nВведите \"init array\", где вместо array записаны числа через пробел.\n" +
                "Для простотра всех доступных комманд введите \"help\".\n" +
                "Для выхода из программы введите \"complete\".");

        for (;;) {
            Scanner sc = new Scanner(System.in);
            String theMessage = sc.nextLine();
            if (theMessage.equals("complete")) break;
            DefiningAction definingAction = new DefiningAction();
            definingAction.defineAction(theMessage, databaseOfArrays);
        }
    }
}
