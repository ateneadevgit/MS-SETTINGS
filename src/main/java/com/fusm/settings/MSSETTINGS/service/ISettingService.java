package com.fusm.settings.MSSETTINGS.service;

import com.fusm.settings.MSSETTINGS.entity.Setting;
import com.fusm.settings.MSSETTINGS.model.SettingModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISettingService {

    String getSettingByName(String settingName);
    List<Setting> getSettings();
    void updateSetting(SettingModel settingModel, Integer settingId);

}
