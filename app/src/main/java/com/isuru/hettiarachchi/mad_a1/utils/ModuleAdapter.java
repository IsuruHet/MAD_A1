package com.isuru.hettiarachchi.mad_a1.utils;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.isuru.hettiarachchi.mad_a1.R;
import com.isuru.hettiarachchi.mad_a1.utils.ModuleItem;
import java.util.List;

public class ModuleAdapter extends RecyclerView.Adapter<ModuleAdapter.ViewHolder> {
    private final Context context;
    private List<ModuleItem> moduleList;

    public ModuleAdapter(Context context, List<ModuleItem> moduleList) {
        this.context = context;
        this.moduleList = moduleList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_module, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModuleItem item = moduleList.get(position);

        holder.month.setText(item.getMonth());
        holder.date.setText(item.getDate());
        holder.year.setText(item.getYear());
        holder.moduleDetails.setText(item.getModuleDetails());

        holder.checkBtn.setOnClickListener(v -> {
            // Handle button click
        });
    }

    @Override
    public int getItemCount() {
        return moduleList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView month, date, year, moduleDetails;
        Button checkBtn;

        public ViewHolder(View itemView) {
            super(itemView);
            month = itemView.findViewById(R.id.month);
            date = itemView.findViewById(R.id.date);
            year = itemView.findViewById(R.id.year);
            moduleDetails = itemView.findViewById(R.id.moduleDetails);
            checkBtn = itemView.findViewById(R.id.checkBtn);
        }
    }
}
