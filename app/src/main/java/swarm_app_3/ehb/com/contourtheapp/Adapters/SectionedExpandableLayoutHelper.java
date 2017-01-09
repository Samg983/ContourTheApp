package swarm_app_3.ehb.com.contourtheapp.Adapters;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import swarm_app_3.ehb.com.contourtheapp.Model.Checkpoint;
import swarm_app_3.ehb.com.contourtheapp.Model.Photo;

/**
 * Created by Bram Schrooyen on 23/12/2016.
 */

public class SectionedExpandableLayoutHelper implements SectionStateChangeListener{

    //data list
    private LinkedHashMap<Checkpoint, ArrayList<Photo>> mSectionDataMap = new LinkedHashMap<Checkpoint, ArrayList<Photo>>();
    private ArrayList<Object> mDataArrayList = new ArrayList<Object>();

    //section map
    //TODO : look for a way to avoid this
    private HashMap<String, Checkpoint> mSectionMap = new HashMap<String, Checkpoint>();

    //adapter
    private SectionedExpandableGridAdapter mSectionedExpandableGridAdapter;

    //recycler view
    RecyclerView mRecyclerView;

    public SectionedExpandableLayoutHelper(Context context, RecyclerView recyclerView, ItemClickListener itemClickListener,
                                           int gridSpanCount) {

        //setting the recycler view
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, gridSpanCount);
        recyclerView.setLayoutManager(gridLayoutManager);
        mSectionedExpandableGridAdapter = new SectionedExpandableGridAdapter(context, mDataArrayList,
                gridLayoutManager, itemClickListener, this);
        recyclerView.setAdapter(mSectionedExpandableGridAdapter);

        mRecyclerView = recyclerView;
    }

    public void notifyDataSetChanged() {
        //TODO : handle this condition such that these functions won't be called if the recycler view is on scroll
        generateDataList();
        mSectionedExpandableGridAdapter.notifyDataSetChanged();
    }

    public void addSection(int section, ArrayList<Photo> items) {
        Checkpoint newSection;
        mSectionMap.put(Integer.toString(section), (newSection = new Checkpoint(section)));
        mSectionDataMap.put(newSection, items);
    }

    public void addItem(String section, Photo item) {
        mSectionDataMap.get(mSectionMap.get(section)).add(item);
    }

    public void removeGalleryPhoto(String section, Photo item) {
        mSectionDataMap.get(mSectionMap.get(section)).remove(item);
    }

    public void removeGalleryCheckpoint(String section) {
        mSectionDataMap.remove(mSectionMap.get(section));
        mSectionMap.remove(section);
    }

    private void generateDataList () {
        mDataArrayList.clear();
        for (Map.Entry<Checkpoint, ArrayList<Photo>> entry : mSectionDataMap.entrySet()) {
            Checkpoint key;
            mDataArrayList.add((key = entry.getKey()));
            if (key.isExpanded)
                mDataArrayList.addAll(entry.getValue());
        }
    }

    @Override
    public void onSectionStateChanged(Checkpoint section, boolean isOpen) {
        if (!mRecyclerView.isComputingLayout()) {
            section.isExpanded = isOpen;
            notifyDataSetChanged();
        }
    }

}
