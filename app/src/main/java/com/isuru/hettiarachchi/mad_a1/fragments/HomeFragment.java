package com.isuru.hettiarachchi.mad_a1.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.isuru.hettiarachchi.mad_a1.utils.ModuleAdapter;
import com.isuru.hettiarachchi.mad_a1.utils.ModuleItem;
import com.isuru.hettiarachchi.mad_a1.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private ModuleAdapter adapter;
    private List<ModuleItem> moduleList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Sample Data
        moduleList = new ArrayList<>();
        moduleList.add(new ModuleItem("January", "5", "2025", "Operating System\n 8:00 AM - 10:00 AM\n SF 01\n 1st Year\n"));
        moduleList.add(new ModuleItem("January", "10", "2025", "Data Structures\n 10:00 AM - 12:00 PM\n CS 02\n 1st Year\n"));
        moduleList.add(new ModuleItem("February", "15", "2025", "Algorithms\n 2:00 PM - 4:00 PM\n CS 03\n 1st Year\n"));
        moduleList.add(new ModuleItem("March", "7", "2025", "Networking\n 9:00 AM - 11:00 AM\n SF 02\n 2nd Year\n"));
        moduleList.add(new ModuleItem("March", "21", "2025", "Database Systems\n 11:00 AM - 1:00 PM\n CS 01\n 2nd Year\n"));
        moduleList.add(new ModuleItem("April", "10", "2025", "Software Engineering\n 8:00 AM - 10:00 AM\n SF 01\n 2nd Year\n"));
        moduleList.add(new ModuleItem("April", "18", "2025", "Operating Systems\n 1:00 PM - 3:00 PM\n CS 04\n 3rd Year\n"));
        moduleList.add(new ModuleItem("May", "5", "2025", "Data Structures\n 10:00 AM - 12:00 PM\n SF 03\n 3rd Year\n"));
        moduleList.add(new ModuleItem("June", "12", "2025", "Algorithms\n 3:00 PM - 5:00 PM\n CS 02\n 3rd Year\n"));
        moduleList.add(new ModuleItem("June", "26", "2025", "Networking\n 9:00 AM - 11:00 AM\n SF 02\n 3rd Year\n"));


        adapter = new ModuleAdapter(getContext(), moduleList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}