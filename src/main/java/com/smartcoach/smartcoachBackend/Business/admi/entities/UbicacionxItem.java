package com.smartcoach.smartcoachBackend.Business.admi.entities;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ubicacionxitem")
public class UbicacionxItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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


    public UbicacionxItem(Long id, int mapaid, int coordenadaX, int coordenadaY, int itemid, int gimnasioid) {
        this.id = id;
        this.mapaid = mapaid;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.itemid = itemid;
        this.gimnasioid = gimnasioid;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UbicacionxItem{" +
                "id=" + id +
                ", mapaid=" + mapaid +
                ", coordenadaX=" + coordenadaX +
                ", coordenadaY=" + coordenadaY +
                ", itemid=" + itemid +
                ", gimnasioid=" + gimnasioid +
                '}';
    }
}
