// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        /*
        Your task is to sort a given string. Each word in the string will contain a single number.
        This number is the position the word should have in the result.

        Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0).

        If the input string is empty, return an empty string. The words in the input
        String will only contain valid consecutive numbers.

        Examples
        "is2 Thi1s T4est 3a"  -->  "Thi1s is2 3a T4est"
        "4of Fo1r pe6ople g3ood th5e the2"  -->  "Fo1r the2 g3ood 4of th5e pe6ople"
""  -->  ""
         */
        System.out.println(sortOrder("is2 Thi1s T4est 3a"));
    }
    public static String sortOrder(String str) {
        StringBuilder sb = new StringBuilder();
        if(str == null || str.isEmpty()) return "";
        String[] words = str.split(" ");
        for(int i = 0; i < words.length; i++) {
            for(int j = i + 1; j < words.length; j++) {
                int indexOfi = getIndex(words[i]);
                int indexOfj = getIndex(words[j]);
                if(indexOfi > indexOfj) {
                    String temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                }
            }
        }
        for(int i = 0; i < words.length; i++) {
            sb.append(words[i]).append(" ");
        }
        return sb.toString().trim();
    }
    public static int getIndex(String str) {
        str = str.toLowerCase();
        char[] chars = str.toCharArray();
        for(char c : chars) {
            if(Character.isDigit(c)) return Integer.parseInt(String.valueOf(c));
        }
        return -1;
    }
}