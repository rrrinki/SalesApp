package Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

import Models.EquipmentsModel;
import Models.JobsModels;
import salesapp.interstatesawing.com.salesapp.R;

/**
 * Created by VS3 on 7/19/2017.
 */

public class EquipementListAdapter extends RecyclerView.Adapter<EquipementListAdapter.MyViewHolder> {
    ArrayList<EquipmentsModel> servicesModels;
    Context context;
    EquipmentsModel servicesModel;


    public EquipementListAdapter(ArrayList<EquipmentsModel> servicesModels, Context context) {
        this.servicesModels = servicesModels;
        this.context = context;

    }

    @Override
    public EquipementListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_of_dasboard_data, parent, false);
        return new EquipementListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final EquipementListAdapter.MyViewHolder holder, final int position) {
        servicesModel = servicesModels.get(position);
        holder.Name.setText(servicesModel.getEquipmentName());
        if(position %2==0){
            holder.linearLayout.setBackgroundColor(Color.GRAY);
        }else{
            holder.linearLayout.setBackgroundColor(Color.WHITE);
        }
        File direct = new File(Environment.getExternalStorageDirectory()
                + "/InterestWings1");
        final File ServiceappDir = new File(direct, "");
        String imagePath= ServiceappDir + "/" + servicesModel.getEquipmentThumnail();
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        Bitmap bmp = BitmapFactory.decodeFile(imagePath);
        holder.imageView.setImageBitmap(bmp);
    }


    @Override
    public int getItemCount() {
        return servicesModels.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView Name;
        ImageView imageView;
        LinearLayout linearLayout;


        public MyViewHolder(View view) {
            super(view);
            Name = (TextView) view.findViewById(R.id.text_view);
            imageView = (ImageView) view.findViewById(R.id.image_view);
            linearLayout = (LinearLayout) view.findViewById(R.id.linear_layout);

        }

    }
}
