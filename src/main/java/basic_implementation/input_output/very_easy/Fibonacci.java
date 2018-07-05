package basic_implementation.input_output.very_easy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by iurii on 6/6/18.
 */
public class Fibonacci {
    /** 0,1,1,2,3,5,8,13,21... **/

    private static final class Transaction {
        private final String currency;
        private final Integer id;

        private Transaction(String currency, Integer id) {
            this.currency = currency;
            this.id = id;
        }

        public String getCurrency() {
            return currency;
        }

        public Integer getId() {
            return id;
        }

        static Transaction of(String currency, Integer id) {
            return new Transaction(currency, id);
        }
    }

    public static List<Transaction> generateTestTransactions() {
        Transaction tr1 = Transaction.of("UAH", 1);
        Transaction tr2 = Transaction.of("USD", 2);
        Transaction tr3 = Transaction.of("EUR", 3);
        Transaction tr4 = Transaction.of("UAH", 4);
        Transaction tr5 = Transaction.of("USD", 5);

        return Arrays.asList(tr1, tr2, tr3, tr4, tr5);
    }

    public static void main(String[] args) {

        Map<String, List<Transaction>> rez = generateTestTransactions().stream().
                collect(Collectors.groupingBy(Transaction::getCurrency));

        int y =1;
        /*Stream.iterate(new int[] {0, 1}, a -> new int[] {a[1], a[0] + a[1]}).map(t -> t[0]).
                limit(10).forEach(System.out::println);*/

        /** (0,1) (1,2) (3,5) (8,13) (21, 34) **/
        /*IntStream.rangeClosed(0, 5).reduce(0, (a, b) -> a + b);*/
/*
        IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                                .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
                                .mapToObj(b ->
                                        new int[]{a, b, (int)Math.sqrt(a * a + b * b)})
                ).limit(6).forEach(t -> System.out.println(t[0] + "," + t[1] + "," + t[2]));*/
        /*Stream<int[]> stream = IntStream.rangeClosed(0, 10).boxed().flatMap(
                a -> IntStream.rangeClosed(a, 100).
                        filter(b -> )
        )*/
    }
}
