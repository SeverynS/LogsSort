package com;
/*
You are given an array of logs. Each log is a space-delimited string of words, where the first word is the identifier.

There are two types of logs:

Letter-logs: All words (except the identifier) consist of lowercase English letters.
Digit-logs: All words (except the identifier) consist of digits.
Reorder these logs so that:

The letter-logs come before all digit-logs.
The letter-logs are sorted lexicographically by their contents. If their contents are the same,
then sort them lexicographically by their identifiers.
The digit-logs maintain their relative ordering.
Return the final order of the logs.

Example 1:

Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
Explanation:
The letter-log contents are all different, so their ordering is "art can", "art zero", "own kit dig".
The digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".

Example 2:

Input: logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
*/

import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<String> logs = Arrays.asList("dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero");
        List<String> logs2 = Arrays.asList("a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo");
        Solution solution = new Solution();
        System.out.println(solution.reorderLogFiles(logs));
        System.out.println(solution.reorderLogFiles(logs2));

    }
}

class Solution {
    public List<String> reorderLogFiles(List<String> logs) {
        List<String> result = new ArrayList<>();
        List<String> digits = new ArrayList<>();
        List<String> letters = new ArrayList<>();

        for (int i = 0; i < logs.size(); i++) {
            String value = logs.get(i).substring(logs.get(i).indexOf(" "));
            if (Character.isDigit(value.charAt(1))) {
                digits.add(logs.get(i));
            } else {
                letters.add(logs.get(i));
            }
        }

        result.addAll(lettersListSorting(letters));
        result.addAll(digits);

        return result;

    }

    private List<String> lettersListSorting(List<String> stringList) {
        for (int i = 1; i < stringList.size(); i++) {
            String id = stringList.get(i).substring(0, stringList.get(i).indexOf(" "));
            String value = stringList.get(i).substring(stringList.get(i).indexOf(" "));
            String prevId = stringList.get(i - 1).substring(0, stringList.get(i - 1).indexOf(" "));
            String prevValue = stringList.get(i - 1).substring(stringList.get(i - 1).indexOf(" "));
            int compareValue = value.compareTo(prevValue);
            int compareId = id.compareTo(prevId);
            if (compareValue == 0) {
                if (compareId < 0) {
                    stringList.set(i, prevId + "" + prevValue);

                }
            }
        }
        return stringList;
    }
}


