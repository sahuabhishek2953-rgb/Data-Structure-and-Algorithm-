class Solution {
    private static final int[] DAYS_IN_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int startAlice = getDayOfYear(arriveAlice);
        int endAlice = getDayOfYear(leaveAlice);
        int startBob = getDayOfYear(arriveBob);
        int endBob = getDayOfYear(leaveBob);

        int overlapStart = Math.max(startAlice, startBob);
        int overlapEnd = Math.min(endAlice, endBob);

        return Math.max(0, overlapEnd - overlapStart + 1);
    }

    private int getDayOfYear(String date) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));

        int dayOfYear = day;
        for (int i = 0; i < month - 1; i++) {
            dayOfYear += DAYS_IN_MONTH[i];
        }
        return dayOfYear;
    }
}