/**
 * 
 */
package dynamicprogramming;

/**
 * @author Muktevi
 *
 */
public class LongestPalindromicSubstring {

	public static String getLPSubstring(String s){
		if (s.length() == 0 || s.length() == 1){
			return s;
		}
		
		int n = s.length();
		int start = 0, maxLength = 0;
		boolean[][] dp = new boolean[n][n];
		
		for (int i = 0; i<n; i++){
			dp[i][i] = true;
		}
		
		for (int i =0; i<n-1; i++){
			if (s.charAt(i) == s.charAt(i+1)){
				dp[i][i+1] = true;
				start = i;
				maxLength = 2;
			}
		}
		
		for (int cur = 3; cur<=n; cur++){
			for (int i = 0; i< n-cur+1; i++){
				int j = i+cur-1;
				if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
					dp[i][j] = true;
					start = i;
					maxLength = cur;
				}
			}
		}
		return s.substring(start, maxLength+start);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getLPSubstring("bananas"));
	}

}
