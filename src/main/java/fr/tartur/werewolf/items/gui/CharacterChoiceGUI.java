package fr.tartur.werewolf.items.gui;

import fr.tartur.werewolf.items.common.gui.GUI;
import fr.tartur.werewolf.items.common.gui.GUIAdapter;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;

public class CharacterChoiceGUI extends GUIAdapter {



    public CharacterChoiceGUI() {
        super(GUI.builder()
                .title(Component.text("Choisis le personnage que tu voudrais jouer !")
                        .color(TextColor.color(0x00ffff)))
                .size(3)
                .component(new WereWolfChoiceItem())
                .build());
    }

}
