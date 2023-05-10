package Util;

import java.io.*;
import java.util.Arrays;

/**
 * @Author: Mr_Poke
 * @Date: 2023/4/28 18:16
 * @Description:
 */
public class Utils {
    /**
    * @Author Mr_Poke
    * @Date 18:18 2023/4/28
    * @Description  生成随机的二维数组
    * @Param  * @param x  @param y
    * @Return int[][]
    */
    public static int[][] getTwoArrays(int x,int y){
        int[][] arrays = new int[x][y];
        for(int i = 0;i<x;i++){
            for(int j = 0;j<y;j++){
                if(i == j) {
                    arrays[i][j] = (int) (Math.random()*100);
                }
            }
        }
        return arrays;
    }
    /**
    * @Author Mr_Poke
    * @Date 18:48 2023/4/28
    * @Description  将数组存储到文本中
    * @Param  * @param arrays
    * @Return void 
    */
    public static void down(int[][] arrays){
        File file = new File("D:/test/tes1.txt");
        try (FileWriter fw = new FileWriter(file)){
            for (int i = 0; i < arrays.length; i++) {
               fw.write(Arrays.toString(arrays[i]));
               fw.write("\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
