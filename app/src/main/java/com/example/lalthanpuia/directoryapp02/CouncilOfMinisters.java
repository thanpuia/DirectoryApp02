package com.example.lalthanpuia.directoryapp02;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class CouncilOfMinisters extends Fragment {

 String[] numbers = {"03892326197", "03892326197", "03892322147", "03892322538","03892322538","03892322298"};
    String[] name = {"R.Lalzirliana (Home Dept.)", "H.Liansailoa (Agriculture)", "S.Hiato (PHE)", "P.C.Zoramsangliana (Transport)","J.H.Rothuama (Taxation)","Lalsawta (School Education)"};
    public CouncilOfMinisters() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate( R.layout.fragment_raj_bhavan, container, false );
        CustomAdapter customAdapter=new CustomAdapter();

        android.widget.ListView listview = view.findViewById( R.id.listview );

        listview.setAdapter( customAdapter );

        listview.setClickable( true );
        listview.setOnItemClickListener( new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(android.widget.AdapterView<?> adapterView, View view, int i, long l) {
                android.util.Log.i( "TAG", "" + numbers[i] );

                android.content.Intent callIntent = new android.content.Intent(android.content.Intent.ACTION_CALL);
                callIntent.setData( android.net.Uri.parse("tel:"+numbers[i]));

                if (android.support.v4.app.ActivityCompat.checkSelfPermission(getContext(),
                    android.Manifest.permission.CALL_PHONE) != android.content.pm.PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);
            }
        } );

        return view;
    }

          class CustomAdapter extends android.widget.BaseAdapter {
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

            android.widget.TextView textView1= (android.widget.TextView)convertView.findViewById(R.id.textview1_listview);
            android.widget.TextView textView2= (android.widget.TextView)convertView.findViewById(R.id.textview2_listview);

            textView1.setText(name[position]);
            textView2.setText(numbers[position]);
            return convertView;
        }
    }

}
