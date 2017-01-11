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

/*

    SectionedExpandableGridAdapter en SectionedExpandableLayoutHelper zijn gemaakt op basis van een GitHub-project door 'bpncool': https://github.com/bpncool/SectionedExpandableGridRecyclerView
    Gridlayouts in Expandable Lists zijn niet op een simpele manier te implementeren omdat beide views scrollable zijn en elkaar tegenwerken.
    Om dit te verhelpen wordt er een RecyclerView gebruikt, dat speciaal is gemaakt om gemakkelijker te werken met layout changes en ingeladen data (wat dus gebeurt bij een Expandable List)

 */

public class SectionedExpandableLayoutHelper implements SectionStateChangeListener{

    //data list
    private LinkedHashMap<Checkpoint, ArrayList<Photo>> mSectionDataMap = new LinkedHashMap<Checkpoint, ArrayList<Photo>>();
    private ArrayList<Object> mDataArrayList = new ArrayList<Object>();

    //section map
    private HashMap<String, Checkpoint> mSectionMap = new HashMap<String, Checkpoint>();

    //adapter
    private SectionedExpandableGridAdapter mSectionedExpandableGridAdapter;

    //recycler view
    RecyclerView mRecyclerView;

    //constructor -> werkt samen met de gridadapter om de layout volledig vorm te geven
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
        generateDataList();
        mSectionedExpandableGridAdapter.notifyDataSetChanged();
    }


    //hangt de Checkpoint objecten aangemaakt in de GalleryActivity aan de sections.
    public void addSection(int section, ArrayList<Photo> items) {
        Checkpoint newSection;
        mSectionMap.put(Integer.toString(section), (newSection = new Checkpoint(section)));
        mSectionDataMap.put(newSection, items);
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
