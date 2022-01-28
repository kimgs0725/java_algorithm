package algorithm.programmers;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class ProblemNo42627 {

    @Test
    void test() {
        assertThat(solution(new int[][]{{0, 3}, {1, 9}, {2, 6}})).isEqualTo(9);
    }

    public int solution(int[][] jobs) {
        LinkedList<Job> waiting = new LinkedList<>();
        PriorityQueue<Job> pq = new PriorityQueue<>();

        for (int[] job : jobs) {
            waiting.offer(new Job(job[0], job[1]));
        }

        waiting.sort(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.requestTime - o2.requestTime;
            }
        });

        int answer = 0, cnt = 0, time = waiting.peek().requestTime;

        while (cnt < jobs.length) {
            while (!waiting.isEmpty() && waiting.peek().requestTime <= time) {
                pq.offer(waiting.pollFirst());
            }

            if (!pq.isEmpty()) {
                Job job = pq.poll();
                time += job.workingTime;
                answer += time - job.requestTime;
                cnt++;
            } else {
                time++;
            }
        }
        return answer / cnt;
    }

    static class Job implements Comparable<Job> {
        int requestTime;
        int workingTime;

        Job(int requestTime, int workingTime) {
            this.requestTime = requestTime;
            this.workingTime = workingTime;
        }

        @Override
        public int compareTo(Job o) {
            return this.workingTime - o.workingTime;
        }
    }
}
