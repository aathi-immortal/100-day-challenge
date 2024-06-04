import java.util.HashMap;

public class RemoveCharacter {

    static HashMap<Character, Integer> map;

    static String removeChars(String string1, String string2) {
        map = new HashMap<>();
        loadHashMap(string1);
        // remove character
        for (int index = 0; index < string2.length(); index++) {
            char character = string2.charAt(index);
            if (map.containsKey(character)) {
                map.put(character, 0);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int index = 0; index < string1.length(); index++) {
            char character = string1.charAt(index);
            if (map.get(character) > 0) {
                stringBuilder.append(character);
            }
        }
        return stringBuilder.toString();
    }

    private static void loadHashMap(String string1) {
        for (int index = 0; index < string1.length(); index++) {
            char character = string1.charAt(index);
            if (map.containsKey(character)) {
                map.put(character, map.get(character) + 1);
            } else {

                map.put(character, 1);

            }
        }
    }

}
