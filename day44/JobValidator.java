import java.time.LocalDate;
import java.time.Year;
import java.util.Date;
import java.util.Scanner;

public class JobValidator {
    // main method excuted at first
    static LocalDate validStartDate = LocalDate.parse("2023-06-20");
    static LocalDate validEndDate = LocalDate.parse("2023-11-15");

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        while (true) {
            LocalDate startDate;
            LocalDate endDate;
            System.out.println("enter the staring date with year and month (yy-mm-dd):");
            startDate = LocalDate.parse(scan.nextLine());

            System.out.println("enter the ending date with year and month (yy-mm-dd):");
            endDate = LocalDate.parse(scan.nextLine());

            boolean result = isValidJob(startDate, endDate);
            boolean result2 = isValidJobOptimal(startDate, endDate);
            System.out.println(result);
            System.out.println(result2);

        }
    }

    private static boolean isValidJobOptimal(LocalDate givenStartDate, LocalDate givenEndDate) {
        return !(givenEndDate.isBefore(validStartDate) || givenStartDate.isAfter(validEndDate));
    }

    private static boolean isValidJob(LocalDate givenStartDate, LocalDate givenEndDate) {

        int givenStartYear = givenStartDate.getYear();
        int givenEndYear = givenEndDate.getYear();

        int givenStartMonth = givenStartDate.getMonthValue();
        int givenEndMonth = givenEndDate.getMonthValue();

        int givenStartDay = givenStartDate.getDayOfMonth();
        int givenEndDay = givenEndDate.getDayOfMonth();

        int startEndYearDifferenceAddOn = validEndDate.getYear() - givenStartYear;
        int endStartYearDifferenceAddon = givenEndYear - validStartDate.getYear();

        int endDateAddon = getNumberOfDays(validEndDate.getYear());
        int givenEndDateAddon = getNumberOfDays(givenEndYear);

        // year validation

        if (!(givenStartYear <= (validEndDate.getYear()) && givenEndYear >= validStartDate.getYear())) {

            return false;
        }

        int constrainEndMonth = (validEndDate.getMonthValue() + (12 * startEndYearDifferenceAddOn));
        int givenJobEndMonth = givenEndMonth + (12 * endStartYearDifferenceAddon);

        // month validation
        if (!(givenStartMonth <= constrainEndMonth)
                && givenJobEndMonth >= validStartDate.getMonthValue()) {
            return false;
        }
        // day validation
        if (!(givenStartDay <= (validEndDate.getDayOfMonth() + endDateAddon)
                && givenEndDay + (givenEndDateAddon) >= validStartDate.getDayOfMonth())) {
            return false;
        }

        return true;
    }

    private static int getNumberOfDays(int givenEndYear) {
        Year year = Year.of(givenEndYear);
        return year.length();
    }

}
