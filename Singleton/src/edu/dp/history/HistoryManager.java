package edu.dp.history;

import edu.dp.IManager;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HistoryManager implements IManager {
    private static IManager historyManager;
    private List<History> historyList;

    private HistoryManager() {
        historyList = new ArrayList<>();
    }

    public List<History> getHistoryList() {
        return historyList;
    }

    public void addEntry(String name, LocalDateTime dateTime) {
        historyList.add(new History(name, dateTime));
        saveHistoryToFile();
    }

    private void saveHistoryToFile() {
        FileWriter fileWriter = null;
        BufferedWriter bw = null;
        try {
            File file = new File("history.txt");
            fileWriter = new FileWriter(file.getAbsolutePath(), true);
            bw = new BufferedWriter(fileWriter);
            bw.write(this.historyList.get(this.historyList.size() - 1).toString());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert fileWriter != null;
                fileWriter.close();
            } catch (IOException ignored) {
            }
        }
    }

    public synchronized static IManager getLazyInstance() {
        // lazy singleton method
        if (historyManager != null) {
            return historyManager;
        }
        historyManager = new HistoryManager();
        return historyManager;
    }

    public static IManager getInstance() {
        // thread safe and double check singleton method
        if (historyManager == null) {
            synchronized (HistoryManager.class) {
                if (historyManager == null) {
                    historyManager = new HistoryManager();
                }
                return historyManager;
            }
        }
        return historyManager;
    }
}
