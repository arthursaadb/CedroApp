package com.example.arthursaad.cedroapp.ui.recyclerSites;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.arthursaad.cedroapp.R;
import com.example.arthursaad.cedroapp.adapter.SitesAdapter;
import com.example.arthursaad.cedroapp.model.Site;
import com.example.arthursaad.cedroapp.ui.createSites.RegisterSitesActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SitesActivity extends AppCompatActivity {

    private List<Site> sitesList = new ArrayList<>();
    private RecyclerView.LayoutManager layoutManager;
    private SitesPresenter sitesPresenter;
    private SitesAdapter adapter;
    private Site site;

    @BindView(R.id.idRecycler)
    RecyclerView recycler;

    @BindView(R.id.newSite)
    FloatingActionButton newSite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sites_acitivy);
        ButterKnife.bind(this);
        sitesPresenter = new SitesPresenter(this);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(layoutManager);
        adapter = new SitesAdapter(sitesPresenter.recoverSites(), this);
        recycler.setAdapter(adapter);

    }

    @OnClick(R.id.newSite)
    public void onClick(View view) {
        Intent intent = new Intent(this, RegisterSitesActivity.class);
        startActivity(intent);
    }


   /* public List<Site> createSites() {
        List<Site> sitesList = new ArrayList<Site>();
        for (int i = 0; i < 4; i++) {
            site = new Site("teste", "teste", "teste");
            sitesList.add(site);
        }

        return  sitesList;
    }*/

}
