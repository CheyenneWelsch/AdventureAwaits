package UML;

import java.util.*;

public class UsersNotes {

	protected static void main(String[] args){
		
	
	//Generics shifts the issue from a runtime error to a compile time error
	//can only pass strings without casting
	
	ArrayList<UsersNotes> list = new ArrayList<UsersNotes>();
	
	//behind the scenes of a dynamic array: gives the best performance. 
	//When it fills, it doubles it, fills existing, and
	//provides you with the same amount of new spots
	
	list.add(new UsersNotes());
	
	UsersNotes u2 = list.get(0);
	
	UsersNotes u3 = list.get(1);
	
	
	
	
	}
}
