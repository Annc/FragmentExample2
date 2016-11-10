package com.example.dou.fragmentexample2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Dou on 2016/4/25.
 */
public class MainActivity extends Activity {
    private Button mButtonReplace;
    private Button mButtonRemove;
    private FirstFragment f1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        f1 = new FirstFragment();

        getFragmentManager().beginTransaction().add(R.id.layout_container, f1).commit();
        mButtonReplace = (Button)findViewById(R.id.button1);
        mButtonReplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.layout_container,new SecondFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        mButtonRemove = (Button)findViewById(R.id.button2);
        mButtonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().remove(f1).commit();
            }
        });
    }
}
