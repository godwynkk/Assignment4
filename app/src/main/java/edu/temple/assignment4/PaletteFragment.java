package edu.temple.assignment4;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;


public class PaletteFragment extends Fragment {

    ColorListener select;


    public PaletteFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ColorListener) {
            select = (ColorListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " you must create an OnFragmentInteractionListener");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_palette, container, false);
        Context context = getActivity();

        Resources res = context.getResources();
        final String[] gridLabels = res.getStringArray(R.array.array1);
        final String[] gridLabels2 = res.getStringArray(R.array.array2);
        GridView gridview =  v.findViewById(R.id.gridView);





        ColorAdapter adapter = new ColorAdapter(context, gridLabels, gridLabels2);

        gridview.setAdapter(adapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = parent.getItemAtPosition(position).toString();
                select.setColor(s);
            }
        });
        return v;
    }





}