package com.example.arthursaad.cedroapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.arthursaad.cedroapp.R;
import com.example.arthursaad.cedroapp.helper.AksHelper;
import com.example.arthursaad.cedroapp.helper.GliderHelper;
import com.example.arthursaad.cedroapp.model.Site;
import com.example.arthursaad.cedroapp.helper.HelperSaveToken;
import com.example.arthursaad.cedroapp.ui.editSite.DetailsActivity;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SitesAdapter extends RecyclerView.Adapter<SitesAdapter.ViewHolder> {

    public List<Site> Siteslits;
    private final Context context;
    private String token;
    private String urlImage = "https://dev.people.com.ai/mobile/api/v2/logo/";
    private AksHelper aksHelper;

    public SitesAdapter(List<Site> sites, Context context) {
        this.Siteslits = sites;
        this.context = context;
        this.token = HelperSaveToken.getToken(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sites_list_row, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Site site = Siteslits.get(position);
        aksHelper = new AksHelper(context);
        site.setPassword(aksHelper.decryptText(site.getPassword()));
        holder.populateView(site,urlImage +Siteslits.get(position).getUrl(),token);

        holder.cardView.setOnClickListener((view)->{
            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("SITE_DETAILS",site);
            intent.putExtra("URL_SITE",urlImage +Siteslits.get(position).getUrl());
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return Siteslits.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image)
        ImageView icon;

        @BindView(R.id.idUrl)
        TextView url;

        @BindView(R.id.user)
        TextView user;

        @BindView(R.id.cardview)
        CardView cardView;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void populateView(Site site,String urlImage,String token) {
            url.setText(site.getUrl());
            user.setText(site.getUser());
            Glide.with(icon.getContext()).load(GliderHelper.getImg(urlImage,token)).into(icon);
        }
    }
}



