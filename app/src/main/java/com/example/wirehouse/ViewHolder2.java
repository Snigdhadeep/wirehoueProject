package com.example.wirehouse;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder2 extends RecyclerView.ViewHolder {

    TextView tx_rcname;

    public ViewHolder2(@NonNull View itemView) {
        super(itemView);
        tx_rcname = (TextView) itemView.findViewById(R.id.tx_rcname);
    }
}


