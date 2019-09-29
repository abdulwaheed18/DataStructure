package com.waheedtechblog.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Java program to find the first non-repeating character from the given String
 * 
 * @author AbdulWaheed18@gmail.com
 *
 */
public class FirstNonRepetetiveChar {

	Map<Character, IndexCount> map = new HashMap<>();

	class IndexCount {
		private int index;
		private int count;

		public IndexCount(int index) {
			this.index = index;
			this.count = 1;
		}

		public void incCount() {
			this.count++;
		}
	}

	private void setMap(String message) {

		for (int i = 0; i < message.length(); i++) {

			Character ch = message.charAt(i);
			if (map.containsKey(ch)) {
				map.get(ch).incCount();
			} else {
				map.put(ch, new IndexCount(i));
			}
		}
	}

	public int getFirstNonRepetetiveIndex(String message) {
		setMap(message);

		int minIndex = Integer.MAX_VALUE;
		for (IndexCount indexCount : map.values()) {
			if (indexCount.count == 1 && minIndex > indexCount.index) {
				minIndex = indexCount.index;
			}
		}
		return minIndex;
	}

	public static void main(String[] args) {

		FirstNonRepetetiveChar firstNonRepetetiveChar = new FirstNonRepetetiveChar();

		String message = "http://waheedtechblog.com";
		int index = firstNonRepetetiveChar.getFirstNonRepetetiveIndex(message);

		if (index == Integer.MAX_VALUE) {
			System.out.println("All chars are repetetive");
		} else {
			System.out.println("First non repetetive char is : " + message.charAt(index));
		}
	}

}

/**
 * Output:
 * First non repetetive char is : p
 * */
