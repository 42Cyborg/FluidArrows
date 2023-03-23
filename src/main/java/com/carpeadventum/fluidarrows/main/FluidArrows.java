package com.carpeadventum.fluidarrows.main;
import com.carpeadventum.fluidarrows.items.ModItems;
import com.carpeadventum.fluidarrows.entity.ModEntityTypes;
import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.util.registry.Registry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.Map;

public class FluidArrows implements ModInitializer {

    public static final String MOD_ID = "fluidarrows";
    public static JsonObject BUCKET_ARROW_RECIPE = null;

    /**
     * Runs the mod initializer.
     */
    @Override
    public void onInitialize() {
        ModItems.registerItems();
        ModEntityTypes.init();
        ModEntityTypes.registerEntityRender();

//        if (FabricLoader.getInstance().isModLoaded("throwablefluids")) {
//            BUCKET_ARROW_RECIPE = createShapelessRecipeJson(
//                    Lists.newArrayList("minecraft:arrow","throwablefluids:throwable_water"), //The items/tags we are using as input.
//                    Lists.newArrayList("item", "item"), //Whether the input we provided is a tag or an item.
//                    "fluidarrows:bucket_arrow" //The crafting output
//            );
//            System.out.println("Throwable Fluids detected, custom recipe loaded");
//        } else {
//            BUCKET_ARROW_RECIPE = createShapelessRecipeJson(
//                    Lists.newArrayList("minecraft:arrow", "minecraft:water_bucket", "minecraft:slime_ball"), //The items/tags we are using as input.
//                    Lists.newArrayList("item", "item", "item"), //Whether the input we provided is a tag or an item.
//                    "fluidarrows:bucket_arrow" //The crafting output
//            );
//            System.out.println("Throwable Fluids not detected, default recipe loaded");
//        }

    }

//    public static JsonObject createShapedRecipeJson(ArrayList<Character> keys, ArrayList<Identifier> items, ArrayList<String> type, ArrayList<String> pattern, Identifier output) {
//        //Creating a new json object, where we will store our recipe.
//        JsonObject json = new JsonObject();
//        //The "type" of the recipe we are creating. In this case, a shaped recipe.
//        json.addProperty("type", "minecraft:crafting_shaped");
//        //This creates:
//        //"type": "minecraft:crafting_shaped"
//
//        //We create a new Json Element, and add our crafting pattern to it.
//        JsonArray jsonArray = new JsonArray();
//        jsonArray.add(pattern.get(0));
//        jsonArray.add(pattern.get(1));
//        jsonArray.add(pattern.get(2));
//        //Then we add the pattern to our json object.
//        json.add("pattern", jsonArray);
//        //This creates:
//        //"pattern": [
//        //  "###",
//        //  " | ",
//        //  " | "
//        //]
//
//        //Next we need to define what the keys in the pattern are. For this we need different JsonObjects per key definition, and one main JsonObject that will contain all of the defined keys.
//        JsonObject individualKey; //Individual key
//        JsonObject keyList = new JsonObject(); //The main key object, containing all the keys
//
//        for (int i = 0; i < keys.size(); ++i) {
//            individualKey = new JsonObject();
//            individualKey.addProperty(type.get(i), items.get(i).toString()); //This will create a key in the form "type": "input", where type is either "item" or "tag", and input is our input item.
//            keyList.add(keys.get(i) + "", individualKey); //Then we add this key to the main key object.
//            //This will add:
//            //"#": { "tag": "c:copper_ingots" }
//            //and after that
//            //"|": { "item": "minecraft:sticks" }
//            //and so on.
//        }
//
//        json.add("key", keyList);
//        //And so we get:
//        //"key": {
//        //  "#": {
//        //    "tag": "c:copper_ingots"
//        //  },
//        //  "|": {
//        //    "item": "minecraft:stick"
//        //  }
//        //},
//
//        //Finally, we define our result object
//        JsonObject result = new JsonObject();
//        result.addProperty("item", output.toString());
//        result.addProperty("count", 1);
//        json.add("result", result);
//        //This creates:
//        //"result": {
//        //  "item": "modid:copper_pickaxe",
//        //  "count": 1
//        //}
//
//        return json;
//    }
//
//
//
//    public static JsonObject createShapelessRecipeJson(ArrayList<String> items, ArrayList<String> type, String output) {
//        //Creating a new json object, where we will store our recipe.
//        JsonObject json = new JsonObject();
//        //The "type" of the recipe we are creating. In this case, a shaped recipe.
//        json.addProperty("type", "minecraft:crafting_shapeless");
//        //This creates:
//        //"type": "minecraft:crafting_shapeless"
//
//        //We create a new Json Element, and add our crafting pattern to it.
//        JsonArray jsonArray = new JsonArray();
//
//
//        JsonObject ingredientsList = new JsonObject(); //The ingredient list
//
//        for (int i = 0; i < items.size(); ++i) {
//            ingredientsList.addProperty(type.get(i), items.get(i).toString()); //This will create a key in the form "type": "input", where type is either "item" or "tag", and input is our input item.
//        }
//
//        json.add("ingredients", ingredientsList);
//        //And so we get:
//        //"key": {
//        //  "#": {
//        //    "tag": "c:copper_ingots"
//        //  },
//        //  "|": {
//        //    "item": "minecraft:stick"
//        //  }
//        //},
//
//        //Finally, we define our result object
//        JsonObject result = new JsonObject();
//        result.addProperty("item", output);
//        result.addProperty("count", 1);
//        json.add("result", result);
//        //This creates:
//        //"result": {
//        //  "item": "modid:copper_pickaxe",
//        //  "count": 1
//        //}
//
//        return json;
//    }
}

