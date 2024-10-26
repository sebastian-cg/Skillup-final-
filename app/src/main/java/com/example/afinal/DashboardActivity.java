package com.example.afinal;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Tutor> tutorsList = new ArrayList<>();
        tutorsList.add(new Tutor("Basketball Professional", "Lebron James", "Hello! I’m Lebron James, a professional basketball coach with over 40 years of experience both playing and coaching. I specialize in skill development, game strategy, and building mental toughness."));

        TutorAdapter adapter = new TutorAdapter(tutorsList);
        recyclerView.setAdapter(adapter);

        // Recommended tutor's Card view
        RecyclerView recoRecyclerView = findViewById(R.id.reco_tutor_list_contents);
        recoRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Tutor> recoTutorsList = new ArrayList<>();
        recoTutorsList.add(new Tutor("Basketball Professional", "Lebron James", "Hello! I’m Lebron James, a professional basketball coach with over 40 years of experience both playing and coaching. I specialize in skill development, game strategy, and building mental toughness."));

        TutorAdapter recoAdapter = new TutorAdapter(recoTutorsList);
        recoRecyclerView.setAdapter(recoAdapter);
    }
}