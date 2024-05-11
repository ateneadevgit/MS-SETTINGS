package com.fusm.settings.MSSETTINGS.service.impl;

import com.fusm.settings.MSSETTINGS.entity.Setting;
import com.fusm.settings.MSSETTINGS.exception.GlobalCustomException;
import com.fusm.settings.MSSETTINGS.model.SettingModel;
import com.fusm.settings.MSSETTINGS.repository.ISettingsRepository;
import com.fusm.settings.MSSETTINGS.service.ISettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SettingService implements ISettingService {

    @Autowired
    private ISettingsRepository settingsRepository;

    @Override
    public String getSettingByName(String settingName) {
        List<Setting> settings = settingsRepository.findBySettingNameAndEnabled(settingName.toUpperCase(), true);
        if (settings.isEmpty()) throw new GlobalCustomException(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND);
        return settings.get(0).getSettingValue();
    }

    @Override
    public List<Setting> getSettings() {
        return settingsRepository.findAllEditableSettings();
    }

    @Override
    public void updateSetting(SettingModel settingModel, Integer settingId) {
        Optional<Setting> settingOptional = settingsRepository.findById(settingId);
        if (settingOptional.isPresent()) {
            Setting setting = settingOptional.get();
            setting.setSettingValue(settingModel.getValue());
            setting.setDescription(settingModel.getDescription());
            setting.setUpdatedAt(new Date());
            settingsRepository.save(setting);
        }
    }

}
