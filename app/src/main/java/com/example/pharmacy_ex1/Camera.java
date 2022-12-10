package com.example.pharmacy_ex1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.googlecode.tesseract.android.TessBaseAPI;
import java.io.File;

import android.content.res.AssetManager;

import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.media.ExifInterface;

import android.os.Environment;

import android.util.Log;

import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.ActivityCompat;


public class Camera extends AppCompatActivity implements View.OnClickListener {

    Bitmap image; //사용되는 이미지
    private TessBaseAPI mTess; //Tess API reference
    String datapath = ""; //언어데이터가 있는 경로

    Button btn_picture; //사진 찍는 버튼
    Button btn_ocr; //텍스트 추출 버튼
    Button btn_gal;
    Button btn_my;
    Button Home, Mypage;
    TextView tv;
    String text;

    private String imageFilePath; //이미지 파일 경로
    private Uri p_Uri;

    static final int REQUEST_IMAGE_CAPTURE = 672;
    ImageView imageView;

    private final String TAG = this.getClass().getSimpleName();

    final static int TAKE_PICTURE = 1;
    final static int CROP_PICTURE = 2;
    private Uri pictureUri;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera);

        btn_picture = (Button) findViewById(R.id.btnPhoto);
        btn_ocr = (Button) findViewById(R.id.ocrButton);
        imageView = (ImageView) findViewById(R.id.imageView);
        btn_gal = (Button) findViewById(R.id.btnGal);
        btn_picture.setOnClickListener(this);
        btn_my = (Button)findViewById(R.id.mypage);
        tv = (TextView)findViewById(R.id.OCRTextView);
        Home = (Button)findViewById(R.id.Home);
        Mypage = (Button)findViewById(R.id.Mypage);

        //언어파일 경로
        datapath = getFilesDir() + "/tesseract/";

        //트레이닝데이터가 카피되어 있는지 체크
        checkFile(new File(datapath + "tessdata/"), "kor");
        checkFile(new File(datapath + "tessdata/"), "eng");
        String lang = "kor+eng";

        mTess = new TessBaseAPI();
        mTess.init(datapath, lang);

        //Uri exposure 무시
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        //권한 요청
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){ //안드로이드 버전확인
            //권한 허용이 됐는지 확인
            if(checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {

            }
            else { //권한 허용 요청
                ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
            }
        }
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Camera.this, Home.class);
                startActivity(a);
            }
        });

        Mypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(Camera.this, Mypage.class);
                startActivity(b);
            }
        });


        btn_my.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text = tv.getText().toString();
                Intent intent = new Intent(getApplicationContext(), Main.class);
                intent.putExtra("a", text);
                startActivity(intent);
            }
        });


        // 텍스트 추출 버튼
        btn_ocr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 가져와진 사진을 bitmap으로 추출
                BitmapDrawable d = (BitmapDrawable) ((ImageView) findViewById(R.id.imageView)).getDrawable();
                image = d.getBitmap();

                String OCRresult = null;
                mTess.setImage(image);

                //텍스트 추출
                OCRresult = mTess.getUTF8Text();
                TextView OCRTextView = (TextView) findViewById(R.id.OCRTextView);
                OCRTextView.setText(OCRresult);
            }
        });
        //갤러리 실행
        btn_gal.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            launcher.launch(intent);
        });
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED && grantResults[2] == PackageManager.PERMISSION_GRANTED){

        }
    }
    ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        Log.e(TAG, "result : " + result);
                        Intent intent = result.getData();
                        Log.e(TAG, "intent : " + intent);
                        Uri uri = intent.getData();
                        Log.e(TAG, "uri : " + uri);
//                        imageview.setImageURI(uri);
                        Glide.with(Camera.this)
                                .load(uri)
                                .into(imageView);
                    }
                }
            });

    private int exifOrientationToDegrees(int exifOrientation) {
        if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_90) {
            return 90;
        } else if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_180) {
            return 180;
        } else if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_270) {
            return 270;
        }
        return 0;
    }

    private Bitmap rotate(Bitmap bitmap, float degree) {
        Matrix matrix = new Matrix();
        matrix.postRotate(degree);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            //크롭된 이미지 가져와서 이미지뷰에 보여주기
            case TAKE_PICTURE:
                if (resultCode == RESULT_OK && data.hasExtra("data")) { //데이터를 가지고 있는지 확인
                    final Bundle extras = data.getExtras();

                    if (extras != null) {
                        Bitmap photo = extras.getParcelable("data"); //크롭한 이미지 가져오기
                        imageView.setImageBitmap(photo); //이미지뷰에 넣기
                    }

                    // 임시 파일 삭제
                    File f = new File(pictureUri.getPath());
                    if (f.exists())
                        f.delete();

                    break;
                }
                break;

            // 이미지 크롭
            case CROP_PICTURE: {
                // 이미지를 가져온 이후의 리사이즈할 이미지 크기를 결정합니다.
                // 이후에 이미지 크롭 어플리케이션을 호출하게 됩니다.

                Intent intent = new Intent("com.android.camera.action.CROP");
                intent.setDataAndType(pictureUri, "image/*");

                intent.putExtra("outputX", 200); //크롭한 이미지 x축 크기
                intent.putExtra("outputY", 200); //크롭한 이미지 y축 크기
                intent.putExtra("aspectX", 1); //크롭 박스의 x축 비율
                intent.putExtra("aspectY", 1); //크롭 박스의 y축 비율
                intent.putExtra("scale", true);
                intent.putExtra("return-data", true);
                startActivityForResult(intent, TAKE_PICTURE);
                break;
            }
        }

        if(requestCode == 0 && resultCode == RESULT_OK) {
            // Bundle로 데이터를 입력
            Bundle extras = data.getExtras();
            // Bitmap으로 컨버전
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            // 이미지뷰에 Bitmap으로 이미지를 입력
            imageView.setImageBitmap(imageBitmap);
        }

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            ((ImageView) findViewById(R.id.imageView)).setImageURI(p_Uri);
            ExifInterface exif = null;

            Bitmap bitmap = BitmapFactory.decodeFile(imageFilePath);
            try {
                exif = new ExifInterface(imageFilePath);
            } catch (IOException e) {
                e.printStackTrace();
            }

            int exifOrientation;
            int exifDegree;

            if (exif != null) {
                exifOrientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
                exifDegree = exifOrientationToDegrees(exifOrientation);
            } else {
                exifDegree = 0;
            }
            ((ImageView) findViewById(R.id.imageView)).setImageBitmap(rotate(bitmap, exifDegree));
        }
    }

    private File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "TEST_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,      /* prefix */
                ".jpg",         /* suffix */
                storageDir          /* directory */
        );
        imageFilePath = image.getAbsolutePath();
        return image;
    }

    //장치에 파일 복사
    private void copyFiles(String lang) {
        try {
            //파일이 있을 위치
            String filepath = datapath + "/tessdata/" + lang + ".traineddata";

            //AssetManager에 액세스
            AssetManager assetManager = getAssets();

            //읽기/쓰기를 위한 열린 바이트 스트림
            InputStream instream = assetManager.open("tessdata/" + lang + ".traineddata");
            OutputStream outstream = new FileOutputStream(filepath);

            //filepath에 의해 지정된 위치에 파일 복사
            byte[] buffer = new byte[1024];
            int read;

            while ((read = instream.read(buffer)) != -1) {
                outstream.write(buffer, 0, read);
            }
            outstream.flush();
            outstream.close();
            instream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //check file on the device
    private void checkFile(File dir, String lang) {
        //디렉토리가 없으면 디렉토리를 만들고 그후에 파일을 카피
        if (!dir.exists() && dir.mkdirs()) {
            copyFiles(lang);
        }
        //디렉토리가 있지만 파일이 없으면 파일카피 진행
        if (dir.exists()) {
            String datafilepath = datapath + "/tessdata/" + lang + ".traineddata";
            File datafile = new File(datafilepath);
            if (!datafile.exists()) {
                copyFiles(lang);
            }
        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            // 버튼 눌렀을 때, 카메라에서 이미지 가져오기
            case R.id.btnPhoto:
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                // 임시로 사용할 파일의 경로를 생성
                String url = "tmp_" + String.valueOf(System.currentTimeMillis()) + ".jpg";
                pictureUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), url));

                cameraIntent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, pictureUri);
                cameraIntent.putExtra("return-data", true);
                startActivityForResult(cameraIntent, CROP_PICTURE);
                break;
        }
//        switch (view.getId()) {
//            // 카메라촬영 클릭 이벤트
//            case R.id.btnPhoto:
//                // 카메라 기능을 Intent
//                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(i, 0);
//                break;
//        }
    }
}

