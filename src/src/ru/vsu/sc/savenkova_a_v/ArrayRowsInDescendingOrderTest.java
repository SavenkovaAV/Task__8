package src.ru.vsu.sc.savenkova_a_v;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ArrayRowsInDescendingOrderTest {
    ArrayRowsInDescendingOrder descendingOrder = new ArrayRowsInDescendingOrder();

    @Test
    public void testStandingArrayRowsInCorrectOrder() {
        int[][] testArray = ru.vsu.cs.util.ArrayUtils.readIntArray2FromFile("tests/TestStandingArrayRowsInCorrectOrder.txt");
        int[][] resultOfTest = ru.vsu.cs.util.ArrayUtils.readIntArray2FromFile("tests/ResultOfTestStandingArrayRowsInCorrectOrder.txt");
        int[][] realResult = descendingOrder.putLinesInDescendingOrder(testArray);

        Assert.assertEquals(realResult, resultOfTest);
    }

    @Test
    public void testArrayWithEmptyRow() {
        int[][] testArray = ru.vsu.cs.util.ArrayUtils.readIntArray2FromFile("tests/TestArrayWithEmptyRow.txt");
        int[][] resultOfTest = ru.vsu.cs.util.ArrayUtils.readIntArray2FromFile("tests/ResultOfTestArrayWithEmptyRow.txt");
        int[][] realResult = descendingOrder.putLinesInDescendingOrder(testArray);

        Assert.assertEquals(realResult, resultOfTest);
    }

    @Test
    public void testRowsWithSameElementValue() {
        int[][] testArray = ru.vsu.cs.util.ArrayUtils.readIntArray2FromFile("tests/TestRowsWithSameElementValue.txt");
        int[][] resultOfTest = ru.vsu.cs.util.ArrayUtils.readIntArray2FromFile("tests/ResultOfTestRowsWithSameElementValue.txt");
        int[][] realResult = descendingOrder.putLinesInDescendingOrder(testArray);

        Assert.assertEquals(realResult, resultOfTest);
    }

    @Test
    public void testRowsWithDuplicateElements() {
        int[][] testArray = ru.vsu.cs.util.ArrayUtils.readIntArray2FromFile("tests/TestRowsWithDuplicateElements.txt");
        int[][] resultOfTest = ru.vsu.cs.util.ArrayUtils.readIntArray2FromFile("tests/ResultOfTestRowsWithDuplicateElements.txt");
        int[][] realResult = descendingOrder.putLinesInDescendingOrder(testArray);

        Assert.assertEquals(realResult, resultOfTest);
    }

    @Test
    public void testArrayWithTwoStringsOfSameValue() {
        int[][] testArray = ru.vsu.cs.util.ArrayUtils.readIntArray2FromFile("tests/TestArrayWithTwoStringsOfSameValue.txt");
        int[][] resultOfTest = ru.vsu.cs.util.ArrayUtils.readIntArray2FromFile("tests/ResultOfTestArrayWithTwoStringsOfSameValue.txt");
        int[][] realResult = descendingOrder.putLinesInDescendingOrder(testArray);

        Assert.assertEquals(realResult, resultOfTest);
    }
}
