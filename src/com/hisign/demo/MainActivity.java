package com.hisign.demo;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMap.OnMapClickListener;
import com.baidu.mapapi.map.BaiduMap.OnMarkerDragListener;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.octopus.demo.R;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;

public class MainActivity extends Activity implements OnClickListener{
	//百度地图控件
	private MapView mMapView;
	//百度地图对象
	private BaiduMap baiduMap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//
		SDKInitializer.initialize(getApplicationContext());
		setContentView(R.layout.activity_main);
		//
		init();
	}

	private void init() {
		mMapView = (MapView) findViewById(R.id.bmapview);
		findViewById(R.id.btn_normal).setOnClickListener(this);;
		baiduMap = mMapView.getMap();
		//不设置以下属性地图不会显示
		//普通地图
		baiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
		//卫星地图
//		baiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
		//开通交通图
		baiduMap.setTrafficEnabled(true);
		//开启热力图     
//		baiduMap.setBaiduHeatMapEnabled(true);  
		baiduMap.setOnMapClickListener(new OnMapClickListener() {
			
			@Override
			public boolean onMapPoiClick(MapPoi arg0) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void onMapClick(LatLng arg0) {
				// TODO Auto-generated method stub
				displayInfoWindow(arg0);
			}

		});
		baiduMap.setOnMarkerDragListener(new OnMarkerDragListener() {
			
			@Override
			public void onMarkerDragStart(Marker arg0) {
				
			}
			
			@Override
			public void onMarkerDragEnd(Marker arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onMarkerDrag(Marker arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	private void displayInfoWindow(LatLng arg0) {
		
	}
	
	/**
	 * 添加覆盖物
	    	在地图上添加覆盖物，一般需要以下几个步骤：
		    1. 定义坐标点，有可能是一个，有可能是多个（比如：多边形覆盖物）。
		    2. 构造OverlayOptions（地图覆盖物选型基类）。
		    3. 在地图上添加覆盖物。
		    4. 添加相应的监听事件。
	 */
	private void addOverlayout(double latitude,double longitude){
		// 定义marker坐标点  
        LatLng point = new LatLng(latitude, longitude);  
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), );
        BitmapDescriptor bitmap = BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher);
        // 构建markerOption，用于在地图上添加marker  
        OverlayOptions options = new MarkerOptions()//  
                .position(point)// 设置marker的位置  
                .icon(bitmap)// 设置marker的图标  
                .zIndex(9)// 設置marker的所在層級  
                .draggable(true);// 设置手势拖拽  
        // 在地图上添加marker，并显示  
        Marker marker1 = (Marker) baiduMap.addOverlay(options);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		mMapView.onResume();
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		mMapView.onPause();
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		mMapView.onDestroy();
		mMapView = null;
		super.onDestroy();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_normal:
			if (baiduMap != null) {
				baiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
			}
			break;
		case R.id.btn_statelite:
			if (baiduMap != null) {
				baiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
			}
			break;
		case R.id.btn_none:
			if (baiduMap != null) {
				baiduMap.setMapType(BaiduMap.MAP_TYPE_NONE);
			}
			break;
		default:
			break;
		}
	}
	
}
