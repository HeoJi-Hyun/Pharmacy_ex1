package com.example.pharmacy_ex1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class AA extends AppCompatActivity
{
    private final String TAG = this.getClass().getSimpleName();

    ImageView imageview;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac);


        imageview = findViewById(R.id.imageview);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            launcher.launch(intent);
        });
    }

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>()
            {
                @Override
                public void onActivityResult(ActivityResult result)
                {
                    if (result.getResultCode() == RESULT_OK)
                    {
                        Log.e(TAG, "result : " + result);
                        Intent intent = result.getData();
                        Log.e(TAG, "intent : " + intent);
                        Uri uri = intent.getData();
                        Log.e(TAG, "uri : " + uri);
//                        imageview.setImageURI(uri);
                        Glide.with(AA.this)
                                .load(uri)
                                .into(imageview);

                    }
                }
            });

}
