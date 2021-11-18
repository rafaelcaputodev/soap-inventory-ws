package com.caputo.estoquews.modelo.usuario;

import javax.xml.ws.WebFault;

@WebFault(name = "AutorizacaoFault")
public class AutorizacaoException extends Exception{

    public AutorizacaoException(String message) {
        super(message);
    }

    public String getFaultInfo(){
        return "Token invalido";
    }
}
