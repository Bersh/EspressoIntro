package com.example.espressotestapp.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.espressotestapp.R;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyHolder> {

	private ArrayList<String> items;
	private Context context;

	public Adapter(int count, Context context) {
		this.context = context;
		items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			items.add("Item " + i);
		}
	}

	@Override
	public Adapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
		return new MyHolder(view);
	}

	@Override
	public void onBindViewHolder(final MyHolder holder, int position) {
		holder.textData.setText(items.get(position));
		holder.textData.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				AlertDialog.Builder builder = new AlertDialog.Builder(context);
				builder.setMessage(items.get(holder.getAdapterPosition()));
				builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						dialogInterface.dismiss();
					}
				});
				builder.create().show();
			}
		});

	}

	@Override
	public int getItemCount() {
		return items.size();
	}

	class MyHolder extends RecyclerView.ViewHolder {

		TextView textData;

		MyHolder(View itemView) {
			super(itemView);
			textData = (TextView) itemView.findViewById(R.id.text);
		}
	}
}
