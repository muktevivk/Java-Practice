/**
 * 
 */
package dynamicprogramming;

/**
 * @author Muktevi
 *
 */
public class LongestCommonSubstring {

	public static int[][] memo;
	public static void main(String[] args) {

		String s = "LCLC", t = "CLCL";
		memo = new int[s.length()+1][t.length()+1];
		int output = getLCSubstring(s,t);
		System.out.println("Longest common substring is: "+ output);
	}

	private static int getLCSubstring(String s, String t) {

		int lenS = s.length(), lenT = t.length(), maxLen = Integer.MIN_VALUE;
		
		for (int i =0; i<lenS;i++){
			for(int j = 0;j<lenT; j++){
				if (s.charAt(i) == t.charAt(j)){
					if (i==0 || j==0) memo[i][j] = 1;
					else memo[i][j] = 1+memo[i-1][j-1];
				}
				if (memo[i][j]>maxLen) maxLen = memo[i][j];
			}
		}
		
		
		return maxLen;
	}

}
