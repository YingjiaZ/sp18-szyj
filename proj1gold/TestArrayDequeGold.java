import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void testGold() {
        StudentArrayDeque<Integer> stu = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> slu = new ArrayDequeSolution<>();
        String message = "\n";
        int size = 0;

        for (int i = 0; i < 20; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.25) {
                stu.addLast(i);
                slu.addLast(i);
                size += 1;
                message = message + "addLast(" + i + ")" + "\n";
                assertEquals(message,slu.get(size - 1),stu.get(size - 1));
            } else if (numberBetweenZeroAndOne > 0.25 && numberBetweenZeroAndOne < 0.5) {
                stu.addFirst(i);
                slu.addFirst(i);
                size += 1;
                message = message + "addFirst(" + i + ")" + "\n";
                assertEquals(message,slu.get(0),stu.get(0));
            } else if (numberBetweenZeroAndOne > 0.5 && numberBetweenZeroAndOne < 0.75) {
                if (size == 0) {
                    continue;
                } else {
                    Integer sturl = stu.removeLast();
                    Integer slurl = slu.removeLast();
                    message = message + "removeLast()" + "\n";
                    size -= 1;
                    assertEquals(message, slurl, sturl);
                }
            } else if (numberBetweenZeroAndOne > 0.75) {
                if (size == 0) {
                    continue;
                } else {
                    Integer sturf = stu.removeFirst();
                    Integer slurf = slu.removeFirst();
                    message = message + "removeFirst()" + "\n";
                    size -= 1;
                    assertEquals(message, slurf, sturf);

                }
            }
        }
    }
}