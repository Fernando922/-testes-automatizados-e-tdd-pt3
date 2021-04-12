package br.com.alura.leilao.ui.recyclerview.adapter;

import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.alura.leilao.api.retrofit.client.RespostaListener;
import br.com.alura.leilao.model.Leilao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ListaLeilaoAdapterTest {

    @Mock
    private Context context;  //cria um contexto pelo mockito para passar para o adapter


    @Spy
    ListaLeilaoAdapter adapter = new ListaLeilaoAdapter(context);


    @Test
    public void deve_AtualizarLisaDeLeiloes_QuandoReceberListaDeLeiloes(){

        //é necessário ignorar esta chamada, pq precisa do android framework para funcionar
        doNothing().when(adapter).atualizaLista();




        adapter.atualiza(new ArrayList<>(Arrays.asList(
                new Leilao("Console"),
                new Leilao("Computador")
        )));


        //verifica se o método está sendo chamado no adapter, porque como estamos ignorando
        // pelo mockito, nada impede do usuário remover a chamada do método atualizaLista()
        //do adapter, e o código vai continuar a compilar
        verify(adapter).atualizaLista();

        int quantidadeLeiloesDevolvida = adapter.getItemCount();
        assertThat(quantidadeLeiloesDevolvida, is(2));
    }

}