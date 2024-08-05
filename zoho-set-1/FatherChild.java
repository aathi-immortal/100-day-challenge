public class FatherChild {
    public static void main(String[] args) {

        String[][] family = { { "luke", "shaw" },
                { "wayne", "rooney" },
                { "rooney", "ronaldo" },
                { "shaw", "rooney" }
        };
        int gen = 3;
        int count = countChild("ronaldo", gen, 0, family);
        System.out.println();
        System.out.println("ans : " + count);
    }

    private static int countChild(String name, int gen, int currentGen, String[][] family) {
        int count = 0;
        if (gen == currentGen) {
            for (String[] innerArray : family) {
                if (innerArray[0].compareTo(name) == 0) {
                    count += 1;
                }
            }
            return count;
        }
        for (String[] innerArray : family) {
            if (innerArray[1].compareTo(name) == 0) {
                count += countChild(innerArray[0], gen, currentGen + 1, family);
            }
        }
        return count;
    }
}
