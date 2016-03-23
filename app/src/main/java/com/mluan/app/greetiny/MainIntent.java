package com.mluan.app.greetiny;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainIntent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_intent);
    }

    public void holiday1(View view)
    {
        Intent intent = new Intent(MainIntent.this,Holiday.class);
        intent.putExtra("number", 1);
        startActivity(intent);
    }

    public void holiday2(View view)
    {
        Intent intent = new Intent(MainIntent.this,Holiday.class);
        intent.putExtra("number",2);
        startActivity(intent);
    }

    public void holiday3(View view)
    {
        Intent intent = new Intent(MainIntent.this,Holiday.class);
        intent.putExtra("number", 3);
        startActivity(intent);
    }

    public void holiday4(View view)
    {
        Intent intent = new Intent(MainIntent.this,Holiday.class);
        intent.putExtra("number",4);
        startActivity(intent);
    }

    public void holiday5(View view)
    {
        Intent intent = new Intent(MainIntent.this,Holiday.class);
        intent.putExtra("number",5);
        startActivity(intent);
    }

    public void holiday6(View view)
    {
        Intent intent = new Intent(MainIntent.this,Holiday.class);
        intent.putExtra("number",6);
        startActivity(intent);
    }


    public void holiday7(View view)
    {
        Intent intent = new Intent(MainIntent.this,Holiday.class);
        intent.putExtra("number",7);
        startActivity(intent);
    }

    public void holiday8(View view)
    {
        Intent intent = new Intent(MainIntent.this,Holiday.class);
        intent.putExtra("number",8);
        startActivity(intent);
    }

    public void holiday9(View view)
    {
        Intent intent = new Intent(MainIntent.this,Holiday.class);
        intent.putExtra("number",9);
        startActivity(intent);
    }


    public void holiday10(View view)
    {
        Intent intent = new Intent(MainIntent.this,Holiday.class);
        intent.putExtra("number",10);
        startActivity(intent);
    }

    public void holiday11(View view)
    {
        Intent intent = new Intent(MainIntent.this,Holiday.class);
        intent.putExtra("number",11);
        startActivity(intent);
    }

    public void holiday12(View view)
    {
        Intent intent = new Intent(MainIntent.this,Holiday.class);
        intent.putExtra("number",12);
        startActivity(intent);
    }

}
