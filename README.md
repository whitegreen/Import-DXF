# Import-DXF

This library imports polylines from DXF file, based on the **kabeja** library.

**dependency**: kabeja-0.4.jar

read all polylines from **single** layer

String file="/Users/huahao/Documents/labAAA teaching/5th 9xiao/poly0.dxf”;

double[][][] polygons = DXFImport.polylines_layer(file, "poly");


read from *multiple* layers

String[] layerNames = { "poly", "vd", "bound" };

double[][][][] all = DXFImport.polylines_layers(file, layerNames);


![alt text](shot.png "Description goes here")

