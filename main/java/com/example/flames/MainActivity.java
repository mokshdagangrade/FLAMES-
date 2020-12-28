package com.example.flames;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("SetTextI18n")
    public void goButtonPressed(View view) {
        EditText firstname = (EditText) findViewById(R.id.editTextPerson1);
        EditText secondname = (EditText) findViewById(R.id.editTextPerson2);
        TextView result = (TextView) findViewById(R.id.Result);

        String firstnameString = firstname.getText().toString();
        String secondnameString = secondname.getText().toString();

        String string1 = firstnameString.toLowerCase();
        String string2 = secondnameString.toLowerCase();
        StringBuilder sb1 = new StringBuilder(string1);
        StringBuilder sb2 = new StringBuilder(string2);
        int sb1_len = sb1.length();
        int sb2_len = sb2.length();

        int uncommon_char_count = uncommon_characters_count(sb1,
                sb1_len, sb2, sb2_len);

        StringBuilder str = new StringBuilder("FLAMES");
        int str_len = str.length();
        int idx = 0, flames_count = 0;

        while (str_len > 0) {
            flames_count++;
            if (idx == str_len - 1) {
                idx = 0;
            } else {
                idx++;
            }
            if (flames_count == uncommon_char_count
            ) {
                int j;
                if (idx == 0) {
                    j = str_len - 1;
                } else {
                    j = --idx;
                }
                while (j < str_len - 1) {
                    str.setCharAt(j, str.charAt(j + 1));
                    j++;
                }
                flames_count = 0;
                str_len--;
            }
        }
        char ch = str.charAt(0);
        switch (ch) {
            case 'F': {
                result.setText("Friends");
                result.setBackgroundColor(Color.YELLOW);
                result.setTextColor(Color.BLACK);
                break;
            }
            case 'L': {
                result.setText("Love");
                result.setBackgroundColor(Color.YELLOW);
                result.setTextColor(Color.BLACK);
                break;
            }
            case 'A': {
                result.setText("Affection");
                result.setBackgroundColor(Color.YELLOW);
                result.setTextColor(Color.BLACK);
                break;
            }
            case 'M': {
                result.setText("Marriage");
                result.setBackgroundColor(Color.YELLOW);
                result.setTextColor(Color.BLACK);
                break;
            }
            case 'E': {
                result.setText("Enemy");
                result.setBackgroundColor(Color.YELLOW);
                result.setTextColor(Color.BLACK);
                break;
            }
            case 'S': {
                result.setText("Sibling");
                result.setBackgroundColor(Color.YELLOW);
                result.setTextColor(Color.BLACK);
                break;
            }
        }
    }

    public static int uncommon_characters_count(StringBuilder sb1,
                                                int sb1_len, StringBuilder sb2, int sb2_len) {
        for (int i = 0; i < sb1_len; i++) {
            for (int j = 0; j < sb2_len; j++) {
                if (sb1.charAt(i) == sb2.charAt(j)) {
                    sb1.setCharAt(i, '$');
                    sb2.setCharAt(j, '$');
                    break;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < sb1_len; i++) {
            if (sb1.charAt(i) != '$') {
                count++;
            }
        }
        for (int i = 0; i < sb2_len; i++) {
            if (sb2.charAt(i) != '$') {
                count++;
            }
        }
        return count;
    }
}
