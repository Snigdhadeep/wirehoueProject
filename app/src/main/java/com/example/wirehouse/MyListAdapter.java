package com.example.wirehouse;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder3> {


    private List<Model2> modelClassList;

    public MyListAdapter(List<Model2>modelClassList){
        this.modelClassList=modelClassList;
        Log.i("ok",String.valueOf(modelClassList.size()));

    }


   class ViewHolder3 extends RecyclerView.ViewHolder{

       TextView tx_rcname;
       TextView tx_rcname2;

       public ViewHolder3(@NonNull View itemView) {
           super(itemView);
           Log.i("ok2","ok2");
          tx_rcname=itemView.findViewById(R.id.tx_rcname);
           tx_rcname2=itemView.findViewById(R.id.tx_rcname2);

       }

       private void setdata(String txt){

           tx_rcname.setText(txt);

       }

   }



    @NonNull
    @Override
    public MyListAdapter.ViewHolder3 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
       Log.i("cre","created");
       return new ViewHolder3(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyListAdapter.ViewHolder3 holder, int position) {
        Log.i("txt", String.valueOf(position));
        String txt=this.modelClassList.get(position).getPallet_name();
        String txt2=this.modelClassList.get(position).getId();

        holder.tx_rcname.setText(txt);
        holder.tx_rcname2.setText(txt2);
    }

    @Override
    public int getItemCount() {
        return modelClassList.size();
    }


}
