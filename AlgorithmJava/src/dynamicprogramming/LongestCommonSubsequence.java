/**
 * 
 */
package dynamicprogramming;

/**
 * @author Muktevi
 *
 */
public class LongestCommonSubsequence {

	public static int[][] memo;
	
	public static void main(String[] args) {
		
		String s = "acbaed", t = "abcadf";
		memo = new int[s.length()+1][t.length()+1];
		int output = getLCSLen(s,t);
		System.out.println("The lenght of LCS : "+output);
	}

	private static int getLCSLen(String s, String t) {
		if (s== null || s.length() == 0 ){
			return 1;
		}
		if (t== null || t.length() == 0 ){
			return 1;
		}
		return getLCS(s.toCharArray(),s.length()-1,t.toCharArray(),t.length()-1);
	}

	private static int getLCS(char[] sArray, int n, char[] tArray, int m) {
		if (n==0||m==0) return 1;
		if (memo[n][m]!=0) return memo[n][m];
		if (sArray[n] == tArray[m]) return memo[n][m] =  1+getLCS(sArray, n-1, tArray, m-1);
		else return memo[n][m]= Math.max( getLCS(sArray, n-1, tArray, m),  getLCS(sArray, n, tArray, m-1));
		
	}

}
