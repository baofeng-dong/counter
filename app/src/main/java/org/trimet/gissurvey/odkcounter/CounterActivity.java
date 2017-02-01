package org.trimet.gissurvey.odkcounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class CounterActivity extends AppCompatActivity {

    private ImageButton remove;
    private ImageButton removeJumper;
    private ImageButton add;
    private ImageButton addJumper;
    private TextView textView;
    private TextView textViewJumper;
    private Integer counter = 0;
    private Integer counterJumper = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        remove = (ImageButton) findViewById(R.id.remove_one);
        add = (ImageButton) findViewById(R.id.add_one);
        textView = (TextView) findViewById(R.id.counter);
        removeJumper = (ImageButton) findViewById(R.id.remove_one_jumper);
        addJumper = (ImageButton) findViewById(R.id.add_one_jumper);
        textViewJumper = (TextView) findViewById(R.id.jumpers);

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (counter > 0) {
                    counter = counter - 1;
                    textView.setText(counter.toString());
                }
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = counter + 1;
                textView.setText(counter.toString());
            }
        });


        removeJumper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (counterJumper > 0) {
                    counterJumper = counterJumper - 1;
                    textViewJumper.setText(counterJumper.toString());
                }
            }
        });

        addJumper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterJumper = counterJumper + 1;
                textViewJumper.setText(counterJumper.toString());
            }
        });
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
            Log.d("counterLog","has fare:"+counter.toString()
            );

            Intent intent = new Intent();
            int result = this.RESULT_OK;
            intent.putExtra("has_fare", counter);
            intent.putExtra("jumpers",counterJumper);
            this.setResult(result, intent);
            this.finish();
        }
        return false;
    }
}
