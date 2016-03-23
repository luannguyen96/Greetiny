package com.mluan.app.greetiny;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Holiday extends AppCompatActivity {
    EditText etxt;
    private int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holiday);
        Bundle extra = getIntent().getExtras();
        number = extra.getInt("number");
        etxt = (EditText)findViewById(R.id.textbox);
        Typeface face = Typeface.createFromAsset(getAssets(),"font/Sofia-Regular.otf");
        etxt.setTypeface(face);
    }

    private int countSpace(String x) {
        int result = 0;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == ' ')
                result++;
        }
        return result;
    }
    public void finish(View view)
    {
        EditText editText =(EditText) findViewById(R.id.textbox);
        String text = editText.getText().toString();
        if(countSpace(text)== editText.getText().length())
        {
            Toast.makeText(getApplicationContext(),"Bạn phải điền đầy đủ thông tin!! ",Toast.LENGTH_LONG).show();
            return;
        }

        if(editText.getText().length() > 20)
        {
            Toast.makeText(getApplicationContext(),"Văn bản quá dài!! Bạn vui lòng nhập lại !",Toast.LENGTH_LONG).show();
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("message",text);
        Intent intent = new Intent(Holiday.this,BuildCard.class);
        bundle.putInt("number",number);
        intent.putExtra("bundle_holiday",bundle);
        startActivity(intent);
    }

    public void cancel(View view)
    {
        finish();
    }
}
