package sg.edu.rp.c346.carapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnRetrieve;
    TextView tvResult;
    EditText etBrand, etLitre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.btnInsert);
        btnRetrieve = findViewById(R.id.btnRetrieve);
        tvResult = findViewById(R.id.tvResult);
        etBrand = findViewById(R.id.etBrand);
        etLitre = findViewById(R.id.etLitre);

        btnInsert.setOnClickListener((v)->{
            DBHelper db = new DBHelper(MainActivity.this);

            String brand = etBrand.getText().toString();
            double litre = Double.parseDouble(etLitre.getText().toString());

            db.insertCar(brand, litre);
            Toast.makeText(this, "Inserted", Toast.LENGTH_SHORT).show();
            db.close();
        });

        btnRetrieve.setOnClickListener((v)->{
            DBHelper db = new DBHelper(MainActivity.this);
            ArrayList<Car> cars = db.getAllCar();
            db.close();

            String text = "";

            for (int i = 0; i < cars.size(); i++) {
                text += "\nBrand: " + cars.get(i).getBrand() + "\nLitre:" + cars.get(i).getLitre() + "\n";
            }
            tvResult.setText(tvResult.getText() + text);

        });


    }
}
