package src.ru.vsu.sc.savenkova_a_v;

public class ArrayRowsInDescendingOrder {
    public static int[][] putLinesInDescendingOrder(int[][] array) {
        int minPos = 0;
        for (int i = 0; i < array.length - 1; ++i) {
            int sum = findSumOfRowElements(array, i);
            for (int j = i + 1; j < array.length; ++j) {
                if (findSumOfRowElements(array, j) < sum) {
                    int[] saveValue = array[minPos];
                    array[minPos] = array[j];
                    array[j] = saveValue;
                }
            }
            minPos += 1;
        }
        return array;
    }

    public static int findSumOfRowElements(int[][] array, int i) {
        int sum = 0;
        for (int j = 0; j < array[i].length; j++) {
            sum += array[i][j];
        }
        return sum;
    }
}
