import java.io.*;
import java.util.*;

public class MainTest {
    public static void main(String args[]) throws FileNotFoundException, IOException{
       
        myTree test = new myTree();
        test.AddL("root", "left");
        test.AddR("root", "right");
        test.AddM("root", "middle");
        test.AddM("middle", "middlemiddle");
        test.AddR("right", "rightright");
        test.AddL("left", "leftleft");
        test.AddM("leftleft", "leftleftmiddle");
        test.AddR("leftleft", "leftleftright");
        test.AddM("leftleftmiddle", "VeryButtom");
        test.AddM("VeryButtom", "leftleft");
        test.Exchange("root", "WASroot");
        test.Exchange("leftleft", "WASleftleft");
        //test.PrintTerminal();
        //test.PrintTerminal();


        String text = new String("addL(yeet,yeet)");
        String arg = text.substring(text.indexOf('(') + 1, text.length() - 1);
        String text1 = new String("yeet,yeet");
        String arg1 = text1.substring(text1.indexOf(',') + 1, text1.length());




        System.out.println(arg);
        System.out.println(arg1);

        System.out.println("The size is: " + test.root.size());
        
        PrintWriter writer = new PrintWriter("outputExample.txt", "UTF-8"); //Output file 
       test.Print(writer);
        writer.close();
        }
}
