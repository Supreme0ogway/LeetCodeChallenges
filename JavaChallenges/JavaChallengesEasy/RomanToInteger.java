// Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
// For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

// Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

// I can be placed before V (5) and X (10) to make 4 and 9. 
// X can be placed before L (50) and C (100) to make 40 and 90. 
// C can be placed before D (500) and M (1000) to make 400 and 900.
// Given a roman numeral, convert it to an integer.

class Solution {
    public int romanToInt(String s) {
        //in order numbers
        Map<Character, Integer> m = new HashMap<>();
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);
        
        char[] ca = s.toCharArray();
        int cur = ca.length-2;//2nd to last index
        int prv = ca.length-1;//last index
        
        int total = m.get(ca[prv]);
        for(int i = ca.length-1; i > 0; i--) {
            //check if cur < prv to subtract
            if(m.get(ca[cur]) < m.get(ca[prv])) {
                total -= m.get(ca[cur]);
            } else {
                total += m.get(ca[cur]);
            }
            System.out.println(total);
            //adjust
            prv--;
            cur--;
        }
        
        return total;
    }
}