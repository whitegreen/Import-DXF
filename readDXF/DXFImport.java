package readDXF;

import java.util.List;
import org.kabeja.dxf.DXFConstants;
import org.kabeja.dxf.DXFDocument;
import org.kabeja.dxf.DXFLWPolyline;
import org.kabeja.dxf.DXFLayer;
import org.kabeja.dxf.DXFVertex;
import org.kabeja.parser.DXFParser;
import org.kabeja.parser.Parser;
import org.kabeja.parser.ParserBuilder;

/**
 * 
 * @author Hao Hua     whitegreen@163.com
 * 
 * http://labaaa.org
 *
 */

public class DXFImport {

	public static double[][][][] polylines_layers(String filename, String[] layerNames) { // read polylines from multiple layers
		Parser parser = ParserBuilder.createDefaultParser();
		DXFDocument doc = null;
		try {
			parser.parse(filename, DXFParser.DEFAULT_ENCODING);
			doc = parser.getDocument();
		} catch (Exception e) {
			e.printStackTrace();
		}
		double[][][][] all = new double[layerNames.length][][][];
		for (int i = 0; i < layerNames.length; i++)
			all[i] = DXFLWPolyline(doc.getDXFLayer(layerNames[i]));
		return all;
	}

	public static double[][][] polylines_layer(String filename, String layerName) { // read polylines from the one layer
		Parser parser = ParserBuilder.createDefaultParser();
		DXFDocument doc = null;
		try {
			parser.parse(filename, DXFParser.DEFAULT_ENCODING);
			doc = parser.getDocument();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DXFLWPolyline(doc.getDXFLayer(layerName));
	}

	public static double[][][] DXFLWPolyline(DXFLayer layer) {
		List<DXFLWPolyline> pls = layer.getDXFEntities(DXFConstants.ENTITY_TYPE_LWPOLYLINE);
		double[][][] polygons = new double[pls.size()][][];
		for (int i = 0; i < polygons.length; i++) {
			DXFLWPolyline pl = pls.get(i);
			int n = pl.getVertexCount();
			double[][] poly = new double[n][];
			for (int j = 0; j < n; j++) {
				DXFVertex v = pl.getVertex(j);
				poly[j] = new double[] { v.getX(), v.getY() };
			}
			polygons[i] = poly;
		}
		return polygons;
	}

}
