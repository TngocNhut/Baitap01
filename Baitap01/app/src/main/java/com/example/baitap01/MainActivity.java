package com.example.baitap01;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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
    }
}
