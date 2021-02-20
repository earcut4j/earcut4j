## earcut4j

This triangulation library is based on the javascript version located in [@mapbox/earcut](https://github.com/mapbox/earcut)

#### The algorithm

The library implements a modified ear slicing algorithm,
optimized by [z-order curve](http://en.wikipedia.org/wiki/Z-order_curve) hashing
and extended to handle holes, twisted polygons, degeneracies and self-intersections
in a way that doesn't _guarantee_ correctness of triangulation,
but attempts to always produce acceptable results for practical data.

It's based on ideas from
[FIST: Fast Industrial-Strength Triangulation of Polygons](http://www.cosy.sbg.ac.at/~held/projects/triang/triang.html) by Martin Held
and [Triangulation by Ear Clipping](http://www.geometrictools.com/Documentation/TriangulationByEarClipping.pdf) by David Eberly.

#### Installation

Download the latest version:

##### Maven dependency:

```XML
<dependency>
  <groupId>io.github.earcut4j</groupId>
  <artifactId>earcut4j</artifactId>
  <version>2.2.2</version>
</dependency>
```
       
##### Or when using Gradle:

```groovy
dependencies {
  compile "io.github.earcut4j:earcut4j:2.2.2"
}
```

#### Usage

```java
List<Integer> triangles = Earcut.earcut(new double[] { 10,0, 0,50, 60,60, 70,10 }, null, 2);
// returns [1,0,3, 3,2,1]
```

Signature: `earcut(double[] data, int[] holeIndices, int dim)`.

* `data` is a flat array of vertice coordinates like `[x0,y0, x1,y1, x2,y2, ...]`.
* `holeIndices` is an array of hole _indices_ if any
  (e.g. `[5, 8]` for a 12-vertice input would mean one hole with vertices 5&ndash;7 and another with 8&ndash;11).
* `dim` is the number of coordinates per vertice in the input array (`2` by default).

Each group of three vertice indices in the resulting array forms a triangle.

```java
// triangulating a polygon with a hole
List<Integer> triangles = Earcut.earcut(new double[] { 0, 0, 100, 0, 100, 100, 0, 100, 20, 20, 80, 20, 80, 80, 20, 80 }, new int[] { 4 }, 2);
// [3,0,4, 5,4,0, 3,4,7, 5,0,1, 2,3,7, 6,5,1, 2,7,6, 6,1,2]

// triangulating a polygon with 3d coords
List<Integer> triangles = Earcut.earcut(new double[] { 10, 0, 1, 0, 50, 2, 60, 60, 3, 70, 10, 4 }, null, 3);
// [1,0,3, 3,2,1]
```

If you pass a single vertice as a hole, Earcut treats it as a Steiner point.