package sg.edu.rp.c346.mylocalbanks;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS, tvOCBC, tvUOB;
    int mode = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.tvdbs);
        tvOCBC = findViewById(R.id.tvocbc);
        tvUOB = findViewById(R.id.tvuob);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        }else if (id == R.id.ChineseSelection) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
            return true;
        }else  {
            tvDBS.setText("Error translation");
            tvOCBC.setText("Error translation");
            tvUOB.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

            menu.add(2,0,0,"Website");
            menu.add(2,1,1,"Contact the Bank");

            if (v.getId() == R.id.tvdbs){
                mode = 1;
            }else if (v.getId() == R.id.tvocbc){
                mode = 2;
            }else if (v.getId() == R.id.tvuob){
                mode = 3;
            }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (mode == 1) {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);

                return true;
            } else if (item.getItemId() == 1) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + 1800 + 1111111));
                startActivity(intent);

                return true;

            }

        }else if (mode ==2) {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);

                return true;
            } else if (item.getItemId() == 1) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + 1800 + 3633333));
                startActivity(intent);

                return true;

            }
        }else if (mode ==3) {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);

                return true;
            } else if (item.getItemId() == 1) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + 1800 + 2222121));
                startActivity(intent);

                return true;

            }
        }
        return super.onContextItemSelected(item);
    }

}
