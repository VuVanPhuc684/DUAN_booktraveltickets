package vanphuc.booktraveltickets.ACTIVITY;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import vanphuc.booktraveltickets.R;

public class welcomeactivity extends AppCompatActivity {
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcomeactivity);

        linearLayout = findViewById(R.id.LLnext);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(welcomeactivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}