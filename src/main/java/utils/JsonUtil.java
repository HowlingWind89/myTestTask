package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonUtil {

    public static String createJsonFormObject(Object object) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(object);
    }

    public static <T> T createObjectFromJson(String json, Class<T> classname) throws IOException {
        return new ObjectMapper().readValue(json, classname);
    }
}
