package com.smartcoach.smartcoachBackend.Business.admi.entities;

import java.io.Serializable;
import java.util.Objects;

public class GimnasioItemId implements Serializable {

    private int gimnasioid;
    private int itemid;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GimnasioItemId that = (GimnasioItemId) o;
        return gimnasioid == that.gimnasioid && itemid == that.itemid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gimnasioid, itemid);
    }

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
}

