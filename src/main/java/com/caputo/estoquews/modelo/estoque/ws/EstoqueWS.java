package com.caputo.estoquews.modelo.estoque.ws;

import com.caputo.estoquews.modelo.item.*;
import com.caputo.estoquews.modelo.usuario.AutorizacaoException;
import com.caputo.estoquews.modelo.usuario.TokenDao;
import com.caputo.estoquews.modelo.usuario.TokenUsuario;
import com.caputo.estoquews.modelo.usuario.Usuario;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import java.util.List;

@WebService
public class EstoqueWS {
    private ItemDao dao = new ItemDao();

    @WebMethod(operationName = "todosOsItens")
    @ResponseWrapper(localName = "itens")
    @WebResult(name = "itens")
    public List<Item> getItens(@WebParam(name = "filtros") Filtros filtros){

        System.out.println("Chamando getItens()");

        List<Filtro> lista = filtros.getLista();
        List<Item> itensResultado = dao.todosItens(lista);

        return itensResultado;
    }

    @WebMethod(operationName = "CadastrarItem")
    @WebResult(name = "item")
    public Item cadastrarItem(@WebParam(name = "tokenUsuario", header = true) TokenUsuario token, @WebParam(name = "item") Item item) throws AutorizacaoException {

        System.out.println("Token" + item + " " + token);

        boolean valido = new TokenDao().ehValido(token);
        
        if(!valido){
            throw new AutorizacaoException("Autorizacao falhou");
        }

        this.dao.cadastrar(item);

        return item;
    }

}
