package com.luvizatnika1501512.utsmobprog.quiz51501512;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<ModalMahasiswa> mahasiswaItems;

    public CustomListAdapter(Activity activity, List<ModalMahasiswa> mahasiswaItems){
        this.activity = activity;
        this.mahasiswaItems = mahasiswaItems;
    }

    @Override
    public int getCount() {
        return mahasiswaItems.size();
    }

    @Override
    public Object getItem(int location) {
        return mahasiswaItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);

        TextView nama = (TextView) convertView.findViewById(R.id.nama);
        TextView alamat = (TextView) convertView.findViewById(R.id.alamat);



        ModalMahasiswa m = mahasiswaItems.get(position);

        nama.setText("Nama :"+ m.get_nama());
        alamat.setText("alamat :"+ m.get_alamat());


        return convertView;
    }
}
