package maulik.letsnurture.savingstatesdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void onButtonClick(View view) {
        if(view.getId() == R.id.btn_normal_demo) {
            startActivity(new Intent(this,NormalActivity.class));
        } else {
            startActivity(new Intent(this,SaveStatesActivity.class));
        }
    }
}
