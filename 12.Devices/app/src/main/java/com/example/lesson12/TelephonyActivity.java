package com.example.lesson12;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lesson12.databinding.ActivityTelephonyBinding;

public class TelephonyActivity extends AppCompatActivity {

    private ActivityTelephonyBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTelephonyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Truy cập thuộc tính Telephony và trạng thái điện thoại
        String srvcName = Context.TELEPHONY_SERVICE;
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(srvcName);

        // Kiểm soát cuộc gọi đến
        // Đã implement trong BroadcastReceiver

        binding.btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Khởi tạo cuộc gọi
                Intent whoYouGonnaCall = new Intent(Intent.ACTION_DIAL);
                whoYouGonnaCall.setData(Uri.parse("tel:555-2368"));
                startActivity(whoYouGonnaCall);
            }
        });

        binding.btnSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Gửi tin nhắn SMS
                try {
                    String sendTo = "900";
                    String myMessage = "Android supports programmatic SMS messaging!";
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(sendTo, null, myMessage, null, null);
                } catch (Exception e) {
                    e.printStackTrace();
                    // Handle the exception (e.g., show a Toast or log it)
                }
            }
        });
    }
}