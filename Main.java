import java.io.*;
import java.util.*;

/**
 *@author Dagvadorj (Tom) Altankhuyag 
 * @version 1.0
 * @since 0.1
 *
 */

public class Main {
    public static void main(String args[]) throws FileNotFoundException, IOException{
        if (!(args[0].substring(args[0].length() - 4).equals(".txt"))){//Make sure the command line inputs have proper name for both arg[0]
            args[0] += ".txt";                                         //and arg[1] (input & output respectively)
        }
        if (!(args[1].substring(args[1].length() - 4).equals(".txt"))){
            args[1] += ".txt";
        }
      
        PrintWriter writer = new PrintWriter(args[1], "UTF-8"); //Output file
        myTree test = new myTree();
        
        
		try {
			
			File myFile = new File(args[0]); //Input File 
			Scanner myFileReader = new Scanner(myFile); // Input File reader


			while(myFileReader.hasNextLine()) {//read next line
                try{
                String text = myFileReader.nextLine();

                if(text.contains("(") == false){
                    
                    if(!test.firstPrint){
                        writer.println();
                    }
                   
                    writer.print("Input error.");
                    writer.close();
                    System.exit(0);
                }
                String command = text.substring(0,text.indexOf('('));



                if(text.length() < 7 || text.charAt(text.length() - 1) != ')'){
                    if(!test.firstPrint){
                        writer.println();
                    }
                   
                    writer.print("Input error.");
                    writer.close();
                    System.exit(0);
                }
                for(int i = 0; i < text.length(); i++){
                    if(text.charAt(i) == ' '){
                        if(!test.firstPrint){
                            writer.println();
                        }
                       
                        writer.print("Input error.");
                        writer.close();
                        System.exit(0);
                    }
                }


                //////////////////////////////////Print method check////////////////////////////////////////
                if(command.equals("Print")){//Check if its a print command
                    if(text.equals("Print()")){
                        test.Print(writer);
                    }
                    else{
                        if(!test.firstPrint){
                            writer.println();
                        }
                        
                        writer.print("Input error.");
                        writer.close();
                        System.exit(0);
                    }
                }
                
                //////////////////////////////////Add method check//////////////////////////////////////
                else if(command.equals("AddL") || command.equals("AddM")|| command.equals("AddR")){
                    //Comma checks
                    
                    int comma = 0;
                    String arg = text.substring(text.indexOf('(') + 1, text.length() - 1);
                    for(int i = 0; i < arg.length(); i++){
                        if(arg.charAt(i) == ','){
                            comma++;
                        }
                    }
                    if(comma == 0){ //In case there was no commas
                        if(!test.firstPrint){
                            writer.println();
                        }
                       
                        writer.print("Input error.");
                        writer.close();
                        System.exit(0);
                    } else if(comma == 1 && (arg.charAt(0) == ',' || arg.charAt(arg.length() - 1) == ',')){ //in case there was one comma but no proper two arguments
                        if(!test.firstPrint){
                            writer.println();
                        }
                       
                        writer.print("Input error.");
                        writer.close();
                        System.exit(0);
                    }
                    
                    String a = new String();
                    String b = new String();

                    if(comma == 1){//Executes add commands once we know only one comma at the right spot exists
                        a = arg.substring(0, arg.indexOf(','));
                        b = arg.substring(arg.indexOf(',') + 1, arg.length());
                        if(b.charAt(0)== '$'){
                            b = b.substring(1, b.length());
                            if(command.equals("AddL")){
                                test.specialAddL(a, b);
                            }else if (command.equals("AddM")){
                                test.specialAddM(a, b);
                            }else if(command.equals("AddR")){
                                test.specialAddR(a, b);
                            }
                            
                            
                        }else{
                        if(command.equals("AddL")){
                            test.AddL(a, b);
                        }else if (command.equals("AddM")){
                            test.AddM(a, b);
                        }else if(command.equals("AddR")){
                            test.AddR(a, b);
                        }
                        if(test.noRoom){
                            if(!test.firstPrint){
                                writer.println();
                            }
                            writer.print("Add operation not possible.");
                        }
                        
                    }
                    
                    }
                    
                    if(comma > 1){
                        
                        if(arg.charAt(arg.indexOf(',') + 1) == ','){//if the first comma is followed by comma(s)
                        int stop = 0;
                        for(int i = arg.indexOf(','); i <arg.length();i++){
                            if(arg.charAt(i) != ','){
                                stop = i;
                                break;
                            }
                        }


                        a = arg.substring(0, stop - 1);
                        b = arg.substring(stop, arg.length());
                        if(b.charAt(0)== '$'){
                            b = b.substring(1, b.length());
                            if(command.equals("AddL")){
                                test.specialAddL(a, b);
                            }else if (command.equals("AddM")){
                                test.specialAddM(a, b);
                            }else if(command.equals("AddR")){
                                test.specialAddR(a, b);
                            }
                            

                        }else{
                        if(command.equals("AddL")){
                            test.AddL(a, b);
                        }else if (command.equals("AddM")){
                            test.AddM(a, b);
                        }else if(command.equals("AddR")){
                            test.AddR(a, b);
                        }
                        if(test.noRoom){
                            if(!test.firstPrint){
                                writer.println();
                            }
                            writer.print("Add operation not possible.");
                        }
                    }


                    }else{
                        a = arg.substring(0, arg.indexOf(','));
                        b = arg.substring(arg.indexOf(',') + 1, arg.length());
                        if(b.charAt(0)== '$'){
                            b = b.substring(1, b.length());
                            if(command.equals("AddL")){
                                test.specialAddL(a, b);
                            }else if (command.equals("AddM")){
                                test.specialAddM(a, b);
                            }else if(command.equals("AddR")){
                                test.specialAddR(a, b);
                            }

                        }else{
                        if(command.equals("AddL")){
                            test.AddL(a, b);
                        }else if (command.equals("AddM")){
                            test.AddM(a, b);
                        }else if(command.equals("AddR")){
                            test.AddR(a, b);
                        }
                        if(test.noRoom){
                            if(!test.firstPrint){
                                writer.println();
                            }
                            writer.print("Add operation not possible.");
                        }
                    }
                    }


                }
            }
            ///////////////////////////////Del method check//////////////////////////////////////////
                else if(command.equals("DelL") ||command.equals("DelM")|| command.equals("DelR")){
                   
                    String arg = text.substring(text.indexOf('(') + 1, text.length() - 1);
                    String a = arg;
                    if(command.equals("DelL")){
                        test.DelL(a);
                    }else if(command.equals("DelM")){
                        test.DelM(a);
                    }else if(command.equals("DelR")){
                        test.DelR(a);
                    }
                    
                    
                }
                ///////////////////////////////Exchange method check////////////////////////////////////
                else if(command.equals("Exchange")){
                    //Comma checks
                    int comma = 0;
                    String arg = text.substring(text.indexOf('(') + 1, text.length() - 1);
                    for(int i = 0; i < arg.length(); i++){
                        if(arg.charAt(i) == ','){
                            comma++;
                        }
                    }
                    if(comma == 0){ //In case there was no commas
                        if(!test.firstPrint){
                            writer.println();
                        }
                       
                        writer.print("Input error.");
                        writer.close();
                        System.exit(0);
                    } else if(comma == 1 && (arg.charAt(0) == ',' || arg.charAt(arg.length() - 1) == ',')){ //in case there was one comma but no proper two arguments
                        if(!test.firstPrint){
                            writer.println();
                        }
                       
                        writer.print("Input error.");
                        writer.close();
                        System.exit(0);
                    }

                    String a = new String();
                    String b = new String();

                    if(comma == 1){//Executes add commands once we know only one comma at the right spot exists
                        a = arg.substring(0, arg.indexOf(','));
                        b = arg.substring(arg.indexOf(',') + 1, arg.length());
                        if(b.charAt(0) == '$'){
                            b = a + b.substring(1, b.length());
                        }
                       test.Exchange(a, b); 
                    }
                    
                    if(comma > 1){
                        //System.out.println(arg);
                        if(arg.charAt(arg.indexOf(',') + 1) == ','){//if the first comma is followed by comma(s)
                        int stop = 0;
                        for(int i = arg.indexOf(','); i <arg.length();i++){
                            if(arg.charAt(i) != ','){
                                stop = i;
                                break;
                            }
                        }


                        a = arg.substring(0, stop - 1);
                        b = arg.substring(stop, arg.length());
                        if(b.charAt(0) == '$'){
                            b = a + b.substring(1, b.length());
                        }
                        test.Exchange(a, b); 


                    }else{
                        a = arg.substring(0, arg.indexOf(','));
                        b = arg.substring(arg.indexOf(',') + 1, arg.length());
                        if(b.charAt(0) == '$'){
                            b = a + b.substring(1, b.length());
                        }
                        test.Exchange(a, b); 
                    }


                }
                    
            }else{////////////////////////Input error. when the input matches none of the above/////////////////
                if(!test.firstPrint){
                    writer.println();
                }
               
                writer.print("Input error.");
                writer.close();
                System.exit(0);
            }


        }catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException();
            }
             
	     }
			myFileReader.close();
         

		} catch (FileNotFoundException e) {
			System.out.println("Input Exception Error.");
			e.printStackTrace();
		}

        writer.close();
    }
}
