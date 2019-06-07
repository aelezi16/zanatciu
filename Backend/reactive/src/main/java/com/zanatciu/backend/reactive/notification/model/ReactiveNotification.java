package com.zanatciu.backend.reactive.notification.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "ReactiveNotification")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReactiveNotification {

    @Id
    private String id;

    private String publicationTitle;
    private String phone;
    private String publicationOwnerUsername;
    private String username;
    private String status;

}
