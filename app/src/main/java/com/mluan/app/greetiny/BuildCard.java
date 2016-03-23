package com.mluan.app.greetiny;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BuildCard extends AppCompatActivity {
    private TextView receivetxt;
    private ImageView myImage;
    private int number;
    private String picPath;
    private int res;
    public final static String NO_PATH  = "noPath";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_card);
        Intent intent = getIntent();
        Bundle getpackage = intent.getBundleExtra("bundle_holiday");
        String txt = getpackage.getString("message");

        picPath = NO_PATH;

        number = getpackage.getInt("number");
        receivetxt = (TextView) findViewById(R.id.textOnCard);
        Typeface face = Typeface.createFromAsset(getAssets(), "font/Sofia-Regular.otf");
        receivetxt.setTypeface(face);
        receivetxt.setText(txt);

        switch (number)
        {
            case 1:
                myImage = (ImageView)findViewById(R.id.imageBox);
                res = R.drawable.holiday_1;
                myImage.setImageResource(R.drawable.holiday_1);
                break;
            case 2:
                myImage = (ImageView)findViewById(R.id.imageBox);
                res = R.drawable.holiday_2;
                myImage.setImageResource(R.drawable.holiday_2);
                break;
            case 3:
                myImage = (ImageView)findViewById(R.id.imageBox);
                res = R.drawable.holiday_3;
                myImage.setImageResource(R.drawable.holiday_3);
                break;
            case 4:
                myImage = (ImageView)findViewById(R.id.imageBox);
                res = R.drawable.holiday_4;
                myImage.setImageResource(R.drawable.holiday_4);
                break;
            case 5:
                myImage = (ImageView)findViewById(R.id.imageBox);
                res = R.drawable.holiday_5;
                myImage.setImageResource(R.drawable.holiday_5);
                break;
            case 6:
                myImage = (ImageView)findViewById(R.id.imageBox);
                res = R.drawable.holiday_6;
                myImage.setImageResource(R.drawable.holiday_6);
                break;
            case 7:
                myImage = (ImageView)findViewById(R.id.imageBox);
                res = R.drawable.holiday_7;
                myImage.setImageResource(R.drawable.holiday_7);
                break;
            case 8:
                myImage = (ImageView)findViewById(R.id.imageBox);
                res = R.drawable.holiday_8;
                myImage.setImageResource(R.drawable.holiday_8);
                break;
            case 9:
                myImage = (ImageView)findViewById(R.id.imageBox);
                res = R.drawable.holiday_9;
                myImage.setImageResource(R.drawable.holiday_9);
                break;
            case 10:
                myImage = (ImageView)findViewById(R.id.imageBox);
                res = R.drawable.holiday_10;
                myImage.setImageResource(R.drawable.holiday_10);
                break;
            case 11:
                myImage = (ImageView)findViewById(R.id.imageBox);
                res = R.drawable.holiday_11;

                myImage.setImageResource(R.drawable.holiday_11);
                break;
            case 12:
                myImage = (ImageView)findViewById(R.id.imageBox);
                res = R.drawable.holiday_12;

                myImage.setImageResource(R.drawable.holiday_12);

                break;
        }

   //     String pictureString = myImage.toString();



     //   picPath = pictureString;

    }


    public void gallery(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 1);
    }

    private ImageView imageView;

    double widthOfImage;
    double heightOfImage;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            picPath = picturePath;
            cursor.close();
            imageView = (ImageView) findViewById(R.id.imageBox);


            Bitmap bitmap = BitmapFactory.decodeFile(picturePath);
            final float scaleTo = 500;
            // tính độ scale
           /* double scaleW = 0, scaleH = 0;
            if (bitmap.getWidth() > bitmap.getHeight()){
                scaleW = scaleTo;
                scaleH = (scaleTo * bitmap.getHeight() * 1.0)/ bitmap.getWidth();
            }
            else{
                scaleH = scaleTo;
                scaleW = (scaleTo * bitmap.getWidth() * 1.0)/ bitmap.getHeight();
            }
            bitmap = Bitmap.createScaledBitmap(bitmap, (int)scaleW, (int)scaleH, false);
            imageView.setImageBitmap(bitmap);*/

            widthOfImage = imageView.getWidth();
            heightOfImage = imageView.getHeight();


            bitmap = Bitmap.createScaledBitmap(bitmap, (int) widthOfImage, (int) heightOfImage, false);
            imageView.setImageBitmap(bitmap);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void done(View view) {
        String text = receivetxt.getText().toString();
        Intent intent = new Intent(BuildCard.this,FinishCard.class);
        intent.putExtra("greeting",text);
        if (picPath == NO_PATH)
            intent.putExtra("imgResource", res);
        intent.putExtra("picture", picPath);
        intent.putExtra("width",widthOfImage);
        intent.putExtra("height",heightOfImage);
        startActivity(intent);

    }
}
