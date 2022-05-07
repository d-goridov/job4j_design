package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "player")
@XmlAccessorType(XmlAccessType.FIELD)
public class Player {

    @XmlAttribute
    private int id;

    @XmlAttribute
    private double balance;

    @XmlAttribute
    private boolean hasPremium;

    @XmlAttribute
    private String nickName;

    private Hero hero;

    @XmlElementWrapper(name = "perks")
    @XmlElement(name = "perk")
    private String[] perks;

    public Player() {
    }

    public Player(int id, double balance, boolean hasPremium, String nickName, Hero hero, String... perks) {
        this.id = id;
        this.balance = balance;
        this.hasPremium = hasPremium;
        this.nickName = nickName;
        this.hero = hero;
        this.perks = perks;
    }

    @Override
    public String toString() {
        return "Player{"
                + "id=" + id
                + ", balance=" + balance
                + ", hasPremium=" + hasPremium
                + ", nickName='" + nickName + '\''
                + ", hero=" + hero
                + ", perks=" + Arrays.toString(perks)
                + '}';
    }

    public static void main(String[] args) throws Exception {
        Player player1 = new Player(94, 12.54, false,
                "pupsik", new Hero("Scorpion"), "Fire", "Teleport");

        JAXBContext context = JAXBContext.newInstance(Player.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml;
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(player1, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }

        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Player result = (Player) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
