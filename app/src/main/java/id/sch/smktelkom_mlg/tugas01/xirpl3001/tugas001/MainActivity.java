package id.sch.smktelkom_mlg.tugas01.xirpl3001.tugas001;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama, etAlamat;
    TextView tvHasil, tvBonus, tvProvinsi;
    Spinner spProvinsi;
    CheckBox cbH, cbJ, cbJH;
    RadioGroup rgType;
    Button bOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etAlamat = (EditText) findViewById(R.id.editTextAlamat);
        spProvinsi = (Spinner) findViewById(R.id.spinnerPemesan);
        rgType = (RadioGroup) findViewById(R.id.radioGroupType);
        cbH = (CheckBox) findViewById(R.id.checkBoxH);
        cbJ = (CheckBox) findViewById(R.id.checkBoxJ);
        cbJH = (CheckBox) findViewById(R.id.checkBoxJH);
        bOK = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvBonus = (TextView) findViewById(R.id.textViewBonus);
        tvProvinsi = (TextView) findViewById(R.id.textViewProvinsi);

        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doProses();

            }
        });

    }

    private void doProses() {
        if (isValid()) {

        }
        String nama = etNama.getText().toString();
        String alamat = etAlamat.getText().toString();
        String hasil = null;
        String bonus = " Bonus yang anda pilih :  \n;


        if (rgType.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton) findViewById(rgType.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }

        if (hasil == null) {
            tvHasil.setText("Belum Mengisi Type Motor");
        } else {
            tvHasil.setText("Type Motor Anda : " + hasil);
        }
        int starlen = bonus.length();
        if (cbH.isChecked())
            bonus += cbH.getText() + "\n";
        if (cbJ.isChecked())
            bonus += cbJ.getText() + "\n";
        if (cbJH.isChecked())
            bonus += cbJH.getText() + "\n";

        if (bonus.length() == starlen)
            bonus += "Tidak ada Bonus";

        tvhasil;
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
