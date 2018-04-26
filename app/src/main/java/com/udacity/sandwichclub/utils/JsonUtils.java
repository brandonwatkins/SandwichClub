package com.udacity.sandwichclub.utils;

import android.annotation.TargetApi;
import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        try {

            String FALL_BACK_STRING = "Not Found";
            JSONObject FALL_BACK_OBJECT = new JSONObject();

            List<String> alsoKnownAs = new ArrayList<>();
            List<String> ingredients = new ArrayList<>();

            // Create the JSON sandwich object from the JSON passed in
            JSONObject sandwich = new JSONObject(json);

            // Create the name Object
            JSONObject name = sandwich.optJSONObject("name");
            // Retrieve the necessary name info
            String mainName = name.optString("mainName", FALL_BACK_STRING);

            JSONArray alsoKnowAsArray = name.optJSONArray("alsoKnownAs");

            // Gets the names within the JSONArray and adds it to the ArrayList I created
            for(int i = 0; i < alsoKnowAsArray.length(); i++) {
                alsoKnownAs.add(alsoKnowAsArray.getString(i));
            }

            // Retrieve other info from the JSON sandwich object
            String placeOfOrigin = sandwich.optString("placeOfOrigin", FALL_BACK_STRING);
            String description = sandwich.optString("description", FALL_BACK_STRING);
            String image = sandwich.optString("image", FALL_BACK_STRING);

           JSONArray ingredientsArray = sandwich.optJSONArray("ingredients");

           for(int i = 0; i < ingredientsArray.length(); i++) {
               ingredients.add(ingredientsArray.getString(i));
           }

            // Initialize new Sandwich Object
            Sandwich JSON_sandwich = new Sandwich();

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
