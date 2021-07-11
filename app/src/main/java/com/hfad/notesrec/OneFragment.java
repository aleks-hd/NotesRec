package com.hfad.notesrec;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class OneFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    int[] pictures;
    ArrayList<Note> arrayList;
    Note note;


    public OneFragment() {

    }


    public static OneFragment newInstance(String param1, String param2) {
        OneFragment fragment = new OneFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        initRecycle(view);
        return view;
    }

    private void initRecycle(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        initListArray();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        Spisok adapter = new Spisok(arrayList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new Spisok.OnItemClickListener(){

            @Override
            public void onItemClick(View view, int position) {

                Toast.makeText(getContext(),(String.format("%s - %d",((TextView)view).getText(),position)), Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        super.onViewCreated(view, savedInstanceState);
    }

    public void initListArray() {

        arrayList = new ArrayList<>();
        String[] array = getResources().getStringArray(R.array.nameArray);
        pictures = getImageArray();
        for (int i = 0; i < array.length; i++) {
            note = new Note();
            String name = array[i];
            note.setImage(pictures[i]);
            note.setName(name);
            arrayList.add(note);
        }

        Log.d("SIZEARRAYLIST", " " + arrayList.size());

    }

    private int[] getImageArray(){

        TypedArray arraImage = getResources().obtainTypedArray(R.array.arrayImages);
        int length = arraImage.length();
        int[] answer = new int[length];
        for (int i = 0; i < arraImage.length(); i++) {
            answer[i] = arraImage.getResourceId(i, 0);
        }
    return answer;
    }

}