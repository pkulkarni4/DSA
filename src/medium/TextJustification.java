package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextJustification {
    public static void main(String[] args) {
        String[] words = new String[] {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        SolutionTextJustification s = new SolutionTextJustification();
        List<String> result = s.fullJustify(words, maxWidth);
         System.out.println(result);
         for(String s1 : result) {
             System.out.print( " : " + s1.length());
         }

    }
}

class SolutionTextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        List<StringBuilder> currentWords = new ArrayList<>();
        int sumOfLenOfCurrWords = 0;

        for(String word : words) {
            int newLineLen = sumOfLenOfCurrWords + word.length() + currentWords.size();
            if(newLineLen > maxWidth) {
                int extraPadding = maxWidth - (sumOfLenOfCurrWords + currentWords.size() - 1);
                int wordsToRoundRobinSpace = Math.max(currentWords.size() - 1, 1);
                for(int i = 0; i<extraPadding; i++){
                    int indexForSpace = i % wordsToRoundRobinSpace;
                    currentWords.get(indexForSpace).append(" ");
                }
                res.add(currentWords.stream().map(StringBuilder::toString).collect(Collectors.joining(" ")));
                currentWords = new ArrayList<>();
                sumOfLenOfCurrWords = 0;
            }
            currentWords.add(new StringBuilder(word));
            sumOfLenOfCurrWords += word.length();
        }

        int extraSpaces = maxWidth - (sumOfLenOfCurrWords + currentWords.size() - 1);
        String spaces = Stream.generate(() -> " ").limit(extraSpaces).collect(Collectors.joining(""));
        res.add(currentWords.stream().map(StringBuilder::toString).collect(Collectors.joining("")) + spaces);
        return res;
    }
}