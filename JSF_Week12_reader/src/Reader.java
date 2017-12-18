import java.io.*;
import java.util.Scanner;

public class Reader {
    File file;
    Scanner scanner;
    public void readTextNotBuffered() throws IOException {
        file = new File("D:/Jelle Schräder/Documents/Github/JSF_Week12/newFile.txt");
        try {

            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String s = scanner.next();
                System.out.println(s);
            }
            scanner.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void readTextBuffered() throws IOException {
        file = new File("D:/Jelle Schräder/Documents/Github/JSF_Week12/newBufferedFile.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader input = new BufferedReader(fileReader);
            String line;
            while((line = input.readLine()) != null) {
                System.out.println(line);
            }
            input.close();
            fileReader.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void readByteNotBuffered() throws IOException {
        try{

            //  Deze werkt nog niet, de volgende ook niet. Hierboven de 2 wel.
            //  Vergeet de fileNames niet aan te passen bij het runnen.

            String fileName = "D:/Jelle Schräder/Documents/Github/JSF_Week12/newBinaireFile.txt";
            file = new File(fileName);
            FileInputStream fileInput = new FileInputStream(fileName);
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            //Edge serializableObject = (Edge)objectInput.readObject();
            Object obj = null;
            while((obj = objectInput.readObject()) != null){
                //if(obj instanceof Edge) {
                    System.out.println(((Edge) obj).getString());
                //}
            }
            objectInput.close();
            fileInput.close();
        } catch(ClassNotFoundException cex) {
            cex.printStackTrace();
        }
    }

    public void readByteBuffered() throws IOException {

    }
}
