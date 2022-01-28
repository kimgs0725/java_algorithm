package algorithm.programmers;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ProblemSixshopNo3 {

    @Test
    void test() {
        assertThat(solution(3, new int[]{4, 2, 2, 5, 3})).containsExactlyInAnyOrder(2, 3, 1, 5, 4);
        assertThat(solution(1, new int[]{100, 1, 50, 1, 1})).containsExactlyInAnyOrder(1, 2, 3, 4, 5);
    }

    public int[] solution(int N, int[] coffee_times) {
        Queue<Coffee> coffeeQueue = new LinkedList<>();
        for (int i = 0; i < coffee_times.length; i++) {
            coffeeQueue.offer(new Coffee(i+1, coffee_times[i]));
        }
        List<Coffee> coffeeMachine = new ArrayList<>();
        Comparator<Coffee> minCoffee = Comparator.comparing(coffee -> coffee.time);
        int[] answer = new int[coffee_times.length];
        AtomicInteger answer_idx = new AtomicInteger();
        while (!coffeeQueue.isEmpty()) {
            Coffee newOrder = coffeeQueue.poll();
            coffeeMachine.add(newOrder);
            if (coffeeMachine.size() < N) {
                continue;
            }
            Coffee coffee = coffeeMachine.stream().min(minCoffee).orElseThrow(IllegalAccessError::new);
            coffeeMachine = coffeeMachine.stream()
                    .filter(c -> {
                        if (c.time == coffee.time) {
                            answer[answer_idx.getAndIncrement()] = coffee.num;
                            return false;
                        }
                        return true;
                    })
                    .map(c -> new Coffee(c.num, c.time - coffee.num))
                    .collect(Collectors.toList());
        }
        while (!coffeeMachine.isEmpty()) {
            for (int i = 0; i < coffeeMachine.size(); i++) {
                Coffee coffee = coffeeMachine.get(i);
                coffee.time--;
                if (coffee.time == 0) {
                    answer[answer_idx.getAndIncrement()] = coffee.num;
                    coffeeMachine.remove(i);
                    i--;
                }
            }
        }
        return answer;
    }

    static class Coffee {
        int num;
        int time;

        public Coffee(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }
}
