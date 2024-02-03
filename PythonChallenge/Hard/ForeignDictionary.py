# Foreign Dictionary

# There is a foreign language language which uses the latin alphabet, but the order among letters is not "a", "b", "c" ... "z" as in English.

# You receive a list of non-empty strings words from the dictionary, where the words are sorted lexicographically based on the rules of this new language.

# Derive the order of letters in this language. If the order is invalid, return an empty string. If there are multiple valid order of letters, return any of them.

# A string a is lexicographically smaller than a string b if either of the following is true:

# The first letter where they differ is smaller in a than in b.
# There is no index i such that a[i] != b[i] and a.length < b.length.
# Example 1:

# Input: ["z","o"]

# Output: "zo"
# Explanation:
# From "z" and "o", we know 'z' < 'o', so return "zo".

# Example 2:

# Input: ["hrn","hrf","er","enn","rfnn"]

# Output: "hernf"
# Explanation:

# from "hrn" and "hrf", we know 'n' < 'f'
# from "hrf" and "er", we know 'h' < 'e'
# from "er" and "enn", we know get 'r' < 'n'
# from "enn" and "rfnn" we know 'e'<'r'
# so one possibile solution is "hernf"

from collections import defaultdict, deque
from typing import List

class Solution:
    def foreignDictionary(self, words: List[str]) -> str:
        graph = defaultdict(set)
        indegree = {c: 0 for word in words for c in word}

        # Build the graph and calculate indegrees
        for i in range(len(words) - 1):
            word1, word2 = words[i], words[i + 1]
            for j in range(min(len(word1), len(word2))):
                if word1[j] != word2[j]:
                    if word2[j] not in graph[word1[j]]:
                        graph[word1[j]].add(word2[j])
                        indegree[word2[j]] += 1
                    break

        # Perform topological sort
        result = []
        queue = deque([c for c in indegree if indegree[c] == 0])

        while queue:
            current = queue.popleft()
            result.append(current)

            for neighbor in graph[current]:
                indegree[neighbor] -= 1
                if indegree[neighbor] == 0:
                    queue.append(neighbor)

        # Check for invalid order (cycle)
        if len(result) != len(indegree):
            return ""

        return ''.join(result)
