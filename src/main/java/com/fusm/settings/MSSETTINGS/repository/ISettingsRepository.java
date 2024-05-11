package com.fusm.settings.MSSETTINGS.repository;

import com.fusm.settings.MSSETTINGS.entity.Setting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISettingsRepository extends JpaRepository<Setting, Integer> {
    List<Setting> findBySettingNameAndEnabled(String settingName, Boolean enabled);

    @Query(
            value = "select * from settings " +
                    "where can_edit = true " +
                    "order by id_settings asc ",
            nativeQuery = true
    )
    List<Setting> findAllEditableSettings();

}
