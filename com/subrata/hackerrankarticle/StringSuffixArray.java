package com.subrata.hackerrankarticle;


import java.util.ArrayList;
import java.util.HashMap;

public class StringSuffixArray {

	public static void main(String[] args) {
		String input = "banana";
		NodeMap nodeMapObj = new NodeMap();
		for(int i=0;i<input.length();i++){
			nodeMapObj.add(i,input.substring(i));
		}
		nodeMapObj.print();
		System.out.println("done");
	}
	
}

class Result{
	int index;
	String val;
	public Result(int index,String val) {
		this.index=index;
		this.val=val;
	}
	@Override
	public String toString() {
		return  index +" " + val;
	}
}

class Node{
	int index;
	Character charValue=null;
	String stringValue;
	NodeMap map;
	public ArrayList<Result> getStrings(){
		ArrayList<Result> mapList = new ArrayList<Result>();
		// Print node alphabetically
		if(map==null){
			if(stringValue!=null){
				Result r1= new Result(this.index,charValue + stringValue);
				mapList.add(r1);
			}else{
				Result r1= new Result(this.index, charValue+"");
				mapList.add(r1);
			}
		}else{
			// Map is not null. So print all all the map contents
	        if(map.get(null)!=null && map.get(null).charValue==null){
	        	Result r1= new Result(map.get(null).index,charValue+"");
	        	mapList.add(r1);
	        }			
	        for( char ch = 'a' ; ch <= 'z' ; ch++ ){
		           Node node = map.get(ch);
		           if(node !=null){
		        	   ArrayList<Result>  internalList = node.getStrings();	         
		        	   for(Result str:internalList){
		        		   Result r1= new Result(str.index,charValue+str.val);
		        		   mapList.add(r1);
		        	   }
		           }
	        }
		}
        return mapList;
	}
	
	}

class NodeMap{
	HashMap<Character,Node> map;
	
	public void add(int index,String inputString){
	 if(inputString != null){
		if(map==null){
			// First time call. Create Map and add String
			map = new HashMap<Character,Node>();
		}
		// Map already present check if character already there
		Node charNode = map.get(inputString.charAt(0));
		if(charNode==null){
			// Character not present in map. Add map entry
			Node node = new Node();
			node.charValue=inputString.charAt(0);
			node.index = index;
			if(inputString.length()>1){
				 node.stringValue=inputString.substring(1);
			}else{
				node.stringValue=null;
			}
			node.map=null;
			map.put(inputString.charAt(0), node);			
		}else{ // Character present 
			// Check if map of node is already populated. if yes, just add input string in that map 
			// If map is not present; then create map. Add existing value in map. and then add new string in map 
			// This is node of first character of input string. So sub-map should be for second character
			if(charNode.map==null){
				// Node does not have map.  So create sub-map.
				charNode.map = new NodeMap();
				charNode.map.add(charNode.index,charNode.stringValue);
			}
			if(inputString.length()>1){
				charNode.map.add(index,inputString.substring(1));
			}else{
				charNode.map.add(index,null);
			}
			
			charNode.stringValue=null;
		}
	}else{
		// Add a null node. Indicating end of string
		Node n = new Node();
		n.index=index;
		n.charValue=null;
		map.put(null,n);
	}
}
	public Node get(Character ch){
		return map.get(ch);
	}
		
	public void print(){
		// Map is not null. So print all all the map contents
		ArrayList<Result> finalArray= new ArrayList<Result>();
        for( char ch = 'a' ; ch <= 'z' ; ch++ ){
        	Node node = map.get(ch);
        	if(node!=null){
        		finalArray.addAll(node.getStrings());
        	}
	    }
        
        for(Result rs : finalArray){
        	System.out.println(rs);
        }
	}
}
		
	
	
