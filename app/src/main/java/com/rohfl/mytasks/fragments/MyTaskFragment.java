package com.rohfl.mytasks.fragments;

import com.rohfl.mytasks.R;
import com.rohfl.mytasks.adapters.TaskAdapter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyTaskFragment extends Fragment {

    // variables
    private String[] taskArray;
    // initializing the image urls
    private String[] imageUrls = {
            "https://i.picsum.photos/id/946/200/200.jpg?hmac=a01jNqgHjp0Vj_csHXBpEttrSyo1vFrUTL1fwgKYG0Y",
            "https://i.picsum.photos/id/672/200/200.jpg?hmac=Lxbn4Lr7MXAJeCswWkTG9-O-DaafCb75aUGSBrd3ZWU",
            "https://i.picsum.photos/id/210/200/200.jpg?hmac=ofnpd0LAPvyH0juHuFCaLU6Y6jqJe4qpuc90jXbzUjY",
            "https://i.picsum.photos/id/995/200/200.jpg?hmac=C_VYf8uWBpaP3GWRI8MP0fMrXh0CR4Y9EgSf7hYhX1E",
            "https://i.picsum.photos/id/9/200/200.jpg?hmac=KeGvZtsfErXTVxRSy5Kev3vLnJBdBYcYoGviv8RE5Vk",
            "https://i.picsum.photos/id/117/200/200.jpg?hmac=hAXY0lMbkjkxYIKxW0UjtazVquGY1NCu3ruHLJGc4gs",
            "https://i.picsum.photos/id/942/200/200.jpg?hmac=Gh7W-H3ZGmweB9STLwQvq-IHkxrVyawHVTKYxy-u9mA",
            "https://i.picsum.photos/id/386/200/200.jpg?hmac=mPGpmd8a-dSFGBZWTzakrKK9snUfEYI764cWc7zihrg",
            "https://i.picsum.photos/id/473/200/200.jpg?hmac=lXsJQxtsh73ygSCMmcWA-YqIpQ4FjdxUYkkuLTAPBfM",
            "https://i.picsum.photos/id/268/200/200.jpg?hmac=I5JAWzISJc5x0jlDhEngvCIwyM0zxRh22iIIzHqOT80"
    };

    // views
    private RecyclerView recyclerView;


    public MyTaskFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_my_task, container, false);;

        // getting the tasks array from the strings.xml file
        taskArray = getActivity().getResources().getStringArray(R.array.my_tasks);

        // getting the recyclerview
        recyclerView = (RecyclerView) v.findViewById(R.id.task_recycler_view);

        // setting adapter
        TaskAdapter taskAdapter = new TaskAdapter(taskArray,imageUrls,getActivity());
        recyclerView.setAdapter(taskAdapter);

        //setting layout
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerView.setHasFixedSize(true);


        return v ;
    }
}