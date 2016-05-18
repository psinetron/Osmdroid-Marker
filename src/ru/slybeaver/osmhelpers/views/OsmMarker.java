package ru.slybeaver.osmhelpers.views;

import android.graphics.drawable.Drawable;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;
import ru.slybeaver.osmhelpers.interfaces.OnMarkerClickListener;

import java.util.ArrayList;

/**
 * Created by slybeaver on 17.05.2016.
 * Marker for Osmdroid
 */
public class OsmMarker {
    private GeoPoint point = null;
    private Drawable icon=null;
    private OverlayItem overlayItem = null;
    private MapView mapview = null;
    private OsmMarker thismarker = this;
    private ItemizedOverlayWithFocus<OverlayItem> mOverlay = null;
    private ArrayList<OnMarkerClickListener> listeners = new ArrayList<>();

    /**
     * Create a new marker
     * @param point - позиция маркера
     */
    public OsmMarker(GeoPoint point){
        this.point = point;
        overlayItem = new OverlayItem("","",this.point);
    }

    /**
     * Create a new marker with cusom icon
     * @param point - marker position
     * @param icon - marker icon
     */
    public OsmMarker(GeoPoint point, Drawable icon){
        this.point = point;
        this.icon = icon;
        overlayItem = new OverlayItem("","",this.point);
        overlayItem.setMarker(icon);
    }

    /**
     * Set custom icon to marker
     * @param icon - marker icon
     */
    public void setIcon(Drawable icon){
        this.icon=icon;
        overlayItem.setMarker(this.icon);
        if (mapview!=null){
            removeMarker();
            addMarker(mapview);
        }
    }

    /**
     * Set new position to marker
     * @param newposition - new marker position
     */
    public void setPosition(GeoPoint newposition){
        this.point=newposition;
        if (mapview==null){
            return;}
        removeMarker();
        overlayItem = new OverlayItem("","",this.point);
        overlayItem.setMarker(icon);
        addMarker(mapview);

    }

    /**
     * Get current marker position
     */
    public GeoPoint getMarkerPosition(){
        return point;
    }

    /**
     * Add marker to Map view
     * @param osmMap - Open street map view
     */
    public void addMarker(MapView osmMap){
        if (osmMap==null){
            return;
        }
        if (mapview!=null){removeMarker();}
        mapview = osmMap;
        ArrayList<OverlayItem> items = new ArrayList<OverlayItem>();
        items.add(overlayItem);

        mOverlay = new ItemizedOverlayWithFocus<OverlayItem>(items,
                new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
                    @Override
                    public boolean onItemSingleTapUp(final int index, final OverlayItem item) {
                        for (int i=0;i<listeners.size();i++){
                            listeners.get(i).onItemSingleTapUp(thismarker,index,item);
                        }
                        return true;
                    }
                    @Override
                    public boolean onItemLongPress(final int index, final OverlayItem item) {
                        for (int i=0;i<listeners.size();i++){
                            listeners.get(i).onItemLongPress(thismarker,index,item);
                        }
                        return false;
                    }
                }, osmMap.getResourceProxy());
        mapview.getOverlays().add(mOverlay);
        mapview.invalidate();
    }

    /**
     * Remove marker from map
     */
    public void removeMarker(){
        if (mOverlay==null){return;}
        if (mapview==null){return;}
        mapview.getOverlays().remove(mOverlay);
    }

    /**
     * Add click listener to map
     */
    public void setOnClickListener(OnMarkerClickListener newlistener){
        listeners.add(newlistener);
    }


    /**
     * Remove listener
     * @param newlistener - listener to remove
     */
    public void removeOnClickListener(OnMarkerClickListener newlistener){
        listeners.remove(newlistener);
    }


}
