package com.toxin.play.XML;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws JAXBException, IOException{
        Entity e1 = new Entity();

        e1.setName("Юрий");
        e1.setNumber(3.14);
        e1.setAge(19);

        FileWriter fileWriter = new FileWriter("src/com/toxin/play/XML/test.xml");
        FileReader fileReader = new FileReader("src/com/toxin/play/XML/test.xml");

        JAXBContext context = JAXBContext.newInstance(Entity.class);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(e1, fileWriter);

        Unmarshaller unmarshaller = context.createUnmarshaller();
        e1 = (Entity) unmarshaller.unmarshal(fileReader);

        System.out.println(e1);
    }
}
