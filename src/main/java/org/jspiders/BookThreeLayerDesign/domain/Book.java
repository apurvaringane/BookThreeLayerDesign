package org.jspiders.BookThreeLayerDesign.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Book {
    @NotNull(message = "Invalid Id")
    private int bookId;
    @NotBlank(message = "Invalid Name")
    private String bookName;
    @NotBlank(message = "Invalid Publication")
    private String publication;
    @NotBlank(message = "Invalid Author")
    private String bookAuthor;
    @NotNull(message = "Invalid price")
    private double bookPrice;
}
