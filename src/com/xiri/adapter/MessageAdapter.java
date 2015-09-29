package com.xiri.adapter;

import java.util.List;


import com.example.iphonereborn.R;
import com.xiri.model.MessageInfo;
import com.xiri.thrid.SwipeListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class MessageAdapter extends BaseAdapter{
	private Context context;
	private List<MessageInfo> list;
	
	public MessageAdapter(Context context,List<MessageInfo> list){
		
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
	            convertView = li.inflate(R.layout.swipe_frontview, parent, false);
	            holder = new ViewHolder();
	            holder.tvNumber = (TextView) convertView.findViewById(R.id.tv_message_number);
	            holder.tvTime = (TextView) convertView.findViewById(R.id.tv_message_time);
	            holder.tvContent = (TextView) convertView.findViewById(R.id.tv_message_content);
	            holder.btnDelete = (Button) convertView.findViewById(R.id.btn_message_delete);
	          
	            convertView.setTag(holder);
	        } else {
	            holder = (ViewHolder) convertView.getTag();
	        }

	        ((SwipeListView)parent).recycle(convertView, position);

	        holder.tvNumber.setText(list.get(position).getNumber()+"");
	        holder.tvTime.setText(list.get(position).getTime());
	        holder.tvContent.setText(list.get(position).getContent());
		return convertView;
	}
class ViewHolder{
	TextView tvNumber;
	TextView tvTime;
	TextView tvContent;
	Button btnDelete;
	
	
}
}
