package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        try {

            // Create the JSON sandwich object from the JSON passed in
            JSONObject sandwich = new JSONObject(json);

            // Create the name Object
            JSONObject name = sandwich.getJSONObject("name");
            // Retrieve the necessary name info
            String mainName = name.getString("mainName");
            List<String> alsoKnownAs = (List) name.getJSONArray("alsoKnownAs"); //Cast the JSON object to a List

            // Retrieve other info from the JSON sandwich object
            String placeOfOrigin = sandwich.getString("placeOfOrigin");
            String description = sandwich.getString("description");
            String image = sandwich.getString("image");
            List<String> ingredients   = (List) sandwich.getJSONArray("ingredients"); //Cast the JSON object to a List

            // Initialize Sandwich Object
            Sandwich JSON_sandwich = null;

            // Set all the necessary fields
            JSON_sandwich.setMainName(mainName);
            JSON_sandwich.setAlsoKnownAs(alsoKnownAs);
            JSON_sandwich.setPlaceOfOrigin(placeOfOrigin);
            JSON_sandwich.setDescription(description);
            JSON_sandwich.setImage(image);
            JSON_sandwich.setIngredients(ingredients);

            return JSON_sandwich;


        } catch (JSONException j) {
            j.printStackTrace();
            Log.d("JSONUtils", "JSON Exception err");
        }

        return null;
    }
}
