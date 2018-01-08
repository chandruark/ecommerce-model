package com.example.chandru.jsonparsing1;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.provider.ContactsContract;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import com.example.chandru.jsonparsing1.ShopCartAdapter;

import org.json.JSONArray;
import org.json.JSONObject;


public class ShopCartAdapter extends RecyclerView.Adapter<ShopCartAdapter.ViewHolder> {
    Context ctx;
    ArrayList<ShopingModel> items = new ArrayList<>();
    Dialog mydialog;
    Button dialogbtn;
    TextView dialograte,dialogdiscount;
    ImageView dialogimg;
     static String rate1 = null;
    static String discount1 = null;
    Activity activity;

    JSONArray articles = new JSONArray();
    JSONObject article = new JSONObject();

    public ShopCartAdapter(ArrayList<ShopingModel> op, Context ctx) {
        this.items = op;
        this.ctx = ctx;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_shoping_listing, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {




        holder.rate.setText(items.get(position).getRate());
        holder.discount.setText(items.get(position).getDiscount());
        if (items.get(position).getUrl() != null) {
            Picasso.with(ctx)
                    .load(items.get(position).getUrl())
                    .into(holder.mContentView);
        }

        holder.name.setText(items.get(position).getName());



        holder.mContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


              final  Dialog  mydialog=new Dialog(ctx);
                mydialog.setContentView(R.layout.dialog_view);

                dialograte=(TextView) mydialog.findViewById(R.id.dialograte);
                dialogdiscount=(TextView) mydialog.findViewById(R.id.dialogdiscount);
                dialogbtn=(Button) mydialog.findViewById(R.id.dialogbtn);
                dialogimg=(ImageView) mydialog.findViewById(R.id.dialogimg);

                if (items.get(position).getUrl() != null) {
                    Picasso.with(ctx)
                            .load(items.get(position).getUrl())
                            .into(dialogimg);
                }

                dialograte.setText(items.get(position).getRate());
                dialogdiscount.setText(items.get(position).getDiscount());

                dialogbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i1=new Intent(ctx,OfferdetailsActivity.class);
                        i1.putExtra("name", items.get(position).getName().toString());
                        i1.putExtra("rate",items.get(position).getRate().toString());
                        i1.putExtra("discount",items.get(position).getDiscount().toString());
                        i1.putExtra("url1",items.get(position).getUrl().toString());
                        ctx.startActivity(i1);


                    }
                });

                mydialog.getWindow().setBackgroundDrawable( new ColorDrawable(Color.TRANSPARENT));
                mydialog.show();

            }
        });

    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public View mView;
        public ImageView mContentView;
        public RelativeLayout cd;
        public TextView rate;
        public TextView discount;
        public TextView name;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mContentView = view.findViewById(R.id.limage);
            cd = view.findViewById(R.id.layoutCardView);
            this.rate = view.findViewById(R.id.rate);
            this.discount = view.findViewById(R.id.discount);
            this.name=view.findViewById(R.id.name);
        }


    }
}

