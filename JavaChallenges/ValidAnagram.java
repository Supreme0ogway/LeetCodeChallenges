
// Given two strings s and t, return true if t is an anagram of s, and false otherwise.

// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

// Example 1:

// Input: s = "anagram", t = "nagaram"
// Output: true
// Example 2:

// Input: s = "rat", t = "car"
// Output: false

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        //find and subtract if found (if it makes it through return true)
        for (char ch : t.toCharArray()) {
            int count = map.getOrDefault(ch, 0);
            if (count == 0) {
                return false;
            }
            map.put(ch, count - 1);
        }

        return true;
    }
}

//another way
//********************* check for valid anogram (same length, diff word same letters********************************

class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length()) {
            return false;
        }
        
        char[] first = s.toCharArray();
        char[] second = t.toCharArray();
        
        Arrays.sort(first);
        Arrays.sort(second);
        
        return Arrays.equals(first, second);
    }
}

//another way
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        List<Character> l = new ArrayList<>();
        //add all of s to a list
        for(int i = 0; i < s.length(); i++) {
            l.add(s.charAt(i));
        }
        //check if what is seen at index i in t is contained in the list of s

        for(int i = 0; i < s.length(); i++) {//must be string.length not l.size() size of l is different
            if(l.contains(t.charAt(i))) {
                l.remove((Character) t.charAt(i));//need to cast to character
            } else {
                return false;
            }
        }

        return true;
        //if not return false
        //if so remove from s

        //return true
    }
}