package hu.nive.ujratervezes.zarovizsga.words;

public class Words {

    public boolean hasMoreDigits(String s) {
        int charCounter = 0;
        int numbCounter = 0;
        for (int i = 0; i < s.length(); i++) {
            boolean temp = true;
            temp = isNumber(s, i, temp);
            if (temp == false) {
                charCounter++;
            } else {
                numbCounter++;
            }
        }
        return numbCounter > charCounter;
    }

    private boolean isNumber(String s, int i, boolean temp) {
        try {
            Integer.parseInt(s.substring(i, i +1));
        } catch (NumberFormatException e) {
            temp = false;
        }
        return temp;
    }
}
