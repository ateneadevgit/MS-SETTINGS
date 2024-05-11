package com.fusm.settings.MSSETTINGS.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Builder
@Entity
@Data
@Table(name = "Settings")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Setting {

    @Id
    @Column(name = "id_settings", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer settingId;

    @NonNull
    @Column(name = "name", nullable = false)
    private String settingName;

    @NonNull
    @Column(name = "value", nullable = false)
    private String settingValue;

    @Column(name = "preview_name", length = 200, nullable = true)
    private String previewName;

    @Column(name = "description", length = 500, nullable = true)
    private String description;

    @Column(name = "can_edit", nullable = true)
    private Boolean canEdit;

    @NonNull
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "updated_at", nullable = true)
    private Date updatedAt;

    @NonNull
    @Column(name = "enabled", nullable = false)
    private Boolean enabled;

}
