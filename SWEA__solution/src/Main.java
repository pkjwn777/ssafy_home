import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>(4);

        for(int i = 0; i < 4; i++){
            ArrayList<Integer> temp = new ArrayList<Integer> (4);
            for(int j = 0; j < 4; j++){
                temp.add(sc.nextInt());
            }
            arr.add(temp);
        }

        int total_squares = 0;

        for(int i = 0; i < 4; i++){
                int w = arr.get(i).get(2) - arr.get(i).get(0);
                int h = arr.get(i).get(3) - arr.get(i).get(1);

                total_squares += w*h;
        }

        int overlap = 0;
        int over_h = 0;
        int over_w = 0;

        for(int i = 0; i < 4; i++) {
            for(int j = i + 1; j < 4; j++) {
                int overlap_x1 = Math.max(arr.get(i).get(0), arr.get(j).get(0));
                int overlap_x2 = Math.min(arr.get(i).get(2), arr.get(j).get(2));
                int overlap_y1 = Math.max(arr.get(i).get(1), arr.get(j).get(1));
                int overlap_y2 = Math.min(arr.get(i).get(3), arr.get(j).get(3));
                over_w = Math.max(0, overlap_x2 - overlap_x1);
                over_h = Math.max(0, overlap_y2 - overlap_y1);

                overlap += over_w * over_h;
            }
        }

        System.out.print(total_squares - overlap);
    }
}