package nakamd.washington.edu.lifecounter;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Playah one = new Playah(getString(R.string.p1), (Button) findViewById(R.id.button),
                (Button) findViewById(R.id.button2), (Button) findViewById(R.id.button3),
                (Button) findViewById(R.id.button4), (TextView) findViewById(R.id.One));
        Playah two = new Playah(getString(R.string.p2), (Button) findViewById(R.id.button5),
                (Button) findViewById(R.id.button6), (Button) findViewById(R.id.button7),
                (Button) findViewById(R.id.button8), (TextView) findViewById(R.id.Two));
        Playah three = new Playah(getString(R.string.p3), (Button) findViewById(R.id.button9),
                (Button) findViewById(R.id.button10), (Button) findViewById(R.id.button11),
                (Button) findViewById(R.id.button12), (TextView) findViewById(R.id.Three));
        Playah four = new Playah(getString(R.string.p4), (Button) findViewById(R.id.button13),
                (Button) findViewById(R.id.button14), (Button) findViewById(R.id.button15),
                (Button) findViewById(R.id.button16), (TextView) findViewById(R.id.Four));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class Playah {
        private int life;
        private String name;
        private Button plus;
        private Button minus;
        private Button p5;
        private Button m5;
        private TextView text;

        public Playah(String name, Button plus, Button minus, Button p5, Button m5, TextView text) {
            life = 20;
            this.name = name;
            this.plus = plus;
            this.minus = minus;
            this.p5 = p5;
            this.m5 = m5;
            this.text = text;
            setActions(this.plus, 1);
            setActions(this.minus, -1);
            setActions(this.p5, 5);
            setActions(this.m5, -5);
        }

        public String getName() {
            return name;
        }

        public boolean isAlive() {
            return life > 0;
        }

        private void setActions(Button button, final int amount) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    changeLife(amount);
                    text.setText("Lives = " + getLife());
                    if (!isAlive()) {
                        TextView tv = (TextView) findViewById(R.id.textView5);
                        tv.setText("Player " + name + " LOSES!");

                    }
                }
            });
        }

        private void changeLife(int increment) {
            life += increment;
        }

        public int getLife() {
            return life;
        }
    }
}
