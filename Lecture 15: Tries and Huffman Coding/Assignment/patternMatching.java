import java.util.ArrayList;

class TrieNode{

	char data;
	boolean isTerminating;
	TrieNode children[];
	int childCount;

	public TrieNode(char data) {
		this.data = data;
		isTerminating = false;
		children = new TrieNode[26];
		childCount = 0;
	}
}


public class Trie {

	private TrieNode root;
	public int count;
	public Trie() {
		root = new TrieNode('\0');
	}

	public boolean search(String word){
		return search(root, word);
	}

	private boolean search(TrieNode root, String word) {
		if(word.length() == 0){
			return true;
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			return false;
		}
		return search(child, word.substring(1));
	}
	private void insertHelper(TrieNode root, String word)
    {
        if(word.length() == 0)
        {
            root.isTerminating = true;
            return;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null)
        {
        	child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
        }
        insertHelper(child,word.substring(1));
        
    }
	private void insert(String word)
    {
        insertHelper(root,word);
    }
	public boolean patternMatching(ArrayList<String> vect, String pattern) {
        
        for(int i=0;i<vect.size();i++)
        {
        	for(int j = 0;j<vect.get(i).length();j++)
            {
                insert(vect.get(i).substring(j));
            }
        }
        return search(pattern);
	}

}
