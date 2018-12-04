package com.example.lalthanpuia.directoryapp02;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    public FragmentTransaction ft0,ft1,ft2,ft3,ft4,ft5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );


        spinner = findViewById( R.id.spinner );

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource( this,R.array.department_names,android.R.layout.simple_dropdown_item_1line );

        spinner.setAdapter( adapter );


        spinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("tag","int: "+i);
                //selected_dept = String.valueOf( spinner.getSelectedItem() );

               if(i==1){
                     MizoramHouse();
               }
               else if(i==2){
                       RajBhavan();
                       }
                       else if(i==3){
                       ChiefMinister();
                       }
                       else if(i==4){
                       CouncilOfMinisters();
                       }

                       else if(i==5){
                       MLA();
                       }
                       else if(i==6){
                       PicnicSpot();
                       }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        } );

    }
    public void MizoramHouse(){
         ft0= getSupportFragmentManager().beginTransaction();
                                        ft0.replace( R.id.fragmentContainer,new MizoramHouse() );
                                        ft0.commit();
}

public void RajBhavan(){
        ft1= getSupportFragmentManager().beginTransaction();
                                        ft1.replace( R.id.fragmentContainer,new RajBhavan() );
                                        ft1.commit();
}
public void ChiefMinister(){
        ft2= getSupportFragmentManager().beginTransaction();
                                        ft2.replace( R.id.fragmentContainer,new ChiefMinister() );
                                        ft2.commit();
}
public void CouncilOfMinisters(){
        ft3= getSupportFragmentManager().beginTransaction();
                                        ft3.replace( R.id.fragmentContainer,new CouncilOfMinisters() );
                                        ft3.commit();
}
public void MLA(){
        ft4= getSupportFragmentManager().beginTransaction();
                                        ft4.replace( R.id.fragmentContainer,new MLA() );
                                        ft4.commit();
}

public void PicnicSpot(){
        ft5= getSupportFragmentManager().beginTransaction();
                                        ft5.replace( R.id.fragmentContainer,new picnicSpot() );
                                        ft5.commit();
}
}
