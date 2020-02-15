package com.manin.cobarecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.manin.cobarecyclerview.adapter.ListHeroAdapter;
import com.manin.cobarecyclerview.model.Hero;
import com.manin.cobarecyclerview.model.HeroesData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvHeroes;
    private ArrayList<Hero> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHeroes=findViewById(R.id.id_rv_heroes);
        rvHeroes.setHasFixedSize(true);

        list.addAll(HeroesData.getListData());
        tampilRecyclerList();


    }

    private void tampilRecyclerList() {
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        ListHeroAdapter m=new ListHeroAdapter(MainActivity.this,list);// nambah MainActivity.this
        rvHeroes.setAdapter(m);
    }


    //codingan tambah menu di samping oncreate dan onOption
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_list:

                Intent b=new Intent(MainActivity.this, AboutMe.class);
                startActivity(b);
                break;

        }
    }
}
