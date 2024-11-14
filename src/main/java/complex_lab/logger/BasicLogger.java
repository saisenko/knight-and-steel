package complex_lab.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BasicLogger {
    private final FileWriter fw;

    public BasicLogger(String filePathPrefix) throws IOException {
        int fileNumber = 1;
        File file;

        do {
            file = new File(filePathPrefix + "_" + fileNumber + ".log");
            fileNumber++;
        } while (file.exists());

        fw = new FileWriter(file);
    }

    public void recordAction(String action) throws IOException {
        fw.write(action + "\n");
    }

    public void close() throws IOException {
        if (fw != null) {
            fw.close();
        }
    }
}
