import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LinearSearch {
    public static void main(String args[]) {
        List<Integer> orderedList = new ArrayList<>();
        for (String a : args) {
            orderedList = linearSearch(castStringToArrayList(a));
        }
        System.out.println("Ordered Array");
        System.out.println(orderedList);
    }

    public static List<Integer> linearSearch(ArrayList<Integer> arrayList) {
        Integer[] fixedArray = arrayList.toArray(new Integer[arrayList.size()]);
        for (int i = 1; i < fixedArray.length; i++) {
            int k = fixedArray[i];
            int j = i - 1;
            while (j >= 0 && fixedArray[j] > k) {
                fixedArray[j + 1] = fixedArray[j];
                j = j - 1;
            }
            fixedArray[j + 1] = k;
        }
        
        return Arrays.asList(fixedArray);
    }

    public static ArrayList<Integer> castStringToArrayList(String aString) {
        StringBuilder collector = new StringBuilder(aString.length());
        ArrayList<Integer> arrayOfIntegers = new ArrayList<>();
        for (int i = 0; i < aString.length();) {
            char character = aString.charAt(i);
            while (Character.isDigit(character)) {
                collector.append(character);
                i++;
                character = aString.charAt(i);
            }
            if (collector.length() > 0) arrayOfIntegers.add(Integer.parseInt(collector.toString()));
            collector.delete(0, collector.length());
            i++;
        }
        return arrayOfIntegers;
    }
}