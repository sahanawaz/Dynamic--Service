package com.linehaul.workshop.Repositories;

import com.linehaul.workshop.Entity.TruckTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TruckTypeRepo extends JpaRepository<TruckTypeEntity, String> {
    @Query(
            value = """
                WITH t_truck AS (
                    SELECT * FROM jsonb_to_recordset(:argJson\\:\\:JSONB)
                    AS trk_typ_data (
                        "truckId" varchar(50),
                        "vhclType" varchar(50),
                        "size" integer,
                        "noOfPallets" integer,
                        "maxWeight" integer,
                        "pltWgt" integer,
                        "maxPltWgt" integer,
                        "maxPltHeight" integer,
                        "createdAt" timestamp,
                        "updatedAt" timestamp
                        
                    )
                ), INS_TT AS (
                    INSERT INTO config_truck_type
                    (vehicle_type,
                    size,
                    no_of_pallets,
                    max_weight,
                    pallet_weight,
                    max_pallet_weight,
                    max_pallet_height,
                    created_at ,
                    updated_at )
                    SELECT td."vhclType", td."size", td."noOfPallets", td."maxWeight", td."pltWgt", td."maxPltWgt", td."maxPltHeight", now(), now()
                    FROM t_truck td WHERE td."truckId" = '0'
                    RETURNING truck_id
                )
                UPDATE config_truck_type
                SET vehicle_type=td."vhclType", SIZE=td."size", no_of_pallets=td."noOfPallets",max_weight=td."maxWeight", pallet_weight=td."pltWgt", max_pallet_weight=td."maxPltWgt", max_pallet_height= td."maxPltHeight", created_at =now(), updated_at=now()\s
                FROM t_truck td WHERE td."truckId" LIKE 'VT%' AND truck_id = td."truckId"
                RETURNING truck_id
             """,
            nativeQuery = true
    )
    void saveNative(@Param("argJson") String jsonPayload);
}
