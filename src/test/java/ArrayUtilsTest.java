import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayUtilsTest {

    @Test
    public void testFindLastNull() {
        // Do not execute fault
        assertThrows(NullPointerException.class, () -> {ArrayUtils.findLast(null, 3);});
    }


    @Test
    public void testFindLastEmpty() {
        // For any input where y appears in the second or later position, there is no error. Also,
        // if x is empty, there is no error.
        assertEquals(-1, ArrayUtils.findLast(new int[]{}, 3));
    }

    @Test
    public void testFindLastNonExistent() {
        assertEquals(-1, ArrayUtils.findLast(new int[]{1, 2}, 3));
    }

    @Test
    public void testFindLastExistsFirstElement() {
        assertEquals(0, ArrayUtils.findLast(new int[]{2, 3, 5}, 2));
    }

    @Test
    public void testOddOrPosNull() {
        // Do not execute fault
        assertThrows(NullPointerException.class, () -> {ArrayUtils.oddOrPos(null);});
    }


    @Test
    public void testOddOrPosAllPositives() {
        // Any nonempty x with only non-negative elements works, because the first part of the
        // compound if-test is not necessary unless the value is negative.
        assertEquals(3, ArrayUtils.oddOrPos(new int[]{1, 2, 3}));
    }

    @Test
    public void testOddOrPositiveBothPositivesAndNegatives() {
        assertEquals(3, ArrayUtils.oddOrPos(new int[]{-3, -2, 0, 1, 4}));
    }

// Added tests:

    @Test
    public void testCountOfWithTargetPresent() {
        // Test to ensure countOf correctly counts occurrences of a target that exists in the array.
        assertEquals(2, ArrayUtils.countOf(new int[]{1, 2, 2, 3}, 2), "Target occurs twice");
    }

    @Test
    public void testCountOfWithTargetAbsent() {
        // Test to ensure countOf returns 0 when the target is not present in the array.
        assertEquals(0, ArrayUtils.countOf(new int[]{1, 2, 2, 3}, 4), "Target does not occur");
    }

    @Test
    public void testCountOfWithEmptyArray() {
        // Test to ensure countOf handles an empty array correctly.
        assertEquals(0, ArrayUtils.countOf(new int[]{}, 1), "Empty array should return 0");
    }

    @Test
    public void testCountOfWithAllElementsMatching() {
        // Test to ensure countOf correctly counts when all elements in the array match the target.
        assertEquals(4, ArrayUtils.countOf(new int[]{2, 2, 2, 2}, 2), "All elements match the target");
    }

    // Additional tests to improve coverage for findLast and oddOrPos if needed

    @Test
    public void testFindLastExistsMultipleTimes() {
        // Test to ensure findLast returns the last index when the target exists multiple times.
        assertEquals(3, ArrayUtils.findLast(new int[]{2, 3, 2, 2}, 2), "Target exists multiple times");
    }

    @Test
    public void testOddOrPosWithNegativesAndZeros() {
        // Test to ensure oddOrPos counts correctly with an array containing negatives and zeros.
        assertEquals(0, ArrayUtils.oddOrPos(new int[]{-4, -2, 0}), "Array with negatives and zeros");
    }
}