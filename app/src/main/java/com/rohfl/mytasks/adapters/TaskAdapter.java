package com.rohfl.mytasks.adapters;

import com.bumptech.glide.Glide;
import com.google.android.material.textview.MaterialTextView;
import com.rohfl.mytasks.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    // context
    private Context mContext;

    // Both arrays will be used to show content in the recycler view
    private String[] taskArray;
    private String[] imageUrls;

    // constructor of the adapter
    public TaskAdapter(String[] taskArray, String[] imageUrls,Context mContext) {
        this.taskArray = taskArray;
        this.imageUrls = imageUrls;
        this.mContext = mContext;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public TaskAdapter.ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_task_layout,parent,false) ;

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull TaskAdapter.ViewHolder holder, int position) {
        holder.bindData(position);
    }

    /**
     *
     * @return taskArray.length length of the task array of this adapter
     */

    @Override
    public int getItemCount() {
        return taskArray.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        // views in the single task layout
        AppCompatImageView imageView;
        MaterialTextView taskTv;

        public ViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);

            // getting the views
            imageView = (AppCompatImageView)itemView.findViewById(R.id.imageview);
            taskTv = (MaterialTextView)itemView.findViewById(R.id.task_tv);

            // setting the onClickListener for the view which is created
            itemView.setOnClickListener(this);

        }

        /**
         * This function binds the data with its view
         * @param position
         */
        public void bindData(int position) {

            // loading image using glide library
            Glide.with(mContext).load(imageUrls[position]).into(imageView);
            taskTv.setText(taskArray[position]);

        }

        /**
         * For handling the clicks of views
         * @param v view which was clicked
         */

        @Override
        public void onClick(View v) {
//            Log.d("Clicked","This");
//            Toast.makeText(mContext,"Clicked on "+getAdapterPosition(),Toast.LENGTH_SHORT).show();

            // building the alert dialog box when the user clicks on a view
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(mContext);
            alertDialogBuilder.setTitle("Task");
            alertDialogBuilder.setMessage(taskArray[getAdapterPosition()]);

            // user will have to click on the button to cancel the dialog box
            alertDialogBuilder.setCancelable(false);

            // adding button and setting handling the on click
            alertDialogBuilder.setPositiveButton("Ok", (dialog,which) -> {
                dialog.cancel();
            });

            // creating the alert dialog box
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        }

    }

}
