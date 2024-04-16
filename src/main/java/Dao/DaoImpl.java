package Dao;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
public class DaoImpl implements IDao {
    private static final String FILE_PATH = "src/main/resources/data.json";

    @Override
    public LocalDate getData() {
        try{
            JsonElement jsonElement = new Gson().fromJson(new FileReader(FILE_PATH), JsonElement.class);
            JsonArray jsonArray = jsonElement.getAsJsonArray();
            JsonObject jsonObject = jsonArray.get(1).getAsJsonObject();
            String birthDayString = jsonObject.get("birthDate").getAsString();
            return LocalDate.parse(birthDayString);
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
