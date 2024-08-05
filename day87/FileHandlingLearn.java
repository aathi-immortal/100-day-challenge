import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileHandlingLearn {

    public static void main(String[] args) {

        String fileName = "simple.txt";
        String content = "aathivanakkam";
        // fileWrite(fileName, content);
        fileRead(fileName);

    }

    private static void fileRead(String fileName) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(fileName);
            char[] contentInCharacterArray = new char[fileInputStream.available()];
            int index = 0;
            while (fileInputStream.available() != 0) {

                char character = (char) fileInputStream.read();
                contentInCharacterArray[index++] = character;

            }
            System.out.println();
            System.out.println(String.valueOf(contentInCharacterArray));
            fileInputStream.close();
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    private static void fileWrite(String fileName, String content) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);

            byte[] nameArray = content.getBytes();
            fileOutputStream.write(nameArray);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {

            e.printStackTrace();
        }

    }
}
