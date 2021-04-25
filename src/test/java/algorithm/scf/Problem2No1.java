package algorithm.scf;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem2No1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        long limit = convertSec(input[1]);
        long[] time = new long[n];
        long[] mem = new long[n + 1];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            time[i] = convertSec(br.readLine());
            if (i > 0) {
                mem[i] = mem[i-1] + time[i-1];
            }
        }
        int index = 1000001;
        int max_music_cnt = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long timeline = mem[j] - mem[i];
                if (timeline >= limit) {
                    int music_cnt = j - i;
                    int ind = i;
                    if (max_music_cnt < music_cnt) {
                        max_music_cnt = music_cnt;
                        index = ind;
                    } else if (max_music_cnt == music_cnt) {
                        index = Math.min(index, ind);
                    }
                    break;
                }
            }
        }
        System.out.println(max_music_cnt + " " + (index + 1));
    }

    private static long convertSec(String time) {
        String[] all_time = time.split(":");
        long sec = 0L;
        if (all_time.length == 2) {
            sec =  Long.parseLong(all_time[1]);
            sec += 60L * Long.parseLong(all_time[0]);
        } else {
            sec =  Long.parseLong(all_time[2]);
            sec += 60L * Long.parseLong(all_time[1]);
            sec += 3600L * Long.parseLong(all_time[0]);
        }

        return sec;
    }
}