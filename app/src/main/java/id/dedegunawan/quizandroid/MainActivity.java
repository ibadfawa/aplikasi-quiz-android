package id.dedegunawan.quizandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import id.dedegunawan.quizandroid.ClassAsli.Soal;

public class MainActivity extends AppCompatActivity {
    Button buttonSalahCek, buttonBenarCek, resetSoal;
    TextView soalNya, skorNya, skorKeterangan;
    public int skor=0;
    public int index=0;
    public ArrayList<Soal> soals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSalahCek = findViewById(R.id.buttonSalahCek);
        buttonBenarCek = findViewById(R.id.buttonBenarCek);
        soalNya = findViewById(R.id.soalNya);
        skorNya = findViewById(R.id.skorNya);
        skorKeterangan = findViewById(R.id.skorKeterangan);
        resetSoal = findViewById(R.id.resetSoal);


        skor=0;
        index=0;

        soals = new ArrayList<>();

        soals.add(new Soal("Apakah Jakarta Ibu Kota Indonesia ?", true));
        soals.add(new Soal("Apakah Indonesia negara ASEAN ?", true));
        soals.add(new Soal("Apakah Jokowi Presiden Inggris ?", false));

        loadSoal();

    }

    public void loadSoal() {
        int jumlahSoal = soals.size();
        if (index < jumlahSoal) {
            Soal soal = soals.get(index);
            soalNya.setText(String.valueOf(soal.getSoal()));
            skorKeterangan.setVisibility(View.GONE);
            skorNya.setVisibility(View.GONE);
            resetSoal.setVisibility(View.GONE);
            soalNya.setVisibility(View.VISIBLE);
            buttonSalahCek.setVisibility(View.VISIBLE);
            buttonBenarCek.setVisibility(View.VISIBLE);
        }
        else {
            soalNya.setVisibility(View.GONE);
            buttonSalahCek.setVisibility(View.GONE);
            buttonBenarCek.setVisibility(View.GONE);
            skorNya.setText(String.valueOf(skor));
            skorNya.setVisibility(View.VISIBLE);
            skorKeterangan.setVisibility(View.VISIBLE);
            resetSoal.setVisibility(View.VISIBLE);

        }
    }

    public void cekJawabanBenar(View view) {
        Soal soal = soals.get(index);
        if (soal.cekJawaban(true)) {
            Toast.makeText(MainActivity.this, "Jawaban Anda Benar", Toast.LENGTH_SHORT)
                .show();
            skor++;
        }
        else {
            Toast.makeText(MainActivity.this, "Jawaban Anda Salah", Toast.LENGTH_SHORT)
                    .show();
        }
        index++;
        loadSoal();

    }



    public void cekJawabanSalah(View view) {
        Soal soal = soals.get(index);
        if (soal.cekJawaban(false)) {
            Toast.makeText(MainActivity.this, "Jawaban Anda Benar", Toast.LENGTH_SHORT)
                    .show();
            skor++;
        }
        else {
            Toast.makeText(MainActivity.this, "Jawaban Anda Salah", Toast.LENGTH_SHORT)
                    .show();
        }
        index++;
        loadSoal();
    }

    public void resetJawaban(View view) {
        index=0;
        skor=0;
        loadSoal();
    }
}
