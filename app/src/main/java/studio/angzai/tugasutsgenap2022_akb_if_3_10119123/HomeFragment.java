package studio.angzai.tugasutsgenap2022_akb_if_3_10119123;

//Nama : ANGGA CAHYA ABADI
//NIM : 10119123
//Kelas : IF-3

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


public class HomeFragment extends Fragment {
    Toolbar toolbar;
    private RecyclerView recyclerView;
    FloatingActionButton button;
    IAdapter adapter;
    List<Note> notes;

    public HomeFragment() {
        // Required empty public constructor

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.listOfNote);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        button = view.findViewById(R.id.addBtn);
        toolbar = view.findViewById(R.id.toolbar);
        NoteDatabase db = new NoteDatabase(view.getContext());
        notes = db.getNotes();
        adapter = new IAdapter(view.getContext(),notes);
        recyclerView.setAdapter(adapter);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(),AddNoteActivity.class);
                startActivity(i);
            }
        });

        return view;

    }

}