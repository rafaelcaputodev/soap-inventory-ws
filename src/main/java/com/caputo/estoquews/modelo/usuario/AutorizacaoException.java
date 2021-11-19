package com.caputo.estoquews.modelo.usuario;

import javax.xml.ws.WebFault;
import java.util.Date;

@WebFault(name = "AutorizacaoFault")
public class AutorizacaoException extends Exception{

    public AutorizacaoException(String message) {
        super(message);
    }

    public InfoFault getFaultInfo() {
        return new InfoFault(new Date(), "Token invalido");
    }
}
