import java.util.HashMap;

public class CheckIsPanagaram {

    public static void main(String[] args) {
        System.out.println();
        System.out.println((int) 'z');
    }

    public boolean checkIfPangram(String sentence) {

        // create ascii array
        // traverse the sentence and update the ascii array
        // traverse the ascii array if we face zero return false
        // return true

        int asziiArray[] = new int[26];

        for (int index = 0; index < sentence.length(); index++) {
            Character character = sentence.charAt(index);

            // update in ascii array
            asziiArray[((int) character) - 97] = 1;
        }

        //validate

        for(int data : asziiArray)
        {
            if(data == 0)
                return false;
        }
        return true;

    }
}
