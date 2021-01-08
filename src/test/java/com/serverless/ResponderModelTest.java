package com.serverless;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResponderModelTest {

    ResponderModel responderModel = new ResponderModel();

    @Test
    public void cuandoPreguntaWhatIsYourName (){
        String pregunta = ".*what is your name";
        String respuesta = responderModel.answer(pregunta);
        assertThat(respuesta).isEqualTo("Jovenes En Accion");
    }

    @Test
    public void cuandoPreguntaTest (){
        String pregunta = ".*what is your name";
        String respuesta = responderModel.answer(pregunta);
        assertThat(respuesta).isEqualTo("Jovenes En Accion");
    }

    @Test
    public void cuandoPreguntaSuma1Plus10 (){
        String pregunta = "*.what is 1 plus 10";
        String respuesta = responderModel.answer(pregunta);
        assertThat(respuesta).isEqualTo("11");
    }

    @Test
    public void sumaCinco(){
        String pregunta = ".* what is 0 plus 5";
        String respuesta = responderModel.answer(pregunta);
        assertThat(respuesta).isEqualTo("5");
    }

    @Test
    public void largest(){
        String pregunta = ".*which of the following numbers is the largest: 616, 22";
        String respuesta = responderModel.answer(pregunta);
        assertThat(respuesta).isEqualTo("616");
    }

    @Test
    public void cualEsElNumeroMasGrande4(){
        String pregunta = "*.which of the following numbers is the largest: 69, 355, 963, 85";
        String respuesta = responderModel.answer(pregunta);
        assertThat(respuesta).isEqualTo("963");
    }

    @Test
    public void cuandoPreguntaMultiplicacion (){
        String pregunta = "*.what is 2 multiplied by 3";
        String respuesta = responderModel.answer(pregunta);
        assertThat(respuesta).isEqualTo("6");
    }



}
