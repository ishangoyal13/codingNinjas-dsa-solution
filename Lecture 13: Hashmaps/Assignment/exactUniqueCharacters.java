import java.util.HashMap;

public class Solution {

	public static String uniqueChar(String str){
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
        HashMap<Character,Integer> map = new HashMap<>();
        String newstr="";
        for (int i=0;i<str.length();i++)
        {
            char c = str.charAt(i);
            if (map.containsKey(c))
            {
                map.put(c, map.get(c)+1);
            }
            else
            {
                newstr=newstr+c;
                map.put(c,1);
            }
        }
        return newstr;
	}
}
