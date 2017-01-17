package com.example.ammacias.appsorteo.Recycler;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ammacias.appsorteo.Clase.Item;
import com.example.ammacias.appsorteo.Interfaz.IItem;
import com.example.ammacias.appsorteo.MainActivity;
import com.example.ammacias.appsorteo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link IItem}
 * interface.
 */
public class ItemFragmentList extends Fragment {

    // TODO: Customize parameters
    private int mColumnCount = 1;

    private IItem mListener;


    List<Item> listInput;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemFragmentList() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        //Get the List<Item> from MainActivity
        MainActivity ma = (MainActivity)getActivity();
        listInput = ma.getListInput();


        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            listInput = new ArrayList<>();
            recyclerView.setAdapter(new MyItemRecyclerViewAdapter(listInput, mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof IItem) {
            mListener = (IItem) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement IItem");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
