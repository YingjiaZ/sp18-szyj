public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> result = new LinkedListDeque<>();
        //both ArrayDeque & LinkedListDeque pass the test
        int length = word.length();
        for (int i = 0; i < length; i++) {
            result.addLast(word.charAt(i));
        }
        return result;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> someDeque = wordToDeque(word);
        return palindromeHelper(someDeque);
    }

    private boolean palindromeHelper(Deque someDeque) {
        if (someDeque.size() == 0 || someDeque.size() == 1) {
            return true;
        } else {
            Object first = someDeque.removeFirst();
            Object last = someDeque.removeLast();
            if (first != last) {
                return false;
            } else {
                return palindromeHelper(someDeque);
            }
        }
    }

    /** The method will return true if the word is a palindrome according to the
     * character comparison test provided by the CharacterComparator passed in as argument cc. */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> someDeque = wordToDeque(word);
        return palindromeHelper2(someDeque, cc);
    }

    private boolean palindromeHelper2(Deque someDeque, CharacterComparator cc) {
        if (someDeque.size() == 0 || someDeque.size() == 1) {
            return true;
        } else {
            char first = (char) someDeque.removeFirst();
            char last = (char) someDeque.removeLast();
            if (!cc.equalChars(first, last)) {
                return false;
            } else {
                return palindromeHelper2(someDeque, cc);
            }
        }
    }
}
