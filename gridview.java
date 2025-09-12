package com.example.gridviewdemo;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.GridView;
public class MainActivity extends AppCompatActivity {
    int[] imageIds = {
            R.drawable.img, R.drawable.img_1, R.drawable.img_2,
            R.drawable.img_3, R.drawable.img_4, R.drawable.img_5
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gridView = findViewById(R.id.gridView);
        ImageAdapter adapter = new ImageAdapter(this, imageIds);
        gridView.setAdapter(adapter);
        // On item click → show AlertDialog
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, android.view.View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Image Selected");
                builder.setMessage("You clicked image at position: " + position);
                builder.setPositiveButton("OK", null);
                builder.show();
            }
        });
    }
}

