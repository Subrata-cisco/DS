package com.subrata.codingchallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
Roy wants to change his profile picture on Facebook. Now Facebook has some restriction over the dimension of picture that we can upload.
Minimum dimension of the picture can be L x L, where L is the length of the side of square.

Now Roy has N photos of various dimensions.
Dimension of a photo is denoted as W x H 
where W - width of the photo and H - Height of the photo

When any photo is uploaded following events may occur:

[1] If any of the width or height is less than L, user is prompted to upload another one. Print "UPLOAD ANOTHER" in this case.
[2] If width and height, both are large enough and 
(a) if the photo is already square then it is accepted. Print "ACCEPTED" in this case.
(b) else user is prompted to crop it. Print "CROP IT" in this case.

(quotes are only for clarification)

Given L, N, W and H as input, print appropriate text as output.

Input:1
First line contains L.
Second line contains N, number of photos.
Following N lines each contains two space separated integers W and H.

Output:
Print appropriate text for each photo in a new line.

Constraints:
1 <= L,W,H <= 10000
1 <= N <= 1000
*/
public class RoyAndProfilePicture {
	public static void main(String[] args)  {
		RoyAndProfilePicture obj = new RoyAndProfilePicture();
		PhotoDetails details = null;
		try {
			details = obj.constructData();
			obj.processData(details);
		} catch (Exception e) {
			//System.out.println("****** Subrata -> ERROR ::"+e.getMessage());
			return;
		} 
	}
	
	void processData(PhotoDetails details){
		if(details != null){
			Map<Integer,Integer> map = details.getMap();
			Iterator<Integer> iterator = map.keySet().iterator();
			while(iterator.hasNext()){
				int length = iterator.next();
				int breadth = map.get(length);
				
				if(length == details.getLength() && breadth == details.getLength()){
					System.out.println("ACCEPTED");
				}else if (length > details.getLength() && breadth > details.getLength()){
					System.out.println("CROP IT");
				}else {
					System.out.println("UPLOAD ANOTHER");
				}
			}
		}
	}
	
	PhotoDetails constructData() throws NumberFormatException, IOException{
		boolean loopExists = true;
		BufferedReader br = null;
		PhotoDetails details = new PhotoDetails();
		while(loopExists){
			if(details.getLength() == 0){
				System.out.println("****** Subrata -> Enter length ::");
				br = new BufferedReader(new InputStreamReader(System.in));
				details.setLenght(Integer.valueOf(br.readLine()));
			}else if (details.getTotalNumber() == 0){
				System.out.println("****** Subrata -> Enter number of photos ::");
				br = new BufferedReader(new InputStreamReader(System.in));
				details.setNumber(Integer.valueOf(br.readLine()));
			}else{
				int num = details.getTotalNumber();
				while(num > 0){
					System.out.println("****** Subrata -> Enter (L,B) :: ");
					br = new BufferedReader(new InputStreamReader(System.in));
					String line = br.readLine();
					String[] words = line.split(" ");
					if(words == null || words.length != 2){
						throw new RuntimeException(" Invalid input , terminating !!");
					}else{
						details.setParticularPhotoDetails(Integer.valueOf(words[0]), Integer.valueOf(words[1]));
					}
					num --;
				}
				loopExists = false;
			}
		}
		return details;
	}
	
	class PhotoDetails {
		int requiredLength;
		int number;
		HashMap<Integer,Integer> map;
		
		PhotoDetails(){
			map = new HashMap<>();
		}
		
		void setParticularPhotoDetails(int l,int b){
			map.put(l, b);
		}
		
		void setLenght(int l){
			this.requiredLength = l;
		}
		
		int getLength(){
			return requiredLength;
		}
		
		void setNumber(int num){
			this.number = num;
		}
		
		int getTotalNumber(){
			return number;
		}
		
		Map<Integer,Integer> getMap(){
			return (Map<Integer,Integer>)map.clone();
		}
	}
}
