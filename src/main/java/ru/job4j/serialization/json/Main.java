package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Client client = new Client("Dmitriy", 32,
         true, new String[]{"Portugal", "New Zealand", "Malaysia"},
                new Passport("32098"));

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(client));

        final String clientJson =
                "{"
                + "\"name\":\"Dmitriy\","
                + "\"age\":32,"
                + "\"hasVisa\":true,"
                + "\"wishList\":"
                + "[\"Portugal\",\"New Zealand\", \"Malaysia\"],"
                + "\"passport\":"
                + "{"
                + "\"number\":\"32098\""
                + "}"
                + "}";

        final Client clientMod = gson.fromJson(clientJson, Client.class);
        System.out.println(clientMod);

        JSONObject jsonPassport = new JSONObject("{\"number\":\"32098\"}");
        List<String> list = new ArrayList<>();
        list.add("Portugal");
        list.add("New Zealand");
        list.add("Malaysia");
        JSONArray jsonWishList = new JSONArray(list);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", client.getName());
        jsonObject.put("age", client.getAge());
        jsonObject.put("hasVisa", client.isHasVisa());
        jsonObject.put("wishList", jsonWishList);
        jsonObject.put("passport", jsonPassport);

        System.out.println(jsonObject);
        System.out.println(new JSONObject(client));
    }
}
