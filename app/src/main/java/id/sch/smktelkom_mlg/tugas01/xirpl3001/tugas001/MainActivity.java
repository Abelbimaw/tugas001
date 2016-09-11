package id.sch.smktelkom_mlg.tugas01.xirpl3001.tugas001;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    EditText etNama, etAlamat, etType;
    TextView tvHasil, tvBonus;
    Spinner spProvinsi, spKota;
    String[][] arKota = {{"Kediri", "Malang", "Blitar", "Tulungagung"}, {"Surakarta", "Klaten", "Yogyakarta"}, {"Bandung", "Depok", "Cirebon"}};

    ArrayList<String> listKota = new ArrayList<>();
    ArrayAdapter<String> adapter;
    RadioButton rbS, rbU, rbM;
    RadioGroup rgType;
    Button bOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etAlamat = (EditText) findViewById(R.id.editTextAlamat);
        etType = (EditText) findViewById(R.id.editTextType);

        spProvinsi = (Spinner) findViewById(R.id.spinnerProvinsi);
        spKota = (Spinner) findViewById(R.id.spinnerKota);

        rbS = (RadioButton) findViewById(R.id.radioButtonS);
        rbU = (RadioButton) findViewById(R.id.radioButtonU);
        rbM = (RadioButton) findViewById(R.id.radioButtonM);
        rgType = (RadioGroup) findViewById(R.id.radioGroupType);

        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvBonus = (TextView) findViewById(R.id.textViewBonus);

        bOK = (Button) findViewById(R.id.buttonOK);

        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doProses();
            }
        });

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listKota);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spKota.setAdapter(adapter);

        spProvinsi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                listKota.clear();
                listKota.addAll(Arrays.asList(arKota[pos]));
                adapter.notifyDataSetChanged();
                spKota.setSelection(0);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


    }


    private void doProses() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            String alamat = etAlamat.getText().toString();
            tvHasil.setText("Nama " + nama + " Beralamat " + alamat + " Kota " + spKota.getSelectedItem().toString() + " Provinsi " + spProvinsi.getSelectedItem().toString());
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String alamat = etAlamat.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama Belum Diisi");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Nama Minimal 3 Karakter");
            valid = false;
        } else {
            etNama.setError(null);
        }
        if (alamat.isEmpty()) {
            etAlamat.setError("Alamat Belum Diisi");
            valid = false;
        } else if (alamat.length() < 3) {
            etAlamat.setError("Nama Minimal 3 Karakter");
            valid = false;
        } else {
            etAlamat.setError(null);
        }

        return valid;
    }
}
