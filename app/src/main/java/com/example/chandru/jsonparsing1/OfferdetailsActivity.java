package com.example.chandru.jsonparsing1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class OfferdetailsActivity extends AppCompatActivity {

    TextView name,rateer,discer;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offerdetails);

        name=(TextView)findViewById(R.id.name);
        rateer=(TextView)findViewById(R.id.rateer);
        discer=(TextView)findViewById(R.id.discer);

        img=(ImageView)findViewById(R.id.imageView1);
        Intent i1 = getIntent();
        String name1 = i1.getStringExtra("name");
        String rate1 = i1.getStringExtra("rate");
        String disc1 = i1.getStringExtra("discount");
        String url12 = i1.getStringExtra("url1");

        name.setText(name1.toString());
        rateer.setText(rate1.toString());
        discer.setText(disc1.toString());

        Picasso.with(this)
                .load(url12)
                .into(img);









    }
}
