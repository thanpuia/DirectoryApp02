package com.example.lalthanpuia.directoryapp02;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class




MizoramHouse extends Fragment {
    String[] numbers = {"01126153563", "03324615887", "022 65784852", "03612529441","03642502868","03842226166","01126153563"};
    String[] name = {"New Delhi ", "Kolkata", "Mumbai", "Guwahati","Shillong","Silchar","Vellor"};

    public MizoramHouse() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate( R.layout.fragment_mizoram_house, container, false );
        CustomAdapter customAdapter=new CustomAdapter();

        ListView listview = view.findViewById( R.id.listview );

        listview.setAdapter( customAdapter );

        listview.setClickable( true );
        listview.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i( "TAG", "" + numbers[i] );

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData( Uri.parse("tel:"+numbers[i]));

                if (ActivityCompat.checkSelfPermission(getContext(),
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);
            }
        } );

        return view;
    }
    class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            // return 0;
            return name.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView= getLayoutInflater().inflate(R.layout.list_details,null);

            TextView textView1= (TextView)convertView.findViewById(R.id.textview1_listview);
            TextView textView2= (TextView)convertView.findViewById(R.id.textview2_listview);

            textView1.setText(name[position]);
            textView2.setText(numbers[position]);
            return convertView;
        }
    }
}
