package complex_lab.utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private FileWriter recorder;

    public Logger(String filePathPrefix) throws IOException {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String filePath = "./logs/" + filePathPrefix + "_" + timestamp + ".log";
        
        recorder = new FileWriter(filePath);
    }

    public void recordAction(String action) throws IOException {
        recorder.write(action + "\n");
    }

    public void closeLogger() throws IOException {
        if (recorder != null) {
            recorder.close();
        }
    }
}
