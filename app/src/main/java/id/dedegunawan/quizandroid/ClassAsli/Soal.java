package id.dedegunawan.quizandroid.ClassAsli;

/**
 * Created by tik on 12/11/17.
 */

public class Soal {
    protected boolean jawaban;
    protected String soal;
    public boolean cekJawaban(boolean jawaban) {
        return this.jawaban == jawaban;
    }
    public Soal(String soal, boolean jawaban) {
        this.soal = soal;
        this.jawaban = jawaban;
    }

    public String getSoal() {
        return soal;
    }

}
