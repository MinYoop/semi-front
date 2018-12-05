package util;

import java.util.List;

import dto.SellBoard;
import geo.LocationDistance;

public class MyUtil {
	
	public static void getDistance(double myLat, double myLon, List<SellBoard> list) {
		for(int i = 0 ; i < list.size(); i++) {
			int meter = (int)(LocationDistance.distance(myLat,myLon,Double.parseDouble(list.get(i).getTradeLat()),Double.parseDouble(list.get(i).getTradeLon()),"meter"));
			list.get(i).setDistance(meter/1000.0);
		}
	}
	
	public static void setSortList(List<SellBoard> list){// 거리에 맞게 리스트 정렬
		
		double min = 0;
		int minIndex = 0;
		SellBoard tmp = null;
		
		for(int i = 0 ; i < (list.size()-1); i++) {	
			min = list.get(i).getDistance();
			minIndex = i;
			
			for(int j = i+1; j < list.size(); j++) {
				if(min > list.get(j).getDistance()) {		
					min = list.get(j).getDistance();
					minIndex = j;					
				}							
			}	
			tmp = list.get(i);
			list.set(i,list.get(minIndex));
			list.set(minIndex,tmp);	
		}	
		for(int i = 0; i < list.size() ; i++) {
			System.out.println(list.get(i).getTitle()+"=" +list.get(i).getDistance());
		}
	}

}