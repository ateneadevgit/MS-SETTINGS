package com.fusm.settings.MSSETTINGS.controller;

import com.fusm.settings.MSSETTINGS.entity.Setting;
import com.fusm.settings.MSSETTINGS.model.Response;
import com.fusm.settings.MSSETTINGS.model.SettingModel;
import com.fusm.settings.MSSETTINGS.model.SettingRequest;
import com.fusm.settings.MSSETTINGS.service.ISettingService;
import com.fusm.settings.MSSETTINGS.util.AppRoutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Clase que expone los servicios relacionados con los valores parametricos de la aplicación
 * ITSense Inc - Andrea Gómez
 */

@RestController
@RequestMapping(value = AppRoutes.SETTINGS_ROUTE)
public class SettingController {

    @Autowired
    private ISettingService settingService;


    /**
     * Obtiene el valor de una configuración
     * @param settingRq Modelo que contiene la configuración a buscar
     * @return valor de la configuraicón
     */
    @PostMapping
    public ResponseEntity<String> getSettingValue(
            @RequestBody SettingRequest settingRq
            ) {
        return new ResponseEntity<>(
                settingService.getSettingByName(settingRq.getSettingName()),
                HttpStatus.OK
        );
    }

    /**
     * Obtiene una lista de todas las configuraciones
     * @return lista de configuraciones
     */
    @GetMapping
    public ResponseEntity<List<Setting>> getSettings() {
        return ResponseEntity.ok(settingService.getSettings());
    }

    /**
     * Actualiza la configuración
     * @param settingId ID de la configuración
     * @param settingModel Modelo que contiene la información a actualizar de la configuración
     * @return OK
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> updateSetting(
            @PathVariable("id") Integer settingId,
            @RequestBody SettingModel settingModel
            ) {
        settingService.updateSetting(settingModel, settingId);
        return ResponseEntity.ok(HttpStatus.OK.getReasonPhrase());
    }

}
