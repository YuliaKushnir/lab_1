package com.example.lab_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private RadioButton radioButton;
    private RadioGroup radioGroup;
    private CheckBox checkBox, checkBox2, checkBox3;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        checkBox = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView4);
    }

    public void onClickOk(View view) {

        int selectedId = radioGroup.getCheckedRadioButtonId();

        if (selectedId == -1) {
            Toast.makeText(this, "Завершіть введення всіх даних", Toast.LENGTH_SHORT).show();
            return;
        }

        radioButton = findViewById(selectedId);

        String result = "Подробиці замовлення: Маргарита\n\n";
        result += "Діаметр: " + radioButton.getText() + "\n\n";
        result += "Додатково:\n";

        boolean hasOption = false;

        if (checkBox.isChecked()) {
            result += "- Додатковий сир\n";
            hasOption = true;
        }

        if (checkBox2.isChecked()) {
            result += "- Безглютенове тісто\n";
            hasOption = true;
        }

        if (checkBox3.isChecked()) {
            result += "- Борт хот-дог\n";
            hasOption = true;
        }

        if (!hasOption) {
            Toast.makeText(this, "Оберіть хоча б одну додаткову опцію", Toast.LENGTH_SHORT).show();
            return;
        }

        textView.setText(result);
    }
}