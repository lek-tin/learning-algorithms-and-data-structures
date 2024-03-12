package main.java.com.example.backtracking;

// Generate all permutations of given string. 
public class StringPermutationUnique { 

	// Function call 
	public static void main(String[] args) 
	{ 
		String str = "abcd"; 
		int n = str.length(); 
		StringPermutationUnique permutation = new StringPermutationUnique(); 
		permutation.permute(str, 0, n - 1); 
	} 

	/** 
	* permutation function
	* Time complexity: O(N!), N denotes the length of the input string
	* Space complexity: O(N)
	* @param str string to calculate permutation for, with only unique characters
	* @param l starting index 
	* @param r end index 
	*/
	private void permuteUniqueChars(String str, int l, int r) 
	{ 
		if (l == r) {
			System.out.println(str); 
        } else { 
			for (int i = l; i <= r; i++) { 
                // swap l'th char with the rest of the characters
				str = swap(str, l, i); 
				permute(str, l + 1, r); 
                // revert swapping: i'th -> l'th
				str = swap(str, l, i); 
			} 
		} 
	} 

	/** 
	* permutation function
	* @param str string to calculate permutation for , it contains duplicate characters?
	* @param l starting index 
	* @param r end index 
	*/
	private void permuteDuplicateChars(String str, int l, int r) {
        
    }

	/** 
	* Swap Characters at position 
	* @param a string value 
	* @param i position 1 
	* @param j position 2 
	* @return swapped string 
	*/
	public String swap(String a, int i, int j) 
	{ 
		char temp; 
		char[] charArray = a.toCharArray(); 
		temp = charArray[i]; 
		charArray[i] = charArray[j]; 
		charArray[j] = temp; 
		return String.valueOf(charArray); 
	} 
} 

// This code is contributed by Mihir Joshi
