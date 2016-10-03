package earcut4j;

import java.util.Arrays;
import java.util.List;

public class Test01 {

    public static void main(String[] args) {

        List<Integer> triangles = Earcut.earcut(new double[] { 10, 0, 0, 50, 60, 60, 70, 10 }, null, 2);
        // returns [1,0,3, 3,2,1]
        System.out.println(Arrays.toString(triangles.toArray()));

        // triangulating a polygon with a hole
        List<Integer> values = Earcut.earcut(new double[] { 0, 0, 100, 0, 100, 100, 0, 100, 20, 20, 80, 20, 80, 80, 20, 80 }, new int[] { 4 }, 2);
        // [3,0,4, 5,4,0, 3,4,7, 5,0,1, 2,3,7, 6,5,1, 2,7,6, 6,1,2]
        System.out.println(Arrays.toString(values.toArray()));

        // triangulating a polygon with 3d coords
        List<Integer> result = Earcut.earcut(new double[] { 10, 0, 1, 0, 50, 2, 60, 60, 3, 70, 10, 4 }, null, 3);
        // [1,0,3, 3,2,1]
        System.out.println(Arrays.toString(result.toArray()));
    }
    }
