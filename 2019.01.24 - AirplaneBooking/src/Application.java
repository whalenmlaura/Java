// Author - Laura Whalen

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Application {
	
	Scanner scan_object = new Scanner(System.in);		
	boolean plane_array[][] = new boolean[4][4];
	ArrayList<String> display_ticket = new ArrayList<String>();
	
	//START METHOD
	public void start(){
		airplane();	
		seat_select();
	}//end start
	
	
	//FIRST AND LAST NAME VALIDATION METHOD
	public boolean name_validation(String input){
	String validChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz-'";
	char testChar;
		if(input.length() == 0){
			return false;}
		else{
			for(int i=0; i<input.length(); i++){ //start at 0, keep going for the length of i, i+1
				testChar = input.charAt(i);
				if(validChars.indexOf(testChar) < 0) 
					return false;} //if valid return false		
	}
	return true;
	}//end name_validation
	
	//NUMBER VALIDATION METHOD
	public boolean number_validation(String input){
	String validChars = "12";
	char testChar;
		if(input.length() == 0){
			return false;}
		else{
			for(int i=0; i<input.length(); i++){ //start at 0, keep going for the length of i, i+1
				testChar = input.charAt(i);
				if(validChars.indexOf(testChar) < 0) 
					return false;} //if valid return false		
	}
	return true;
	}//end number validation
	
	//2 or q VALIDATION METHOD
	public boolean twoorq_validation(String input){
	String validChars = "2q";
	char testChar;
	if(input.length() == 0){
		return false;}
	else{
		for(int i=0; i<input.length(); i++){ //start at 0, keep going for the length of i, i+1
			testChar = input.charAt(i);
			if(validChars.indexOf(testChar) < 0) 
				return false;} //if valid return false		
	}
	return true;
	}//end number validation
	
	//1 or q VALIDATION METHOD
	public boolean oneorq_validation(String input){
	String validChars = "1q";
	char testChar;
	if(input.length() == 0){
		return false;}
	else{
		for(int i=0; i<input.length(); i++){ //start at 0, keep going for the length of i, i+1
			testChar = input.charAt(i);
			if(validChars.indexOf(testChar) < 0) 
				return false;} //if valid return false		
	}
	return true;
	}//end number validation
	
	
	//AIRPLANE 2D ARRAY METHOD
	public void airplane(){
		for(int row=0;row < plane_array.length; row++){
			for(int col=0; col < plane_array[row].length; col++){
				plane_array[row][col] = false;}}
	}//end airplane method
	
	//PRINT PLANE
	public void print_airplane(boolean[][] plane_array){
		System.out.println("======================================\nPlane seats:\n([ X ] = booked, [   ] = available)\n");
		for(int row=0;row < plane_array.length; row++){
			for(int col=0; col < plane_array[row].length; col++){
				if(col<3)
					if(plane_array[row][col]){						
						System.out.print("[ X ]"+ " ");}
					else{						
						System.out.print("[   ]"+" ");}
				else{
					if(plane_array[row][col]){						
						System.out.println("[ X ]"+ " ");}
					else{						
						System.out.println("[   ]"+" ");}}}}
		System.out.println("======================================\n");
	}//end airplane method

	//FIRST CLASS METHOD
	public String first_class(int seat){
		String seat_letter = "";
		String seat_number = "";
		int row = 0, col = 0;
		boolean booked = false;
		
		for(row=0;row < 2; row++){
			for(col=0; col < 4; col++){
				if(plane_array[row][col] == false){
					if(seat == 1 && (col == 0 || col == 3)) {
						plane_array[row][col] = true;
						booked = true;
						break;}
					else if(seat == 2 && (col == 1 || col == 2)){
						plane_array[row][col] = true;
						booked = true;
						break;}}}
			if(booked) {
				break;}}
		switch(col){
			case 0: seat_letter = "A";break;
			case 1: seat_letter = "B";break;
			case 2: seat_letter = "C";break;
			case 3: seat_letter = "D";break;}
		//seat_num = Integer.toString;
		seat_number = (row+1) + seat_letter;
		return seat_number;
	}//end first class method
	
	//SECOND CLASS METHOD
	public String second_class(int seat){
		String seat_letter = "";
		String seat_number = "";
		int row = 2, col = 0;
		boolean booked = false;
		
		for(row=2;row < 4; row++){
			for(col=0; col < 4; col++){
				if(plane_array[row][col] == false){
					if(seat == 1 && (col == 0 || col == 3)) {
						plane_array[row][col] = true;
						booked = true;
						break;}
					else if(seat == 2 && (col == 1 || col == 2)){
						plane_array[row][col] = true;
						booked = true;
						break;}}}
			if(booked) {
				break;}}
		switch(col){
			case 0: seat_letter = "A";break;
			case 1: seat_letter = "B";break;
			case 2: seat_letter = "C";break;
			case 3: seat_letter = "D";break;}
		//seat_num = Integer.toString;
		seat_number = (row+1) + seat_letter;
		return seat_number;
	}//end first class method
	
	//PLANE FULL METHOD
	public boolean plane_full(boolean[][] plane_array){
		for(int row=0;row < plane_array.length; row++){
			for(int col=0; col < plane_array[row].length; col++){
				if(plane_array[row][col] == false){
					return false;}}}
		return true;
	}//end plane_full method
	
	//FIRST CLASS FULL METHOD
	public boolean first_class_seats(boolean[][] plane_array){
		for(int row=0; row < 2; row++){
			for(int col=0; col < plane_array[row].length; col++){
			if(plane_array[row][col] == false){
					return false;}}}
		return true;
	}//end first_class_seats method
	
	//FIRST CLASS WINDOW FULL METHOD
	public boolean first_window_full(boolean[][] plane_array){
		for(int row=0; row < 2; row++){
			for(int col=0; col < plane_array[row].length; col=col+3){
				if(plane_array[row][col] == false){
					return false;}}}
		return true;}
	
	//FIRST CLASS AISLE FULL METHOD
	public boolean first_aisle_full(boolean[][] plane_array){
		for(int row=0; row < 2; row++){
			for(int col=1; col < 3; col=col+1){
				if(plane_array[row][col] == false){
					return false;}}}
		return true;}
		
	//SECOND CLASS FULL METHOD
	public boolean second_class_seats(boolean[][] plane_array){
		for(int row=2; row < 4; row++){
			for(int col=0; col < plane_array[row].length; col++){
			if(plane_array[row][col] == false){
					return false;}}}
		return true;
	}//end first_class_seats method
	
	//SECOND CLASS WINDOW FULL METHOD
	public boolean second_window_full(boolean[][] plane_array){
		for(int row=2; row < 4; row++){
			for(int col=0; col < plane_array[row].length; col=col+3){
				if(plane_array[row][col] == false){
					return false;}}}
		return true;}
	
	//SECOND CLASS AISLE FULL METHOD
	public boolean second_aisle_full(boolean[][] plane_array){
		for(int row=2; row < 4; row++){
			for(int col=1; col < 3; col=col+1){
				if(plane_array[row][col] == false){
					return false;}}}
		return true;}
	
		
	//SELECTING SEAT METHOD
	public void seat_select(){
		String first_name = "";
		String last_name = "";
		String full_name = "";
		String maybe_seat_class = "";
		String maybe_seat_type = "";
		int seat_type = 0;
		String seat_number = "";
		
				
		//WHILE LOOP FOR PASSENGER NAME AND SEAT SELECTION
		while((plane_full(plane_array)) == false){
			
			//FIRST AND LAST NAME
			System.out.println("Please enter your first name: ");
			first_name = scan_object.nextLine();
			boolean name_result = name_validation(first_name); //call validation method
			while(name_result == false){
				System.out.println("INVALID, please re-enter your FIRST name: ");
				first_name = scan_object.nextLine();
				boolean name_result1 = name_validation(first_name);
				if(name_result1 == true){ //after valid input, break the loop
					break;}}
			System.out.println("Please enter your last name: ");
			last_name = scan_object.nextLine();
			boolean name_result2 = name_validation(last_name);
			while(name_result2 == false){
				System.out.println("INVALID, please re-enter your LAST name: ");
				last_name = scan_object.nextLine();
				boolean name_result3 = name_validation(last_name);
				if(name_result3 == true){
					break;}}
			full_name = (last_name+", "+first_name);
			
			
			//IF FIRST CLASS FULL
			if((first_class_seats(plane_array)) == true){
				System.out.println("Sorry, there are no first class seats left, would you like a second class seat (2) or quit (q)?");
				maybe_seat_class = scan_object.nextLine();
				boolean num_result = twoorq_validation(maybe_seat_class); 
				while(num_result == false){
					System.out.println("INVALID, please re-enter 2 for second class, or q to quit: ");
					maybe_seat_class = scan_object.nextLine();
					boolean num_result1 = twoorq_validation(maybe_seat_class);
					if(num_result1 == true){ 
						break;}}
				//IF SECOND CLASS
				if(maybe_seat_class.equals("2")){
					//IF SECOND CLASS WINDOWS FULL
					if((second_window_full(plane_array)) == true){
						System.out.println("Sorry, there are no second class window seats left, would you like an aisle (2), or quit (q)?");
						maybe_seat_type = scan_object.nextLine();
						boolean num_result2 = twoorq_validation(maybe_seat_type); 
						while(num_result2 == false){
							System.out.println("INVALID, please re-enter 2 for an aisle seat, or q to quit: ");
							maybe_seat_type = scan_object.nextLine();
							boolean num_result3 = twoorq_validation(maybe_seat_type);
							if(num_result3 == true){ 
								break;}}
						//IF AISLE
						if(maybe_seat_type.equals("2")){
							seat_type = Integer.parseInt(maybe_seat_type); //convert to integer
							seat_number = second_class(seat_type);}
						//ELSE QUIT
						else if(maybe_seat_type.equals("q")){
							System.out.println("\n=============================\nNEXT FLIGHT LEAVES IN 3 HOURS\n=============================\n");
							continue;}}
					//IF AISLE FULL
					else if((second_aisle_full(plane_array)) == true){
						System.out.println("Sorry, there are no second class aisle seats left, would you like an window (1), or quit (q)?");
						maybe_seat_type = scan_object.nextLine();
						boolean num_result2 = oneorq_validation(maybe_seat_type); 
						while(num_result2 == false){
							System.out.println("INVALID, please re-enter 1 for a window seat, or q to quit: ");
							maybe_seat_type = scan_object.nextLine();
							boolean num_result3 = oneorq_validation(maybe_seat_type);
							if(num_result3 == true){ 
								break;}}
						//IF WINDOW
						if(maybe_seat_type.equals("1")){
							seat_type = Integer.parseInt(maybe_seat_type); //convert to integer
							seat_number = second_class(seat_type);}
						//ELSE QUIT
						else if(maybe_seat_type.equals("q")){
							System.out.println("\n=============================\nNEXT FLIGHT LEAVES IN 3 HOURS\n=============================\n");
							continue;}}
					//WINDOW OR AISLE SECOND CLASS
					else{
						System.out.println("Would you like a window seat (1), or an aisle (2)?");
						maybe_seat_type = scan_object.nextLine();
						boolean num_result2 = number_validation(maybe_seat_type); 
						while(num_result2 == false){
							System.out.println("INVALID, please re-enter 1 for window, or 2 for aisle: ");
							maybe_seat_type = scan_object.nextLine();
							boolean num_result3 = number_validation(maybe_seat_type);
							if(num_result3 == true){ 
								break;}}
						seat_type = Integer.parseInt(maybe_seat_type); //convert to integer
						seat_number = second_class(seat_type);}}
				else if(maybe_seat_class.equals("q")) {
					System.out.println("\n=============================\nNEXT FLIGHT LEAVES IN 3 HOURS\n=============================\n");
					continue;}}
				//ELSE WINDOW OR AISLE (SECOND CLASS)
			
			
			//ELSE, FIRST OR SECOND CLASS?
			else{
				System.out.println("Would you like a first class seat (1), or second class (2)?");
				maybe_seat_class = scan_object.nextLine();
				boolean num_result4 = number_validation(maybe_seat_class); 
				while(num_result4 == false){
					System.out.println("INVALID, please re-enter 1 for first class, or 2 for second class: ");
					maybe_seat_class = scan_object.nextLine();
					boolean num_result1 = number_validation(maybe_seat_class);
					if(num_result1 == true){ 
						break;}}
				//IF FIRST CLASS
				if(maybe_seat_class.equals("1")){			
					//IF WINDOWS FULL
					if((first_window_full(plane_array)) == true){
						System.out.println("Sorry, there are no first class window seats left, would you like an aisle (2), or quit (q)?");
						maybe_seat_type = scan_object.nextLine();
						boolean num_result2 = twoorq_validation(maybe_seat_type); 
						while(num_result2 == false){
							System.out.println("INVALID, please re-enter 2 for an aisle seat, or q to quit: ");
							maybe_seat_type = scan_object.nextLine();
							boolean num_result3 = twoorq_validation(maybe_seat_type);
							if(num_result3 == true){ 
								break;}}
						//IF AISLE
						if(maybe_seat_type.equals("2")){
							seat_type = Integer.parseInt(maybe_seat_type); //convert to integer
							seat_number = first_class(seat_type);}
						//ELSE QUIT
						else if(maybe_seat_type.equals("q")){
							System.out.println("\n=============================\nNEXT FLIGHT LEAVES IN 3 HOURS\n=============================\n");
							continue;}}
					//IF AISLE FULL
					else if((first_aisle_full(plane_array)) == true){
						System.out.println("Sorry, there are no first class aisle seats left, would you like an window (1), or quit (q)?");
						maybe_seat_type = scan_object.nextLine();
						boolean num_result2 = oneorq_validation(maybe_seat_type); 
						while(num_result2 == false){
							System.out.println("INVALID, please re-enter 1 for a window seat, or q to quit: ");
							maybe_seat_type = scan_object.nextLine();
							boolean num_result3 = oneorq_validation(maybe_seat_type);
							if(num_result3 == true){ 
								break;}}
						//IF WINDOW
						if(maybe_seat_type.equals("1")){
							seat_type = Integer.parseInt(maybe_seat_type); //convert to integer
							seat_number = first_class(seat_type);}
						//ELSE QUIT
						else if(maybe_seat_type.equals("q")){
							System.out.println("\n=============================\nNEXT FLIGHT LEAVES IN 3 HOURS\n=============================\n");
							continue;}}
					//ELSE WINDOW OR AISLE??
					else{
						System.out.println("Would you like a window seat (1), or an aisle (2)?");
						maybe_seat_type = scan_object.nextLine();
						boolean num_result2 = number_validation(maybe_seat_type); 
						while(num_result2 == false){
							System.out.println("INVALID, please re-enter 1 for window, or 2 for aisle: ");
							maybe_seat_type = scan_object.nextLine();
							boolean num_result3 = number_validation(maybe_seat_type);
							if(num_result3 == true){ 
								break;}}
						seat_type = Integer.parseInt(maybe_seat_type); //convert to integer
						seat_number = first_class(seat_type);}}
				
				//IF SECOND CLASS
				else if(maybe_seat_class.equals("2")){
					//IF WINDOWS FULL
					if((second_window_full(plane_array)) == true){
						System.out.println("Sorry, there are no second class window seats left, would you like an aisle (2), or quit (q)?");
						maybe_seat_type = scan_object.nextLine();
						boolean num_result2 = twoorq_validation(maybe_seat_type); 
						while(num_result2 == false){
							System.out.println("INVALID, please re-enter 2 for an aisle seat, or q to quit: ");
							maybe_seat_type = scan_object.nextLine();
							boolean num_result3 = twoorq_validation(maybe_seat_type);
							if(num_result3 == true){ 
								break;}}
						//IF AISLE
						if(maybe_seat_type.equals("2")){
							seat_type = Integer.parseInt(maybe_seat_type); //convert to integer
							seat_number = second_class(seat_type);}
						//ELSE QUIT
						else if(maybe_seat_type.equals("q")){
							System.out.println("\n=============================\nNEXT FLIGHT LEAVES IN 3 HOURS\n=============================\n");
							continue;}}
					//IF AISLE FULL
					if((second_aisle_full(plane_array)) == true){
						System.out.println("Sorry, there are no second class aisle seats left, would you like an window (1), or quit (q)?");
						maybe_seat_type = scan_object.nextLine();
						boolean num_result2 = oneorq_validation(maybe_seat_type); 
						while(num_result2 == false){
							System.out.println("INVALID, please re-enter 1 for a window seat, or q to quit: ");
							maybe_seat_type = scan_object.nextLine();
							boolean num_result3 = oneorq_validation(maybe_seat_type);
							if(num_result3 == true){ 
								break;}}
						//IF WINDOW
						if(maybe_seat_type.equals("1")){
							seat_type = Integer.parseInt(maybe_seat_type); //convert to integer
							seat_number = second_class(seat_type);}
						//ELSE QUIT
						else if(maybe_seat_type.equals("q")){
							System.out.println("\n=============================\nNEXT FLIGHT LEAVES IN 3 HOURS\n=============================\n");
							continue;}}
					//ELSE WINDOW OR AISLE??
					else{
						System.out.println("Would you like a window seat (1), or an aisle (2)?");
						maybe_seat_type = scan_object.nextLine();
						boolean num_result2 = number_validation(maybe_seat_type); 
						while(num_result2 == false){
							System.out.println("INVALID, please re-enter 1 for window, or 2 for aisle: ");
							maybe_seat_type = scan_object.nextLine();
							boolean num_result3 = number_validation(maybe_seat_type);
							if(num_result3 == true){ 
								break;}}
						seat_type = Integer.parseInt(maybe_seat_type); //convert to integer
						seat_number = second_class(seat_type);}}}
			
			System.out.println("======================================");
			System.out.println("BOARDING PASS\n");
			System.out.println("Name: "+full_name);
			System.out.println("Seat: "+seat_number);
			System.out.println("======================================\n");
			String name_and_ticket = (full_name+" - "+seat_number);
			display_ticket.add(name_and_ticket);
			print_airplane(plane_array);
			
		}//end while loop
		
		System.out.println("\nThank you for flying with AirJava!\nThe plane is now full. Next flight leaves in 3 hours.\n");

		//Source: https://beginnersbook.com/2013/12/how-to-sort-arraylist-in-java/
		Collections.sort(display_ticket);
		for(String counter: display_ticket){
			System.out.println(counter);}
				
	}//end seat_select method
		
}//end class