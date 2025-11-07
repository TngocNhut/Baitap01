package com.example.baitap01;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private EditText edtInput;
    private Button btnReverse;
    private TextView tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        CircleImageView profileImage = findViewById(R.id.profile_image);
        TextView tvName = findViewById(R.id.tv_name);
        TextView tvInfo = findViewById(R.id.tv_info);

        tvName.setText("Trần Ngọc Nhất");
        tvInfo.setText("MSSV: 24162086 - Sinh viên ĐH SPKT TP.HCM");
        profileImage.setImageResource(R.drawable.profile);

        edtInput = findViewById(R.id.edtInput);
        btnReverse = findViewById(R.id.btnReverse);
        tvOutput = findViewById(R.id.tvOutput);

        printEvenOddNumbers();

        if (btnReverse != null) {
            btnReverse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String input = "";
                    if (edtInput != null && edtInput.getText() != null) {
                        input = edtInput.getText().toString();
                    }
                    if (input == null || input.trim().isEmpty()) {
                        Toast.makeText(MainActivity.this, "Vui lòng nhập chuỗi!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    String reversed = reverseWordsPreserveSpaces(input);
                    if (tvOutput != null) tvOutput.setText(reversed);
                    Toast.makeText(MainActivity.this, reversed.toUpperCase(), Toast.LENGTH_LONG).show();
                }
            });
        } else {
            Log.w("MainActivity", "btnReverse not found in layout (id: btnReverse). Skipping string-reverse setup.");
        }
    }

    private void printEvenOddNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();

        for (int n : numbers) {
            if (n % 2 == 0) even.add(n);
            else odd.add(n);
        }

        Log.d("BaiTap01_Even", even.toString());
        Log.d("BaiTap01_Odd", odd.toString());
    }

    private String reverseWordsPreserveSpaces(String s) {
        if (s == null) return null;
        int len = s.length();
        ArrayList<String> tokens = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        boolean inSpace = Character.isWhitespace(s.charAt(0));
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            boolean isSpace = Character.isWhitespace(c);
            if (isSpace == inSpace) {
                cur.append(c);
            } else {
                tokens.add(cur.toString());
                cur.setLength(0);
                cur.append(c);
                inSpace = isSpace;
            }
        }
        tokens.add(cur.toString());
        ArrayList<String> words = new ArrayList<>();
        for (String t : tokens) {
            if (!t.trim().isEmpty() && !Character.isWhitespace(t.charAt(0))) {
                words.add(t);
            }
        }
        Collections.reverse(words);
        StringBuilder out = new StringBuilder();
        int wordIndex = 0;
        for (String t : tokens) {
            if (t.trim().isEmpty()) {
                out.append(t);
            } else {
                out.append(words.get(wordIndex++));
            }
        }
        return out.toString().trim();
    }
}
