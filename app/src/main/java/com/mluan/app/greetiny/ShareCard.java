package com.mluan.app.greetiny;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;

public class ShareCard extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageView;
    private TextView textView;
    private double width;
    private double height;
    private String picturePath;
    private ImageView btShareByFB;
    private View view;
    private double a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_card);
        imageView = (ImageView) findViewById(R.id.imageShare);
        view = getWindow().getDecorView();


        btShareByFB = (ImageView) findViewById(R.id.imageShare);
        btShareByFB.setOnClickListener(this);


        Bundle extra = getIntent().getExtras();
        String txt = extra.getString("greeting");
        picturePath = extra.getString("picture");
        if(txt != null)
        {
            textView = (TextView) findViewById(R.id.textShare);
            Typeface face = Typeface.createFromAsset(getAssets(), "font/Sofia-Regular.otf");
            textView.setTypeface(face);
            textView.setText(txt);
        }

        if (picturePath.compareTo(BuildCard.NO_PATH) == 0){
            int rs = extra.getInt("img");
            imageView.setImageResource(rs);
        }else {
            width = extra.getDouble("width");
            height = extra.getDouble("height");



            if (picturePath != null) {

                Bitmap bitmap = BitmapFactory.decodeFile(picturePath);

                bitmap = Bitmap.createScaledBitmap(bitmap, (int) width, (int)height, false);

                imageView.setImageBitmap(bitmap);

            }
        }

        new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                takeScreenshot(view);
            }
        }.start();
    }


    private void shareFB() {

        Bitmap bitmapCustom = getScreenShot(view);
        String path = save(bitmapCustom);
        Log.e("Path", path);

        finish();

//        Intent intentShare = new Intent(Intent.ACTION_SEND);
//        intentShare.setType("image/*");  // neu cho nay la file png thi k dc a chu
//        intentShare.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(path)));
//        startActivity(intentShare);
    }



    private Bitmap getScreenShot(View v){
        View screen = v.getRootView();
        screen.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(screen.getDrawingCache());
        screen.setDrawingCacheEnabled(false);
        return bitmap;
    }

    private String save(Bitmap bitmap){
        String path = Environment.getExternalStorageDirectory() + "/Greetiny";
        File fileInfor = new File(path);
        if (!fileInfor.exists()){
            fileInfor.mkdirs();
        }
        String fileName = "temp.png";
        File file = new File(fileInfor, fileName);
        try{
            FileOutputStream fout = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fout);
            fout.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return path + "/" + fileName;
    }
    public void takeScreenshot(View view)
    {
        onClick(view);
    }

    @Override
    public void onClick(View v) {

        shareFB();
    }
}
