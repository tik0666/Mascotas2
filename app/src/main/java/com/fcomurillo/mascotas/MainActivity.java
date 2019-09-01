package com.fcomurillo.mascotas;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.fcomurillo.mascotas.adapter.MascotaAdapter;
import com.fcomurillo.mascotas.adapter.PageAdapter;
import com.fcomurillo.mascotas.fragment.PerfilFragment;
import com.fcomurillo.mascotas.fragment.RecyclerViewFragment;
import com.fcomurillo.mascotas.pojo.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        //Toolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.drawable.ic_pata_mascota);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itmRaking:
                //Toast.makeText(this, "Item 1 selected", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MascotasFavoritas.class);
                this.startActivity(intent);
                return true;
            /*case R.id.itmCerrar:
                //Toast.makeText(this, "Item 2 selected", Toast.LENGTH_SHORT).show();
                finish();
                System.exit(0);
                return true;*/
            case R.id.itmContacto:
                Intent intent2 = new Intent(this, Contacto.class);
                this.startActivity(intent2);
                return true;
            case R.id.itmAcerca:
                //Toast.makeText(this, getResources().getString(R.string.creador), Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(this, Informacion.class);
                this.startActivity(intent3);
                return true;
            /*case R.id.subitem2:
                Toast.makeText(this, "Sub Item 2 selected", Toast.LENGTH_SHORT).show();
                return true;*/
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_casa);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_pata_mascota);

    }
}
