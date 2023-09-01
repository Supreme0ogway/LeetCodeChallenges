// Given an array of strings strs, group the anagrams together. You can return the answer in any order.

// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

// Example 1:

// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
// Example 2:

// Input: strs = [""]
// Output: [[""]]
// Example 3:

// Input: strs = ["a"]
// Output: [["a"]]

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //go through each enetry
        //at each entry make it array of char
        //sort the array of char
        //compare any other array that exists which is the same
        //(hash map ith place being length-1 and char[])
        //if not make new one/list
        //if so then add the string to the existing list
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            if (map.containsKey(sortedStr)) {
                map.get(sortedStr).add(str);
            } else {
                List<String> anagramGroup = new ArrayList<>();
                anagramGroup.add(str);
                map.put(sortedStr, anagramGroup);
            }
        }

        return new ArrayList<>(map.values());
    }
}