import java.io.*;

public class Writer {

    public void writeTextNotBuffered(String edge, boolean append) throws IOException {
        String filename = "D:/Jelle Schräder/Documents/Github/JSF_Week12/newFile.txt";
        FileWriter file = new FileWriter(filename, append);
        file.write(edge + "\n");
        file.flush();
        file.close();
    }

    public void writeTextBuffered(String edge, boolean append) throws IOException {
        String filename = "D:/Jelle Schräder/Documents/Github/JSF_Week12/newBufferedFile.txt";
        FileWriter file = new FileWriter(filename, append);
        BufferedWriter out = new BufferedWriter(file);
        out.write(edge + "\n");
        out.flush();
        out.close();
    }

    public void binaireNotBuffered(Object edge, boolean append) throws IOException {
        String filename = "D:/Jelle Schräder/Documents/Github/JSF_Week12/newBinaireFile.txt";
        FileOutputStream file = new FileOutputStream(filename, append);
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(edge);
        out.flush();
        out.close();
    }

    public void binaireBuffered(Object edge, boolean append) throws IOException {
        String filename = "D:/Jelle Schräder/Documents/Github/JSF_Week12/newBufferedBinaireFile.txt";
        FileOutputStream file = new FileOutputStream(filename, append);
        BufferedOutputStream out = new BufferedOutputStream(file);
        out.write(edge.toString().getBytes());
        out.flush();
        out.close();
    }
}
