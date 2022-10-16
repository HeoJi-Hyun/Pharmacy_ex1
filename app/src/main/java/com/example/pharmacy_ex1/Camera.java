package com.example.pharmacy_ex1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Camera extends AppCompatActivity {
//    Bitmap image; //사용되는 이미지
//    private TessBaseAPI mTess; //Tess API reference
//    String datapath = "" ; //언어데이터가 있는 경로
//    TextView OCRTextView; // OCR 결과뷰
//
//    Button btn;
//    TextView tv1 ,tv2;
    Button btn1;
    TextView tv1, tv2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera);

        tv1 = (TextView) findViewById(R.id.textView5);
        tv2 = (TextView) findViewById(R.id.textView3);

        btn1 = (Button) findViewById(R.id.btnMy2);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        tv1.setText("(3)낙소졸정500/20 밀리그램(한미약품)");
                        tv2.setText("(4)에크로바정 400밀리그람(아시클로버)");
                    }
                },2000);

            }
        });


//        OCRTextView = findViewById(R.id.OCRTextView);
//
//        image = BitmapFactory.decodeResource(getResources(), R.drawable.img_8);
//
//        datapath = getFilesDir()+ "/tesseract/";
//
//        checkFile(new File(datapath + "tessdata/"));
//
//        String lang = "kor";
//        mTess = new TessBaseAPI();
//        mTess.init(datapath, lang);
//    }
//    private void checkFile(File file) {
//    }
//    public void processImage(View view) {
//        String OCRresult = null;
//        mTess.setImage(image);
//        OCRresult = mTess.getUTF8Text();
//
//        OCRTextView.setText(OCRresult);
//    }
//    private void copyFiles() {
//        try{
//            String filepath = datapath + "파일경로";
//            AssetManager assetManager = getAssets();
//            InputStream instream = assetManager.open("파일경로");
//            OutputStream outstream = new FileOutputStream(filepath);
//            byte[] buffer = new byte[1024];
//            int read;
//            while ((read = instream.read(buffer)) != -1) {
//                outstream.write(buffer, 0, read);
//            }
//            outstream.flush();
//            outstream.close();
//            instream.close();
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
