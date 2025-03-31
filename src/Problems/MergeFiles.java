package Problems;

import java.io.*;

public class MergeFiles {
    final private String file1 = "C:\\Users\\scmccune\\IdeaProjects\\1.txt";
    final private String file2 = "C:\\Users\\scmccune\\IdeaProjects\\2.txt";
    public MergeFiles(){
        bufferedReader();
        bufferedStream();




    }

    private void bufferedStream() {


        try (InputStream is1 = new FileInputStream(file1);
             InputStream is2 = new FileInputStream(file2);
             BufferedInputStream bis1 = new BufferedInputStream(is1, 1024);
             BufferedInputStream bis2 = new BufferedInputStream(is2, 1024);
//             BufferedReader reader1 = new BufferedReader(bis1);
//             BufferedReader reader2 = new BufferedReader(bis2);
             ) {

//            while(null != line1 && null != line2) {
//                System.out.println(line1);
//                System.out.println(line2);
//                line1 = reader1.readLine();
//                line2 = reader2.readLine();
//            }
//

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void bufferedReader() {
        try (FileReader fi1 = new FileReader(file1);
             FileReader fi2 = new FileReader(file2);
             BufferedReader reader1 = new BufferedReader(fi1);
             BufferedReader reader2 = new BufferedReader(fi2);
             ) {
            String line1 = reader1.readLine();
            String line2 = reader2.readLine();
            while(null != line1 && null != line2) {
                System.out.println(line1);
                System.out.println(line2);
                line1 = reader1.readLine();
                line2 = reader2.readLine();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
