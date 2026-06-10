package service;

import com.google.gson.Gson;
import model.SaveData;

import java.io.FileReader;
import java.io.FileWriter;

public class SaveService {
    public void saveGame(
            SaveData saveData
    ) {
        try {

            Gson gson = new Gson();

            FileWriter writer =
                    new FileWriter(
                            "resources/save.json"
                    );

            gson.toJson(
                    saveData,
                    writer
            );

            writer.close();

            System.out.println(
                    "Game saved successfully."
            );

        }
        catch (Exception e) {

            e.printStackTrace();
        }

    }// converts SaveData to save.json

    public SaveData loadGame() {
        try {

            Gson gson = new Gson();

            FileReader reader =
                    new FileReader(
                            "resources/save.json"
                    );

            SaveData saveData =
                    gson.fromJson(
                            reader,
                            SaveData.class
                    );

            return saveData;

        }
        catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }
}
