// Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
//careful with this problem it is tricky but doesn't seem so

// Example 1:

// Input: s = "leetcode"
// Output: 0
// Example 2:

// Input: s = "loveleetcode"
// Output: 2
// Example 3:

// Input: s = "aabb"
// Output: -1


//can do this too, uses integer number to count:
class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> l = new HashMap<>();

        // Add to the map and count occurrences
        for (int i = 0; i < s.length(); i++) {
            l.put(s.charAt(i), l.getOrDefault(s.charAt(i), 0) + 1);//gets the current count
                //or 0 if it doesn't exist yet and adds 1
        }

        // Find the first character with a count of 1
        for (int i = 0; i < s.length(); i++) {
            if (l.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}

//can do this too uses size of list to count:
// class Solution {
//     public int firstUniqChar(String s) {
//         Map<Character, List<Integer>> l = new HashMap<>();
        
//         //add to list
//         for(int i = 0; i < s.length(); i++) {
//             l.put(s.charAt(i), new ArrayList<>());
//         }
        
//         for(int i = 0; i < s.length(); i++) {
//             l.get(s.charAt(i)).add(1);
//         }
        
//         for(int i = 0; i < s.length(); i++) {
//             if(!(l.get(s.charAt(i)).size() > 1)) {
//                 return i;
//             }
//         }
//         return -1;
//     }
// }