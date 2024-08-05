class SubSequence {
    boolean isSubSequence(String A, String B) {
        if (A.length() > B.length())
            return false;

        int Aindex = 0;
        int Bindex = 0;
        while (Bindex < B.length() && Aindex < A.length()) {
            char Achar = A.charAt(Aindex);
            char Bchar = B.charAt(Bindex);
            if (Achar == Bchar) {
                Aindex++;
            }
            Bindex++;

        }
        return Aindex == A.length();

    }
    public static void main(String[] args) {
        SubSequence subSequence = new SubSequence();
        subSequence.isSubSequence("BAT", "BATMAN");
    }
}