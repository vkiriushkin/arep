package com.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

@RestController
public class MarksController {

    private static final String LOAD_MARKS_REQUEST = "http://api.auto.ria.com/categories/1/marks/_with_count";

    private Gson gson = new Gson();

    private final RestTemplate restTemplate = new RestTemplate();

    @RequestMapping("/marks")
    public @ResponseBody
    List<Mark> getMarks() throws IOException {

        String marksJSON = restTemplate.getForObject(LOAD_MARKS_REQUEST, String.class);
        Type marksListType = new TypeToken<List<Mark>>(){}.getType();
        List<Mark> marksList = gson.fromJson(marksJSON, marksListType);

        System.out.println(marksList.toString());

        return marksList;
    }

}
