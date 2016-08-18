package com.example.ahmme.messmealcalculation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {
    MealInfo mealInfo;
    MealInfoManager manager;
    EditText totalBazarET;
    EditText totalExtraET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        totalBazarET=(EditText)findViewById(R.id.totalBazar);
        totalExtraET=(EditText)findViewById(R.id.totalExtra);
        mealInfo=new MealInfo();
        manager=new MealInfoManager(this);

        /*MealInfo info=manager.getBazarAndExtra();
        totalExtraET.setText(String.valueOf(info.getTotalBazar()));
        totalExtraET.setText(String.valueOf(info.getTotalExtra()));*/
    }


    public void calculate(View view) {
        String bazar=totalBazarET.getText().toString();
        String extra=totalExtraET.getText().toString();
        if(bazar.length()>0 && extra.length()>0){
            mealInfo.setTotalBazar(Float.valueOf(totalBazarET.getText().toString()));
            mealInfo.setTotalExtra(Float.valueOf(totalExtraET.getText().toString()));

            Intent nexPageIntent=new Intent(this,MealResultActivity.class);
            nexPageIntent.putExtra("totalBazar",mealInfo.getTotalBazar());
            nexPageIntent.putExtra("totalExtra",mealInfo.getTotalExtra());
            finish();
            startActivity(nexPageIntent);
        }else {
            Toast.makeText(DialogActivity.this, "Fild is Empty", Toast.LENGTH_SHORT).show();
        }


    }
}
