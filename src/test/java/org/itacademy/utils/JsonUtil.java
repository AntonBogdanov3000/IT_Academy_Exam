package org.itacademy.utils;

import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.itacademy.models.User;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;


public class JsonUtil {

    private Logger logger = Logger.getLogger(JsonUtil.class);

    public String getDataFromJson(String filePath){
        logger.debug("Getting data from Json");
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
        logger.debug("Getting User model from Json");
        return new Gson().fromJson(getDataFromJson("src/test/resources/UserData.json"), User.class);
    }

}
