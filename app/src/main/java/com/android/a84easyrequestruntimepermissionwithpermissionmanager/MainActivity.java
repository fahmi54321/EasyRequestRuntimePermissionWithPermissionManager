package com.android.a84easyrequestruntimepermissionwithpermissionmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.karan.churi.PermissionManager.PermissionManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    PermissionManager permissionManager;
    TextView txtDenied,txtGranted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDenied = findViewById(R.id.txtDenied);
        txtGranted = findViewById(R.id.txtGrannted);

        permissionManager = new PermissionManager() {};
        permissionManager.checkAndRequestPermissions(this);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        permissionManager.checkResult(requestCode, permissions, grantResults);

        ArrayList<String> granted = permissionManager.getStatus().get(0).granted;
        ArrayList<String> denied = permissionManager.getStatus().get(0).denied;

        for (String item:granted){
            txtGranted.setText(txtGranted.getText()+"\n"+item);
        }

        for (String item:denied){
            txtDenied.setText(txtDenied.getText()+"\n"+item);
        }
    }
}