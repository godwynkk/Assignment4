package edu.temple.assignment4;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;



public class ColorAdapter extends BaseAdapter {

    String[] colors;
    String[] colors2;
    Context context;

    private LayoutInflater inflater;

    public ColorAdapter(Context context, String[] colors, String[] colors2){
        this.context = context;
        this.colors = colors;
        this.colors2 = colors2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = new TextView(context);

        if (convertView == null) {
            textView = new TextView(context);
        } else {
            textView = (TextView) convertView;
        }

        textView.setText(colors2[position]);
        textView.setBackgroundColor(Color.parseColor(colors[position]));

        return textView;
    }

    @Override
    public int getCount() {

        return colors.length;
    }

    @Override
    public Object getItem(int position) {

        return colors[position];
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }


}
