package dynamicprogramming;

public class PortfolioManager {
	public static int[][] memo;
	public static int len;
	public static String[] str;
	public static int[][] bt;
	public static void main(String[] args) {
		String input = "1 2 3 # # 4 # # 5";
		int output = getMax(input);
		System.out.println(output);
	
	}
	public static int getMax(String s){
		str = s.split(" ");
		bt = new int[str.length][3];
		len = str.length;
		int blanckCount = 0;
		for (int i = 0; i<str.length; i++){
			if (str[i].equalsIgnoreCase("#")){
				blanckCount += 2;
				continue;
			}
			int a = Integer.parseInt(str[i]);
			bt[i][0] = i*2+1 - blanckCount;
			bt[i][1] = i*2+2 - blanckCount;
			bt[i][2] = a;
		}
		memo = new int[str.length][2];
		for (int i = 0; i<str.length; i++){
			for(int j = 0; j<2; j++){
				memo[i][j]= -1;
			}
		}
		
		int result = Math.max(getResult(0,0),getResult(0,1));
		return result;
	}
	public static int getResult(int cur,int selected){
		if (cur >= len){
			return 0;
		}
		if (str[cur].equalsIgnoreCase("#")){
			return 0;
		}
		if (memo[cur][selected] != -1){
			return memo[cur][selected];
		}
		int leftChild = bt[cur][0];
		int rightChild = bt[cur][1];
		if (selected == 1){
			memo[cur][selected] = getResult(leftChild, 0)+getResult(rightChild, 0) + bt[cur][2];
			return memo[cur][selected];
		}else{
			memo[cur][selected] = Math.max(getResult(leftChild, 0),getResult(leftChild, 1)) + Math.max(getResult(rightChild, 0), getResult(rightChild, 1));
			return memo[cur][selected];
		}
	}
}
