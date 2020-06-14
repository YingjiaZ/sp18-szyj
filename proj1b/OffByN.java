public class OffByN implements CharacterComparator {
    private int number;
    public OffByN(int N) {
        number = N;
    }
    /** returns true for characters that are different by N.*/
    @Override
    public boolean equalChars(char x, char y) {
        if (x - y == number || y - x == number) {
            return true;
        }
        return false;
    }
}
