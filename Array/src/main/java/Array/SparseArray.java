package Array;

import Util.Utils;

import java.util.Arrays;

/**
 * @Author: Mr_Poke
 * @Date: 2023/4/28 18:16
 * @Description: 稀疏数组
 */
public class SparseArray {
    /**
    * @Author Mr_Poke
    * @Date 18:37 2023/4/28
    * @Description  二维变稀疏
    * @Param  * @param arrays
    * @Return int[][]
    */
    public static int[][] getSpaceArray(int[][] arrays){
        int sum = 0;
        for (int[] array : arrays) {
            for (int j = 0; j < arrays[0].length; j++) {
                if (array[j] != 0) {
                    ++sum;
                }
            }
        }

        int[][] spaceArrays = new int[sum+1][3];
        spaceArrays[0][0] = arrays.length;
        spaceArrays[0][1] = arrays[0].length;
        spaceArrays[0][2] = sum;
        int index = 1;
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[0].length; j++) {
                if(arrays[i][j] != 0){
                    spaceArrays[index][0] = i;
                    spaceArrays[index][1] = j;
                    spaceArrays[index][2] = arrays[i][j];
                    ++index;
                }
            }
        }
        return spaceArrays;
    }
    /**
    * @Author Mr_Poke
    * @Date 18:38 2023/4/28
    * @Description  稀疏转二维
    * @Param  * @param spaceArrays
    * @Return int[][]
    */
    public static int[][] getArrays(int[][] spaceArrays){
        int[][] arrays = new int[spaceArrays[0][0]][spaceArrays[0][1]];

        for (int i = 1; i < spaceArrays.length; i++) {
            arrays[spaceArrays[i][0]][spaceArrays[i][1]] =  spaceArrays[i][2];
        }
        return arrays;
    }

    public static void main(String[] args) {


        int[][] arrays = Utils.getTwoArrays(11,11);
        arrays[3][4] = 5;
        for(int [] row : arrays){
           System.out.println(Arrays.toString(row));
        }
        System.out.println("===============");
        System.out.println("===============");
        int[][] spaceArray = getSpaceArray(arrays);
        for(int[] row : spaceArray){
            System.out.println(Arrays.toString(row));
        }
        System.out.println("===============");
        System.out.println("===============");
        int[][] arrays1 = getArrays(spaceArray);
        for(int[] row : arrays1){
            System.out.println(Arrays.toString(row));
        }
    }
}
