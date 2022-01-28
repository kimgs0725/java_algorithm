package algorithm.programmers;

public class ProblemNo17676 {

    public int solution(String[] lines) {
        int answer = 0;
        int[] startTimes = new int[lines.length];
        int[] endTimes = new int[lines.length];
        parseProcessingTime(lines, startTimes, endTimes);
        for (int i = 0; i < startTimes.length; i++) {
            int cnt = 0;
            int startOfSection = startTimes[i];
            int endOfSection = startOfSection + 1000;

            for (int j = 0; j < startTimes.length; j++) {
                if (startOfSection <= startTimes[j] && startTimes[j] < endOfSection) {
                    cnt++;
                } else if (startOfSection <= endTimes[j] && endTimes[j] < endOfSection) {
                    cnt++;
                } else if (startTimes[j] <= startOfSection && endOfSection <= endTimes[j]) {
                    cnt++;
                }
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    private void parseProcessingTime(String[] lines, int[] startTimes, int[] endTimes) {
        for (int i = 0; i < lines.length; i++) {
            String[] log = lines[i].split(" ");
            String[] responseTime = log[1].split(":");
            int processingTime = (int)(Double.parseDouble(log[2].substring(0, log[2].length() - 1)) * 1000);
            int startTime = 0, endTime = 0;
            endTime += Integer.parseInt(responseTime[0]) * 60 * 60 * 1000;
            endTime += Integer.parseInt(responseTime[0]) * 60 * 1000;
            endTime += (int)(Double.parseDouble(responseTime[2]) * 1000);
            startTime = endTime - processingTime + 1;

            startTimes[i] = startTime;
            endTimes[i] = endTime;
        }
    }
}
