package com.example.chandru.jsonparsing1;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.example.chandru.jsonparsing1.Listing;

public class Listing extends AppCompatActivity {
    public String TAG = "TestJson";
    ArrayList<ShopingModel> womenSaree = new ArrayList();
    ArrayList<ShopingModel> womenTops = new ArrayList();
    ArrayList<ShopingModel> womenKurta = new ArrayList();
    ArrayList<ShopingModel> menTshirt = new ArrayList();
    ArrayList<ShopingModel> menSweatShirt = new ArrayList();
    ArrayList<ShopingModel> menShirt = new ArrayList();


    private RecyclerView recyclerView;
    Context ctx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);
        ctx=this;
        recyclerView = findViewById(R.id.shopingRecyclerList);

        final GridLayoutManager mGridManager = new GridLayoutManager(this, 2);
        womenSaree = load(R.raw.myntra_women_saree);
//        womenTops = load(R.raw.myntra_women_tops);
//        womenKurta = load(R.raw.myntra_women_kurta);
//        menShirt = load(R.raw.myntra_men_shirt);
//        menSweatShirt = load(R.raw.myntra_men_sweatshirt);
//        menTshirt = load(R.raw.myntra_men_tshirt);
        final ShopCartAdapter shopCartAdapter = new ShopCartAdapter(womenSaree,this);
        recyclerView.setAdapter(shopCartAdapter);
        recyclerView.setLayoutManager(mGridManager);
    }


    private ArrayList<ShopingModel> load(int id) {
        ArrayList<ShopingModel> shoping = new ArrayList();
        Resources res = getResources();
        InputStream is = res.openRawResource(id);

        Scanner scanner = new Scanner(is);
        StringBuilder builder = new StringBuilder();
        while (scanner.hasNextLine()) {
            builder.append(scanner.nextLine());
        }
        try {
            JSONObject value = new JSONObject("{'items':" + builder.toString() + "}");
            JSONArray valueJSONArray = value.getJSONArray("items");
            for (int i = 0; i < valueJSONArray.length(); i++) {
                JSONObject shopingObject = valueJSONArray.getJSONObject(i);
                shoping.add(new ShopingModel(shopingObject.getString("discount_price"),shopingObject.getString("original_price"),"2",shopingObject.getString("thumbnails"),shopingObject.getString("product_name")));
            }
            return shoping;

        } catch (JSONException e) {

            e.printStackTrace();

        }
        return  null;
    }
}

