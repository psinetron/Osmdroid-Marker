# Osmdroid-Marker
Simple markers add, like Google maps

**Example:**
```Java
OsmMarker myPositionMarker = new OsmMarker(new GeoPoint(57.9671615,75.3016578));
myPositionMarker.setIcon(context.getResources().getDrawable(R.drawable.myperson));
myPositionMarker.addMarker(mapView);

myPositionMarker.setOnClickListener(new OnMarkerClickListener() {
            @Override
            public void onItemSingleTapUp(OsmMarker marker, int index, OverlayItem item) {
                //Do something
            }

            @Override
            public void onItemLongPress(OsmMarker marker, int index, OverlayItem item) {
                //Do something
            }
        });
```
