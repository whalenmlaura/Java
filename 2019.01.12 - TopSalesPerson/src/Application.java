// Author - Laura Whalen

import javax.swing.JOptionPane; //graphics library

public class Application {

	public void start(){
		
		user_input(); //call to user_input method
		
	}//end start method
		
	//FIRST AND LAST NAME VALIDATION
	public boolean name_validation(String input){
	String validChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz-'";
	char testChar;
	for(int i=0; i<input.length(); i++){ //start at 0, keep going for the length of i, i+1
		testChar = input.charAt(i);
		if(validChars.indexOf(testChar) < 0) //compares each index of testChar against validChars. Returns numbers of the position of the correct character, if less than 0 than it�s false. For example, a = 0, b = 1, c = 2
			return false; //if valid return false
	}//end for loop
	return true; //if invalid, returns true
	}//end name_validation
	
	//NUMBER VALIDATION
	public boolean number_validation(String input){
	String validChars = "1234567890";
	char testChar;
	for(int i=0; i<input.length(); i++){ //start at 0, keep going for the length of i, i+1
		testChar = input.charAt(i);
		if(validChars.indexOf(testChar) < 0) //compares each index of testChar against validChars. Returns numbers of the position of the correct character, if less than 0 than it�s false. For example, a = 0, b = 1, c = 2
			return false; //if valid return false
	}//end for loop
	return true; //if invalid, returns true
	}//end name_validation
	
	//CONTINUE Y/N VALIDATION
	public boolean yesno_validation(String input){
	String validChars = "ynYN";
	char testChar;
	for(int i=0; i<input.length(); i++){ //start at 0, keep going for the length of i, i+1
		testChar = input.charAt(i);
		if(validChars.indexOf(testChar) < 0) //compares each index of testChar against validChars. Returns numbers of the position of the correct character, if less than 0 than it�s false. For example, a = 0, b = 1, c = 2
			return false; //if valid return false
	}//end for loop
	return true; //if invalid, returns true
	}//end name_validation
	
	public void user_input(){
		
		double item_one = 239.99; //item values
		double item_two = 129.75;
		double item_three = 99.95;
		double item_four = 350.89;
		String maybe_sales_one = ""; //number of sales inputed as strings
		String maybe_sales_two = "";
		String maybe_sales_three = "";
		String maybe_sales_four = "";
		int sales_one = 0; //number of sales as integers
		int sales_two = 0;
		int sales_three = 0;
		int sales_four = 0;
		String salesperson = ""; 
		String first_name = ""; 
		String last_name = ""; 
		String top_salesperson = ""; 
		double top_total_sales = 0; 
		double sum_all_sales = 0; //sum of all sales
		int number_sales = 0; //number of sales (so we can calculate average)
		boolean name_result;
		boolean num_result;

		String keep_going = "y";
		while(keep_going.equals("y")){
			//FIRST AND LAST NAME OF SALESPERSON
			first_name = JOptionPane.showInputDialog("Please enter the salesperson's first name: ");
			name_result = name_validation(first_name); //call validation method
			while(name_result == false){
				first_name = JOptionPane.showInputDialog("Invalid, please re-enter the salesperson's FIRST name: ");
				name_result = name_validation(first_name);
				if(name_result == true){ //after valid input, break the loop
					break;
				}//end if
			}//end while
			last_name = JOptionPane.showInputDialog("Please enter the salesperson's last name: ");
			name_result = name_validation(last_name); //call validation method
			while(name_result == false){
				last_name = JOptionPane.showInputDialog("Invalid, please re-enter the salesperson's LAST name: ");
				name_result = name_validation(last_name);
				if(name_result == true){ //after valid input, break the loop
					break;
				}//end if
			}//end while
			salesperson = (first_name+" "+last_name);
			
			//NUMBER OF SALES FOR ITEM ONE
			maybe_sales_one = JOptionPane.showInputDialog("Please enter the number of sales for item one: ");
			num_result = number_validation(maybe_sales_one); 
			while(num_result == false){
				maybe_sales_one = JOptionPane.showInputDialog("Invalid, please re-enter the NUMBER of sales for item one: ");
				num_result = number_validation(maybe_sales_one);
				if(num_result == true){ 
					break;
				}//end if
			}//end while
			sales_one = Integer.parseInt(maybe_sales_one); //convert to integer

			//NUMBER OF SALES FOR ITEM TWO
			maybe_sales_two = JOptionPane.showInputDialog("Please enter the number of sales for item two: ");
			num_result = number_validation(maybe_sales_two);
			while(num_result == false){
				maybe_sales_two = JOptionPane.showInputDialog("Invalid, please re-enter the NUMBER of sales for item two: ");
				num_result = number_validation(maybe_sales_two);
				if(num_result == true){
					break;
				}//end if
			}//end while
			sales_two = Integer.parseInt(maybe_sales_two);

			//NUMBER OF SALES FOR ITEM THREE
			maybe_sales_three = JOptionPane.showInputDialog("Please enter the number of sales for item three: ");
			num_result = number_validation(maybe_sales_three);
			while(num_result == false){
				maybe_sales_three = JOptionPane.showInputDialog("Invalid, please re-enter the NUMBER of sales for item three: ");
				num_result = number_validation(maybe_sales_three);
				if(num_result == true){
					break;
				}//end if
			}//end while
			sales_three = Integer.parseInt(maybe_sales_three);
			
			//NUMBER OF SALES FOR ITEM FOUR
			maybe_sales_four = JOptionPane.showInputDialog("Please enter the number of sales for item four: ");
			num_result = number_validation(maybe_sales_four);
			while(num_result == false){
				maybe_sales_four = JOptionPane.showInputDialog("Invalid, please re-enter the NUMBER of sales for item four: ");
				num_result = number_validation(maybe_sales_four);
				if(num_result == true){
					break;
				}//end if
			}//end while
			sales_four = Integer.parseInt(maybe_sales_four);
			
			//CALCULATIONS (NUMBER OF SALES, TOTAL SALES, TOP TOTAL SALES, TOP SALESPERSON, SUM ALL SALES)
			number_sales = (number_sales + sales_one + sales_two + sales_three + sales_four);
			double total_sales = ((sales_one * item_one)+(sales_two * item_two)+(sales_three * item_three)+(sales_four * item_four));
			if(top_total_sales <= total_sales){ //if total sales is greater or equal to top total sales, replace
				top_total_sales = total_sales;
				top_salesperson = salesperson;
			}//end if
			sum_all_sales = (sum_all_sales + total_sales);			
			double weekly_earnings = (((total_sales) * 0.09) + 200);
			JOptionPane.showMessageDialog(null, String.format(salesperson+"'s total weekly earnings is: $%.2f", weekly_earnings)); //%.2f to format
			
			//WOULD YOU LIKE TO CONTINUE?
			keep_going = JOptionPane.showInputDialog("Would you like to continue with another salesperson? (y or n): ");
			keep_going = keep_going.toLowerCase(); //convert to lowercase
			boolean keepgoing_result = yesno_validation(keep_going);
			while(keepgoing_result == false){
				keep_going = JOptionPane.showInputDialog("Invalid, please re-enter if you'd like to continue (y or n): ");
				boolean keepgoing_result2 = yesno_validation(keep_going);
				if(keepgoing_result2 == true){
					break;
				}//end if
			}//end while
		}//end while loop
				
		//DISPLAY ALL TOTALS, AVERAGE, ETC.
		JOptionPane.showMessageDialog(null, String.format("The sum off all sales is: $%.2f", sum_all_sales));
		double average_sale_value = (sum_all_sales / number_sales);
		JOptionPane.showMessageDialog(null, String.format("The average value of a sale is: $%.2f", average_sale_value));
		JOptionPane.showMessageDialog(null, "The top salesperson is: "+top_salesperson);
	}//end user_input method
	
}//end Application class