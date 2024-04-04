package com.ironhack.ironlibrary.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Getter
@NoArgsConstructor
@Component
public class MenuItem {
    private String text;

    public MenuItem(String text) {
        this.text = text;
    }
}
