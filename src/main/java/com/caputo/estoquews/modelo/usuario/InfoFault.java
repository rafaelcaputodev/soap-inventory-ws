package com.caputo.estoquews.modelo.usuario;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
public class InfoFault {

    private Date dataErro;
    private String mensagem;

    public InfoFault(Date dataErro, String mensagem) {
        this.dataErro = dataErro;
        this.mensagem = mensagem;
    }

    //JAX-B PRECISA
    InfoFault(){
    }
}
