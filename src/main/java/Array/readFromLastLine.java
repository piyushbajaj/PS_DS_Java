package Array;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by piyush.bajaj on 10/02/17.
 */
public class readFromLastLine {
    public static void main(String[] args) {
        readFromLastLine rf = new readFromLastLine();
        File file = new File("/Users/piyush.bajaj/Documents/advice_advice/sample.txt");
        rf.readFromLast(file);
    }

    public void readFromLast(File file) {
        int lines = 0;
        StringBuilder builder = new StringBuilder();
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
            long fileLength = file.length() - 1;
            // Set the pointer at the last of the file
            randomAccessFile.seek(fileLength);
            for (long pointer = fileLength; pointer >= 0; pointer--) {
                randomAccessFile.seek(pointer);
                char c;
                // read from the last one char at the time
                c = (char) randomAccessFile.read();
                // break when end of the line
                if (c == '\n') {
                    break;
                }
                builder.append(c);
            }
            // Since line is read from the last so it
            // is in reverse so use reverse method to make it right
            builder.reverse();
            System.out.println("Line - " + builder.toString());
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
