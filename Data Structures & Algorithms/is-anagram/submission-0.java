class Solution {
    private String getAnagram(String s) {
        StringBuilder anagram = new StringBuilder();
        Map<Character, Integer> freqMap = new HashMap<>();

        for(Character ch: s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        for(var entry: freqMap.entrySet()) {
            anagram.append(entry.getKey());
            anagram.append(entry.getValue().toString());
        }

        return anagram.toString();
    }

    public boolean isAnagram(String s, String t) {
        return getAnagram(s).equals(getAnagram(t));
    }
}
