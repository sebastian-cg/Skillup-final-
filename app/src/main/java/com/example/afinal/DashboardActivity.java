package com.example.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.dashboard_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        // Top tutor's Card view
        RecyclerView recyclerView = findViewById(R.id.tutor_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


        List<Tutor> tutorsList = new ArrayList<>();
        tutorsList.add(new Tutor("Basketball Professional", "Lebron James", "Hello! I’m Lebron James, a professional basketball coach with over 40 years of experience both playing and coaching. I specialize in skill development, game strategy, and building mental toughness."));
        tutorsList.add(new Tutor("IT Professional", "Bronny James Jr.", "Hi! I'm Bronny James Jr., a professional IT coach with over 40 years of experience both playing and coaching. I specialize in skill development, game strategy, and building mental toughness."));

        TutorAdapter adapter = new TutorAdapter(tutorsList);
        recyclerView.setAdapter(adapter);

        // Recommended tutor's Card view
        RecyclerView recoRecyclerView = findViewById(R.id.reco_tutor_list_contents);
        recoRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        List<Tutor> recoTutorsList = new ArrayList<>();
        recoTutorsList.add(new Tutor("Basketball Professional", "Lebron James", "Hello! I’m Lebron James, a professional basketball coach with over 40 years of experience both playing and coaching. I specialize in skill development, game strategy, and building mental toughness."));
        recoTutorsList.add(new Tutor("IT Professional", "Bronny James Jr.", "Hi! I'm Bronny James Jr., a professional IT coach with over 40 years of experience both playing and coaching. I specialize in skill development, game strategy, and building mental toughness."));
        recoTutorsList.add(new Tutor("Basketball Professional", "Lebron James", "Hello! I’m Lebron James, a professional basketball coach with over 40 years of experience both playing and coaching. I specialize in skill development, game strategy, and building mental toughness."));

        // disable nested scrolling for each recycler view
        recyclerView.setNestedScrollingEnabled(false);
        recoRecyclerView.setNestedScrollingEnabled(false);

        TutorAdapter recoAdapter = new TutorAdapter(recoTutorsList);
        recoRecyclerView.setAdapter(recoAdapter);

        // add function listener to bottom nav
        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);

        bottomNav.setOnNavigationItemSelectedListener(item -> {

            int itemId = item.getItemId();
            if (itemId == R.id.home_appbar) {
                showHomeLayout();
                return true;
            } else if (itemId == R.id.profile_appbar) {
                loadFragment(new ProfileFragment());
                return true;
            } else if (itemId == R.id.menu_appbar){
                loadFragment(new MenuFragment());
                return true;
            }
            return false;
        });
    }
    private void loadFragment(Fragment fragment){
        NestedScrollView nestedScrollView = findViewById(R.id.nested_scroll_view);
        FrameLayout frameContainer = findViewById(R.id.fragment_container);

        nestedScrollView.setVisibility(View.GONE);
        frameContainer.setVisibility(View.VISIBLE);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();

    }
    private void showHomeLayout(){
        NestedScrollView nestedScrollView = findViewById(R.id.nested_scroll_view);
        FrameLayout frameContainer = findViewById(R.id.fragment_container);


        nestedScrollView.setVisibility(View.VISIBLE);
        frameContainer.setVisibility(View.GONE);

    }
}