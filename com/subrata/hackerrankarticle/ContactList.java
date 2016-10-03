package com.subrata.hackerrankarticle;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContactList {
    
    private class TrieNode {
        Map<Character, TrieNode> children;
        int wordCount = 0;
        boolean endOfWord;
        public TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }
    
    private final TrieNode root;
    
    public ContactList() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                node = new TrieNode();
                node.wordCount++;
                current.children.put(ch, node);
            }else{
            	 node.wordCount++;
            }
            current = node;
        }
        //mark the current nodes endOfWord as true
        current.endOfWord = true;
    }
    
    public int prefixCount(String word) {
    	int count = 0;
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            
            //if node does not exist for given char then return false
            if (node == null) {
                return 0;
            }
            current = node;
        }
        if(current != null){
        	count = current.wordCount;
        }
        return count;
    }
    
    public static void main(String[] args) {
    	ContactList obj = new ContactList();
        Scanner in = new Scanner(System.in);
		int numQueries = (int) new Integer(in.nextLine());

        for (int i = 0; i < numQueries; i++){
        	String text = in.nextLine();
            String[] data = text.split("\\s+"); 

            if (data[0].equals("add")){
                obj.insert(data[1]);
            } else { 
                System.out.println(obj.prefixCount(data[1]));
            }
            
            
            
        }
    }
}

