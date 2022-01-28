package algorithm.programmers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class ProblemSixshopNo2 {

    @Test
    void test() {
        assertThat(solution(3, new String[]{"alex111 100", "cheries2 200", "coco 150", "luna 100", "alex111 120", "coco 300", "cheries2 110"})).isEqualTo(4);
    }

    public int solution(int K, String[] user_scores) {
        int answer = 0, idx = 0;
        UserScore[] userScoreList = new UserScore[K];
        Set<String> topTierUsername = new HashSet<>();
        while (topTierUsername.size() < K) {
            UserScore userScore = new UserScore(user_scores[idx]);
            if (topTierUsername.contains(userScore.user)) {
                for (int j = 0; j < userScoreList.length; j++) {
                    if (userScoreList[j].user == userScore.user) {
                        if (userScore.score < userScoreList[j].score) {
                            break;
                        }
                        userScoreList[j].score = userScore.score;
                        if ((j > 0 && userScoreList[j - 1].score < userScoreList[j].score) ||
                                (j < userScoreList.length - 1 && userScoreList[j + 1].score > userScoreList[j].score)) {
                            Arrays.sort(userScoreList);
                            answer++;
                        }
                    }
                }
                continue;
            }
            topTierUsername.add(userScore.user);
            userScoreList[idx++] = userScore;
            Arrays.sort(userScoreList);
            answer++;
        }
        for (int i = K; i < user_scores.length; i++) {
            UserScore userScore = new UserScore(user_scores[i]);
            if (topTierUsername.contains(userScore.user)) {
                for (int j = 0; j < userScoreList.length; j++) {
                    if (userScoreList[j].user == userScore.user) {
                        if (userScore.score < userScoreList[j].score) {
                            break;
                        }
                        userScoreList[j].score = userScore.score;
                        if ((j > 0 && userScoreList[j - 1].score < userScoreList[j].score) ||
                                (j < userScoreList.length - 1 && userScoreList[j + 1].score > userScoreList[j].score)) {
                            Arrays.sort(userScoreList);
                            answer++;
                        }
                    }
                }
            } else {
                if (userScoreList[userScoreList.length-1].score > userScore.score) {
                    continue;
                }
                topTierUsername.remove(userScoreList[userScoreList.length - 1].user);
                userScoreList[userScoreList.length - 1] = userScore;
                topTierUsername.add(userScore.user);
                Arrays.sort(userScoreList);
                answer++;
            }
        }
        return answer;
    }

    static class UserScore implements Comparable<UserScore> {
        String user;
        Integer score;

        public UserScore(String userScore) {
            String[] s = userScore.split(" ");
            this.user = s[0];
            this.score = Integer.parseInt(s[1]);
        }

        @Override
        public int compareTo(UserScore o) {
            return this.score <= o.score ? 1 : -1;
        }
    }

}
