//this is a program showcasing how to merge two existing files
package mergefile;

import java.util.*;
import java.io.*;

public class MergeFile {

    public static void main(String args[]) throws IOException {
        if (args.length != 3) {
            System.out.println("Usage: java MergeFiles file1 file2 mergedFile");
            System.exit(1);
        }
        String[] names = new String[13];
        File file1 = new File("file1.txt"); //there is a file that has the same name and type inside the project file
        Scanner in1 = new Scanner(file1);
        int x = 0;
        while (in1.hasNext()) {
            String s = in1.nextLine();
            names[x] = s;
            x++;
        }
        File file2 = new File("file2.txt");//there is a file that has the same name and type inside the project file
        Scanner in2 = new Scanner(file2);
        while (in2.hasNext()) {
            String s = in2.nextLine();
            names[x] = s;
            x++;
        }
        Arrays.sort(names, 0, x);
        File file = new File("mergedFile.txt"); //this will be the name of the new file (file1 & file2 combined)
        PrintWriter output = new PrintWriter(file);
        for (int i = 0; i < x; i++) {
            boolean isduplicate = false;
            for (int j = 0; j < i; j++) {
                if (names[i].equals(names[j])) {
                    isduplicate = true;
                    break;
                }
            }
            if (isduplicate == false) {
                output.println(names[i]);
            }
        }
        output.close();
        System.out.println("Successfully Merged files");
    }
}
