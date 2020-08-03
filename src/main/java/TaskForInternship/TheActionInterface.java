package TaskForInternship;

public interface TheActionInterface {

    //инициализация массивов
    public void makeArrays(int[] arrayOfNumbers, DatabaseOfArrays databaseOfArrays);

    //проверка все ли числа записались в массив
    public void checkOdds(DatabaseOfArrays databaseOfArrays);

    //вывести все (или Xth, Sth, Mth массив) на экран
    public void printAll(DatabaseOfArrays databaseOfArrays);
    public void printXthArray(DatabaseOfArrays databaseOfArrays);
    public void printSthArray(DatabaseOfArrays databaseOfArrays);
    public void printMthArray(DatabaseOfArrays databaseOfArrays);

    //очистить Xth, Sth, Mth массив
    public void clearXthArray(DatabaseOfArrays databaseOfArrays);
    public void clearSthArray(DatabaseOfArrays databaseOfArrays);
    public void clearMthArray(DatabaseOfArrays databaseOfArrays);

    //вывести один массив, составленный из Xth, Sth, Mth массивов и очистить эти массивы
    public void mergeArrays(DatabaseOfArrays databaseOfArrays);

    //вывести справочную информацию по командам программы
    public void getInfo();

}
