package com.smartcoach.smartcoachBackend.Business.admi.entities;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ubicacionxitem")
public class UbicacionxItem implements Serializable {

    @Id
    @Column(name = "mapaid")
    private int mapaid;

    @Column(name = "coordenadaX")
    private int coordenadaX;

    @Column(name = "coordenadaY")
    private int coordenadaY;

    @Column(name = "itemid")
    private int itemid;

    @Column(name = "gimnasioid")
    private int gimnasioid;

    @ManyToOne
    @JoinColumn(name = "Mapaid", insertable = false, updatable = false)
    private Mapa mapa;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "Gimnasioid", referencedColumnName = "Gimnasioid", insertable = false, updatable = false),
            @JoinColumn(name = "Itemid", referencedColumnName = "Itemid", insertable = false, updatable = false)
    })
    private GimnasioItem gimnasioItem;

    public UbicacionxItem(int mapaid, int coordenadaX, int coordenadaY, int itemid, int gimnasioid, Mapa mapa, GimnasioItem gimnasioItem) {
        this.mapaid = mapaid;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.itemid = itemid;
        this.gimnasioid = gimnasioid;
        this.mapa = mapa;
        this.gimnasioItem = gimnasioItem;
    }

    public UbicacionxItem()
    {

    }

    public int getMapaid() {
        return mapaid;
    }

    public void setMapaid(int mapaid) {
        this.mapaid = mapaid;
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public int getGimnasioid() {
        return gimnasioid;
    }

    public void setGimnasioid(int gimnasioid) {
        this.gimnasioid = gimnasioid;
    }

    public Mapa getMapa() {
        return mapa;
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }

    public GimnasioItem getGimnasioItem() {
        return gimnasioItem;
    }

    public void setGimnasioItem(GimnasioItem gimnasioItem) {
        this.gimnasioItem = gimnasioItem;
    }
}
