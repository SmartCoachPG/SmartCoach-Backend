package com.smartcoach.smartcoachBackend.Business.admi.entities;

import javax.persistence.*;

@Entity
@Table(name = "gimnasio_Item")
@IdClass(GimnasioItemId.class)
public class GimnasioItem {

    @Id
    @Column(name = "gimnasioid")
    private int gimnasioid;

    @Id
    @Column(name = "itemid")
    private int itemid;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    public GimnasioItem(int gimnasioid, int itemid, int cantidad) {
        this.gimnasioid = gimnasioid;
        this.itemid = itemid;
        this.cantidad = cantidad;
    }

    public GimnasioItem(){}

    public int getGimnasioid() {
        return gimnasioid;
    }

    public void setGimnasioid(int gimnasioid) {
        this.gimnasioid = gimnasioid;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
