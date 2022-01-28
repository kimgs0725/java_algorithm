package algorithm.algo;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueAlgo {

    private static final Comparator<PQ> aComp = new Comparator<PQ>() {
        @Override
        public int compare(PQ o1, PQ o2) {
            return o1.a - o2.a;
        }
    };

    private static final Comparator<PQ> bComp = new Comparator<PQ>() {
        @Override
        public int compare(PQ o1, PQ o2) {
            return o1.b - o2.b;
        }
    };

    @Test
    void test() {
        PriorityQueue<PQ> pq = new PriorityQueue<>(aComp);
        pq.offer(new PQ(4, 2));
        pq.offer(new PQ(5, 2));
        pq.offer(new PQ(5, 1));
        pq.offer(new PQ(3, 2));
        pq.offer(new PQ(2, 2));
        pq.offer(new PQ(5, 3));
        pq.offer(new PQ(1, 2));

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    static class PQ{
        int a;
        int b;

        PQ(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "PQ{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }
}
