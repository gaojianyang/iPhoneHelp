package com.xiri.adapter;

import java.util.List;

import com.example.iphonereborn.R;
import com.xiri.model.Icon;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridViewAdapter extends BaseAdapter implements OnItemClickListener {

	private List<Icon> iconList;
	// private Context context;
	private LayoutInflater inflate;

	public GridViewAdapter(Context context, List<Icon> iconList) {
		// this.context=context;
		this.iconList = iconList;
		this.inflate = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return iconList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return iconList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	class ViewHolder {
		public ImageView appicon;
		public TextView apptext;

	}

	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder viewHolder = null;
		if (convertView == null) {
			convertView = inflate.inflate(R.layout.gridview_adapter, null);
			viewHolder = new ViewHolder();
			viewHolder.appicon = (ImageView) convertView
					.findViewById(R.id.app_icon);
			viewHolder.apptext = (TextView) convertView
					.findViewById(R.id.app_text);
			convertView.setTag(viewHolder);

		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.appicon
				.setImageDrawable(iconList.get(position).getAppIcon());
		viewHolder.apptext.setText(iconList.get(position).getAppText());
		return convertView;

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		parent.setAlpha(0.5f);
	}

}
