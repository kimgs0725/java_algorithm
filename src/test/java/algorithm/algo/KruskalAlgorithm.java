package algorithm.algo;

import org.junit.jupiter.api.Test;

import java.util.*;

class Edge implements Comparable<Edge> {
    int v1;
    int v2;
    int cost;

    public Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        if (this.cost < o.cost) {
            return -1;
        }
        else if (this.cost == o.cost) {
            return 0;
        }
        return 1;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("edge.v1=");
        builder.append(this.v1);
        builder.append(" edge.v2=");
        builder.append(this.v2);
        builder.append(" cost=");
        builder.append(this.cost);
        return builder.toString();
    }
}

public class KruskalAlgorithm {

    private int[] parent;

    @Test
    void test() {
        List<Edge> edgeList = new ArrayList<>();
        edgeList.add(new Edge(0,3,4));
        edgeList.add(new Edge(0,1,6));
        edgeList.add(new Edge(1,2,5));
        edgeList.add(new Edge(1,3,3));
        edgeList.add(new Edge(1,4,7));
        edgeList.add(new Edge(1,5,8));
        edgeList.add(new Edge(2,5,8));
        edgeList.add(new Edge(3,4,9));
        edgeList.add(new Edge(4,5,11));
        Set<Edge> ret = kruscal(edgeList);
    }

    private Set<Edge> kruscal(List<Edge> nodes) {
        parent = new int[7];
        for (int i = 0; i < 7; i++) {
            parent[i] = i;
        }

        Collections.sort(nodes);

        Set<Edge> ret = new HashSet<>();
        for (Edge edge : nodes) {
            if (!isSameParent(edge.v1, edge.v2)) {
                ret.add(edge);
                union(edge.v1, edge.v2);
            }
        }
        return ret;
    }

    private boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        return x == y;
    }

    private int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
        }
    }


}
