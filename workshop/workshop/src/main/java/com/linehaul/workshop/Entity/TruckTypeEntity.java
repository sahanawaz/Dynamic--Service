package com.linehaul.workshop.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "config_truck_type")
public class TruckTypeEntity {
    @Id
    private String truckId;
    @Column(name = "vehicle_type")
    private String vhclType;
    @Column(name = "size")
    private Integer size;
    @Column(name = "no_of_pallets")
    private Integer noOfPallets;
    @Column(name = "max_weight")
    private Integer maxWeight;
    @Column(name = "pallet_weight")
    private Integer pltWgt;
    @Column(name = "max_pallet_weight")
    private Integer maxPltWgt;
    @Column(name = "max_pallet_height")
    private Integer maxPltHeight;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public String getTruckId() {
        return truckId;
    }

    public void setTruckId(String truckId) {
        this.truckId = truckId;
    }

    public String getVhclType() {
        return vhclType;
    }

    public void setVhclType(String vhclType) {
        this.vhclType = vhclType;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getNoOfPallets() {
        return noOfPallets;
    }

    public void setNoOfPallets(Integer noOfPallets) {
        this.noOfPallets = noOfPallets;
    }

    public Integer getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Integer maxWeight) {
        this.maxWeight = maxWeight;
    }

    public Integer getPltWgt() {
        return pltWgt;
    }

    public void setPltWgt(Integer pltWgt) {
        this.pltWgt = pltWgt;
    }

    public Integer getMaxPltWgt() {
        return maxPltWgt;
    }

    public void setMaxPltWgt(Integer maxPltWgt) {
        this.maxPltWgt = maxPltWgt;
    }

    public Integer getMaxPltHeight() {
        return maxPltHeight;
    }

    public void setMaxPltHeight(Integer maxPltHeight) {
        this.maxPltHeight = maxPltHeight;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String toJson() {
        return String.format("""
                {
                    "truckId": "%s",
                    "vhclType": "%s",
                    "size": %d,
                    "noOfPallets": %d,
                    "maxWeight": %d,
                    "pltWgt": %d,
                    "maxPltWgt": %d,
                    "maxPltHeight": %d
                }
                """, truckId, vhclType, size, noOfPallets, maxWeight, pltWgt, maxPltWgt, maxPltHeight);
    }
}
