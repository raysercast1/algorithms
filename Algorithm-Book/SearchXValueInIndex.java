import java.util.Optional;

public class SearchXValueInIndex {
    public static void main(String[] args) {
        Integer[] numbers = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        for (String x : args) {
            Optional<Integer> value = searchXValueInIndex(numbers, Integer.valueOf(x));
            if (value.isPresent()) {
                System.out.println("Value x is in index: ");
                System.out.println(value);
            } else {
                System.out.println("Value x is not in array: ");
                System.out.println(value);
            }
        }
    }

    public static Optional<Integer> searchXValueInIndex(Integer[] numbers, Integer valueToSearch) {
        for (Integer i = 0; i < numbers.length; i++) {
            if (numbers[i] == valueToSearch) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }
}
