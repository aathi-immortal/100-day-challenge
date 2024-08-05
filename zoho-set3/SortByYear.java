import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class SortByYear {

    public static void main(String[] args) {

        String[] dates = { "24 Jul 2017", "25 Jul 2017", "11 Jun 1996",
                "01 Jan 2019", "12 Aug 2005", "01 Jan 1997" };
        sortByDates(dates);
        printDates(dates, dates.length);
    }

    static void printDates(String[] dates, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(dates[i]);
        }
    }

    private static void sortByDates(String[] dates) {
        Arrays.sort(dates, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return getDates(o1) - getDates(o2);

            }

        });

    }

    private static int getDates(String o1) {
        Date dateOne = new Date(o1);
        return dateOne.date + dateOne.month * 100 + dateOne.year * 10000;

    }

}

class Date {
    int date;
    int month;
    int year;
    static HashMap<String, Integer> monthsMap;
    static {
        monthsMap = new HashMap<>();
        monthsMap.put("Jan", 1);
        monthsMap.put("Feb", 2);
        monthsMap.put("Mar", 3);
        monthsMap.put("Apr", 4);
        monthsMap.put("May", 5);
        monthsMap.put("Jun", 6);
        monthsMap.put("Jul", 7);
        monthsMap.put("Aug", 8);
        monthsMap.put("Sep", 9);
        monthsMap.put("Oct", 10);
        monthsMap.put("Nov", 11);
        monthsMap.put("Dec", 12);
    }

    Date(String dateInString) {

        String[] date1 = dateInString.split(" ");
        this.date = Integer.parseInt(date1[0]);
        this.month = monthsMap.get(date1[1]);
        this.year = Integer.parseInt(date1[2]);
    }
}
