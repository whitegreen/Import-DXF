package test;

import readDXF.DXFImport;

public class SimpleTest {

	public static final void main(String[] s) {
		new SimpleTest();
	}

	public SimpleTest() {

		//read all polylines from one layer
		double[][][] polygons = DXFImport.polylines_layer("/Users/huahao/Documents/labAAA teaching/5th 9xiao/poly0.dxf", "poly");
		System.out.println(polygons.length + "  polygons");
		for (int i = 0; i < polygons.length; i++) {
			double[][] poly = polygons[i];
			System.out.println("poly " + i + " has " + poly.length + " vertices.");
		}
		
		//read multiple layers
//		String[] layerNames = { "poly", "vd", "bound" };
//		double[][][][] all = DXFImport.polylines_layers("/Users/huahao/Documents/labAAA teaching/5th 9xiao/poly0.dxf", layerNames);
//		for (int i = 0; i < all.length; i++) {
//			System.out.println("'"+layerNames[i] + "' has " + all[i].length + " polgons.");
//		}

	}

}
