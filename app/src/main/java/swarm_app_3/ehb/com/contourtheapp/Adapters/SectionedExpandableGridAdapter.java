package swarm_app_3.ehb.com.contourtheapp.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

import swarm_app_3.ehb.com.contourtheapp.Activities.GalleryActivity;
import swarm_app_3.ehb.com.contourtheapp.Model.Checkpoint;
import swarm_app_3.ehb.com.contourtheapp.Model.Photo;
import swarm_app_3.ehb.com.contourtheapp.R;

/**
 * Created by Bram Schrooyen on 23/12/2016.
 */

public class SectionedExpandableGridAdapter extends RecyclerView.Adapter<SectionedExpandableGridAdapter.ViewHolder>{

    //data array
    private ArrayList<Object> mDataArrayList;

    //context
    private final Context mContext;

    //listeners
    private final ItemClickListener mItemClickListener;
    private final SectionStateChangeListener mSectionStateChangeListener;

    private GalleryActivity galleryActivity;

    //view type
    private static final int VIEW_TYPE_SECTION = R.layout.layout_section;
    private static final int VIEW_TYPE_ITEM = R.layout.layout_item; //TODO : change this

    public SectionedExpandableGridAdapter(Context context, ArrayList<Object> dataArrayList,
                                          final GridLayoutManager gridLayoutManager, ItemClickListener itemClickListener,
                                          SectionStateChangeListener sectionStateChangeListener) {
        mContext = context;
        mItemClickListener = itemClickListener;
        mSectionStateChangeListener = sectionStateChangeListener;
        mDataArrayList = dataArrayList;

        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return isSection(position)?gridLayoutManager.getSpanCount():1;
            }
        });
    }

    private boolean isSection(int position) {
        return mDataArrayList.get(position) instanceof Checkpoint;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(viewType, parent, false), viewType);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        switch (holder.viewType) {
            case VIEW_TYPE_ITEM :
                final Photo item = (Photo) mDataArrayList.get(position);
                holder.itemImageView.setImageResource(item.getSourcePhoto());
                holder.view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        mItemClickListener.itemClicked(item);


                    }
                });
                break;
            case VIEW_TYPE_SECTION :
                final Checkpoint section = (Checkpoint) mDataArrayList.get(position);
                holder.sectionTextView.setText("Checkpoint " + Integer.toString(section.getCheckpointId()));
                holder.sectionTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //mItemClickListener.itemClicked(section);
                        if(!section.isExpanded){ //Zorgt ervoor dat toggle button ook werkt bij het klikken op de section titel.
                            mSectionStateChangeListener.onSectionStateChanged(section, true);
                        } else if(section.isExpanded){
                            mSectionStateChangeListener.onSectionStateChanged(section, false);
                        }

                    }
                });
                holder.sectionToggleButton.setChecked(section.isExpanded);
                holder.sectionToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        mSectionStateChangeListener.onSectionStateChanged(section, isChecked);
                    }
                });
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mDataArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (isSection(position))
            return VIEW_TYPE_SECTION;
        else return VIEW_TYPE_ITEM;
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {

        //common
        View view;
        int viewType;

        //for section
        TextView sectionTextView;
        ToggleButton sectionToggleButton;

        //for item
        SquareImageView itemImageView;

        public ViewHolder(View view, int viewType) {
            super(view);
            this.viewType = viewType;
            this.view = view;
            if (viewType == VIEW_TYPE_ITEM) {
                itemImageView = (SquareImageView) view.findViewById(R.id.image_item);
            } else {
                sectionTextView = (TextView) view.findViewById(R.id.text_section);

                //FONT AANPASSEN BIJ ADAPTERS
                Typeface tf_regular = Typeface.createFromAsset(itemView.getContext().getAssets(), "CutiveMono-Regular.ttf");
                sectionTextView.setTypeface(tf_regular);

                sectionToggleButton = (ToggleButton) view.findViewById(R.id.toggle_button_section);
            }
        }
    }

}
