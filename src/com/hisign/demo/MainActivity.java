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
	//�ٶȵ�ͼ�ؼ�
	private MapView mMapView;
	//�ٶȵ�ͼ����
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
		//�������������Ե�ͼ������ʾ
		//��ͨ��ͼ
		baiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
		//���ǵ�ͼ
//		baiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
		//��ͨ��ͨͼ
		baiduMap.setTrafficEnabled(true);
		//��������ͼ     
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
	 * ��Ӹ�����
	    	�ڵ�ͼ����Ӹ����һ����Ҫ���¼������裺
		    1. ��������㣬�п�����һ�����п����Ƕ�������磺����θ������
		    2. ����OverlayOptions����ͼ������ѡ�ͻ��ࣩ��
		    3. �ڵ�ͼ����Ӹ����
		    4. �����Ӧ�ļ����¼���
	 */
	private void addOverlayout(double latitude,double longitude){
		// ����marker�����  
        LatLng point = new LatLng(latitude, longitude);  
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), );
        BitmapDescriptor bitmap = BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher);
        // ����markerOption�������ڵ�ͼ�����marker  
        OverlayOptions options = new MarkerOptions()//  
                .position(point)// ����marker��λ��  
                .icon(bitmap)// ����marker��ͼ��  
                .zIndex(9)// �O��marker�����ڌӼ�  
                .draggable(true);// ����������ק  
        // �ڵ�ͼ�����marker������ʾ  
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
