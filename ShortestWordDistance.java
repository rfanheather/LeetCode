public class ShortestWordDistance {

	/**
     * Given a list of words and two words word1 and word2, 
     * return the shortest distance between these two words in the list.

	 * For example,
	 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

	 * Given word1 = “coding”, word2 = “practice”, return 3.
	 * Given word1 = "makes", word2 = "coding", return 1.
     * @param str   all the words
     * @param A       word A
     * @param B       word B
     * @return the shortest distance between A and B
     */
	// time O(N), space O(1)
	public int shortestDistance1(String str, String A, String B) {
		String[] words = str.split(" ");
		int prev = 0;
		for (prev = 0; prev < words.length; prev++) {
			if (words[prev].equals(A) || words[prev].equals(B)) {
				break;
			}
		}

		int cur = prev + 1;
		int min = Integer.MAX_VALUE;
		for (cur = prev + 1; cur < words.length; cur++) {
			if (words[cur].equals(A) || words[cur].equals(B)) {
				if (!words[cur].equals(words[prev])) {
					min = Math.min(min, cur - prev);
				}
				prev = cur;
			}
		}
		return min;
	}

	/**
     * The only difference is now you are given the list of words 
     * and your method will be called repeatedly many times with 
     * different parameters. How would you optimize it?

     * Design a class which receives a list of words in the constructor, 
     * and implements a method that takes two words word1 and word2 
     * and return the shortest distance between these two words in the list.

	 * For example,
	 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

	 * Given word1 = “coding”, word2 = “practice”, return 3.
	 * Given word1 = "makes", word2 = "coding", return 1.
     * @param str   all the words
     * @param A       word A
     * @param B       word B
     * @return the shortest distance between A and B
     */
	// space O(N), time O(M + N)
	public int shortestDistance2(String str, String A, String B) {
		String[] words = str.split(" ");
		Map<String, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			if (!map.containsKey(words[i])) {
				map.put(words[i], new ArrayList<>());
			} 
			map.get(words[i]).add(i);
		}

		List<Integer> l1 = map.get(A);
		List<Integer> l2 = map.get(B);
		int p1 = 0;
		int p2 = 0;
		int min = Integer.MAX_VALUE;

		while (p1 < l1.size() && p2 < l2.size()) {
			min = Math.min(min, Math.abs(l1.get(p1) - l2.get(p2)));
			if (l1.get(p1) < l2.get(p2)) {
				p1++;
			} else {
				p2++;
			}
		}

		return min;
	}
}