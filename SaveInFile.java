import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveInFile {
    static public void writeFile(String[] info) {
        String path = String.format("%s.txt", info[0]);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path, true));
            for (String string : info) {
                bw.write(string + " ");
            }
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
