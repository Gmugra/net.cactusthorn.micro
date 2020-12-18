package net.cactusthorn.micro.jersey.rest;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class TestRestPingResponse {

    @XmlElement(name = "alpha3")
    private String alpha3;

    public TestRestPingResponse(String alpha3) {
        this.alpha3 = alpha3;
    }

}
