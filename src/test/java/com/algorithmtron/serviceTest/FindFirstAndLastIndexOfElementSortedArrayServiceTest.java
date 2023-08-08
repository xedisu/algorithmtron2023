package com.algorithmtron.serviceTest;

import com.algorithmtron.service.FindFirstAndLastIndexOfElementSortedArrayService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
public class FindFirstAndLastIndexOfElementSortedArrayServiceTest {

    @Test
    void findFirstAndLastIndexOfElement() {
        FindFirstAndLastIndexOfElementSortedArrayService service = new FindFirstAndLastIndexOfElementSortedArrayService();
        int[] nums = {1, 1, 1};
        int target = 1;
        int[] res = {0, 2};

        Assertions.assertEquals(Arrays.toString(res), Arrays.toString(service.searchRange(nums, target)));
    }

    @Test
    void findFirstAndLastIndexOfElementVariation() {
        FindFirstAndLastIndexOfElementSortedArrayService service = new FindFirstAndLastIndexOfElementSortedArrayService();
        int[] nums = {1, 2, 3};
        int target = 3;
        int[] res = {2, 2};

        Assertions.assertEquals(Arrays.toString(res), Arrays.toString(service.searchRange(nums, target)));
    }

    @Test
    void findFirstAndLastIndexOfElementVariation2() {
        FindFirstAndLastIndexOfElementSortedArrayService service = new FindFirstAndLastIndexOfElementSortedArrayService();
        int[] nums = {1, 2, 3};
        int target = 1;
        int[] res = {0, 0};

        Assertions.assertEquals(Arrays.toString(res), Arrays.toString(service.searchRange(nums, target)));
    }

    @Test
    void findFirstAndLastIndexOfElementNullArrayInput() {
        FindFirstAndLastIndexOfElementSortedArrayService service = new FindFirstAndLastIndexOfElementSortedArrayService();
        int[] nums = null;
        int target = 4;
        int[] res = {-1, -1};

        Assertions.assertEquals(Arrays.toString(res), Arrays.toString(service.searchRange(nums, target)));
    }

    @Test
    void findFirstAndLastIndexOfElementEmptyArrayInput() {
        FindFirstAndLastIndexOfElementSortedArrayService service = new FindFirstAndLastIndexOfElementSortedArrayService();
        int[] nums = new int[3];
        int target = 3;
        int[] res = {-1, -1};

        Assertions.assertEquals(Arrays.toString(res), Arrays.toString(service.searchRange(nums, target)));
    }

    @Test
    void findFirstAndLastIndexOfElementEmptyArrayInputWithZeroAsTarget() {
        FindFirstAndLastIndexOfElementSortedArrayService service = new FindFirstAndLastIndexOfElementSortedArrayService();
        int[] nums = new int[2];
        int target = 0;
        int[] res = {0, 1};

        Assertions.assertEquals(Arrays.toString(res), Arrays.toString(service.searchRange(nums, target)));
    }

}
