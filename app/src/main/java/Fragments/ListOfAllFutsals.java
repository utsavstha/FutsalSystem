package Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.utsavstha.futsalbook.R;
import java.util.ArrayList;
import java.util.List;
import Adapters.RVAdapter;
import Utils.DBHelper;
import Utils.InformationData;
import Utils.RecyclerTouchListener;
import Utils.T;

/**
 * Created by utsav on 8/24/2015.
 */
public class ListOfAllFutsals  extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private T t;
    private RecyclerView recyclerView;  //recycler view variable
    private SwipeRefreshLayout swipeRefreshLayout;
    private List<InformationData> listData = new ArrayList<>() ; //creating list of the information data class
    private DBHelper dbHelper;
    public ListOfAllFutsals() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        t = new T();
        dbHelper = new DBHelper(getActivity());

        View view = inflater.inflate(R.layout.fragment_futsal_list, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.rv_list);

        swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.swipe_to_refresh);

        swipeRefreshLayout.setOnRefreshListener(this);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity()); //this will make the recycler view work as list view

        recyclerView.setLayoutManager(llm);

        populateRecyclerViewFromDB();

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                t.showS(getActivity(), "clicked "+ position);
            }

            @Override
            public void onLongClick(View view, int position) {
                t.showS(getActivity(), "long clicked");
            }
        }));

        return view;
    }

    private void populateRecyclerViewFromDB() {

        listData = dbHelper.viewAllData();

        RVAdapter adapter = new RVAdapter(listData);

        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onRefresh() {
       t.showS(getActivity(),"ref");
    }

    public static interface ClickListener{
        public void onClick(View view, int position);
        public void onLongClick(View view, int position);
    }
}
