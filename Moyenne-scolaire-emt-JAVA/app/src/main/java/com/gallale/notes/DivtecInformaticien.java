package com.gallale.notes;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.gallale.notes.ui.main.SectionsPagerAdapter;

import java.util.List;

public class DivtecInformaticien extends AppCompatActivity{

    ViewPager viewPager;
    ImageView imgSettings;
    AppBarLayout appBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_divtec_inf);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        final TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        imgSettings = findViewById(R.id.img_settings);
        appBar = findViewById(R.id.divtec_appbar);

        final Intent settings = new Intent(this,settngs.class);

        ThemeApp();

        imgSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(settings);
            }
        });
    }


    public void onBackPressed(){
        tellFragments();
    }

    private void tellFragments(){
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        for(Fragment f : fragments){
            if(f != null){
                if(f instanceof fragmentDivtecInfEpt){
                    ((fragmentDivtecInfEpt)f).onBackPressed();
                }else if(f instanceof fragmentDivtecInfModules){
                    ((fragmentDivtecInfModules)f).onBackPressed();
                }
            }
        }
    }

    /**
     * Change le thème de l'application
     */
    private void ThemeApp(){

        int nightModeFlags =
                this.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;

        switch (nightModeFlags) {
            case Configuration.UI_MODE_NIGHT_YES:
                appBar.setBackgroundColor(Color.BLACK);
                imgSettings.setImageResource(R.drawable.baseline_settings_white_24);
                break;

            case Configuration.UI_MODE_NIGHT_UNDEFINED:
            case Configuration.UI_MODE_NIGHT_NO:
                appBar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                imgSettings.setImageResource(R.drawable.baseline_settings_black_24);
                break;
        }
    }

}