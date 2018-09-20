package com.test.lintcode.sort;

/**
 * Created by le on 2017/3/5.
 * 快速排序
 * <li>从数列中挑出一个元素，称为“基准”</li>
 * <li>重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
 * 在这个分割之后，该基准是它的最后位置。这个称为分割（partition）操作。</li>
 * <li>递归地把小于基准值元素的子数列和大于基准值元素的子数列排序。</li>
 */
public class QuickSortTest {

    public static void main(String[] args) {
        int[] nums = new int[]{10, 20, 15, 0, 6, 7, 2, 1, -5, 55, -100};

        quickSort(nums);

        System.out.println(nums.length);

    }

    private static void quickSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    //递归调用方法  将数组中从i-j的元素以j为基准  找到j的准确位置
    private static void sort(int[] nums, int i, int j) {
        if (i < j) {
            //将j放到正确位置  并返回位置索引
            int x = partition(nums, i, j);

            sort(nums, i, x - 1);   //递归调用j前半段
            sort(nums, x + 1, j);   //递归调用j后半段
        }


    }

    //将j放到正确位置  返回正确位置的索引  使得在i-j段中j的左边全是小于j的元素 右边全是大于j的元素
    private static int partition(int[] nums, int i, int j) {
        int x = nums[j];    //以j为基准
        int y = i;  //y记录目标位置  默认在i-j所有元素前面
        for (int a = i; a < j; a++) {   //从i开始比较  一直到j-1
            if (nums[a] <= x) {
                //如果a位置的元素比x小  则放到x所在的位置  然后x的位置后移一位
                SortUtils.swap(nums, y, a);
                y++;
            }
        }
        SortUtils.swap(nums, y, j);  //将j元素放到正确位置
        return y;
    }


}
