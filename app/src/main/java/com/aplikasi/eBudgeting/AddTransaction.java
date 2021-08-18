package com.aplikasi.eBudgeting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AddTransaction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);
    }

    public void goto_pemasukan(View view) {
        Intent intent = new Intent(AddTransaction.this, BudgetActivity.class);
        startActivity(intent);
    }

    public void goto_pengeluaran(View view) {
        Intent intent = new Intent(AddTransaction.this, TodaySpendingActivity.class);
        startActivity(intent);
    }

    public void cancel_Th(View view) {
        Intent intent = new Intent(AddTransaction.this, MainActivity.class);
        startActivity(intent);
    }
}