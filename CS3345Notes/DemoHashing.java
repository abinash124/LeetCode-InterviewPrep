/** @author rbk
 *  Example to illustrate what happens when a user defined class is used
 *  as Key to a hash table without defining hashCode() and equals() methods.
 */

import java.io.*;
import java.util.*;

public class DemoHashing {
    static String edges = "1 2   1 3   1 4   1 6   2 3   3 4   3 6   4 5   4 6   5 6";
    static String queries = "1 2   1 3   1 4   1 5   1 6   2 3   2 4   2 5   2 6   3 4   3 5   3 6   4 5   4 6   5 6   6 5";

    static class Edge {
	int u, v;
	Edge(int u, int v) { this.u = u;   this.v = v; }
	public String toString() { return "(" + u + "," + v + ")"; }
    }

    static class EdgeCorrected extends Edge {
	EdgeCorrected(int u, int v) { super(u, v); }

	@Override
	public int hashCode() {
	    return u*u+v*v;  // This is not a good hash function
	}
	@Override
	public boolean equals(Object another) {
	    if(another == null) return false;
	    if(this == another) return true;
	    Edge other = (Edge) another;
	    boolean result = (u == other.u && v == other.v) || (u == other.v && v == other.u);
	    return result;
	}
    }

    public static void main(String[] args) {
	Scanner in = new Scanner(edges);
	Set<Edge> s1 = new HashSet<>();
	Set<EdgeCorrected> s2 = new HashSet<>();
	while(in.hasNext()) {
	    int u = in.nextInt();
	    int v = in.nextInt();
	    s1.add(new Edge(u, v));
	    s2.add(new EdgeCorrected(u, v));
	}

	runQueries("s1:", s1);
	runQueries("s2:", s2);
    }

    public static void runQueries(String name, Set<? extends Edge> s) {
	System.out.println("Edges in hash table " + name);
	for(Edge e: s) {
	    System.out.print(e);
	}
	System.out.println();
	Scanner in = new Scanner(queries);
	System.out.println("\nQuery edges in " + name);
	while(in.hasNext()) {
	    int a = in.nextInt();
	    int b = in.nextInt();
	    Edge e = new EdgeCorrected(a, b);
	    if(s.contains(e)) {
		System.out.println(e + "\tYes");
	    } else {
		System.out.println(e + "\tNo");
	    }
	}
	System.out.println("___________________________________\n");
    }
}

/* Output:
Edges in hash table s1:
(1,3)(2,3)(5,6)(1,4)(1,2)(4,6)(4,5)(3,4)(1,6)(3,6)

Query edges in s1:
(1,2)	No
(1,3)	No
(1,4)	No
(1,5)	No
(1,6)	No
(2,3)	No
(2,4)	No
(2,5)	No
(2,6)	No
(3,4)	No
(3,5)	No
(3,6)	No
(4,5)	No
(4,6)	No
(5,6)	No
(6,5)	No
___________________________________

Edges in hash table s2:
(1,2)(2,3)(3,4)(4,5)(5,6)(1,3)(4,6)(1,4)(3,6)(1,6)

Query edges in s2:
(1,2)	Yes
(1,3)	Yes
(1,4)	Yes
(1,5)	No
(1,6)	Yes
(2,3)	Yes
(2,4)	No
(2,5)	No
(2,6)	No
(3,4)	Yes
(3,5)	No
(3,6)	Yes
(4,5)	Yes
(4,6)	Yes
(5,6)	Yes
(6,5)	Yes
___________________________________
*/
