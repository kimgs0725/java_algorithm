package algorithm.baekjoon;

import java.io.*;

public class ProblemNo3029 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] current = br.readLine().split(":");
        String[] threw = br.readLine().split(":");
        Time currentTime = new Time(Integer.parseInt(current[0]), Integer.parseInt(current[1]), Integer.parseInt(current[2]));
        Time throwTime = new Time(Integer.parseInt(threw[0]), Integer.parseInt(threw[1]), Integer.parseInt(threw[2]));
        Time newTime = throwTime.subscriptTime(currentTime);
        bw.write(newTime.toString());
        bw.close();
        br.close();
    }

    static class Time {
        int hour;
        int minute;
        int seconds;

        public Time(int hour, int minute, int seconds) {
            this.hour = hour;
            this.minute = minute;
            this.seconds = seconds;
        }

        public Time subscriptTime(Time t) {
            int new_h, new_m, new_s;
            int minus_h = 0, minus_m = 0;
            if (seconds < t.seconds) {
                minus_m++;
                new_s = 60 - t.seconds + seconds;
            } else {
                new_s = seconds - t.seconds;
            }

            if ((minute - minus_m) < t.minute) {
                minus_h++;
                new_m = 60 - t.minute + (minute - minus_m);
            } else {
                new_m = (minute - minus_m) - t.minute;
            }

            if ((hour - minus_h) < t.hour) {
                new_h = 24 - t.hour + (hour - minus_h);
            } else {
                new_h = (hour - minus_h) - t.hour;
            }

            if (new_h == 0 && new_m == 0 && new_s == 0) {
                return new Time(24, 0, 0);
            }
            return new Time(new_h, new_m, new_s);
        }

        @Override
        public String toString() {
            return String.format("%02d:%02d:%02d", hour, minute, seconds);
        }
    }
}
