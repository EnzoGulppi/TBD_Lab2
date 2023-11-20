package com.example.resq.Repository;

import com.example.resq.Models.Region;

import java.util.List;

public interface RegionRepository {
    List<Region> getAllRegiones();
    Region getRegionById(Integer id_region);
    void saveRegion(Region region);
    void deleteRegion(Integer id_region);
    Region updateRegion(Region region);
}
