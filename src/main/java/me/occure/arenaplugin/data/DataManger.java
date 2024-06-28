package me.occure.arenaplugin.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class DataManger {

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static Path dataDirectory = Path.of("plugins/ArenaPlugin/player_data");

    public static void saveData(PlayerData playerData){
        Path playerFile = dataDirectory.resolve(playerData.getPlayerName() + ".json");
        FileWriter writer = null;

        try {
            writer = new FileWriter(playerFile.toFile());
            gson.toJson(playerData, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if(writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void loadData() throws IOException {
        if(!Files.exists(dataDirectory)) {
            try {
                Files.createDirectories(dataDirectory);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return;
        }

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dataDirectory, ".json")){
            for(Path entry : stream) {
                FileReader reader = null;
                try {
                    reader = new FileReader(entry.toFile());
                    PlayerData data = gson.fromJson(reader, PlayerData.class);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }

    public static PlayerData getPlayerData(String playerName) {
        Path playerFile = dataDirectory.resolve(playerName + ".json");
        FileReader reader = null;

        try {
            if(Files.exists(playerFile)){
                reader = new FileReader(playerFile.toFile());
                return gson.fromJson(reader, PlayerData.class);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return new PlayerData(playerName);
    }

}
