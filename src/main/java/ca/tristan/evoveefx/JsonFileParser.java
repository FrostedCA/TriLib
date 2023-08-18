package ca.tristan.evoveefx;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;

public abstract class JsonFileParser {

    private BufferedWriter bufferedWriter;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final File file;
    private final ArrayList<JsonNode> jsons = new ArrayList<>();

    public JsonFileParser(File file) throws IOException {
        this.file = file;
        if(!file.exists()) {
            file.createNewFile();
        }else {
            this.loadToArray();
        }
    }

    public void loadToArray() {
        if(!file.exists()) {
            Logger.error("File not found -> " + file.getPath());
            return;
        }

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String s;
            while((s = bufferedReader.readLine()) != null) {
                JsonNode jsonNode = objectMapper.readTree(s);
                jsons.add(jsonNode);
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeLine(String line) throws IOException {
        this.bufferedWriter.write(line);
        this.bufferedWriter.newLine();
    }

    public void writeFromArray() {
        if(!file.exists()) {
            Logger.error("File not found -> " + file.getPath());
            return;
        }
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            for(JsonNode jsonNode : jsons) {
                this.writeLine(jsonNode.toString());
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<JsonNode> getJsons() {
        return this.jsons;
    }

    public void addJsonNode(JsonNode jsonNode) {
        this.jsons.add(jsonNode);
    }

}
