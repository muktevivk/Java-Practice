/**
 * 
 */
package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Muktevi
 *
 */
public class LongestCommonSubstring {

	public static int[][] memo;
	public static void main(String[] args) {

		String s = "LCLC", t = "CLCL";
		memo = new int[s.length()+1][t.length()+1];
		String output = getLCSubstring(s,t);
		System.out.println("Longest common substring is: "+ output);
	}

	private static String getLCSubstring(String s, String t) {

		int lenS = s.length(), lenT = t.length(), maxLen = Integer.MIN_VALUE;
		List<String> result = null;
		for (int i =0; i<lenS;i++){
			for(int j = 0;j<lenT; j++){
				if (s.charAt(i) == t.charAt(j)){
					if (i==0 || j==0) memo[i][j] = 1;
					else memo[i][j] = 1+memo[i-1][j-1];
					if (memo[i][j]>maxLen){
						maxLen = memo[i][j];
						result = new ArrayList<String>();
						result.add(s.substring(i-maxLen+1,i+1));
					}
					else if (memo[i][j]== maxLen){
						result.add(s.substring(i-maxLen+1, i+1));
					}
				}
				
			}
		}
		
		
		return result.toString();
	}

}
