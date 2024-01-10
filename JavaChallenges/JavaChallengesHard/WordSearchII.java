// Given an m x n board of characters and a list of strings words, return all words on the board.

// Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 

// Example 1:


// Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
// Output: ["eat","oath"]
// Example 2:


// Input: board = [["a","b"],["c","d"]], words = ["abcb"]
// Output: []

class TrieNode {
    TrieNode[] children;
    String word;

    public TrieNode() {
        children = new TrieNode[26];
        word = null;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.word = word;
    }
}

public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        Trie trie = new Trie();

        // Insert words into Trie
        for (String word : words) {
            trie.insert(word);
        }

        // Perform DFS on each cell of the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, trie.root, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;  // Check if the indices are within bounds
        }

        char currentChar = board[i][j];
        if (currentChar == '#' || node.children[currentChar - 'a'] == null) {
            return;  // Check if the current cell is visited or if there's no corresponding child in Trie
        }

        TrieNode nextNode = node.children[currentChar - 'a'];

        board[i][j] = '#'; // Mark the current cell as visited

        if (nextNode.word != null) {
            result.add(nextNode.word);
            nextNode.word = null; // Avoid duplicates
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : directions) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            dfs(board, newRow, newCol, nextNode, result);
        }

        board[i][j] = currentChar; // Restore the current cell after DFS
    }
}