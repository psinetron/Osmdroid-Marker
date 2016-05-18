# Osmdroid-Marker
Assistant, which allows you to quickly cope with the marks on the OpenstreetMap.

**Installation**
download to working directory

**Usage:**
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
