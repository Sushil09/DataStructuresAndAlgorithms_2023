class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = s.length();
        int[] match = new int[n];
        Arrays.fill(match, -1);
        
        // Mark where replacements should happen
        for (int i = 0; i < indices.length; i++) {
            int idx = indices[i];
            String src = sources[i];
            if (s.startsWith(src, idx)) {
                match[idx] = i; // Store the index of replacement
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n;) {
            if (match[i] >= 0) {
                ans.append(targets[match[i]]);
                i += sources[match[i]].length();
            } else {
                ans.append(s.charAt(i));
                i++;
            }
        }

        return ans.toString();
    }
}
