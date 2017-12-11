package id.dedegunawan.quizandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import id.dedegunawan.quizandroid.ClassAsli.Soal;

public class MainActivity extends AppCompatActivity {
    Button buttonSalahCek, buttonBenarCek;
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
        }
        else {
            soalNya.setVisibility(View.GONE);
            buttonSalahCek.setVisibility(View.GONE);
            buttonBenarCek.setVisibility(View.GONE);
            skorNya.setText(String.valueOf(skor));
            skorNya.setVisibility(View.VISIBLE);
            skorKeterangan.setVisibility(View.VISIBLE);
        }
    }

    public void cekJawabanBenar(View view) {
        Soal soal = soals.get(index);
        if (soal.cekJawaban(true)) {
            skor++;
        }
        index++;
        loadSoal();

    }

    public void cekJawabanSalah(View view) {
        Soal soal = soals.get(index);
        if (soal.cekJawaban(false)) {
            skor++;
        }
        index++;
        loadSoal();
    }
}
