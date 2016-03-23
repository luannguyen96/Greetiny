package com.mluan.app.greetiny;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class FinishCard extends AppCompatActivity{
    private TextView textView;
    private ImageView imageView;
    private String picturePath;
    private Bitmap newBitmap;
    private int number;
    double width;
    double height;
    private int res;
    private int typeShare; // typeShare = 0 -> share custom image, 1 -> share default image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_card);
        imageView = (ImageView) findViewById(R.id.finish_image);
        Bundle extra = getIntent().getExtras();
        String txt = extra.getString("greeting");
        picturePath = extra.getString("picture");
        res = 0;
        typeShare = 1;
        Log.w("path", picturePath);
        if(txt != null)
        {
            textView = (TextView) findViewById(R.id.finish_text);
            Typeface face = Typeface.createFromAsset(getAssets(), "font/Sofia-Regular.otf");
            textView.setTypeface(face);
            textView.setText(txt);
        }

        if (picturePath.compareTo(BuildCard.NO_PATH) == 0){
            res = extra.getInt("imgResource");
            imageView.setImageResource(res);
            typeShare = 1;
//            return;
        }
        else{
            typeShare = 0;
            width = extra.getDouble("width");
            height = extra.getDouble("height");
            number = extra.getInt("number");


            if(picturePath != null)
            {
                Bitmap bitmap = BitmapFactory.decodeFile(picturePath);

                newBitmap = bitmap;
                bitmap = Bitmap.createScaledBitmap(bitmap, (int)width, (int)height, false);

                imageView.setImageBitmap(bitmap);

            }

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e("s", "" + requestCode);
        if (requestCode == 10){
            String path = Environment.getExternalStorageDirectory() + "/Greetiny/temp.png";
            Intent intentShare = new Intent(Intent.ACTION_SEND);
            intentShare.setType("image/*");
            intentShare.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(path)));
            startActivity(intentShare);

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void share(View view)
    {
        String text = textView.getText().toString();
        Intent intent = new Intent(FinishCard.this,ShareCard.class);
        intent.putExtra("greeting", text);
        intent.putExtra("picture", picturePath);
        if (typeShare == 0){
            Bundle bundle = new Bundle();

            intent.putExtra("width",width);
            intent.putExtra("height", height);



        }
        else{
            intent.putExtra("img", res);
        }
 //       startActivity(intent);
        startActivityForResult(intent, 10);
    }
}
