package com.ifsc.mypaint;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private PaintView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mView = findViewById(R.id.mPaint);
    }

    public void changeToRed(View view){
        mView.changeColorBrushTool(Color.RED);
    }

    public void changeToGreen(View view){
        mView.changeColorBrushTool(Color.GREEN);
    }

    public void changeToBlue(View view){
        mView.changeColorBrushTool(Color.BLUE);
    }
}