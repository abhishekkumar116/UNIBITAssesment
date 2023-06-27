package UnibitAssesment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class combinationSumAndSortArray {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombination(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
    public static void findCombination(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds){
        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = ind; i < arr.length; i++){
            if(i > ind && arr[i] == arr[i - 1]){
                continue;
            }
            if(arr[i] > target){
                break;
            }
            ds.add(arr[i]);
            findCombination(i + 1, arr, target - arr[i], ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 2, -4, -6, -2, 8};
        int target = 4;
        // int target = 8;
        List < List < Integer >> ls = combinationSum(arr, target);
        System.out.println("Combinations are: ");
        System.out.println("[");
        for (int i = 0; i < ls.size(); i++) {
            System.out.print("[");
            for (int j = 0; j < ls.get(i).size(); j++) {

                System.out.print( + ls.get(i).get(j) + ",");
            }
            System.out.println("],");
        }
        System.out.println("]");

        /******************/
        int[] ans = sortArray(arr);
        System.out.print("[");
        for(int i = 0; i < ans.length; i++){
            System.out.print(+ans[i]+",");
        }
        System.out.print("]");

    }

    // sort Array

    public static int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
    public static void mergeSort(int[] nums, int st, int end){
        if(st < end){
            int mid = (st + end)/2;

            mergeSort(nums, st, mid);
            mergeSort(nums, mid + 1, end);
            merge(nums, st, mid, end);
        }
    }

    public static void merge(int[] nums, int start, int mid, int end){
        int i= start,  j= mid+1, k=0;
        int[] temp = new int[end-start+1];
        while( i <= mid && j<= end){
            if (nums[i] < nums[j])
                temp[k++] = nums[i++];
            else
                temp[k++] = nums[j++];
        }

        while (i <= mid){
            temp[k++] = nums[i++];
        }
        //copy remaining elements
        while (j <= end){
            temp[k++] = nums[j++];
        }
        //copy remaining elements
        for (int pointer = start; pointer <= end; pointer++){
            nums[pointer] = temp[pointer-start];
        }
    }
}
