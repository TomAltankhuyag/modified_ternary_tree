import java.io.PrintWriter;

//import java.lang.System.Logger.Level;

public class myTree{
    public Node highLevel;
    public int count;
    public boolean firstPrint = true;
    boolean noRoom = false;


    class Node{
        int level;
        Node leftChild;
        Node middleChild;
        Node rightChild;
        Node parent;
        int index;
        boolean print = true;
        

        public String element;

        public Node(){
            element = new String("null");
            leftChild = null;
            middleChild = null;
            rightChild = null;
            parent = null;
        }
 
        /*public boolean isLeaf(){
            if(leftChild == null && rightChild == null && middleChild == null){
                return true;
            }else{
                return false;
            }
        }*/


        /**
         * This method searches for all nodes that has payload matching the key and gets loaded 
         * into the array
         * @param key The payload to search for 
         * @param array Any matching nodes will be loaded into the array
         * @param added Tracks how many nodes have been added
         * @return
         */
        public Node search(String key, Node[] array,int added){
            Node temp = null;
            
            if(element.equals(key)){
                
                array[count] = this;
                count++;
                added++;
            }
            if(leftChild != null){
                temp = leftChild.search(key,array,added);
                
            }
            if(middleChild != null){
                temp = middleChild.search(key,array,added);
               
            }
            if(rightChild != null){
                temp = rightChild.search(key,array,added);
                
            }
          
           return temp; 
    
        }
        public void setElement(String s){
            this.element = s;
        }
    
        public void setLeft(Node node){
            this.leftChild = node;
        }
        public void setMiddle(Node node){
            this.middleChild = node;
        }
        public void setRight(Node node){
            this.rightChild = node;
        }

        /**
         * 
         * @return The method returns the size of the (sub)tree, (including the node itself) 
         * MAKE SURE to set count = 0 before size() is called
         */
        public int size(){ 
                            
            int num = 1;
                
            
            if(leftChild != null){
                num += leftChild.size();
                
            }
            if(middleChild != null){
                num += middleChild.size();
               
            }
            if(rightChild != null){
                num += rightChild.size();
                
            }
          
           return num; 
    
        }

        /**
         * 
         * @param array The array will get filled with all the nodes of the (sub)tree recursively, ordering
         * from left-to-right search going downwards
         * @return
         */
        public Node fillArray(Node [] array){//Make sure to set count = 0 before the method is called
            Node temp = null;
            array[count] = this;
            count++;
           
            if(leftChild != null){
                temp = leftChild.fillArray(array);
                
            }
            if(middleChild != null){
                temp = middleChild.fillArray(array);
               
            }
            if(rightChild != null){
                temp = rightChild.fillArray(array);
                
            }
          
           return temp; 

    }
}////////////////////////////////////END OF NODE CLASS////////////////////////////////////////
    Node root;
    /**
     * 
     * @param key Searches for the highest-level node and creates a left child (if it doesn't exist)
     * with the payload of b
     * @param b The payload
     */
 public void AddL(String key, String b){ //Add new left child to node with the same payload
        noRoom = false;
        Node temp = root;
        int added = 0;
        Node[] list = new Node[7];
        for(int i = 0; i < 7; i++){
            list[i] = new Node();
        }
        
        count = 0;
        temp = temp.search(key, list,added);
        if(list[0].element.equals("null")){//Checks if any nodes were added to the list
            return;
        }
       
        
        Node highest = list[0];
        
        for(int i = 0; i < count; i++){ // iterate through each of the array element
            
            if(list[i].level >= highest.level && list[i].leftChild ==null){
                
                highest = list[i];
            }
           
        }
        
        if(highest.leftChild != null){//In case the first element is the only node but has left child occupied
            noRoom = true;
            return;
        }

        //Implement a function to add the LEFT child node here
        //This is after an available node was found
      
        Node newChild = new Node();
        newChild.level = highest.level + 1;
        newChild.element = b;
        highest.leftChild = newChild;
    }

     /**
     * 
     * @param key Searches for the highest-level node and creates a middle child (if it doesn't exist)
     * with the payload of b
     * @param b The payload
     */
 public void AddM(String key, String b){ //Add new middle child to node with the same payload
        noRoom = false;
        Node temp = root;
        int added = 0;
        Node[] list = new Node[7];
        for(int i = 0; i < 7; i++){
            list[i] = new Node();
        }
        
        count = 0;
        temp = temp.search(key, list,added);
        if(list[0].element.equals("null")){//Checks if any nodes were added to the list
            return;
        }
       
        Node highest = list[0];
        
        for(int i = 0; i < count; i++){ // iterate through each of the array element
            
            if(list[i].level >= highest.level && list[i].middleChild ==null){
                
                highest = list[i];
            }
           
        }
        
        if(highest.middleChild != null){//In case the first element is the only node but has middle child occupied
            noRoom = true;
            return;
        }

        //Implement a function to add the MIDDLE child node here
        //This is after an available node was found
      
        Node newChild = new Node();
        newChild.level = highest.level + 1;
        newChild.element = b;
        highest.middleChild = newChild;
       

    }

    /**
     * 
     * @param key Searches for the highest-level node and creates a right child (if it doesn't exist)
     * with the payload of b
     * @param b The payload
     */
public void AddR(String key, String b){ //Add new right child to node with the same payload
        noRoom = false;
        Node temp = root;
        int added = 0;
        Node[] list = new Node[7];
        for(int i = 0; i < 7; i++){
            list[i] = new Node();
        }
        
        count = 0;
        temp = temp.search(key, list,added);
        if(list[0].element.equals("null")){//Checks if any nodes were added to the list
            return;
        }
       
        
        Node highest = list[0];
        
        for(int i = 0; i < count; i++){ // iterate through each of the array element
            
            if(list[i].level >= highest.level && list[i].rightChild ==null){
                
                highest = list[i];
            }
           
        }
        
        if(highest.rightChild != null){//In case the first element is the only node but has right child occupied
             noRoom = true;
            return;
        }

        //Implement a function to add the RIGHT child node here
        //This is after an available node was found
      
        Node newChild = new Node();
        newChild.level = highest.level + 1;
        newChild.element = b;
        highest.rightChild = newChild;
       

    }


    /**
     * 
     * @param key Searches for the highest-level node and creates a middle child (if it doesn't exist)
     * with the payload of b OR overwrites the compatible node's middle child
     * @param b The payload
     */

public void specialAddM(String key,String b){
        Node temp = root;
        int added = 0;
        Node[] list = new Node[7];

        for(int i = 0; i < 7; i++){
        list[i] = new Node();
    }
    
        count = 0;
        temp = temp.search(key, list,added);
        if(list[0].element.equals("null")){//Checks if any nodes were added to the list
        return;
    }
   
    
        Node highest = list[0];
    
        for(int i = 0; i < count; i++){ // iterate through each of the array element
        
        if(list[i].level >= highest.level ){
            
            highest = list[i];
        }
       
    }
        if(highest.middleChild != null){
        highest.middleChild.element = b;
        return;
    }
    
  
        Node newChild = new Node();
        newChild.level = highest.level + 1;
        newChild.element = b;
        highest.middleChild = newChild;
}

 /**
     * 
     * @param key Searches for the highest-level node and creates a right child (if it doesn't exist)
     * with the payload of b OR overwrites the compatible node's right child
     * @param b The payload
     */
public void specialAddR(String key,String b){
    Node temp = root;
    int added = 0;
    Node[] list = new Node[7];
    for(int i = 0; i < 7; i++){
        list[i] = new Node();
    }
    
    count = 0;
    temp = temp.search(key, list,added);
    if(list[0].element.equals("null")){//Checks if any nodes were added to the list
        return;
    }
   
    
    Node highest = list[0];
    
    for(int i = 0; i < count; i++){ // iterate through each of the array element
        
        if(list[i].level >= highest.level ){
            
            highest = list[i];
        }
       
    }
    if(highest.rightChild != null){
        highest.rightChild.element = b;
        return;
    }
    
  
    Node newChild = new Node();
    newChild.level = highest.level + 1;
    newChild.element = b;
    highest.rightChild = newChild;
}

/**
     * 
     * @param key Searches for the highest-level node and creates a left child (if it doesn't exist)
     * with the payload of b OR overwrites the compatible node's left child
     * @param b The payload
     */

public void specialAddL(String key,String b){
    Node temp = root;
    int added = 0;
    Node[] list = new Node[7];
    for(int i = 0; i < 7; i++){
        list[i] = new Node();
    }
    
    count = 0;
    temp = temp.search(key, list,added);
    if(list[0].element.equals("null")){//Checks if any nodes were added to the list
        return;
    }
   
    
    Node highest = list[0];
    
    for(int i = 0; i < count; i++){ // iterate through each of the array element
        
        if(list[i].level >= highest.level ){
            
            highest = list[i];
        }
       
    }
    if(highest.leftChild != null){
        highest.leftChild.element = b;
        return;
    }
    
  
    Node newChild = new Node();
    newChild.level = highest.level + 1;
    newChild.element = b;
    highest.leftChild = newChild;
}


/**
 * 
 * @param key Searches for a node with the payload key and deletes the whole left child subtree
 */
public void DelL(String key){
        Node temp = root;
        int added = 0;
        Node[] list = new Node[7];
        for(int i = 0; i < 7; i++){
            list[i] = new Node();
        }
        
        count = 0;
        temp = temp.search(key, list,added);
        if(list[0].element.equals("null")){//Checks if any nodes were added to the list
            return;
        }
       
        
        Node highest = list[0];
        
        for(int i = 0; i < count; i++){ // iterate through each of the array element
            
            if(list[i].level > highest.level && list[i].leftChild !=null){
                
                highest = list[i];
            }
           
        }
        
        if(highest.leftChild != null){//In case the first element is the only node but has right child occupied
            highest.leftChild = null;
        }
       
    }
    /**
 * 
 * @param key Searches for a node with the payload key and deletes the whole middle child subtree
 */
    public void DelM(String key){
        Node temp = root;
        int added = 0;
        Node[] list = new Node[7];
        for(int i = 0; i < 7; i++){
            list[i] = new Node();
        }
        
        count = 0;
        temp = temp.search(key, list,added);
        if(list[0].element.equals("null")){//Checks if any nodes were added to the list
            return;
        }
       
        
        Node highest = list[0];
        
        for(int i = 0; i < count; i++){ // iterate through each of the array element
            
            if(list[i].level > highest.level && list[i].middleChild !=null){
                
                highest = list[i];
            }
           
        }
        
        if(highest.middleChild != null){//In case the first element is the only node but has right child occupied
            highest.middleChild = null;
        }
       
    }

 /**
 * 
 * @param key Searches for a node with the payload key and deletes the whole right child subtree
 */
 public void DelR(String key){
        Node temp = root;
        int added = 0;
        Node[] list = new Node[7];
        for(int i = 0; i < 7; i++){
            list[i] = new Node();
        }
        
        count = 0;
        temp = temp.search(key, list,added);
        if(list[0].element.equals("null")){//Checks if any nodes were added to the list
            return;
        }
       
        
        Node highest = list[0];
        
        for(int i = 0; i < count; i++){ // iterate through each of the array element
            
            if(list[i].level > highest.level && list[i].rightChild !=null){
                
                highest = list[i];
            }
           
        }
        
        if(highest.rightChild != null){//In case the first element is the only node but has right child occupied
            highest.rightChild = null;
        }
       
    }

/**
 * 
 * @param key Searches for all nodes with the payload key and all gets replaced by b
 * @param b The payload to replace with
 */
    public void Exchange(String key, String b){
        Node temp = this.root;
        int added = 0;
        Node[] list = new Node[7];
        for(int i = 0; i < 7; i++){
            list[i] = new Node();
        }

        count = 0;
        temp = temp.search(key, list,added);
       
        if(list[0].element.equals("null")){//Checks if any nodes were added to the list
            return;
        }
        for(int i = 0; i < count; i++){
            list[i].element = b;
            
        }
        
    }
  

   /* public void PrintTerminal(){ //ONLY USED FOR PERSONAL TESTINGS
        int max = this.root.size();
        int counter = 0;
        int levelCheck = 0;
        Node[] array = new Node[max];
        Node temp = root;
        count = 0;
        temp = temp.fillArray(array);
    
       // System.out.println(this.root.element); //Outputs the root node without the ';' symbol
        //array[0].print = false;
        

        while(counter < max){
            boolean noSemicolon = true;
            
            for(int i = 0; i < max; i++){
                if(array[i].level == levelCheck && array[i].print == true && noSemicolon == true){
                    System.out.print(array[i].element);
                    array[i].print = false;
                    noSemicolon = false;
                    counter++;
                }else if(array[i].level == levelCheck && array[i].print == true && noSemicolon == false){
                    System.out.print(" ; " + array[i].element);
                    array[i].print = false;
                    counter++;
                }
            }
            System.out.println();
            levelCheck++;

        }
        for(int i = 0; i < max; i++){
            array[i].print = true;
        }

    }*/
/**
 * 
 * @param writer The output writer
 */
    public void Print(PrintWriter writer){ 
        int max = this.root.size();
        int counter = 0;
        int levelCheck = 0;
        Node[] array = new Node[max];
        Node temp = root;
        count = 0;
        temp = temp.fillArray(array);
        if(!firstPrint){
            writer.print('\n');
        }
        while(counter < max){
            boolean noSemicolon = true;
        
           
            for(int i = 0; i < max; i++){
                if(array[i].level == levelCheck && array[i].print == true && noSemicolon == true){
                    
                    writer.print(array[i].element);
                    array[i].print = false;
                    noSemicolon = false;
                    counter++;
                }else if(array[i].level == levelCheck && array[i].print == true && noSemicolon == false){
                    writer.print(" ; " + array[i].element);
                   
                    array[i].print = false;
                    counter++;
                }
            }
            if(counter < max){
                writer.print('\n');
            }

            levelCheck++;

        }
        for(int i = 0; i < max; i++){ // make sure every node can be printed again to avoid infinite loop
            array[i].print = true;
        }
        if(firstPrint){
            firstPrint = false;
        }

    }

    public myTree(){
        root = new Node();
        this.root.level = 0;
        this.root.element = new String("root");
        
    }
}


   
    


