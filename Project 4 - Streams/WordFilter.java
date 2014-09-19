import java.nio.file.Files;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordFilter extends Filter<String>{
  private BufferedReader br;
  public WordFilter(String file){
    super(file, null);
    try{
      br = new BufferedReader(new FileReader("C:\\Users\\Sarah Whelan\\Dropbox\\Case\\Classes\\Semester 2\\EECS 132\\Projects\\Project 4\\" + file));
    }
    catch(IOException e){
    }
  }
  
  public boolean passFilter(String word){
    //InputStream text = new newInputStream("/"+value);
    System.out.println(br);
    return true;
  }
}