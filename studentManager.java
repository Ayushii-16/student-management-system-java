import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class studentmanager {
     List<student> stud = new ArrayList<>();
            
    Scanner s = new Scanner(System.in);

     public void saveToFile() throws IOException{
          try(FileWriter appender = new FileWriter("students.txt",false)){
              for(student st : stud){
               appender.write(st.name + " , " + st.rollNumber + " , " + st.marks + "\n");
               System.out.println();
              }
              System.out.println("Saving " + stud.size() + " students");
              appender.close();
          }
     }

     public void addStudents() throws IOException{
        System.out.println("How many students do you want to add : ");
        int n = s.nextInt();
        for(int i=0;i<n;i++){
             System.out.println("Enter your name , rollnumber and marks : ");
           stud.add(new student(s.next(), s.nextInt(), s.nextInt())); 
        }
             saveToFile();
         
            
     }

      public void removeStudents() throws IOException{
          System.out.println("Enter roll number to delete: ");
            int input  = s.nextInt();
          for(int i=0;i<stud.size();i++){
               if(stud.get(i).rollNumber == input){
                  stud.remove(i);
                  System.out.println("Successfully Deleted..");
                  break;
               }
          }
          saveToFile();
     }

     public void loadFromFile() throws Exception, IOException{
     String path = "students.txt";
      try(BufferedReader br = new BufferedReader(new FileReader(path))){
          String line ;
        
          while( (line =  br.readLine()) != null){
          String[] parts = line.split(" , ");
              System.out.println(line);
              stud.add(new student(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
          }
     }
      catch(Exception e){
          System.out.println(e.getMessage());
      }
       }

     public void show(){
        int sum = 0;
        if(stud.size()==0) System.out.println("no students found");
        for(student st : stud){
           if(st.marks >= 40 ) {
             System.out.println(st.name + " : " + st.rollNumber + " : " + st.marks + "  PASS");
           }
              
           else
                System.out.println(st.name + " : " + st.rollNumber + " : " + st.marks + "  FAIL");
            sum += st.marks;
        }
        System.out.println("The average is : "  + sum/stud.size());
     }
     
}
