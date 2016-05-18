package ru.slybeaver.osmhelpers.interfaces;

import org.osmdroid.views.overlay.OverlayItem;
import ru.exits.vezzun.views.OsmMarker;

/**
 * Created by slybeaver 17.05.2016.
 */
public interface OnMarkerClickListener {
    public void onItemSingleTapUp(OsmMarker marker, int index, OverlayItem item);
    public void onItemLongPress(OsmMarker marker, int index, OverlayItem item);
}
