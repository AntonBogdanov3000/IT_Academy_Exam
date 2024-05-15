package org.itacademy.utils;

import com.google.gson.Gson;
import org.itacademy.models.User;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class jsonUtil {

    public String getDataFromJson(String filePath){
        String json = null;
        JSONParser parser = new JSONParser();
        try {
            JSONObject object = (JSONObject) parser.parse(new FileReader(filePath));
            json = object.toString();
        } catch (IOException | ParseException e){
            System.out.println(e.getMessage());
        }
        return json;
    }

    public User getUserModel(){
        return new Gson().fromJson(getDataFromJson("src/test/java/org/itacademy/resources/UserData.json"), User.class);
    }

}
