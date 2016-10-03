package earcut4j;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class Test01 {

    @Test
    public void simplePolygon() {
        List<Integer> triangles = Earcut.earcut(new double[] { 10,0, 0,50, 60,60, 70,10 }, null, 2);
        // returns [1,0,3, 3,2,1]
        Assert.assertArrayEquals(new Object[] {1,0,3, 3,2,1}, triangles.toArray());
    }
    
    @Test
    public void polygonWithHole() {
        List<Integer> triangles = Earcut.earcut(new double[] { 0, 0, 100, 0, 100, 100, 0, 100, 20, 20, 80, 20, 80, 80, 20, 80 }, new int[] { 4 }, 2);
        // [3,0,4, 5,4,0, 3,4,7, 5,0,1, 2,3,7, 6,5,1, 2,7,6, 6,1,2]
        Assert.assertArrayEquals(new Object[] {3,0,4, 5,4,0, 3,4,7, 5,0,1, 2,3,7, 6,5,1, 2,7,6, 6,1,2}, triangles.toArray());
    }
    
    @Test
    public void poluygonWith3DCoords() {
        List<Integer> triangles = Earcut.earcut(new double[] { 10, 0, 1, 0, 50, 2, 60, 60, 3, 70, 10, 4 }, null, 3);
        // [1,0,3, 3,2,1]
        Assert.assertArrayEquals(new Object[] {1,0,3, 3,2,1}, triangles.toArray());
    }

}
