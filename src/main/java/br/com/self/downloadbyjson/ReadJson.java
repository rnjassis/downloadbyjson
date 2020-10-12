package br.com.self.downloadbyjson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJson {
	
    public String[] getListOfFiles() {
        File files = new File(FolderUtils.toDownloadPath);
        return files.list();
    }

    public JSONArray loadFile(String path) {
        try (FileReader reader = new FileReader(FolderUtils.toDownloadPath+"\\"+path))
        {
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(reader);
            JSONArray downloadList = (JSONArray) obj;
            return downloadList;
        } catch (IOException e){
            System.out.println("Erro ao carregar arquivo: "+e.getMessage());
            e.printStackTrace();
        }catch(ParseException e1){
            System.err.println("erro ao converter o json: "+e1.getMessage());
            e1.printStackTrace();
        }
        return null;
    }
}
