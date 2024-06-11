public class FindNumberOfDates {
    static int noOfDays(int d1, int m1, int y1, int d2, int m2, int y2) {

        // year alignment
        if (y1 > y2 || (m1 > m2) && (y1 == y2)) {
            int tem = d1;
            d1 = d2;
            d2 = tem;

            tem = m1;
            m1 = m2;
            m2 = tem;

            tem = y1;
            y1 = y2;
            y2 = tem;
        }

        int currentMonth = m1;
        int currentYear = y1;
        int days = 0;
        // number of month between two dates
        int numberOfMonths = getNumberOfMonths(y1, y2, m1, m2);

        // if no of month is negative -> same month and same year
        if (numberOfMonths < 0) {
            return d2 - d1;
        }
        // first month
        days += getNumberOfDaysInCurrentMonth(currentMonth, currentYear) - d1;

        // iterate numberOfMonth time between two dates
        for (int time = 0; time < numberOfMonths; time++) {

            currentMonth++;

            // if currentMonth become 13 we jump into next year
            if (currentMonth == 13) {
                // next year first month
                currentMonth = 1;
                // new year
                currentYear++;
            }
            // currentMonthDays
            days += getNumberOfDaysInCurrentMonth(currentMonth, currentYear);

        }

        // last month
        days += d2;
        return days;
        // if not different month
    }

    private static int getNumberOfDaysInCurrentMonth(int currentMonth, int currentYear) {
        int daysInMont[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (currentMonth == 2 && isLeapYear(currentYear)) {
            // leap year has 29 days in feb
            return daysInMont[currentMonth - 1] + 1;
        }
        return daysInMont[currentMonth - 1];

    }

    private static boolean isLeapYear(int currentYear) {
        if (currentYear % 400 == 0 || (currentYear % 100 != 0 && currentYear % 4 == 0))
            return true;
        return false;

    }

    private static int getNumberOfMonths(int yearOne, int yearTwo, int monthOne, int monthTwo) {
        int numberOfYear = yearTwo - yearOne;
        // same year
        if (numberOfYear == 0) {
            return monthTwo - monthOne - 1;
        }
        return (Math.abs((numberOfYear * 12)) - monthOne) + monthTwo - 1;

        // not in same year

    }

    public static void main(String[] args) {
        int days = noOfDays(11, 3, 1038, 1, 7, 962);
        System.out.println();
        System.out.println(days);
    }

}

// 11 3 1038
// 1 7 962