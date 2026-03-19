import java.io.IOException;

public class index{
    public static void main(String a[]) throws Exception,IOException{
        studentmanager stud = new studentmanager();

        
            stud.loadFromFile();
          stud.addStudents();  
           stud.removeStudents();
        stud.searchStudent();
        stud.updateStudent();
        stud.saveToFile();
           stud.show();
    }
}