package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
    }
}
