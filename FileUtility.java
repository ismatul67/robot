import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileUtility {
    final static File posisi = new File("posisi.txt");

    public static String  read() {
        String lastPosition = "0,0:N";
 
        try {
            String currentLine;
            List<String> lines = Files.readAllLines(Paths.get(posisi.toString()),
            Charset.defaultCharset());
          
                if(lines.size()>0){
                    currentLine = lines.get(lines.size()-1);
                    lastPosition = currentLine;
                }  else{
                    write(lastPosition);

                } 

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lastPosition;
    }

    public static void write(String lastPosition)  {
        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter(posisi,true));
            fw.append(lastPosition);
            fw.newLine();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void reset(){
        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter(posisi));
            fw.append("0,0:N");
            fw.newLine();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

}

}
