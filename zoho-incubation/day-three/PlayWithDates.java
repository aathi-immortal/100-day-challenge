
class MyDate {
    int date;
    int month;
    int year;

    MyDate() {

    }

    @Override
    public String toString() {
        return "MyDate [date=" + date + ", month=" + month + ", year=" + year + "]";
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public MyDate(int date, int month, int year) {
        this.date = date;
        this.month = month;
        this.year = year;
    }

    public void add(int days) {
        // year calculation
        int remainingDays = yearCalculation(days);
        dayAndMonthCal(remainingDays);

    }

    private void dayAndMonthCal(int remainingDays) {
        System.out.println(remainingDays);
        int daysInMonth[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if (this.month == 2 && isLeapYear(this.year)) {
            daysInMonth[1] = 29;
        } else {
            daysInMonth[1] = 28;
        }
        int month = 1;

        while (remainingDays > daysInMonth[month - 1]) {

            remainingDays -= daysInMonth[month - 1];

            month++;

        }
        this.date = remainingDays;
        this.month = month;

    }

    // private int yearCalculationForSubtraction(MyDate date, int days) {
    // int currentYear = date.year;
    // int numberOfDays = calculateDays(date) - days;
    // int numberOfDaysInYear = getNumberOfDaysInYear(currentYear);

    // while (numberOfDays <= 0) {
    // currentYear--;
    // numberOfDaysInYear = getNumberOfDaysInYear(currentYear);
    // numberOfDays += numberOfDaysInYear;
    // }

    // date.year = currentYear;
    // return numberOfDays;
    // }

    private int yearCalculation(int days) {
        int currentYear = this.year;
        int numberOfDays = calculateDays() + days;
        int numberOfDaysInYear = getNumberOfDaysInYear(currentYear);
        while (numberOfDays > numberOfDaysInYear) {
            numberOfDays -= numberOfDaysInYear;
            currentYear++;
            numberOfDaysInYear = getNumberOfDaysInYear(currentYear);

        }
        this.year = currentYear;
        return numberOfDays;
    }

    private int getNumberOfDaysInYear(int currentYear) {
        if (isLeapYear(currentYear)) {
            return 366;
        }
        return 365;
    }

    private int calculateDays() {
        int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int days = 0;
        if (isLeapYear(this.year))
            daysInMonth[1] = 29;
        for (int month = 1; month < this.month; month++) {
            days += daysInMonth[month];
        }
        days += this.date;
        return days;
    }

    private boolean isLeapYear(int year) {
        if (year % 400 == 0)
            return true;
        else if (year % 100 == 0)
            return false;
        else if (year % 4 == 0)
            return true;

        return false;
    }

    public void sub(int days) {

        int nday = findNumberOfDays(this.month, this.year) + this.date - days;

        int year = this.year;
        while (nday <= 0) {
            year--;
            nday += getNumberOfDayInYear(year);
        }
        this.date = 31;
        this.month = 12;
        this.year = year - 1;
        add(nday);
    }

    private int getNumberOfDayInYear(int year) {
        if (isLeapYear(year)) {
            return 366;
        }
        return 365;
    }

    // input month and year
    // number of days from jan to given month
    private int findNumberOfDays(int givenMonth, int givenYear) {
        int month = 1;
        int days = 0;
        while (month < givenMonth) {
            days += getDaysInMonth(month, givenYear);
            month++;
        }
        return days;
    }

    private int getDaysInMonth(int month, int givenYear) {
        int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (month - 1 == 1 && isLeapYear(givenYear)) {
            return months[1] + 1;
        }
        return months[month - 1];
    }

    public void display() {
        System.out.println(this.toString());
    }

}

class DateUtility {

    public static MyDate add(MyDate date, int days) {
        // year calculation
        int remainingDays = yearCalculation(date, days);
        dayAndMonthCal(date, remainingDays);
        return date;
    }

    private static void dayAndMonthCal(MyDate date, int remainingDays) {
        System.out.println(remainingDays);
        int daysInMonth[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if (date.month == 2 && isLeapYear(date.year)) {
            daysInMonth[1] = 29;
        } else {
            daysInMonth[1] = 28;
        }
        int month = 1;

        while (remainingDays > daysInMonth[month]) {

            remainingDays -= daysInMonth[month];

            month++;

        }
        date.date = remainingDays;
        date.month = month;

    }

    // private int yearCalculationForSubtraction(MyDate date, int days) {
    // int currentYear = date.year;
    // int numberOfDays = calculateDays(date) - days;
    // int numberOfDaysInYear = getNumberOfDaysInYear(currentYear);

    // while (numberOfDays <= 0) {
    // currentYear--;
    // numberOfDaysInYear = getNumberOfDaysInYear(currentYear);
    // numberOfDays += numberOfDaysInYear;
    // }

    // date.year = currentYear;
    // return numberOfDays;
    // }

    private static int yearCalculation(MyDate date, int days) {
        int currentYear = date.year;
        int numberOfDays = calculateDays(date) + days;
        int numberOfDaysInYear = getNumberOfDaysInYear(currentYear);
        while (numberOfDays > numberOfDaysInYear) {
            numberOfDays -= numberOfDaysInYear;
            currentYear++;
            numberOfDaysInYear = getNumberOfDaysInYear(currentYear);

        }
        date.year = currentYear;
        return numberOfDays;
    }

    private static int getNumberOfDaysInYear(int currentYear) {
        if (isLeapYear(currentYear)) {
            return 366;
        }
        return 365;
    }

    private static int calculateDays(MyDate date) {
        int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int days = 0;
        if (isLeapYear(date.year))
            daysInMonth[1] = 29;
        for (int month = 1; month < date.month; month++) {
            days += daysInMonth[month];
        }
        days += date.date;
        return days;
    }

    private static boolean isLeapYear(int year) {
        if (year % 400 == 0)
            return true;
        else if (year % 100 == 0)
            return false;
        else if (year % 4 == 0)
            return true;

        return false;
    }

    public static MyDate sub(MyDate date, int days) {

        int nday = findNumberOfDays(date.month, date.year) + date.date - days;

        int year = date.year;
        while (nday <= 0) {
            year--;
            nday += getNumberOfDayInYear(year);
        }
        date.date = 31;
        date.month = 12;
        date.year = year - 1;
        return add(date, nday);
    }

    private static int getNumberOfDayInYear(int year) {
        if (isLeapYear(year)) {
            return 366;
        }
        return 365;
    }

    // input month and year
    // number of days from jan to given month
    private static int findNumberOfDays(int givenMonth, int givenYear) {
        int month = 1;
        int days = 0;
        while (month < givenMonth) {
            days += getDaysInMonth(month, givenYear);
            month++;
        }
        return days;
    }

    private static int getDaysInMonth(int month, int givenYear) {
        int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (month - 1 == 1 && isLeapYear(givenYear)) {
            return months[1] + 1;
        }
        return months[month - 1];
    }

    // public static int difference(MyDate dateOne, MyDate dateTwo) {
    // if (datePosition(dateOne, dateTwo) == false) {
    // MyDate temDate = dateOne;
    // dateTwo = dateOne;
    // dateOne = temDate;
    // }
    // if (dateOne.getYear() == dateTwo.getYear()) {
    // return Math.abs(findNumberOfDays(dateTwo) - findNumberOfDays(dateOne));
    // }
    // int daysBetweenYears = 0;
    // daysBetweenYears = getNumberOfDayInYear(dateOne.getYear())
    // - (findNumberOfDays(dateOne.month, dateOne.year) + dateOne.date);
    // System.out.println(getNumberOfDayInYear(dateOne.getYear()) + " " +
    // daysBetweenYears + " "
    // + (findNumberOfDays(dateOne.month, dateOne.year) + dateOne.date));
    // for (int year = dateOne.getYear() + 1; year < dateTwo.getYear(); year++) {
    // daysBetweenYears += getNumberOfDayInYear(year);
    // }
    // daysBetweenYears += (helper.findNumberOfDays(date2.month, date2.year) +
    // date2.date);
    // return daysBetweenYears;
    // }

    public static MyDate parseDate(String dateString) {
        char[] dateArray = dateString.toCharArray();
        String day = "", month = "", year = "";

        int i = 0;
        while (dateArray[i] != '-') {
            day += dateArray[i];
            i++;
        }

        i++;

        while (dateArray[i] != '-') {
            month += dateArray[i];
            i++;
        }

        i++;

        while (i < dateArray.length) {
            year += dateArray[i];
            i++;
        }
        return new MyDate(Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year));
    }

}

public class PlayWithDates {
    public static void main(String[] args) {
        MyDate date = DateUtility.parseDate("30-11-2023");
        date.add(1);
        date.display();
    }
}
