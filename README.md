# Import-DXF

This library imports polylines from DXF file, based on the **kabeja** library.

**dependency**: kabeja-0.4.jar

## read polylines from **single** layer

String file=“…/poly0.dxf”;

double[][][] polygons = DXFImport.polylines_layer(file, "poly");


## read polylines from *multiple* layers

String[] layerNames = { "poly", "vd", "bound" };

double[][][][] all = DXFImport.polylines_layers(file, layerNames);


![alt text](shot.png "Description goes here")

