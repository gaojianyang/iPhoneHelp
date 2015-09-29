package com.xiri.adapter;

import java.util.List;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.iphonereborn.R;
import com.xiri.model.PhotoThrid;

public class PhotoThridAdapter extends BaseAdapter{
	private Context context;
	private List<PhotoThrid> list;
	
	public PhotoThridAdapter(Context context,List<PhotoThrid> list){
		
		this.context=context;
		this.list=list;
	} 

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
	        ViewHolder holder;
	        if (convertView == null) {
	            LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	            convertView = li.inflate(R.layout.photo_thrid_adapter, parent, false);
	            holder = new ViewHolder();
	            holder.ivPhoto = (ImageView) convertView.findViewById(R.id.photo_adapter_iv);
	            holder.tvName = (TextView) convertView.findViewById(R.id.photo_adapter_tv);
	            holder.tvNumber = (TextView) convertView.findViewById(R.id.tv_message_content);
	          
	            convertView.setTag(holder);
	        } else {
	            holder = (ViewHolder) convertView.getTag();
	        }

	        holder.ivPhoto.setImageResource(list.get(position).getImg_id());
	        holder.tvName.setText(list.get(position).getTitle());
	        holder.tvNumber.setText(list.get(position).getNumber());
		return convertView;
	}
class ViewHolder{
	ImageView ivPhoto;
	TextView tvName;
	TextView tvNumber;
	
	
}

}
