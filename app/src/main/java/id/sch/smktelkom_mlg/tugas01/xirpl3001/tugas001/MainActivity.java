package id.sch.smktelkom_mlg.tugas01.xirpl3001.tugas001;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama, etAlamat, etType;
    TextView tvHasil, tvBonus;
    Button bOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etAlamat = (EditText) findViewById(R.id.editTextAlamat);
        etType = (EditText) findViewById(R.id.editTextType);

        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvBonus = (TextView) findViewById(R.id.textViewBonus);

        bOK = (Button) findViewById(R.id.buttonOK);
    }
}
