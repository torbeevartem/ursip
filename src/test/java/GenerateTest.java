import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GenerateTest {

    @Test
    void generateNum_list_contains_123() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        String result = Generate.generateNum(list);
        assertEquals("004", result);
    }

    @Test
    void generateNum_list_contains_13() {
        List<Integer> list = Arrays.asList(1, 3);
        String result = Generate.generateNum(list);
        assertEquals("002", result);
    }

    @Test
    void generateNum_list_contains_2() {
        List<Integer> list = Arrays.asList(2);
        String result = Generate.generateNum(list);
        assertEquals("001", result);
    }

    @Test
    void generateNum_list_contains_1() {
        List<Integer> list = Arrays.asList(1);
        String result = Generate.generateNum(list);
        assertEquals("001", result);
    }

    @Test
    void generateNum_list_contains_0() {
        List<Integer> list = Arrays.asList(0);
        String result = Generate.generateNum(list);
        assertEquals("000", result);
    }

    @Test
    void generateNum_list__element_contains_duplicate_the_beginning() {
        List<Integer> list = Arrays.asList(1,1,2);
        String result = Generate.generateNum(list);
        assertEquals("003", result);
    }

    @Test
    void generateNum_list_element_contains_duplicate_the_end() {
        List<Integer> list = Arrays.asList(1,2,2);
        String result = Generate.generateNum(list);
        assertEquals("003", result);
    }

    @Test
    void generateNum_list_element_contains_duplicate() {
        List<Integer> list = Arrays.asList(2,2,2);
        String result = Generate.generateNum(list);
        assertEquals("003", result);
    }

    @Test
    void generateNum_list_element_contains_null() {
        List<Integer> list = new ArrayList<>();
        list.add(null);
        NullPointerException exception =
                assertThrows(NullPointerException.class, () -> Generate.generateNum(list));
        assertEquals("Element in list must not be null", exception.getMessage());
    }

    @Test
    void generateNum_list_is_null() {
        NullPointerException exception =
                assertThrows(NullPointerException.class, () -> Generate.generateNum(null));
        assertEquals("List of numbers is empty", exception.getMessage());
    }
}