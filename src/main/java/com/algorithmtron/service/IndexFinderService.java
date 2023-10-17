package com.algorithmtron.service;

import org.springframework.stereotype.Service;

@Service
public class IndexFinderService {
    public int[] findFirstAndLastOccurrence(int[] nums, int target) {
        if (nums == null) {
            return new int[]{-1, -1};
        }

        if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[]{0, 0};

            } else {
                return new int[]{-1, -1};
            }
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (target == nums[middle]) {
                return new int[]{findLeft(nums, target, middle), findRight(nums, target, middle)};
            }

            if (target > nums[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return new int[]{-1, -1};
    }

    private int findLeft(int[] nums, int target, int right) {
        int left = 0;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (target == nums[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }

    private int findRight(int[] nums, int target, int left) {
        int right = nums.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (target == nums[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return right;
    }
}