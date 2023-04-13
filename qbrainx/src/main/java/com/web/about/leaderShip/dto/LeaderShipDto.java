package com.web.about.leaderShip.dto;




import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeaderShipDto {
    private int id;

    private String name;

    private String jobTitle;

    private String link;

    private String fileName;

    @Lob
    private byte[] data;
}
